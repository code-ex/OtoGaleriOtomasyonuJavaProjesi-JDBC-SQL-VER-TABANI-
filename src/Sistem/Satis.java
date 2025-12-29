package Sistem;

import java.sql.Date;

public class Satis {
    private int id;
    private int aracID;
    private int musteriID;
    private Date tarih;
    private double fiyat;
    
    public Satis(int id, int aracID, int musteriID, Date tarih, double fiyat) {
		this.id = id;
		this.aracID = aracID;
		this.musteriID = musteriID;
		this.tarih = tarih;
		this.fiyat = fiyat;
	}
    
    	public int getId() {
		return id;
	}
    	
    	public int getAracID() {
		return aracID;
	}
    	
    	public int getMusteriID() {
		return musteriID;
	}
    	
		public Date getTarih() {
		return tarih;
	}
		
		public double getFiyat() {
		return fiyat;
	}
		
}

