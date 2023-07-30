package apacheIgnite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ignite {

    private static String jdbcUrl = "jdbc:ignite:thin://localhost:10800/";
    private static String username = "kerem";
    private static String password = "3767";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
            Connection connection = ignite.getConnection();
            Statement statement = connection.createStatement();   
            
            String sqlQuery = "SELECT * FROM SUBSCRIBER";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int subscId = resultSet.getInt("SUBSC_ID");
                String subscName = resultSet.getString("SUBSC_NAME");
                String subscSurname = resultSet.getString("SUBSC_SURNAME");
                String msisdn = resultSet.getString("MSISDN");
                int tariffId = resultSet.getInt("TARIFF_ID");
                String startDate = resultSet.getString("START_DATE");

                System.out.println(subscId +" "+subscName+" "
                        +  subscSurname + " "+  msisdn
                        +" "+ tariffId + " "+startDate);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
