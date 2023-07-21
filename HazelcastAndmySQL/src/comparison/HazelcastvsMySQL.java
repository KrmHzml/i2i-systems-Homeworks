package comparison;

import java.sql.SQLException;

public class HazelcastvsMySQL {
    public static void main(String[] args) throws SQLException {

        // Hazelcast ve mySQLOperations sınıflarını kullanarak nesneler oluşturuyoruz.
        Hazelcast hazelCast = new Hazelcast();
        mySQLOperations mySQLOperations = new mySQLOperations();

        // MySQL'de bir tablo oluşturuyoruz.
        mySQLOperations.createTable();

        // 20,000 veri ekleyip süreyi ölçüyoruz.
        hazelCast.putDataToHazel(20000);
        mySQLOperations.putDataTomySQL(20000);
        System.out.println("");

        // 20,000 veriyi alıp süreyi ölçüyoruz.
        hazelCast.getDataFromHazel(20000);
        mySQLOperations.getDataFrommySQL(20000);
        System.out.println(""); 

        // 10,000 veri ekleyip süreyi ölçüyoruz.
        hazelCast.putDataToHazel(10000);
        mySQLOperations.putDataTomySQL(100000);
        System.out.println("");

        // 100,000 veriyi alıp süreyi ölçüyoruz.
        hazelCast.getDataFromHazel(100000);
        mySQLOperations.getDataFrommySQL(100000);

    }
}
