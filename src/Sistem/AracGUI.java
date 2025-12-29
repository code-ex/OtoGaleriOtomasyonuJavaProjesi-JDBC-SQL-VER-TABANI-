package Sistem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AracGUI extends JFrame {

    private SQL db = new SQL(); // Veritabanı bağlantısı
    private DefaultTableModel model;
    private JTable table;
    
    // Girdi Alanları
    private JTextField txtPlaka, txtMarka, txtModel, txtYil, txtFiyat, txtKm, txtRenk, txtDurum;

    public AracGUI() {
        setTitle("Araç İşlemleri Paneli");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Sadece bu pencereyi kapat
        setLocationRelativeTo(null);
        setLayout(null);

        // --- 1. TABLO (LİSTELEME) BÖLÜMÜ ---
        model = new DefaultTableModel();
        // Sütun başlıklarını ekle
        model.setColumnIdentifiers(new Object[]{"Plaka", "Marka", "Model", "Yıl", "Fiyat", "KM", "Renk", "Durum"});
        
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 850, 300); // Tablonun konumu
        add(scrollPane);

        // Tabloya Tıklama Olayı (Verileri kutulara doldur)
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int secilenSatir = table.getSelectedRow();
                txtPlaka.setText(model.getValueAt(secilenSatir, 0).toString());
                txtMarka.setText(model.getValueAt(secilenSatir, 1).toString());
                txtModel.setText(model.getValueAt(secilenSatir, 2).toString());
                txtYil.setText(model.getValueAt(secilenSatir, 3).toString());
                txtFiyat.setText(model.getValueAt(secilenSatir, 4).toString());
                txtKm.setText(model.getValueAt(secilenSatir, 5).toString());
                txtRenk.setText(model.getValueAt(secilenSatir, 6).toString());
                txtDurum.setText(model.getValueAt(secilenSatir, 7).toString());
            }
        });

        // --- 2. GİRİŞ KUTUCUKLARI ---
        int y = 340; // Başlangıç Y koordinatı
        
        addLabel("Plaka:", 20, y);    txtPlaka = addTextField(80, y);
        addLabel("Marka:", 250, y);   txtMarka = addTextField(310, y);
        addLabel("Model:", 480, y);   txtModel = addTextField(540, y);
        addLabel("Yıl:", 710, y);     txtYil = addTextField(750, y);

        y += 40; // Bir alt satıra geç
        addLabel("Fiyat:", 20, y);    txtFiyat = addTextField(80, y);
        addLabel("KM:", 250, y);      txtKm = addTextField(310, y);
        addLabel("Renk:", 480, y);    txtRenk = addTextField(540, y);
        addLabel("Durum:", 710, y);   txtDurum = addTextField(750, y);
        txtDurum.setText("Satışta"); // Varsayılan değer

        // --- 3. BUTONLAR ---
        JButton btnListele = new JButton("Listele / Yenile");
        btnListele.setBounds(100, 450, 150, 40);
        add(btnListele);

        JButton btnEkle = new JButton("Araç Ekle");
        btnEkle.setBounds(270, 450, 150, 40);
        btnEkle.setBackground(new Color(46, 204, 113)); // Yeşil
        add(btnEkle);

        JButton btnGuncelle = new JButton("Güncelle");
        btnGuncelle.setBounds(440, 450, 150, 40);
        btnGuncelle.setBackground(new Color(241, 196, 15)); // Sarı
        add(btnGuncelle);

        JButton btnSil = new JButton("Sil");
        btnSil.setBounds(610, 450, 150, 40);
        btnSil.setBackground(new Color(231, 76, 60)); // Kırmızı
        btnSil.setForeground(Color.WHITE);
        add(btnSil);

        // --- BUTON İŞLEVLERİ ---
        
        // Listeleme
        btnListele.addActionListener(e -> tablolariDoldur());

        // Ekleme
        btnEkle.addActionListener(e -> {
            AracIslem.aracEkle(db, 
                txtPlaka.getText(), txtMarka.getText(), txtModel.getText(), 
                Integer.parseInt(txtYil.getText()), Double.parseDouble(txtFiyat.getText()), 
                Integer.parseInt(txtKm.getText()), txtRenk.getText(), txtDurum.getText()
            );
            tablolariDoldur(); // Tabloyu yenile
            temizle();
        });

        // Silme
        btnSil.addActionListener(e -> {
            AracIslem.aracSil(db, txtPlaka.getText());
            tablolariDoldur();
            temizle();
        });

        // Güncelleme
     // AracGUI.java içindeki btnGuncelle aksiyonu:

        btnGuncelle.addActionListener(e -> {
            try {
                // 1. Bilgileri kutucuklardan al
                String plaka = txtPlaka.getText();
                double fiyat = Double.parseDouble(txtFiyat.getText());
                int km = Integer.parseInt(txtKm.getText()); // Kilometreyi de alıyoruz

                // 2. Güncellenmiş metoda gönder (4 parametre)
                AracIslem.aracGuncelle(db, plaka, fiyat, km);
                
                // 3. Tabloyu yenile
                tablolariDoldur();
                
                // Kullanıcıya bilgi ver
                javax.swing.JOptionPane.showMessageDialog(null, "Araç Başarıyla Güncellendi!");
                
            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Lütfen Fiyat ve KM alanlarına sadece sayı giriniz!");
            }
        });

        // Pencere açılınca otomatik listele
        tablolariDoldur();
        setVisible(true);
    }

    // --- YARDIMCI METOTLAR ---

    // Tabloyu veritabanından çekip dolduran metot
    private void tablolariDoldur() {
        model.setRowCount(0); 
        ResultSet rs = db.select("SELECT * FROM araclar");
        try {
            while(rs != null && rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("plaka"),
                    rs.getString("marka"),
                    rs.getString("model"),
                    rs.getInt("yil"),
                    rs.getDouble("fiyat"),
                    rs.getInt("km"),
                    rs.getString("renk"),
                    rs.getString("durum")
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    private void temizle() {
        txtPlaka.setText(""); txtMarka.setText(""); txtModel.setText("");
        txtYil.setText(""); txtFiyat.setText(""); txtKm.setText(""); txtRenk.setText("");
    }

    
    private void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 60, 25);
        add(lbl);
    }

    
    private JTextField addTextField(int x, int y) {
        JTextField txt = new JTextField();
        txt.setBounds(x, y, 120, 25);
        add(txt);
        return txt;
    }
}