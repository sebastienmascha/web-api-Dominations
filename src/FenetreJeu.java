import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FenetreJeu extends JPanel {

	PanelDeJeu panelC = new PanelDeJeu();
	PanelDeJeu panelN = new PanelDeJeu();
	PanelDeJeu panelS = new PanelDeJeu();
	
	JLabel lblPlateau = new JLabel("Plateau #1");
	JComboBox SelectionDefilante = new JComboBox();
	JButton btnRetournerAuMenu = new JButton("Retourner au menu");
	

			
	public FenetreJeu() {

		this.setLayout(new GridLayout(3, 1, 0, 0));
		
			//PANEL NORD
			this.add(panelN, "Haut" );
			panelN.setLayout(null);
			lblPlateau.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));				lblPlateau.setForeground(Color.RED);
			lblPlateau.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlateau.setBounds(152, 16, 146, 16);
			panelN.add(lblPlateau);
			SelectionDefilante.setBounds(152, 33, 146, 41);
			panelN.add(SelectionDefilante);
			
			
			//PANEL CENTRALE
			panelC.setLayout(new GridLayout(9, 9, 0, 0));
			for (int i=1; i <=40; i++) {
				panelC.add(new JButton("Domino " + i), BorderLayout.CENTER);}
			for (int i=42; i <=81; i++) {
				panelC.add(new JButton("Domino " + i), BorderLayout.CENTER);}
			this.add(panelC, "Central");
			panelC.add(new JButton(new ImageIcon("chateau.jpg")), BorderLayout.CENTER);
			this.add(panelS, "Bas");
				
			//PANEL SUD
			panelS.setLayout(null);
			btnRetournerAuMenu.setBounds(281, 45, 163, 29);
			panelS.add(btnRetournerAuMenu);
	}

}
