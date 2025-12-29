package Sistem;

import java.util.Scanner;

public class GaleriTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secim;

        while (true) {
            System.out.println("\n===== OTO GALERİ OTOMASYONU =====");
            System.out.println("1) Araç İşlemleri");
            System.out.println("2) Müşteri İşlemleri");
            System.out.println("3) Satış İşlemleri");
            System.out.println("4) Raporlar");
            System.out.println("0) Çıkış");
            System.out.print("Seçim: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    aracMenu(scanner);
                    break;
                case 2:
                    musteriMenu(scanner);
                    break;
                case 3:
                    satisMenu(scanner);
                    break;
                case 4:
                    raporMenu(scanner);
                    break;
                case 0:
                    System.out.println("Program kapatılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Hatalı seçim! Tekrar deneyin.");
            }
        }
    }

    
    public static void aracMenu(Scanner scanner) {
        int secim;

        while (true) {
            System.out.println("\n--- Araç İşlemleri ---");
            System.out.println("1) Araç Ekle");
            System.out.println("2) Araç Sil");
            System.out.println("3) Araç Güncelle");
            System.out.println("4) Araç Listele");
            System.out.println("5) Araç Ara");
            System.out.println("0) Geri Dön");
            System.out.print("Seçim: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Araç ekleme işlemi çalıştı (test).");
                    break;
                case 2:
                    System.out.println("Araç silme işlemi çalıştı (test).");
                    break;
                case 3:
                    System.out.println("Araç güncelleme işlemi çalıştı (test).");
                    break;
                case 4:
                    System.out.println("Araç listeleme işlemi çalıştı (test).");
                    break;
                case 5:
                    System.out.println("Araç arama işlemi çalıştı (test).");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Hatalı seçim!");
            }
        }
    }

    
    public static void musteriMenu(Scanner scanner) {
        int secim;

        while (true) {
            System.out.println("\n--- Müşteri İşlemleri ---");
            System.out.println("1) Müşteri Ekle");
            System.out.println("2) Müşteri Sil");
            System.out.println("3) Müşteri Güncelle");
            System.out.println("4) Müşteri Listele");
            System.out.println("0) Geri Dön");
            System.out.print("Seçim: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Müşteri ekleme işlemi çalıştı (test).");
                    break;
                case 2:
                    System.out.println("Müşteri silme işlemi çalıştı (test).");
                    break;
                case 3:
                    System.out.println("Müşteri güncelleme işlemi çalıştı (test).");
                    break;
                case 4:
                    System.out.println("Müşteri listeleme işlemi çalıştı (test).");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Hatalı seçim!");
            }
        }
    }

    
    public static void satisMenu(Scanner scanner) {
        int secim;

        while (true) {
            System.out.println("\n--- Satış İşlemleri ---");
            System.out.println("1) Satış Yap");
            System.out.println("2) Satış Listele");
            System.out.println("0) Geri Dön");
            System.out.print("Seçim: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Satış yapma işlemi çalıştı (test).");
                    break;
                case 2:
                    System.out.println("Satış listeleme işlemi çalıştı (test).");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Hatalı seçim!");
            }
        }
    }

    
    public static void raporMenu(Scanner scanner) {
        int secim;

        while (true) {
            System.out.println("\n--- Raporlar ---");
            System.out.println("1) Satılan Araçlar");
            System.out.println("2) Satış Toplamı");
            System.out.println("3) En Çok Satılan Marka");
            System.out.println("4) Satılık Araç Listesi");
            System.out.println("0) Geri Dön");
            System.out.print("Seçim: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Satılan araçlar raporu çalıştı (test).");
                    break;
                case 2:
                    System.out.println("Toplam satış tutarı raporu çalıştı (test).");
                    break;
                case 3:
                    System.out.println("En çok satılan marka raporu çalıştı (test).");
                    break;
                case 4:
                    System.out.println("Satılık araç listesi raporu çalıştı (test).");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Hatalı seçim!");
            }
        }
    }
}

