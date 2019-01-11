import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonTuile extends JButton {
	
	public BoutonTuile (Tuile Tuile, String img) {
		super("Domino : " + Tuile.getnumdomi() + "Tuile : " + Tuile.getnumtuile());

		setForeground(Color.WHITE);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false); 
        setFocusPainted(false);
        //setRolloverIcon(Tuile.nbCouronne); il faut creer cette méthode 
        int Couronnes = Tuile.getnbcouronne(); // POURQUOI TUILE N'EST PAS EN GRAS ?
        
        //Creer une image pour chaque type avec chaqque couronne
    	switch(Tuile.gettype()) {
    	case "Mer":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon(img));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon(img));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon(img)); 
        	}
        	else if (Tuile.getnbcouronne() == 3) {
        		setIcon(new ImageIcon(img));
        	}
    		break;
    	case "Montagne":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon(img));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon(img));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon(img)); 
        	}
        	else if (Tuile.getnbcouronne() == 3) {
        		setIcon(new ImageIcon(img));
        	}
    		break;
    	case "Mine":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon(img));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon(img));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon(img)); 
        	}
        	else if (Tuile.getnbcouronne() == 3) {
        		setIcon(new ImageIcon(img));
        	}
    		break;
    	case "Prairie":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon(img));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon(img));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon(img)); 
        	}
        	else if (Tuile.getnbcouronne() == 3) {
        		setIcon(new ImageIcon(img));
        	}
    		break;
    	case "Foret":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon(img));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon(img));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon(img)); 
        	}
        	else if (Tuile.getnbcouronne() == 3) {
        		setIcon(new ImageIcon(img));
        	}
    		break;
    	case "Champs":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon(img));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon(img));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon(img)); 
        	}
        	else if (Tuile.getnbcouronne() == 3) {
        		setIcon(new ImageIcon(img));
        	}
    		break;
    	}
    	

    }

	

}
