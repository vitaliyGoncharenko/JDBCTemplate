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
            //Çàãğóæàåì äğàéâåğ
//            Class.forName("org.postgresql.Driver");
//            Class.forName("com.mysql.jdbc.Driver");
//            LOGGER.info("Äğàéâåğ ïîäêëş÷åí");
//            LOGGER.info("Driver is connected");
//            System.out.println("Äğàéâåğ ïîäêëş÷åí");
            //Ñîçäà¸ì ñîåäèíåíèå
//            connection = DriverManager.getConnection(url, name, password);
//            LOGGER.info("Conection is complete ");
//            System.out.println("Ñîåäèíåíèå óñòàíîâëåíî");


            //Äëÿ èñïîëüçîâàíèÿ SQL çàïğîñîâ ñóùåñòâóşò 3 òèïà îáúåêòîâ:
            //1.Statement: èñïîëüçóåòñÿ äëÿ ïğîñòûõ ñëó÷àåâ áåç ïàğàìåòğîâ
            Statement statement = null;

            statement = connection.createStatement();
            //Âûïîëíèì çàïğîñ
            ResultSet result1 = statement.executeQuery(
                    "SELECT * FROM test");
            //result ıòî óêàçàòåëü íà ïåğâóş ñòğîêó ñ âûáîğêè
            //÷òîáû âûâåñòè äàííûå ìû áóäåì èñïîëüçîâàòü
            //ìåòîä next() , ñ ïîìîùüş êîòîğîãî ïåğåõîäèì ê ñëåäóşùåìó ıëåìåíòó
//            System.out.println("Âûâîäèì statement" + result1.getString("name"));
            while (result1.next()) {

                System.out.println("Íîìåğ â âûáîğêå #" + result1.getRow()
                        + "\t Íîìåğ â áàçå #" + result1.getInt("test_id")
                        + "\t" + result1.getString("name")
                        + "\t Íîìåğ â áàçå #" + result1.getInt("count"));
            }
//            // Âñòàâèòü çàïèñü
//            statement.executeUpdate(
//                    "INSERT INTO users(username) values('name')");
//            //Îáíîâèòü çàïèñü
//            statement.executeUpdate(
//                    "UPDATE users SET username = 'admin' where id = 1");
//
//
//
//            //2.PreparedStatement: ïğåäâàğèòåëüíî êîìïèëèğóåò çàïğîñû,
//            //êîòîğûå ìîãóò ñîäåğæàòü âõîäíûå ïàğàìåòğû
//            PreparedStatement preparedStatement = null;
//            // ? - ìåñòî âñòàâêè íàøåãî çíà÷åíÿ
//            preparedStatement = connection.prepareStatement(
//                    "SELECT * FROM users where id > ? and id < ?");
//            //Óñòàíàâëèâàåì â íóæíóş ïîçèöèş çíà÷åíèÿ îïğåäåë¸ííîãî òèïà
//            preparedStatement.setInt(1, 2);
//            preparedStatement.setInt(2, 10);
//            //âûïîëíÿåì çàïğîñ
//            ResultSet result2 = preparedStatement.executeQuery();
//
//            System.out.println("Âûâîäèì PreparedStatement");
//            while (result2.next()) {
//                System.out.println("Íîìåğ â âûáîğêå #" + result2.getRow()
//                        + "\t Íîìåğ â áàçå #" + result2.getInt("id")
//                        + "\t" + result2.getString("username"));
//            }
//
//            preparedStatement = connection.prepareStatement(
//                    "INSERT INTO users(username) values(?)");
//            preparedStatement.setString(1, "user_name");
//            //ìåòîä ïğèíèìàåò çíà÷åíèå áåç ïàğàìåòğîâ
//            //òåìæå ñïîñîáîì ìîæíî ñäåëàòü è UPDATE
//            preparedStatement.executeUpdate();
//
//
//
//            //3.CallableStatementExample: èñïîëüçóåòñÿ äëÿ âûçîâà õğàíèìûõ ôóíêöèé,
//            // êîòîğûå ìîãóò ñîäåğæàòü âõîäíûå è âûõîäíûå ïàğàìåòğû
//            CallableStatementExample callableStatement = null;
//            //Âûçûâàåì ôóíêöèş myFunc (õğàíèòñÿ â ÁÄ)
//            callableStatement = connection.prepareCall(
//                    " { call myfunc(?,?) } ");
//            //Çàäà¸ì âõîäíûå ïàğàìåòğû
//            callableStatement.setString(1, "Dima");
//            callableStatement.setString(2, "Alex");
//            //Âûïîëíÿåì çàïğîñ
//            ResultSet result3 = callableStatement.executeQuery();
//            //Åñëè CallableStatementExample âîçâğàùàåò íåñêîëüêî îáúåêòîâ ResultSet,
//            //òî íóæíî âûâîäèòü äàííûå â öèêëå ñ ïîìîùüş ìåòîäà next
//            //ó ìåíÿ ôóíêöèÿ âîçâğàùàåò îäèí îáúåêò
//            result3.next();
//            System.out.println(result3.getString("MESSAGE"));
//            //åñëè ôóíêöèÿ âñòàâëÿåò èëè îáíîâëÿåò, òî èñïîëüçóåòñÿ ìåòîä executeUpdate()

        } catch (Exception ex) {
            //âûâîäèì íàèáîëåå çíà÷èìûå ñîîáùåíèÿ
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
