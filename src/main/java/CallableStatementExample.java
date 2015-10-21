import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * STORE PROCEDURES
 */
public class CallableStatementExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallableStatementExample.class.getName());
    private static Connection connection;
    private static CallableStatement callableStatement;
    private static ResultSet result;
    //function
    private static final String func = "{ call myfunc(?,?) }";

    public static ResultSet selectStatement(
            String function, String firstParameter, String secondParameter) {
        connection = GetConnection.getConnection();
        try {
            callableStatement = connection.prepareCall(func);

            //Set to the desired position values of a certain type
            callableStatement.setString(1, firstParameter);
            callableStatement.setString(2, secondParameter);
            //Execute query
            ResultSet result = callableStatement.executeQuery();
            //print result
            logger(result);
        } catch (SQLException e) {
            LOGGER.error("CallableStatement error ", e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error("Close connection is failed ", e.getMessage(), e);
                }
            }
        }
        return result;
    }

    public static ResultSet insertOrUpdateStatement(
            String function, String firstParameter, String secondParameter) {
        connection = GetConnection.getConnection();
        try {
            callableStatement = connection.prepareCall(function);

            //input parameter
            callableStatement.setString(1, firstParameter);
            callableStatement.setString(2, secondParameter);
            //Execute query
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("CallableStatement error ", e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error("Close connection is failed ", e.getMessage(), e);
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

        LOGGER.info("Print callableStatement " + result.getString("name"));
        while (result.next()) {
            LOGGER.info("The selection number #" + result.getRow()
                    + "\t number in the database #" + result.getInt("test_id")
                    + "\t" + result.getString("name")
                    + "\t the number in the database #" + result.getInt("count"));
        }
    }


    //3.CallableStatementExample: используется для вызова хранимых функций,
//            // которые могут содержать входные и выходные параметры
//            CallableStatementExample callableStatementExample = null;
//            //Вызываем функцию myFunc (хранится в БД)
//            callableStatementExample = connection.prepareCall(
//                    " { call myfunc(?,?) } ");
//            //Задаём входные параметры
//            callableStatementExample.setString(1, "Dima");
//            callableStatementExample.setString(2, "Alex");
//            //Выполняем запрос
//            ResultSet result3 = callableStatementExample.executeQuery();
//            //Если CallableStatementExample возвращает несколько объектов ResultSet,
//            //то нужно выводить данные в цикле с помощью метода next
//            //у меня функция возвращает один объект
//            result3.next();
//            System.out.println(result3.getString("MESSAGE"));
//            //если функция вставляет или обновляет, то используется метод executeUpdate()
}
