package Uzd_1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Ritenbraucejs {

	public static void main(String[] args) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		String izvele;
		int izvelesID;
		String[] darbibas = {"Jauns ritenis", "Noņemt riteni",
				"Riteņu saraksts", "Kārtot pēc cenas", "Izsaukt metodi",
				"Aizvērt programmu"};
		String[] veidi = {"Velosipēds", "Kalnu velosipēds", "Bērnu velosipēds"};
		String[] atbilde = {"Jā", "Nē"};
		ArrayList<Object> riteni = new ArrayList<>();
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību",
					"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
					,darbibas, darbibas[0]);
			if(izvele == null) break;
			
			izvelesID = Arrays.asList(darbibas).indexOf(izvele);
			
			switch(izvelesID) {
			case 0:
				izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies riteni",
						"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
						,veidi, veidi[0]);
				if (izvele == null)break;
				
				double ritenaD = Metodes.skaitlaParbaude("Ievadi riteņa diametru", 12, 29, "29");
				int sedeklaPoz = Metodes.iestatitSedekli();
				double cena = Metodes.skaitlaParbaude("Ievadi cenu", 1.0, 9999.99, "1000");
				String razotajs = Metodes.virknesParbaude("Ievadi ražotāju", "Intars");
				
				switch(izvele) {
				case "Velosipēds":
					riteni.add(new Velosipeds((int)ritenaD, sedeklaPoz, cena, razotajs));
					JOptionPane.showMessageDialog(null, "Veiksmīgi uztaisīts velosipēds",
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case "Kalnu velosipēds":
					int Atrums = Metodes.iestatitAtrumu();
				
					izvele = (String)JOptionPane.showInputDialog(null, "Vai būs atsperes",
							"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
							,atbilde, atbilde[0]);
					if(izvele == null) break;
					
					boolean a;
					if(izvele == "Jā")
						a = true;
					else a = false;
					
					riteni.add(new KalnuRitenis(Atrums, a,
							(int)ritenaD, sedeklaPoz, cena, razotajs));	
					JOptionPane.showMessageDialog(null, "Veiksmīgi uztaisīts kalnu ritenis",
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case "Bērnu velosipēds":
					izvele = (String)JOptionPane.showInputDialog(null, "Vai būs papildriteņi?",
							"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
							,atbilde, atbilde[0]);
					if(izvele == null) break;
					
					boolean rit;
					if(izvele == "Jā") rit = true;
					else rit = false;
					
					izvele = (String)JOptionPane.showInputDialog(null, "Vai būs zvaniņš?",
							"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
							,atbilde, atbilde[0]);
					if(izvele == null) break;
					
					boolean zvan;
					if(izvele == "Jā") zvan = true;
					else zvan = false;
					
					riteni.add(new BernuRitenis(rit, zvan,
							(int)ritenaD, sedeklaPoz, cena, razotajs));
					JOptionPane.showMessageDialog(null, "Veiksmīgi uztaisīts bērnu ritenis",
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				break;
			case 1:
				if(riteni.size() > 0) { 
					int ritID = Metodes.ritenaIzvele(riteni);
					
					riteni.remove(ritID);
					JOptionPane.showMessageDialog(null, "Veiksmīgi izdzēsts ritenis",
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Nav ievadīts neviens ritenis",
							"Kļūda", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				break;
				
			case 2:
				if(riteni.size() > 0) { 
					String str = "Riteņu skaits: "+riteni.size()+
							"\n_________________________________\n";
					for(int i=0; i<riteni.size(); i++) {
						str += ((Velosipeds)riteni.get(i)).izvadit()+
							"\n_________________________________\n";
					}
					
					JTextArea ta = new JTextArea (str, 10, 40);
					ta.setEditable(false);
					JScrollPane sp = new JScrollPane(ta);
					sp.setVerticalScrollBarPolicy(
							ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					JOptionPane.showMessageDialog(ta, sp, "Atzīmes",
							JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Nav ievadīts neviens ritenis",
							"Kļūda", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				break;
			case 3:
				if(riteni.size() > 0) {
					String atb = (String) JOptionPane.showInputDialog(null,
							"Kārtot riteņus pēc cenas augoši?", "Izvēle",
							JOptionPane.INFORMATION_MESSAGE, null, 
							atbilde, atbilde[0]);
					if(atb != null) {
						if(atb.equals("Jā")) {
							riteni.sort(null);
							JOptionPane.showMessageDialog(null, 
									"Riteņi sakārtoti augoši!", "Kārtošana",
									JOptionPane.INFORMATION_MESSAGE);
						}else {
							riteni.sort(Collections.reverseOrder());
							JOptionPane.showMessageDialog(null, 
									"Riteņi sakārtoti dilstoši!", "Kārtošana",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Nav ievadīts neviens ritenis",
							"Kļūda", JOptionPane.ERROR_MESSAGE);
					break;
				}
				break;
			case 4:
				if(riteni.size() > 0) {
					int kurs = Metodes.ritenaIzvele(riteni);
					String[] metodes = {"Noteikt riteņa izmēru",
							"Iestatīt sēdekli", "Noteikt kustības ātrumu",
							"Mīties", "Bremzēt", "Noteikt iestatīto ātrumu",
							"Pārslēgt ātrumu", "Palīgriteņi", "Zvaniņš"
					};
					
					izvele = (String) JOptionPane.showInputDialog(null,
							"Izvēlies metodi", "Izvēle", 
							JOptionPane.INFORMATION_MESSAGE, null,
							metodes, metodes[0]);
					if(izvele == null)break;
					
					izvelesID = Arrays.asList(metodes).indexOf(izvele);
					
					switch(izvelesID) {
					case 0:
						JOptionPane.showMessageDialog(null,
								"Riteņa izmērs: "+((Velosipeds)riteni.get(kurs)).noteiktRitenaD(), "Ievade", 
								JOptionPane.INFORMATION_MESSAGE);
						break;
					case 1:
						sedeklaPoz = Metodes.iestatitSedekli();
						((Velosipeds)riteni.get(kurs)).iestatitSedeklaPoz(sedeklaPoz);
						JOptionPane.showMessageDialog(null,
								"Veiksmīgi nomainīta sēdekļa pozīcija", "Paziņojums", 
								JOptionPane.INFORMATION_MESSAGE);
						break;
					case 2:
						JOptionPane.showMessageDialog(null,
								"Kustības ātrums: "+((Velosipeds)riteni.get(kurs)).noteiktAtr()+"km/h", "Paziņojums", 
								JOptionPane.INFORMATION_MESSAGE);
						break;
					case 3:
						((Velosipeds)riteni.get(kurs)).mities(kurs);
						JOptionPane.showMessageDialog(null,
								"Tu sāc mīties ātrāk", "Paziņojums", 
								JOptionPane.INFORMATION_MESSAGE);
						break;
					case 4:
					
						int berze = JOptionPane.showConfirmDialog(null, 
								"Bremzet?", "Bremzēšana", 
								JOptionPane.YES_NO_OPTION);
						if(berze == JOptionPane.YES_OPTION) {
							berze = 1;
							JOptionPane.showMessageDialog(null,
									"Tu bremzē ", "Paziņojums", 
									JOptionPane.INFORMATION_MESSAGE);
						
						}else if(berze == JOptionPane.NO_OPTION) {
							berze = 0;
							JOptionPane.showMessageDialog(null,
									"Tu nebremzē", "Paziņojums", 
									JOptionPane.INFORMATION_MESSAGE);
						}	else 
							break;
						
						
						((Velosipeds)riteni.get(kurs)).bremzet(berze);
						
						
						
						break;
					case 5:
						
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						if(riteni.get(kurs) instanceof BernuRitenis) {
							((BernuRitenis)riteni.get(kurs)).zvanitZvaninu();
						}else {
							JOptionPane.showMessageDialog(null, 
									"Šim riteņa veidam nav zvaniņš", "Paziņojums",
									JOptionPane.ERROR_MESSAGE);
						}
						break;
					
					}
				}else {
					JOptionPane.showMessageDialog(null, "Nav ievadīts neviens ritenis",
							"Kļūda", JOptionPane.ERROR_MESSAGE);
					break;
				}
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Programma apturēta", "Apturēta",
						JOptionPane.PLAIN_MESSAGE);
				break;
			}
		}while(izvelesID != 5);
		
	}
	

}