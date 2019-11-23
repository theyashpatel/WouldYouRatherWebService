package Application.Vote;

import Application.Database.DBConnection;
import Application.Parent.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static Application.Database.DBConnection.closeConnection;
import static Application.Vote.VoteQuery.*;

@Service
public class VoteService extends DataService {

    public ResponseEntity<?> getTotalCount(Integer qid) {
        return getCount(TOTAL_COUNT, qid);
    }

    public ResponseEntity<?> addVote(Vote v) {
        conn = DBConnection.getConnection();
        String query = "";
        if (v.getVoteValue().equals("a")) {
            query = ADD_VOTE_A;
        }
        else if (v.getVoteValue().equals("b")) {
            query = ADD_VOTE_B;
        }
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, v.getQid());
            Integer i = pstmt.executeUpdate();
            if (i == 1) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<?> getCount(String query, Integer qid) {
        conn = DBConnection.getConnection();
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, qid);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Map<String, Integer> res = new HashMap<>();
                Integer i = rs.getInt("totalvote");
                Integer j = rs.getInt("avote");
                res.put("totalVote", i);
                res.put("aVote", j);
                return new ResponseEntity<>(res, HttpStatus.OK);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            closeConnection(conn, pstmt, rs);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
