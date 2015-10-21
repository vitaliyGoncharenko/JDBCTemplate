import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Vitaliy on 27.09.2015.
 */
public class GetConnection {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetConnection.class.getName());
    private static Connection connection = null;
    // URL to a database consists of protocol: subprotocol: // [host]: [porta_SUBD] / [database] and other information
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    //  for postgresql          URL = "jdbc:postgresql://127.0.0.1:5432/test";
    private static final String PASSWORD = "123456";
    private static final String NAME_USER = "root";
    //Driver for mysql
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //for postgresql "org.postgresql.Driver"


    public static Connection getConnection() {
        try {
            LOGGER.info("Load database driver");
            Class.forName(DRIVER);
            LOGGER.info("Driver is connected");
            //Create connection
            connection = DriverManager.getConnection(URL, NAME_USER, PASSWORD);
            LOGGER.info("Conection is complete ");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Cannot find driver ", e.getMessage(), e);
        } catch (SQLException e) {
            LOGGER.error("Connection is failed ", e.getMessage(), e);
        }
        return connection;
    }
}
