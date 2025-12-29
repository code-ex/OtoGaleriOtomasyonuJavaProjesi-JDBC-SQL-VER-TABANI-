package Sistem;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AracEkFonk {

    private Connection conn;

    public AracEkFonk(Connection conn) {
        this.conn = conn;
    }

    public void aracEklemeFonk(Arac arac) {
        
        String sql = "INSERT INTO araclar (plaka, marka, model, yil, fiyat, km, renk, durum) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, arac.getPlaka());
            ps.setString(2, arac.getMarka());
            ps.setString(3, arac.getModel());
            ps.setInt(4, arac.getYil());
            ps.setDouble(5, arac.getFiyat());
            ps.setInt(6, arac.getKilometre());    
            ps.setString(7, arac.getRenk()); 
            ps.setString(8, arac.getDurum());

            ps.executeUpdate();
            System.out.println("Araç başarıyla veritabanına kaydedildi.");

        } catch (Exception e) {
            System.err.println("Ekleme Hatası: " + e.getMessage());
            e.printStackTrace();
        }
    }
}