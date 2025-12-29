package Sistem;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SatisEkFonk {

    private Connection conn;

    public SatisEkFonk(Connection conn) {
        this.conn = conn;
    }

    public void satisEklemeFonk(Satis satis) {
        String sql = "INSERT INTO Satis (aracId, musteriId, tarih, fiyat) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, satis.getAracID());
            ps.setInt(2, satis.getMusteriID());
            ps.setDate(3, satis.getTarih());
            ps.setDouble(4, satis.getFiyat());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
