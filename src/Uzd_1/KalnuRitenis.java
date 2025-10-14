package Uzd_1;

public class KalnuRitenis extends Velosipeds{
	private int iestatAtrums;
	private boolean atsperes;
	
	//konstruktors
	public KalnuRitenis(int iestatAtrums, boolean atsperes,
			int ritenaD, int sedeklaPoz, double cena, String razotajs) {
		super(ritenaD, sedeklaPoz, cena, razotajs);
		this.iestatAtrums = iestatAtrums;
		this.atsperes = atsperes;
	}
	
	//metodes
	public int noteiktIestatAtr() {
		return iestatAtrums;
	}
	public void parslegtAtr(int atr) {
		iestatAtrums = atr;
	}
	public String izvadit() {
		return "Riteņa ražotājs: "+noteiktRaz()+
				"\nRiteņa cena: "+noteiktCenu()+
				"\nRiteņa leilums collās: "+noteiktRitenaD()+
				"\nIEstatītais sēdekļa garums: "+noteiktSedeklaPoz()+
				"\nKustības ātrums: "+noteiktAtr()+"m/s"+
				"\nIestatītais ātrums: "+noteiktIestatAtr()+
				"\nPapildus amortizācija: "+((atsperes)? "Ir": "Nav");
	}
}