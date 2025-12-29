package Sistem;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MusteriEkFonk {

    private Connection conn;

    public MusteriEkFonk(Connection conn) {
        this.conn = conn;
    }

    public void musteriEklemeFonk(Musteri musteri) {
        
        
        String sql = "INSERT INTO Musteri (ad, soyad, telefon, email, adres, sifre) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, musteri.getAd());
            ps.setString(2, musteri.getSoyad());
            ps.setString(3, musteri.getTelefon());                        
            ps.setString(4, musteri.getEmail());                       
            ps.setString(5, musteri.getAdres());          
            ps.setString(6, musteri.getSifre());

            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}