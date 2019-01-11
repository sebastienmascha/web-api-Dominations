
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class BoutonsPlateau extends JButton {
	AffichagePanelDeJeu4 a = new AffichagePanelDeJeu4();
	public BoutonsPlateau(String Titre, String img, String imgflottante) {
		super(Titre);
		//this.add(a);
		setForeground(Color.WHITE);
        
        setOpaque(false);
        setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
        setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
        setFocusPainted(false); // On n'affiche pas l'effet de focus.
         
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
          
        setIcon(new ImageIcon(img));
        setRolloverIcon(new ImageIcon(imgflottante));
        //Rajouter la main survolante
	}

}
