import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Vitaliy on 27.09.2015.
 */
public class PreparedStatementExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatementJDBCExample.class.getName());
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet result;

    public static ResultSet selectStatement(String prepareQuery, int firstParameter, int secondParameter) {
        connection = GetConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(prepareQuery);

            //Set to the desired position values of a certain type
            preparedStatement.setInt(1, firstParameter);
            preparedStatement.setInt(2, secondParameter);
            //Execute query
            ResultSet result = preparedStatement.executeQuery();
            //print result
            logger(result);
        } catch (SQLException e) {
            LOGGER.error("PrepareStatement error ", e.getMessage(), e);
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

    public static ResultSet insertOrUpdateStatement(String insertOrUpdateprepareQuery, int firstParameter, int secondParameter) {
        connection = GetConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(insertOrUpdateprepareQuery);

            //Set to the desired position values of a certain type
            preparedStatement.setInt(1, firstParameter);
            preparedStatement.setInt(2, secondParameter);
            //Execute query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("PrepareStatement error ", e.getMessage(), e);
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

        LOGGER.info("Print preparedStatement " + result.getString("name"));
        while (result.next()) {
            LOGGER.info("The selection number #" + result.getRow()
                    + "\t number in the database #" + result.getInt("test_id")
                    + "\t" + result.getString("name")
                    + "\t the number in the database #" + result.getInt("count"));
        }
    }
}
