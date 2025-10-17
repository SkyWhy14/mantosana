package Uzd_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class metodes {
	static String virknesParbuade(String zinojums,String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums,noklusejums);
			if(virkne == null)
				return null;
			
			virkne = virkne.trim();
			
		}while(!Pattern.matches("^[\\p{L} .]+$", virkne));
		return virkne;
	}
public 	static double skaitlaParbaude(String zinojums,int min,int max) {
		
		double  skaitlis;
		while(true) {
			String ievade = JOptionPane.showInputDialog(null,zinojums,"Datu ievade",JOptionPane.INFORMATION_MESSAGE);
			if(ievade == null)
				return -1;
			
			try {
				skaitlis = Double.parseDouble(ievade);
				if(skaitlis <min || skaitlis > max) {
					JOptionPane.showMessageDialog(null, "Noradits nederigs intervals","Nekorekti dati",JOptionPane.WARNING_MESSAGE);
					continue;
				}
				return skaitlis;
				
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Netika ievadits vesels skaitlis","Nekorekti dati",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
static JSlider bidjosla(JOptionPane jop, int max) {
	JSlider js = new JSlider(JSlider.HORIZONTAL, 1, max, 1);
	js.setMajorTickSpacing(1);
	js.setPaintTicks(true);
	js.setPaintLabels(true);
	jop.setInputValue(js.getValue());
	
	ChangeListener cl = new ChangeListener() {
		public void stateChanged(ChangeEvent ce) {
			JSlider sl = (JSlider) ce.getSource();
			
			if(!sl.getValueIsAdjusting()) {
				jop.setInputValue(Integer.valueOf(sl.getValue()));
			}
		}
	};
	js.addChangeListener(cl);
	return js;
}
static int iestatitSedekli() {
	JFrame jf = new JFrame();
	JOptionPane jop = new JOptionPane();
	JSlider js = bidjosla(jop, 6);
	jop.setMessage(new Object[] {"Kādu pozu iestatit sēdeklim?", js});
	jop.setMessageType(JOptionPane.QUESTION_MESSAGE);
	jop.setOptionType(JOptionPane.OK_CANCEL_OPTION);
	JDialog jd = jop.createDialog(jf, "Ātruma iestatīšana");
	jd.setVisible(true);
	return (int)jop.getInputValue();
}

static int iestatitAtrumu() {
	JFrame jf = new JFrame();
	JOptionPane jop = new JOptionPane();
	JSlider js = bidjosla(jop, 16);
	jop.setMessage(new Object[] {"Kuru ātrumu iestatīt?", js});
	jop.setMessageType(JOptionPane.QUESTION_MESSAGE);
	jop.setOptionType(JOptionPane.OK_CANCEL_OPTION);
	JDialog jd = jop.createDialog(jf, "Ātruma iestatīšana");
	jd.setVisible(true);
	return (int)jop.getInputValue();
}
//metode kas panem arraylist un parada visus izveidotos ritenus un atrgriez izveleta ritena indeksu
static int ritenaIzvele(ArrayList <Object> riteni) {
	String[] rSaraksts = new String[riteni.size()] ;
	for(int i=0; i<rSaraksts.length; i++) {
		rSaraksts[i] = 
			(((Velosipeds)riteni.get(i)).noteiktRaz())+" "+
			(((Velosipeds)riteni.get(i)).noteiktCenu())+"EUR";
	}
	
	String izveletais = (String)JOptionPane.showInputDialog(null,
			"Izvēlies riteni: ", "Izvēle", JOptionPane.QUESTION_MESSAGE, null,
			rSaraksts,rSaraksts[0]);
	
	return Arrays.asList(rSaraksts).indexOf(izveletais);
}
}
