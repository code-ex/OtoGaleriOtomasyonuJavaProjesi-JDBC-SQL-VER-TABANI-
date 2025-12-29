/*package Sistem;

import java.util.Scanner;

public class Main {
    
    static SQL db = new SQL(); 
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== OTO GALERİ OTOMASYONU =====");
            System.out.println("1 - Araç İşlemleri");
            System.out.println("2 - Müşteri İşlemleri");
            System.out.println("3 - Satış İşlemleri");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scan.nextInt();
            scan.nextLine(); 

            switch (secim) {
                case 1: aracMenu(); break;
                case 2: musteriMenu(); break;
                case 3: satisMenu(); break;
                case 0: 
                    db.close(); 
                    System.out.println("Program kapatıldı.");
                    return;
                default: System.out.println("Hatalı seçim!");
            }
        }
    }

    // ======== ARAÇ EKRANLARI ========
    public static void aracMenu() {
        while (true) {
            System.out.println("\n--- Araç İşlemleri ---");
            System.out.println("1 - Araç Ekle\n2 - Araç Sil\n3 - Araç Güncelle\n4 - Araç Listele\n0 - Geri Dön");
            System.out.print("Seçim: ");
            int secim = scan.nextInt();
            scan.nextLine(); 

            switch (secim) {
                case 1:
                    System.out.print("Plaka: "); String plaka = scan.nextLine();
                    System.out.print("Marka: "); String marka = scan.nextLine();
                    System.out.print("Model: "); String model = scan.nextLine();
                    System.out.print("Yıl: "); int yil = scan.nextInt();
                    System.out.print("Fiyat: "); double fiyat = scan.nextDouble();                       
                    System.out.print("Kilometre: "); int km = scan.nextInt();
                    scan.nextLine(); 
                    System.out.print("Renk: "); String renk = scan.nextLine();
                    System.out.print("Durum (Satışta/Satıldı): "); String durum = scan.nextLine();
                    
                    AracIslem.aracEkle(db, plaka, marka, model, yil, fiyat, km, renk, durum);
                    break;
                    
                case 2:
                    AracIslem.aracListele(db);
                    System.out.print("Silinecek Aracın Plakası: ");
                    String silPlaka = scan.nextLine();
                    AracIslem.aracSil(db, silPlaka);
                    break;
                    
                case 3:
                    AracIslem.aracListele(db);
                    System.out.print("Güncellenecek Aracın Plakası: ");
                    String gPlaka = scan.nextLine();
                    System.out.print("Yeni Fiyat: "); double nFiyat = scan.nextDouble();
                    AracIslem.aracGuncelle(db, gPlaka, nFiyat);
                    break;
                    
                case 4:
                    AracIslem.aracListele(db);
                    break;
                    
                case 0: return;
            }
        }
    }

    // ======== MÜŞTERİ EKRANLARI ========
    public static void musteriMenu() {
        while (true) {
            System.out.println("\n--- Müşteri İşlemleri ---");
            System.out.println("1 - Müşteri Ekle\n2 - Müşteri Listele\n0 - Geri Dön");
            System.out.print("Seçim: ");
            int secim = scan.nextInt();
            scan.nextLine();

            switch (secim) {
                case 1:
                    System.out.print("Ad: "); String ad = scan.nextLine();
                    System.out.print("Soyad: "); String soyad = scan.nextLine();
                    System.out.print("Telefon: "); String tel = scan.nextLine();
                    System.out.print("E-posta: "); String email = scan.nextLine();
                    System.out.print("Şifre: "); String sifre = scan.nextLine();
                    
                    MusteriIslem.musteriEkle(db, ad, soyad, tel, email, sifre);
                    break;
                case 2:
                    MusteriIslem.musteriListele(db);
                    break;
                case 0: return;
            }
        }
    }

    // ======== SATIŞ EKRANLARI ========
    public static void satisMenu() {
        while (true) {
            System.out.println("\n--- Satış İşlemleri ---");
            System.out.println("1 - Satış Yap\n2 - Satış Listele\n0 - Geri Dön");
            System.out.print("Seçim: ");
            int secim = scan.nextInt();
            scan.nextLine(); 

            switch (secim) {
                case 1:
                    AracIslem.aracListele(db);
                    System.out.print("Satılacak Aracın Plakası: "); 
                    String sPlaka = scan.nextLine();
                    
                    MusteriIslem.musteriListele(db);
                    System.out.print("Müşteri ID (Sayı): "); 
                    int mId = scan.nextInt();
                    
                    System.out.print("Satış Fiyatı: "); 
                    double sFiyat = scan.nextDouble();
                    
                    SatisIslem.satisYap(db, sPlaka, mId, sFiyat);
                    break;
                case 2:
                    SatisIslem.satisListele(db);
                    break;
                case 0: return;
            }
        }
    }
}*/


package Sistem;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Eski Scanner ve while döngülerini SİLDİK.
        // Artık sadece GUI'yi başlatıyoruz.
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI(); // Giriş ekranını aç
            }
        });
    }
}