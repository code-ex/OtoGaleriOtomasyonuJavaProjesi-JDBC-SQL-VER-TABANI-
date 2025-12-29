package Sistem;

public class Arac {
    private int id;
    private String marka;
    private String model;
    private int yil;
    private double fiyat;
    private int kilometre;
    private String renk;
    private String durum;
    private String plaka;




	public Arac(String plaka, String marka, String model, int yil , double fiyat, int kilometre, String renk, String durum)  {
		
		this.plaka = plaka;
		this.marka = marka;
		this.model = model;
		this.yil = yil;
		this.fiyat = fiyat;
		this.kilometre = kilometre;
		this.renk = renk;
		this.durum = durum;
		
		
	}
	
	public int getId() {
		return id;
	}
	public String getMarka() {
		return marka;
	}
	public String getModel() {
		return model;
	}
	public int getYil() {
		return yil;
	}
	public double getFiyat() {
		return fiyat;
	}
	public int getKilometre() {
		return kilometre;
	}
	public String getRenk() {
		return renk;
	}
	
	public String getPlaka() {
		return plaka;
	}

	public String getDurum() {
		return durum;
	}
	
	
}
