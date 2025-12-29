package Sistem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTables {

    static final String DB_URL = "jdbc:mysql://localhost:3306/galeri";
    static final String USER = "root";
    static final String PASS = "1234";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stm = conn.createStatement()) {

            String araclarTable = "CREATE TABLE IF NOT EXISTS araclar ("
                    + "plaka VARCHAR(20) PRIMARY KEY," 
                    + "marka VARCHAR(50),"
                    + "model VARCHAR(50),"
                    + "yil INT,"
                    + "fiyat DOUBLE,"
                    + "km INT,"
                    + "renk VARCHAR(30),"
                    + "durum VARCHAR(20) DEFAULT 'Satışta'" 
                    + ")";

            String musterilerTable = "CREATE TABLE IF NOT EXISTS musteriler ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "ad VARCHAR(50),"
                    + "soyad VARCHAR(50),"
                    + "telefon VARCHAR(20),"
                    + "email VARCHAR(50),"
                    + "sifre VARCHAR(20)" 
                    + ")";

            String satislarTable = "CREATE TABLE IF NOT EXISTS satislar ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "arac_plaka VARCHAR(20),"
                    + "musteri_id INT,"
                    + "tarih DATE,"
                    + "fiyat DOUBLE,"
                    + "FOREIGN KEY (arac_plaka) REFERENCES araclar(plaka)," 
                    + "FOREIGN KEY (musteri_id) REFERENCES musteriler(id)"
                    + ")";

            stm.executeUpdate(araclarTable);
            stm.executeUpdate(musterilerTable);
            stm.executeUpdate(satislarTable);

            System.out.println("Tablolar başarıyla oluşturuldu.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}