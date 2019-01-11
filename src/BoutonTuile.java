import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonTuile extends JButton {
	
	public BoutonTuile (Tuile Tuile) {
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
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/mer.jpg"));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/mer1.jpg"));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/mer2.jpg")); 
        	}
    		break;
    	case "Montagne":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/montagne.jpg"));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/montagne1.jpg"));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/montagne2.jpg")); 
        	}
        	else if (Tuile.getnbcouronne() == 3) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/montagne3.jpg"));
        	}
    		break;
    	case "Mine":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/mine.jpg"));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/mine1.jpg"));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/mine2.jpg")); 
        	}
    		break;
    	case "Prairie":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/prairie.jpg"));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/prairie1.jpg"));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/prairie2.jpg")); 
        	}
    		break;
    	case "Foret":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/foret.jpg"));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/foret1.jpg"));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/foret2.jpg")); 
        	}
    		break;
    	case "Champs":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/champs.jpg"));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/champs1.jpg"));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/champs2.jpg")); 
        	}
    		break;
    	}
    	

    }

	

}
