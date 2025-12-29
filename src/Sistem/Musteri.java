package Sistem;

public class Musteri {
    private int id;
    private String ad;
    private String soyad;
    private String telefon;
    private String email;
    private String adres;
    private String sifre; 
    
   
    public Musteri(int id, String ad, String soyad, String telefon, String email, String adres, String sifre) {
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.telefon = telefon;
		this.email = email;
		this.adres = adres;
        this.sifre = sifre; 
	}
    
	public int getId() {
		return id;
	}
	public String getAd() {
		return ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public String getTelefon() {
		return telefon;
	}
	public String getEmail() {
		return email;
	}
	public String getAdres() {
		return adres;
	}
    public String getSifre() {
        return sifre;
    }
}