import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;

public class AffichageFenetreJeu extends JPanel {
	
	int ValeurSelection = 0;

	//Définition du panel central
	JPanel panelC = new JPanel();
	//Définition du dossier qui contient tous les terrains
	CardLayout PlusieursTerrains = new CardLayout(0, 0);
	//Définitions des 4 terrains
	AffichagePlateau T1 = new AffichagePlateau();
	JPanel T2 = new JPanel();
	AffichagePanelDeJeu T3 = new AffichagePanelDeJeu();
	AffichagePlateau T4 = new AffichagePlateau();


	//Définition du panel du haut et du bas
	AffichagePanelDeJeu panelN = new AffichagePanelDeJeu();
	AffichagePanelDeJeu panelS = new AffichagePanelDeJeu();
	
	//Définition du bouton de selection des terrains
	String[] listeIndice = {"Choix", "Terrain pour le 1er joueur", "Terrain pour le 2ème joueur", "Terrain pour le 3ème joueur", "Terrain pour le 4ème joueur"};
	JComboBox SelectionDefilante = new JComboBox();
	
	//Définition du bouton pour le retour au menu
	JButton btnRetournerAuMenu = new JButton("Retourner au menu");

	//Définition de la 1ère et 2ème zone de texte
	JLabel lblPlateau = new JLabel();
	JLabel lbl = new JLabel();


	public AffichageFenetreJeu() {

		this.setLayout(new GridLayout(3, 1, 0, 0));
		
			//PANEL NORD
			this.add(panelN, "Haut" );
			panelN.setLayout(new GridBagLayout());
			lblPlateau.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));				
			lblPlateau.setForeground(Color.WHITE);
			lblPlateau.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlateau.setBounds(152, 16, 146, 16);
			GridBagConstraints gbc_lblPlateau = new GridBagConstraints();
			gbc_lblPlateau.insets = new Insets(0, 0, 5, 5);
			gbc_lblPlateau.gridx = 0;
			gbc_lblPlateau.gridy = 0;
			panelN.add(lblPlateau, gbc_lblPlateau);
			
			//PANEL CENTRALE
			this.add(panelC, "Central");
			//Mise en place du dossier qui contient tous les terrains
			panelC.setLayout(PlusieursTerrains);
			panelC.add(T1,listeIndice[1]);
			panelC.add(T2,listeIndice[2]);
			panelC.add(T3,listeIndice[3]);
			panelC.add(T4,listeIndice[4]);
			
			//PANEL SUD
			this.add(panelS, "Bas");
			panelS.setLayout(new GridLayout(0, 2, 0, 0));		
			//Mise en place du bouton pou retouner au menu
			btnRetournerAuMenu.setBounds(281, 45, 163, 29);
			panelS.add(btnRetournerAuMenu);
			//Mise en place de la seconde zone de texte
			lbl.setForeground(Color.WHITE);
			lbl.setFont(new Font("Skia", Font.ITALIC, 20));
			panelS.add(lbl);
			//Mise en place du bouton de la selection des terrains
			SelectionDefilante.setModel(new DefaultComboBoxModel(new String[] {"Choissisez votre Terrain...", "Terrain 1", "Terrain 2", "Terrain 3", "Terrain 4"}));
			panelS.add(SelectionDefilante);
			SelectionDefilante.setBounds(152, 33, 146, 41);
			//Définition de l'action au moment du choix sur le bouton de selection des terrains
			SelectionDefilante.addActionListener(new ActionListener()	{
				@Override
				public void actionPerformed (ActionEvent e){
			        String s = (String) SelectionDefilante.getSelectedItem();//get the selected item    
	                switch (s) {//check for a match
	                    case "Terrain 1":
	                        ValeurSelection = 1;
	                        break;
	                    case "Terrain 2":
	                        ValeurSelection = 2; 
	                        break;
	                    case "Terrain 3":
	                        ValeurSelection = 3;
	                        break;   
	                    case "Terrain 4":
	                    	ValeurSelection = 4;
	                    	break;
	                }
	                lbl.setText("Vous êtes sur le " + ((JComboBox) e.getSource()).getItemAt(ValeurSelection));
                    lblPlateau.setText("Plateau #" + ValeurSelection);
	                PlusieursTerrains.show(panelC, listeIndice[ValeurSelection]);

	            }
			});
	}



}
