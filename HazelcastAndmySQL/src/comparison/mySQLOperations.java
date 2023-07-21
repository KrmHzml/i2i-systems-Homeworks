package comparison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class mySQLOperations {
    private static mySQLHelper mySQLHelper = new mySQLHelper();

    // NUMBERS tablosunu oluşturan metot
    public static void createTable() throws SQLException {
        Connection connection = mySQLHelper.getConnection();
        String sql = "CREATE TABLE NUMBERS (numbers int)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    // Belirtilen boyutta veri ekleyip süreyi ölçüyoruz.
    public static void putDataTomySQL(int dataSize) throws SQLException {
        long startTime = System.currentTimeMillis();
        Connection connection = mySQLHelper.getConnection();
        String sql = "INSERT INTO NUMBERS (numbers) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < dataSize; i++) {
            int randomNumber = (int) Math.ceil(Math.random()*5);
            statement.setInt(1, randomNumber);
            statement.executeUpdate();
        }
        statement.close();
        connection.close();
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("MySQL " + dataSize + " veri ekleme süresi: " + totalTime + "ms");
    }

    // Belirtilen boyutta veriyi alıp süreyi ölçüyoruz.
    public static void getDataFrommySQL(int dataSize) throws SQLException {
        long startTime = System.currentTimeMillis();
        Connection connection = mySQLHelper.getConnection();
        String sql = "SELECT * FROM NUMBERS LIMIT ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, dataSize);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){  }
        resultSet.close();
        statement.close();
        connection.close();
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("MySQL " + dataSize + " veri alma süresi: " + totalTime + "ms");
    }
}