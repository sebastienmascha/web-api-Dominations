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
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Container;

import javax.swing.border.MatteBorder;
import java.awt.BorderLayout;

public class AffichageFenetreJeu extends JPanel {
	

	//Définition des différents écrans  (effet de panels qui tournent)
	JPanel EcranSud = new JPanel();
	JPanel EcranNord = new JPanel();
	AffichagePlateau EcranEst = new AffichagePlateau();
	AffichagePlateau EcranOuest = new AffichagePlateau();
	
	//Définition des dossiers qui contiennent tous les terrains
	CardLayout PlusieursTerrainsSud = new CardLayout(0, 0);
	CardLayout PlusieursTerrainsNord = new CardLayout(0, 0);
	
	//Définitions des 4 terrains sur l'ecran du Nord
	AffichagePlateau T1 = new AffichagePlateau();
	JPanel T2 = new JPanel();
	AffichagePanelDeJeu T3 = new AffichagePanelDeJeu();
	AffichagePlateau T4 = new AffichagePlateau();
	
	//Définition des panels inutilisés
	AffichagePanelDeJeu NordEst = new AffichagePanelDeJeu();
	AffichagePanelDeJeu NordOuest = new AffichagePanelDeJeu();
	AffichagePanelDeJeu SudEst = new AffichagePanelDeJeu();
	AffichagePanelDeJeu Centre = new AffichagePanelDeJeu();
	AffichagePanelDeJeu SudOuest = new AffichagePanelDeJeu();

	//Définition du bouton de selection des terrains
	String[] IndiceTerrain = {"Choix", "Terrain pour le 1er joueur", "Terrain pour le 2ème joueur", "Terrain pour le 3ème joueur", "Terrain pour le 4ème joueur"};
	
	//Définition du bouton pour le retour au menu
	JButton btnRetournerAuMenu = new JButton("Retourner au menu");

	//Définition de la 1ère et 2ème zone de texte
	JLabel lblPlateau = new JLabel();
	JLabel lbl = new JLabel();
	JPanel test =new JPanel();

	public AffichageFenetreJeu() {
			setLayout(new GridLayout(3, 3, 0, 0));
			
			this.add(NordOuest);
			NordOuest.setLayout(new GridBagLayout());
			
			
			this.add(EcranNord);

			
			this.add(NordEst);
			btnRetournerAuMenu.setBounds(281, 45, 163, 29);
			NordEst.add(btnRetournerAuMenu);
			
			this.add(EcranEst);
			
			this.add(Centre);
			
			this.add(EcranOuest);
			
			this.add(SudOuest);
			
			this.add(EcranSud);
			EcranSud.setBackground(Color.ORANGE);
			EcranSud.setLayout(new BorderLayout(0, 0));
			EcranSud.add(lblPlateau, BorderLayout.NORTH);
				lblPlateau.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));								
				lblPlateau.setForeground(Color.WHITE);
			EcranSud.add(test, BorderLayout.CENTER);
			//Mise en place du dossier du Joueur actif (à qui c'est de jouer quoi)
			
			test.setLayout(PlusieursTerrainsSud);
			test.add(T1,IndiceTerrain[1]);
			test.add(T2,IndiceTerrain[2]);
			test.add(T3,IndiceTerrain[3]);
			test.add(T4,IndiceTerrain[4]);
			test.setBorder(new MatteBorder(5, 4, 4, 5, (Color) Color.ORANGE));
			test.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{T1, T2, T3, T4}));
			
			this.add(SudEst);
        }
	
	public ActionListener ChangerTerrain = new ActionListener() {
		@Override
		public void actionPerformed (ActionEvent e){ 
			String NomEcran = ((JPanel) e.getSource()).getName();
			switch (NomEcran) {
				case "EcranSud" :
					
					break;
				case "EcranOuest" :

					break;
				case "EcranNord" :

					break;
				case "EcranEst" :

					break;
			}				
			((Container) e.getSource()).removeAll();
		}
	};
}




