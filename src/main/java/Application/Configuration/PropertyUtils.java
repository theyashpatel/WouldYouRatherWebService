package Application.Configuration;

import Application.Database.DBConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class PropertyUtils {

    private final String GET_VALUE = "select * from properties";

    private Map<String, String> keyMap = new HashMap<>();

    public PropertyUtils() {
        this.keyMap = getValueFromDb();
    }

    public String getValue(String key) {
        return keyMap.get(key);
    }

    private Map<String, String> getValueFromDb() {
        Connection conn = DBConnection.getConnection();
        Map<String, String> myMap = new HashMap<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(GET_VALUE);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                myMap.put(rs.getString("pkey"), rs.getString("pvalue"));
                return myMap;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
