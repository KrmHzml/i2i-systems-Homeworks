package comparison;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mySQLHelper {
    static String userName = "root";
    static String password = "3767";
    static String dbUrl = "jdbc:mysql://localhost:3306/database_name";

    // Veritabanına bağlantı oluşturan metot
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl,userName,password);
	}

}