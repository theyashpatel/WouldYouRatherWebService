package Application.Configuration;

public class Constants {

    private static PropertyUtils pu = new PropertyUtils();

    public static final String ENCRYPTION_KEY = pu.getValue("encryptionKey");
}
