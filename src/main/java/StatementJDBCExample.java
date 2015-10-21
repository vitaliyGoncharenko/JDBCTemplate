import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Vitaliy on 26.09.2015.
 */
public class StatementJDBCExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatementJDBCExample.class.getName());
    private static Connection connection;
    private static Statement statement;
    private static ResultSet result;


    public static ResultSet selectStatement(String selectQuery) {
        connection = GetConnection.getConnection();
        try {
            statement = connection.createStatement();

            //Execute query
            result = statement.executeQuery(selectQuery);
            //print result
            logger(result);
        } catch (SQLException e) {
            LOGGER.error("Statement error ", e.getMessage(), e);
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error("Close connection is failed ", e.getMessage(),e);
                }
            }
        }

        return result;
    }

    public static ResultSet insertOrUpdateStatement(String insertOrUpdateQuery) {
        connection = GetConnection.getConnection();
        try {
            statement = connection.createStatement();
            //Execute query
            result = statement.executeQuery(insertOrUpdateQuery);
            //print result
            logger(result);
        } catch (SQLException e) {
            LOGGER.error("Statement error ", e.getMessage(), e);
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error("Close connection is failed ", e.getMessage(),e);
                }
            }
        }
        return result;
    }

    public static void logger(ResultSet result) throws SQLException {
        /*
            * result is a pointer to the first line with sample
            * to get the data, we will use
            * method next (), by which we pass on to the next element
            */

        LOGGER.info("Print statement " + result.getString("name"));
        while (result.next()) {
            LOGGER.info("The selection number #" + result.getRow()
                    + "\t number in the database #" + result.getInt("test_id")
                    + "\t" + result.getString("name")
                    + "\t the number in the database #" + result.getInt("count"));
        }
    }
}
