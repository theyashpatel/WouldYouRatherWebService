package Application.Report;

import Application.Database.DBConnection;
import Application.Parent.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ReportService extends DataService {

    public ResponseEntity<?> reportQuestion(Integer qid) {
        conn = DBConnection.getConnection();
        try {
            pstmt = conn.prepareStatement(ReportQuery.REPORT_QUESTION);
            pstmt.addBatch(TIME_ZONE);
            pstmt.setInt(1, qid);
            pstmt.addBatch();

            int[] i = pstmt.executeBatch();

            if (i.length > 1) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
