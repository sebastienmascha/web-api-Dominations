import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AffichageBoutonTuile extends JButton {
	
	public AffichageBoutonTuile (Tuile Tuile) {
		super("Domino : " + Tuile.getnumdomi() + "Tuile : " + Tuile.getnumtuile());

		setForeground(Color.WHITE);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false); 
        setFocusPainted(false);
        //setRolloverIcon(Tuile.nbCouronne); il faut creer cette méthode
        
       int Couronnes = Tuile.getnbcouronne();
        
        
    	switch(Tuile.gettype()) {
    	case "Mer":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/mer.png"));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/mer1.png"));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/mer2.png")); 
        	}
    		break;
    	case "Montagne":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/montagne.png"));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/montagne1.png"));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/montagne2.png")); 
        	}
        	else if (Tuile.getnbcouronne() == 3) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/montagne3.png"));
        	}
    		break;
    	case "Mine":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/mine.png"));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/mine1.png"));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/mine2.png")); 
        	}
    		break;
    	case "Prairie":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/prairie.png"));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/prairie1.png"));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/prairie2.png")); 
        	}
    		break;
    	case "Foret":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/foret.png"));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/foret1.png"));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/foret2.png")); 
        	}
    		break;
    	case "Champs":
        	if (Tuile.getnbcouronne() == 0) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/champs.png"));
        	}
        	else if (Tuile.getnbcouronne() == 1) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/champs1.png"));	
        	}
        	else if (Tuile.getnbcouronne() == 2) {
        		setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/champs2.png")); 
        	}
    		break;
    	}
    }
}
