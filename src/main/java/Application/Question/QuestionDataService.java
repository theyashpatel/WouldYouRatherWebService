package Application.Question;

import Application.Database.DBConnection;
import Application.Parent.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.sql.*;

import static Application.Database.DBConnection.getConnection;
import static Application.Question.QuestionQuery.SELECT_MAX_QUESTION;
import static Application.Question.QuestionQuery.SELECT_RANDOM_BACK;

@Service
public class QuestionDataService extends DataService {

    public ResponseEntity<?> getQuestion(Integer id) {
        Question q = getRandomQuestion(SELECT_RANDOM_BACK, id);
        return new ResponseEntity<>(q, HttpStatus.OK);
    }

    public Question getRandomQuestion(String query, Integer id) {
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(query);
            if (id != null) pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Integer qid = rs.getInt("id");
                String question = rs.getString("question");
                String oneOption = rs.getString("oneoption");
                String twoOption = rs.getString("twooption");
                String oneimage = rs.getString("oneimage");
                String twoimage = rs.getString("twoimage");
                String category = rs.getString("category");
                String isnsfw = rs.getString("isnsfw");
                return new Question(qid, question, oneOption, twoOption, oneimage, twoimage, category, isnsfw);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(conn, pstmt, rs);
        }
        return null;
    }

    public Question getRandomQuestionBackRandom() {
        return getRandomQuestion(SELECT_RANDOM_BACK, getRandom(this.questionCount));
    }

    public void selectMaxId() {
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(SELECT_MAX_QUESTION);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                this.questionCount = rs.getInt("qid");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(conn, pstmt, rs);
        }
    }

    private Integer getRandom(Integer upperBound) {
        return new SecureRandom().nextInt(upperBound) + 1;
    }
}
