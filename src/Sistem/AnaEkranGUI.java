package Sistem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnaEkranGUI extends JFrame {

    private String kullaniciRolu; // "Admin" veya "Musteri"

    public AnaEkranGUI(String rol) {
        this.kullaniciRolu = rol;

        // Pencere Ayarları
        setTitle("Ana Menü - " + rol + " Paneli");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Ortada aç
        
        
        setLayout(new GridLayout(4, 1, 10, 10)); 

        // --- BUTONLAR ---
        JButton btnArac = new JButton("Araç İşlemleri");
        JButton btnMusteri = new JButton("Müşteri İşlemleri");
        JButton btnSatis = new JButton("Satış İşlemleri");
        JButton btnCikis = new JButton("Çıkış Yap");

        // --- ROL KONTROLÜ (Yetkilendirme) ---
        // Eğer giren kişi Müşteriyse her özelliğe erişim sağlamıyor.
        if (rol.equals("Musteri")) {
            btnMusteri.setEnabled(false); // Müşteriler müşteri listesini göremez/ekleyemez
            btnMusteri.setText("Müşteri İşlemleri (Sadece Admin)"); // Bilgi verelim
            
            btnSatis.setText("Geçmiş Satın Alımlarım"); 
        }

        // --- BUTON AKSİYONLARI ---
        
        btnArac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	btnArac.addActionListener(new ActionListener() {
            	    @Override
            	    public void actionPerformed(ActionEvent e) {            	                    	                    	                    	        
            	        new AracGUI();
            	    }
            	});
            }
        });

        btnMusteri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	btnMusteri.addActionListener(new ActionListener() {
            	    @Override
            	    public void actionPerformed(ActionEvent e) {
            	        new MusteriGUI(); 
            	    }
            	});
            }
        });

        btnSatis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	btnSatis.addActionListener(new ActionListener() {
            	    @Override
            	    public void actionPerformed(ActionEvent e) {
            	        new SatisGUI(); 
            	    }
            	});
            }
        });

        btnCikis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginGUI(); 
                dispose(); // 
            }
        });

        // 
        add(btnArac);
        add(btnMusteri);
        add(btnSatis);
        add(btnCikis);

        setVisible(true);
    }
}