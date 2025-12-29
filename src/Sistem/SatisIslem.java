package Sistem;

import java.sql.*;

public class SatisIslem {
    public static void satisYap(SQL db, String plaka, int musteriID, double fiyat) {
        String sql = "INSERT INTO satislar (arac_plaka, musteri_id, tarih, fiyat) VALUES ("
                     + "'" + plaka + "', " 
                     + musteriID + ", " 
                     + "CURDATE(), " 
                     + fiyat + ")";
        
        if (db.update(sql) != -1) {
            db.update("UPDATE araclar SET durum='Satıldı' WHERE plaka='" + plaka + "'");
            System.out.println("Satış başarılı. Araç durumu 'Satıldı' olarak güncellendi.");
        }
    }

    public static void satisListele(SQL db) {
        ResultSet rs = db.select("SELECT * FROM satislar");
        try {
            System.out.println("\n--- SATIŞ LİSTESİ ---");
            while (rs != null && rs.next()) {
                System.out.println("Satış No: " + rs.getInt("id") + 
                                   " | Araç Plaka: " + rs.getString("arac_plaka") + 
                                   " | Müşteri ID: " + rs.getInt("musteri_id") + 
                                   " | Tarih: " + rs.getDate("tarih") +
                                   " | Satış Fiyatı: " + rs.getDouble("fiyat") + " TL");
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }
}