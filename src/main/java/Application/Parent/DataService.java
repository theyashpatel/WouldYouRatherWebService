package Application.Parent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataService {
    protected Connection conn;
    protected PreparedStatement pstmt;
    protected ResultSet rs;
    protected Integer questionCount;

    protected static final String TIME_ZONE = "SET time_zone = 'US/Eastern'";
}
