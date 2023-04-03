package taxi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String URL
            = "jdbc:mysql://ufk7fr6gbzstiers:SiJmhOS2hMsOBGgZnLnT@bvnsidttphwyvd2qjpnh-mysql."
            + "services.clever-cloud.com:3306/bvnsidttphwyvd2qjpnh?serverTimezone=UTC";
    private static final String USERNAME = "ufk7fr6gbzstiers";
    private static final String PASSWORD = "SiJmhOS2hMsOBGgZnLnT";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }

    public static Connection getConnection() {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        try {
            return DriverManager.getConnection(URL, dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create connection to DB ", e);
        }
    }
}
