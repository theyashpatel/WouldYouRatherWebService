package Application.User;

public class UserQuery {
    public static final String CHECK_USER = "select uid from User where deviceuuid = ? and voidind = 'n'";
    public static final String INSERT_USER = "insert into User (deviceuuid, devicetype) values(?, ?)";
}
