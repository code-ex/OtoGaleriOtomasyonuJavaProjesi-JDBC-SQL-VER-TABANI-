package Sistem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MusteriIslem {

    public static void musteriEkle(SQL db, String ad, String soyad, String tel, String email, String adres, String sifre) {
        String sql = "INSERT INTO musteriler (ad, soyad, telefon, email, adres, sifre) VALUES ("
                + "'" + ad + "', '" + soyad + "', '" + tel + "', '" + email + "', '" + adres + "', '" + sifre + "')";
        if (db.update(sql) != -1) {
            System.out.println("Müşteri Eklendi.");
        }
    }

    
    
    public static void musteriSil(SQL db, int id) {
        String sql = "DELETE FROM musteriler WHERE id=" + id;
        if (db.update(sql) != -1) {
            System.out.println("Müşteri Silindi.");
        }
    }

    public static void musteriGuncelle(SQL db, int id, String ad, String soyad, String tel, String email, String adres, String sifre) {
        String sql = "UPDATE musteriler SET "
                + "ad='" + ad + "', soyad='" + soyad + "', telefon='" + tel + "', "
                + "email='" + email + "', adres='" + adres + "', sifre='" + sifre + "' "
                + "WHERE id=" + id;
        
        if (db.update(sql) != -1) {
            System.out.println("Müşteri Güncellendi.");
        }
    }

    
}