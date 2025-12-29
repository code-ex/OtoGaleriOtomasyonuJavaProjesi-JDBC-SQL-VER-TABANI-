package Sistem;

import java.sql.*;

public class AracIslem {
    public static void aracEkle(SQL db, String plaka ,String marka, String model, int yil, double fiyat, int km, String renk, String durum) {
       
    	String sql = "INSERT INTO araclar (plaka, marka, model, yil, fiyat, km, renk, durum) VALUES ("
                + "'" + plaka + "', "
                + "'" + marka + "', "
                + "'" + model + "', "
                + yil + ", "
                + fiyat + ", "
                + km + ", "
                + "'" + renk + "', "
                + "'" + durum + "')";
        
        int sonuc = db.update(sql);
        if (sonuc != -1) {
            System.out.println(">>> Araç başarıyla eklendi.");
        } else {
            System.out.println(">>> Hata: Araç eklenemedi.");
        }
    }

    public static void aracListele(SQL db) {
        ResultSet rs = db.select("SELECT * FROM araclar");
        try {
            System.out.println("\n--- ARAÇ LİSTESİ ---");
            while (rs != null && rs.next()) {
                
                System.out.println("Plaka: " + rs.getString("plaka") + " - " + 
                                   rs.getString("marka") + " " + 
                                   rs.getString("model") + " | " +
                                   rs.getInt("yil") + " Model | " +
                                   rs.getInt("km") + " KM | Renk: " +
                                   rs.getString("renk") + " | Fiyat: " +
                                   rs.getDouble("fiyat") + " TL"+
                				   " | Durum: " +
								   rs.getString("durum"));
                					
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }

    
    public static void aracSil(SQL db, String plaka) {
        
        String sql = "DELETE FROM araclar WHERE plaka='" + plaka + "'";
        
        if (db.update(sql) != -1) {
            System.out.println("Araç silindi.");
        }
    }

    public static void aracGuncelle(SQL db, String plaka, double yeniFiyat, int yeniKm) {                
        String sql = "UPDATE araclar SET fiyat=" + yeniFiyat + ", km=" + yeniKm + " WHERE plaka='" + plaka + "'";
        
        if (db.update(sql) != -1) {
            System.out.println("Araç bilgileri (Fiyat ve KM) güncellendi.");
        }
    }
}