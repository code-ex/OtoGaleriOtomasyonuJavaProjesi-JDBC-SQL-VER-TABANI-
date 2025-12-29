package Sistem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginGUI extends JFrame {
    
    
    private JTextField txtEmail;
    private JPasswordField txtSifre;
    private SQL db; 

    public LoginGUI() {
        
        db = new SQL(); 
        
        
        setTitle("Oto Galeri Otomasyonu - Giriş");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        setLayout(null); 

        // --- BİLEŞENLERİ OLUŞTURMA ---

        
        JLabel lblBaslik = new JLabel("GİRİŞ YAP");
        lblBaslik.setFont(new Font("Arial", Font.BOLD, 20));
        lblBaslik.setBounds(150, 20, 150, 30); 
        add(lblBaslik);

        // E-posta Kutusu
        JLabel lblEmail = new JLabel("E-posta:");
        lblEmail.setBounds(50, 80, 100, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 80, 180, 25);
        add(txtEmail);

        // Şifre Kutusu
        JLabel lblSifre = new JLabel("Şifre:");
        lblSifre.setBounds(50, 130, 100, 25);
        add(lblSifre);

        txtSifre = new JPasswordField();
        txtSifre.setBounds(150, 130, 180, 25);
        add(txtSifre);

        // Giriş Butonu
        JButton btnGiris = new JButton("Giriş Yap");
        btnGiris.setBounds(150, 190, 120, 35);
        btnGiris.setBackground(new Color(70, 130, 180)); 
        btnGiris.setForeground(Color.WHITE); 
        add(btnGiris);

        // Hata Bilgilendirme (Hata mesajları için)
        JLabel lblMesaj = new JLabel("");
        lblMesaj.setForeground(Color.RED);
        lblMesaj.setBounds(50, 240, 300, 25);
        lblMesaj.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblMesaj);

        // --- BUTON AKSİYONU ---
        btnGiris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // .trim() metodu baştaki ve sondaki gereksiz boşlukları siler
                String email = txtEmail.getText().trim(); 
                
                // JPasswordField'den şifreyi doğru alma yöntemi:
                String sifre = new String(txtSifre.getPassword()).trim();

                // --- HATA AYIKLAMA (Konsola Bak) ---
                System.out.println("Girilen Email: '" + email + "'");
                System.out.println("Girilen Şifre: '" + sifre + "'");
                // -----------------------------------

                // 1. Yönetici Girişi Kontrolü 
                if (email.equals("admin") && sifre.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Yönetici Girişi Başarılı!");
                    new AnaEkranGUI("Admin"); 
                    dispose(); 
                } 
                // 2. Müşteri Girişi Kontrolü
                else {
                    if (musteriDogrula(email, sifre)) {
                        JOptionPane.showMessageDialog(null, "Müşteri Girişi Başarılı!");
                        new AnaEkranGUI("Musteri"); 
                        dispose(); 
                    } else {
                        lblMesaj.setText("Hatalı E-posta veya Şifre!");
                        // Kullanıcıya neyin yanlış olduğunu göstermek için:
                        JOptionPane.showMessageDialog(null, "Giriş Başarısız!\nGirilen: " + email + " - " + sifre);
                    }
                }
            }
        });

        setVisible(true); // Pencereyi görünür yap
    }

    // Veritabanına gidip kullanıcıyı sorgulayan metot
    private boolean musteriDogrula(String email, String sifre) {
        // SQL Sorgusu: Email ve Şifre eşleşiyor mu?
        String query = "SELECT * FROM musteriler WHERE email = ? AND sifre = ?";
        
        try {
            // Güvenli sorgu (PreparedStatement) kullanıyoruz
            PreparedStatement ps = db.getConn().prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, sifre);
            
            ResultSet rs = ps.executeQuery();
            
            
            return rs.next(); 
            
           } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}