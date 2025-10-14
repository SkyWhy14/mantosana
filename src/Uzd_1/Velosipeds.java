package Uzd_1;

import java.util.Random;

public class Velosipeds {
//Atributi
	private int ritenaD,sedeklaPoz,kustiba;
	private double atrumsMS,cena;
	private String razotajs;
	
	
	//Konstruktors
	public Velosipeds(int ritenaD, int sedeklaPoz, String razotajs, double cena) {
		this.ritenaD = ritenaD;
		this.sedeklaPoz = sedeklaPoz;
		this.razotajs = razotajs;
		this.cena = cena;
	     atrumsMS = Kustiba();
		
	}
	public int noteiktRitenaD() {
		return ritenaD;
	}
	public int noteiktSedeklaPoz() {
		return sedeklaPoz;
	}
	public String noteiktRazotaju() {
		return razotajs;
	}
	public double noteiktCenu() {
		return cena;
	}
	public double noteiktatrumu() {
		return atrumsMS;
	}
	public double Kustiba() {
		Random rand = new Random();
		double celsM,laiksS;
		celsM = rand.nextDouble()*(1000-7)+1;
		
	}
	
	
}
