import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AffichageBoutonTuile extends JButton {

	public AffichageBoutonTuile() {

	}

	public void setimage(ImageIcon img, JButton T) {
		Image newimg = img.getImage().getScaledInstance(T.getWidth(), T.getHeight(), java.awt.Image.SCALE_SMOOTH);
		T.setIcon(new ImageIcon(newimg));
	}

	public void display(Tuile Tuile, String titre, JButton T) {
		// super(titre);

		// super("Domino : " + Tuile.getnumdomi() + "Tuile : " + Tuile.getnumtuile());
		/*
		 * setForeground(Color.WHITE); setOpaque(false); setContentAreaFilled(false);
		 * setBorderPainted(false); setFocusPainted(false);
		 * setHorizontalAlignment(SwingConstants.CENTER);
		 * setHorizontalTextPosition(SwingConstants.CENTER);
		 */
		// setRolloverIcon(Tuile.nbCouronne); il faut creer cette méthode
		switch (Tuile.gettype()) {
		case "Mer":
			if (Tuile.getnbcouronne() == 0) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("mer.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 1) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("mer1.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 2) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("mer2.png"));
				setimage(img, T);
			}
			break;
		case "Montagne":
			if (Tuile.getnbcouronne() == 0) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("montagne.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 1) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("montagne1.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 2) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("montagne2.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 3) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("montagne3.png"));
				setimage(img, T);
			}
			break;
		case "Mine":
			if (Tuile.getnbcouronne() == 0) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("mine.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 1) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("mine1.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 2) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("mine2.png"));
				setimage(img, T);
			}
			break;
		case "Prairie":
			if (Tuile.getnbcouronne() == 0) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("prairie.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 1) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("prairie1.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 2) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("prairie2.png"));
				setimage(img, T);
			}
			break;
		case "Foret":
			if (Tuile.getnbcouronne() == 0) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("foret.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 1) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("foret1.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 2) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("foret2.png"));
				setimage(img, T);
			}
			break;
		case "Champs":
			if (Tuile.getnbcouronne() == 0) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("champs.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 1) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("champs1.png"));
				setimage(img, T);
			} else if (Tuile.getnbcouronne() == 2) {
				ImageIcon img = new ImageIcon(this.getClass().getResource("champs2.png"));
				setimage(img, T);
			}
			break;
		}
	}

}
