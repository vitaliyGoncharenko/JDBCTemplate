import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Vitaliy on 19.09.2015.
 */
public class JDBCTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(JDBCTest.class.getName());
    public static void main(String[] args) {
//        Connection connection = StatementJDBCExample.getConnection();
        try {
            //��������� �������
//            Class.forName("org.postgresql.Driver");
//            Class.forName("com.mysql.jdbc.Driver");
//            LOGGER.info("������� ���������");
//            LOGGER.info("Driver is connected");
//            System.out.println("������� ���������");
            //������ ����������
//            connection = DriverManager.getConnection(url, name, password);
//            LOGGER.info("Conection is complete ");
//            System.out.println("���������� �����������");


            //��� ������������� SQL �������� ���������� 3 ���� ��������:
            //1.Statement: ������������ ��� ������� ������� ��� ����������
            Statement statement = null;

            statement = connection.createStatement();
            //�������� ������
            ResultSet result1 = statement.executeQuery(
                    "SELECT * FROM test");
            //result ��� ��������� �� ������ ������ � �������
            //����� ������� ������ �� ����� ������������
            //����� next() , � ������� �������� ��������� � ���������� ��������
//            System.out.println("������� statement" + result1.getString("name"));
            while (result1.next()) {

                System.out.println("����� � ������� #" + result1.getRow()
                        + "\t ����� � ���� #" + result1.getInt("test_id")
                        + "\t" + result1.getString("name")
                        + "\t ����� � ���� #" + result1.getInt("count"));
            }
//            // �������� ������
//            statement.executeUpdate(
//                    "INSERT INTO users(username) values('name')");
//            //�������� ������
//            statement.executeUpdate(
//                    "UPDATE users SET username = 'admin' where id = 1");
//
//
//
//            //2.PreparedStatement: �������������� ����������� �������,
//            //������� ����� ��������� ������� ���������
//            PreparedStatement preparedStatement = null;
//            // ? - ����� ������� ������ �������
//            preparedStatement = connection.prepareStatement(
//                    "SELECT * FROM users where id > ? and id < ?");
//            //������������� � ������ ������� �������� ������������ ����
//            preparedStatement.setInt(1, 2);
//            preparedStatement.setInt(2, 10);
//            //��������� ������
//            ResultSet result2 = preparedStatement.executeQuery();
//
//            System.out.println("������� PreparedStatement");
//            while (result2.next()) {
//                System.out.println("����� � ������� #" + result2.getRow()
//                        + "\t ����� � ���� #" + result2.getInt("id")
//                        + "\t" + result2.getString("username"));
//            }
//
//            preparedStatement = connection.prepareStatement(
//                    "INSERT INTO users(username) values(?)");
//            preparedStatement.setString(1, "user_name");
//            //����� ��������� �������� ��� ����������
//            //����� �������� ����� ������� � UPDATE
//            preparedStatement.executeUpdate();
//
//
//
//            //3.CallableStatementExample: ������������ ��� ������ �������� �������,
//            // ������� ����� ��������� ������� � �������� ���������
//            CallableStatementExample callableStatement = null;
//            //�������� ������� myFunc (�������� � ��)
//            callableStatement = connection.prepareCall(
//                    " { call myfunc(?,?) } ");
//            //����� ������� ���������
//            callableStatement.setString(1, "Dima");
//            callableStatement.setString(2, "Alex");
//            //��������� ������
//            ResultSet result3 = callableStatement.executeQuery();
//            //���� CallableStatementExample ���������� ��������� �������� ResultSet,
//            //�� ����� �������� ������ � ����� � ������� ������ next
//            //� ���� ������� ���������� ���� ������
//            result3.next();
//            System.out.println(result3.getString("MESSAGE"));
//            //���� ������� ��������� ��� ���������, �� ������������ ����� executeUpdate()

        } catch (Exception ex) {
            //������� �������� �������� ���������
            LOGGER.error("ex1 " + ex);
//            Logger.getLogger(JDBCtest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    LOGGER.error("ex2 " + ex);
//                    Logger.getLogger(JDBCtest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
