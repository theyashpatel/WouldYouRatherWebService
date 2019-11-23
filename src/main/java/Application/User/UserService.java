package Application.User;

import Application.Database.DBConnection;
import Application.Parent.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.*;

import static Application.Database.DBConnection.closeConnection;
import static Application.Database.DBConnection.getConnection;
import static Application.User.UserQuery.CHECK_USER;
import static Application.User.UserQuery.INSERT_USER;

@Service
public class UserService extends DataService {

    public ResponseEntity<?> checkUser(Device d) {
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(CHECK_USER);
            pstmt.setString(1, d.getDeviceUuid());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UserId i = new UserId(rs.getInt("uid"));
                return new ResponseEntity<>(i, HttpStatus.OK);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            closeConnection(conn, pstmt, rs);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> insertUser(Device d) {
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(INSERT_USER);
            pstmt.addBatch(TIME_ZONE);
            pstmt.setString(1, d.getDeviceUuid());
            if (d.getDeviceType() == null) {
                pstmt.setNull(2, Types.VARCHAR);
            }
            else {
                pstmt.setString(2, d.getDeviceType());
            }
            pstmt.addBatch();
            int[] i = pstmt.executeBatch();
            System.out.println("Batch length: " + i.length);
            if (i.length > 1) {
                return checkUser(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            closeConnection(conn, pstmt);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
