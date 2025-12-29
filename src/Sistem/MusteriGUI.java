package Sistem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MusteriGUI extends JFrame {

    private SQL db = new SQL();
    private DefaultTableModel model;
    private JTable table;
    
    // Giriş alanları
    private JTextField txtAd, txtSoyad, txtTel, txtEmail, txtAdres, txtSifre;
    private JLabel lblId; // Seçilen ID'yi tutmak için gizli veya görünür bir etiket

    public MusteriGUI() {
        setTitle("Müşteri Yönetim Paneli");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // --- TABLO ---
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID", "Ad", "Soyad", "Telefon", "Email", "Adres", "Şifre"});
        table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 850, 300);
        add(scrollPane);

        // Tablo Tıklama Olayı
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                lblId.setText(model.getValueAt(row, 0).toString()); // ID'yi al
                txtAd.setText(model.getValueAt(row, 1).toString());
                txtSoyad.setText(model.getValueAt(row, 2).toString());
                txtTel.setText(model.getValueAt(row, 3).toString());
                txtEmail.setText(model.getValueAt(row, 4).toString());
                txtAdres.setText(model.getValueAt(row, 5).toString());
                txtSifre.setText(model.getValueAt(row, 6).toString());
            }
        });

        // --- GİRİŞ ALANLARI ---
        int y = 340;
        lblId = new JLabel("0"); // Seçilen ID burada tutulacak
        lblId.setVisible(false); // Kullanıcı görmese de olur
        add(lblId);

        addLabel("Ad:", 20, y);       txtAd = addTextField(80, y);
        addLabel("Soyad:", 250, y);   txtSoyad = addTextField(310, y);
        addLabel("Tel:", 480, y);     txtTel = addTextField(540, y);
        
        y += 40;
        addLabel("Email:", 20, y);    txtEmail = addTextField(80, y);
        addLabel("Adres:", 250, y);   txtAdres = addTextField(310, y);
        addLabel("Şifre:", 480, y);   txtSifre = addTextField(540, y);

        // --- BUTONLAR ---
        JButton btnEkle = new JButton("Ekle");
        btnEkle.setBounds(270, 450, 150, 40);
        btnEkle.setBackground(new Color(46, 204, 113));
        add(btnEkle);

        JButton btnGuncelle = new JButton("Güncelle");
        btnGuncelle.setBounds(440, 450, 150, 40);
        btnGuncelle.setBackground(new Color(241, 196, 15));
        add(btnGuncelle);

        JButton btnSil = new JButton("Sil");
        btnSil.setBounds(610, 450, 150, 40);
        btnSil.setBackground(new Color(231, 76, 60));
        btnSil.setForeground(Color.WHITE);
        add(btnSil);

        // --- AKSİYONLAR ---
        btnEkle.addActionListener(e -> {
            MusteriIslem.musteriEkle(db, txtAd.getText(), txtSoyad.getText(), txtTel.getText(), txtEmail.getText(), txtAdres.getText(), txtSifre.getText());
            listele();
            temizle();
        });

        btnGuncelle.addActionListener(e -> {
            int id = Integer.parseInt(lblId.getText());
            MusteriIslem.musteriGuncelle(db, id, txtAd.getText(), txtSoyad.getText(), txtTel.getText(), txtEmail.getText(), txtAdres.getText(), txtSifre.getText());
            listele();
        });

        btnSil.addActionListener(e -> {
            int id = Integer.parseInt(lblId.getText());
            MusteriIslem.musteriSil(db, id);
            listele();
            temizle();
        });

        listele(); // Açılışta listele
        setVisible(true);
    }

    private void listele() {
        model.setRowCount(0);
        ResultSet rs = db.select("SELECT * FROM musteriler");
        try {
            while (rs != null && rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"), rs.getString("ad"), rs.getString("soyad"),
                    rs.getString("telefon"), rs.getString("email"), 
                    rs.getString("adres"), rs.getString("sifre")
                });
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private void temizle() {
        txtAd.setText(""); txtSoyad.setText(""); txtTel.setText("");
        txtEmail.setText(""); txtAdres.setText(""); txtSifre.setText(""); lblId.setText("0");
    }

    private void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 60, 25);
        add(lbl);
    }

    private JTextField addTextField(int x, int y) {
        JTextField txt = new JTextField();
        txt.setBounds(x, y, 150, 25);
        add(txt);
        return txt;
    }
}