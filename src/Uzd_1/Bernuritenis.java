package Uzd_1;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Bernuritenis extends Velosipeds{
	//atributi
	private boolean paligriten,zvanins;
	//konstruktors
	public Bernuritenis(boolean paligriten, boolean zvanins, int ritenaD, int sedeklaPoz, String razotajs,
			double cena) {
		super(ritenaD, sedeklaPoz, cena, razotajs);
		this.paligriten = paligriten;
		this.zvanins = zvanins;
	}
	public void darbArPaligriteni(boolean darbiba) {
		if(darbiba && paligriten == false) {
			paligriten = true;
			JOptionPane.showMessageDialog(null, "Palīgritenis uzlikts","Pazinojums",JOptionPane.INFORMATION_MESSAGE);
	}else if(darbiba == false && paligriten ) {
		paligriten = false;
		JOptionPane.showMessageDialog(null, "Palīgritenis noņemts","Pazinojums",JOptionPane.INFORMATION_MESSAGE);
	} else {
		JOptionPane.showMessageDialog(null, "Darbibba nav ie","Bridinajums",JOptionPane.WARNING_MESSAGE);
	}
 }
	public void zvanitZvaninu() throws MalformedURLException,
		UnsupportedAudioFileException,IOException, LineUnavailableException {
			if(zvanins) {
				File f = new File(".//audio//"+"ring.wav");
				AudioInputStream ais =AudioSystem.getAudioInputStream(f.toURI().toURL());
				Clip c = AudioSystem.getClip();
				c.open(ais);
				c.start();
				
			}else
				JOptionPane.showMessageDialog(null, "Zvaniņš nav pieejams","Bridinajums",JOptionPane.WARNING_MESSAGE);
	}
}

		
	