package Sistem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SatisGUI extends JFrame {

    private SQL db = new SQL();
    private DefaultTableModel model;
    private JTable table;
    
    private JTextField txtPlaka, txtMusteriId, txtFiyat;

    public SatisGUI() {
        setTitle("Satış İşlemleri");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // --- GEÇMİŞ SATIŞLAR TABLOSU ---
        JLabel lblTablo = new JLabel("Geçmiş Satışlar");
        lblTablo.setBounds(20, 10, 200, 20);
        add(lblTablo);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Satış No", "Araç Plaka", "Müşteri ID", "Tarih", "Fiyat"});
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 35, 750, 250);
        add(scrollPane);

        // --- SATIŞ YAPMA BÖLÜMÜ ---
        JLabel lblIslem = new JLabel("Yeni Satış Yap");
        lblIslem.setFont(new Font("Arial", Font.BOLD, 14));
        lblIslem.setBounds(20, 300, 200, 20);
        add(lblIslem);

        // Plaka
        JLabel lblPlaka = new JLabel("Araç Plaka:");
        lblPlaka.setBounds(20, 330, 80, 25);
        add(lblPlaka);
        
        txtPlaka = new JTextField();
        txtPlaka.setBounds(100, 330, 120, 25);
        add(txtPlaka);

        // Müşteri ID
        JLabel lblMus = new JLabel("Müşteri ID:");
        lblMus.setBounds(240, 330, 80, 25);
        add(lblMus);
        
        txtMusteriId = new JTextField();
        txtMusteriId.setBounds(320, 330, 120, 25);
        add(txtMusteriId);

        // Fiyat
        JLabel lblFiyat = new JLabel("Satış Fiyatı:");
        lblFiyat.setBounds(460, 330, 80, 25);
        add(lblFiyat);
        
        txtFiyat = new JTextField();
        txtFiyat.setBounds(540, 330, 120, 25);
        add(txtFiyat);

        // Buton
        JButton btnSat = new JButton("SATIŞI ONAYLA");
        btnSat.setBounds(20, 380, 200, 40);
        btnSat.setBackground(new Color(52, 152, 219)); // Mavi
        btnSat.setForeground(Color.WHITE);
        add(btnSat);

        // --- AKSİYON ---
        btnSat.addActionListener(e -> {
            try {
                String plaka = txtPlaka.getText();
                int mId = Integer.parseInt(txtMusteriId.getText());
                double fiyat = Double.parseDouble(txtFiyat.getText());

                // SatisIslem sınıfındaki metodu çağırıyoruz
                SatisIslem.satisYap(db, plaka, mId, fiyat);
                
                listele(); // Tabloyu yenile
                JOptionPane.showMessageDialog(null, "Satış Kaydedildi!");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hata: Bilgileri kontrol ediniz.\n" + ex.getMessage());
            }
        });

        listele();
        setVisible(true);
    }

    private void listele() {
        model.setRowCount(0);
        ResultSet rs = db.select("SELECT * FROM satislar");
        try {
            while (rs != null && rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("arac_plaka"),
                    rs.getInt("musteri_id"),
                    rs.getDate("tarih"),
                    rs.getDouble("fiyat")
                });
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}