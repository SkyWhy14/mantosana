package Uzd_1;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class RitenBraucejs {
	
	public static void main(String[] args) {
		String izvele;
		int izvelesID;
		String [] darbibas = {"Jauns ritens","Nonemt riteni","Ritenu saraksts","Kartot pec cenas","Izsaukt metodi","Apturēt"};
		String [] veidi = {"Velosipēds","Kalnu ritenis","Bērnu ritenis"};
		String [] atbilde= {"Jā","Nē"};
		ArrayList<Object> riteni = new ArrayList<>();
				do {
					izvele = (String) JOptionPane.showInputDialog(null, "Izvelies darbibu","Darbibu izvele",JOptionPane.QUESTION_MESSAGE,null,darbibas,darbibas[0]);
					if(izvele == null)
						break;
					izvelesID = Arrays.asList(darbibas).indexOf(izvele);
					switch(izvelesID) {
					case 0 : 
					
						izvele = (String) JOptionPane.showInputDialog(null, "Izvelies ritena veidu","Ritena veida izvele",JOptionPane.QUESTION_MESSAGE,null,veidi,veidi[0]);
						if(izvele == null)
							break;
						izvelesID = Arrays.asList(veidi).indexOf(izvele);
						String razotajs = metodes.virknesParbuade("Ievadi ritena marku","Rockmachine");
						
						double cena = metodes.skaitlaParbaude("Ievadi ritena cenu (0.0 - 10000.0)",0,10000);
						
						double diametrs = metodes.skaitlaParbaude("Ievadi ritena ratu diametru collas (12.0 - 26.0)",12,26);
						//ja veido parastu riteni
						int sezPoz = metodes.iestatitSedekli();
						if(izvelesID == 0) {
							riteni.add(new Velosipeds((int)diametrs,sezPoz,cena,razotajs));
							JOptionPane.showMessageDialog(null, "Ritens veiksmigi pievienots","Jauns ritens",JOptionPane.INFORMATION_MESSAGE);
							
							//ja veido kalna riteni
						}else if (izvelesID == 1){
							int iestatAtr = metodes.iestatitAtrumu();
							JOptionPane.showMessageDialog(null, "Iestatītais ātrums: "+iestatAtr+"m/s","Ātruma iestatīšana",JOptionPane.INFORMATION_MESSAGE);
							izvele = (String) JOptionPane.showInputDialog(null, "Vai ritenim ir pieejams amortizators?","Amortizatora pieejamība",JOptionPane.QUESTION_MESSAGE,null,atbilde,atbilde[0]);
						if(izvele == null)
							break;
							izvelesID = Arrays.asList(atbilde).indexOf(izvele);
							boolean atsperes = (izvelesID == 0) ? true : false;
							riteni.add(new KalnuRitenis(iestatAtr,atsperes,(int)diametrs,sezPoz,cena,razotajs));
							JOptionPane.showMessageDialog(null, "Kalnu ritens veiksmigi pievienots","Jauns ritens",JOptionPane.INFORMATION_MESSAGE);
						
						}else if(izvelesID == 2) {
							izvele = (String) JOptionPane.showInputDialog(null, "Vai ritenim ir pieejams palīgritenis?","Palīgriteņa pieejamība",JOptionPane.QUESTION_MESSAGE,null,atbilde,atbilde[0]);
							if(izvele == null)
								break;
							izvelesID = Arrays.asList(atbilde).indexOf(izvele);
							boolean paligriten = (izvelesID == 0) ? true : false;
							
							izvele = (String) JOptionPane.showInputDialog(null, "Vai ritenim ir pieejams zvaniņš?","Zvaniņa pieejamība",JOptionPane.QUESTION_MESSAGE,null,atbilde,atbilde[0]);
							if(izvele == null)
								break;
							izvelesID = Arrays.asList(atbilde).indexOf(izvele);
							boolean zvanins = (izvelesID == 0) ? true : false;
							
							riteni.add(new Bernuritenis(paligriten,zvanins,(int)diametrs,sezPoz,razotajs,cena));
							JOptionPane.showMessageDialog(null, "Bērnu ritens veiksmigi pievienots","Jauns ritens",JOptionPane.INFORMATION_MESSAGE);
						}
						
						
						
						break;
					case 5:
						JOptionPane.showMessageDialog(null, "Programma apturēta","Beigas",JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}while(izvelesID!= 5);
	}

}
