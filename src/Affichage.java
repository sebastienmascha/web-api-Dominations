import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Affichage {

	//public static void main(String[] args) {}
	
	//On définit notre application
	JFrame FenetreJeu = new JFrame("Projet Kingdomino" );
	JPanel Panel = new JPanel();
	
	//On définit les différentes pages de notre application
	AffichageFenetreJeu PageJeu = new AffichageFenetreJeu();
	AffichageFenetreAccueil PageAccueil = new AffichageFenetreAccueil();
	JPanel pane = new JPanel();
	JPanel pan = new JPanel();

	JPanel pa = new JPanel();
	CardLayout PlusieursPages = new CardLayout(0, 0);
	GridBagLayout recadrage = new GridBagLayout();
	String[] listeIndice = {"Accueil", "Principal"};
	//int indice = 0;

	JComboBox<String> SelectionDefilante = new JComboBox<String>();
	int ValeurSelection = 0;


	public Affichage() {
		Initialisation();
	}

	public void Initialisation() {
		FenetreJeu.setIconImage(new ImageIcon ("//Users/lebens/Desktop/Dominations/images/ISEP.png").getImage());
		FenetreJeu.setBounds(100, 100, 450, 300);
		FenetreJeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FenetreJeu.getContentPane().setLayout(PlusieursPages);
		//FenetreJeu.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		//FenetreJeu.getContentPane().add(layeredPane);
		//FenetreJeu.getContentPane().add(pane);
		//pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
		//pane.add(PageAccueil);
		
			PageAccueil.btnJouer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					PlusieursPages.show(FenetreJeu.getContentPane(), listeIndice[1]);
				}
			});
			
			PageJeu.btnRetournerAuMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					PlusieursPages.show(FenetreJeu.getContentPane(), listeIndice[0]);
				}
			});
			
			SelectionDefilante.setModel(new DefaultComboBoxModel<String>(new String[] {"Choissisez votre Terrain...", "Terrain 1", "Terrain 2", "Terrain 3", "Terrain 4"}));		
			SelectionDefilante.addActionListener(ConfigJoueurs);
		PageJeu.Centre.add(SelectionDefilante);
		//SelectionDefilante.addItemListener();
		
		/**
		else if (Page
		Accueil.TroisJoueurs.isSelected()) {
		SelectionDefilante.setModel(new DefaultComboBoxModel(new String[] {"Choissisez votre Terrain...", "Terrain 1", "Terrain 2", "Terrain 3"}));
		}
		else if (PageAccueil.QuatreJoueurs.isSelected()) {
		SelectionDefilante.setModel(new DefaultComboBoxModel(new String[] {"Choissisez votre Terrain...", "Terrain 1", "Terrain 2", "Terrain 3","Terrain 4"}));
		}/*/
		
		FenetreJeu.getContentPane().add(PageAccueil,listeIndice[0]);
		FenetreJeu.getContentPane().add(Panel,listeIndice[1]);
		
		Panel.setLayout(recadrage);
		Panel.setBackground(Color.RED);
		Panel.add(PageJeu);
        Panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizePreview(PageJeu, Panel);
            }
        });
		//Panel.add(pan);
		
		//Panel.add(pa);

	}
	
	   private static void resizePreview(JPanel innerPanel, JPanel container) {
	        int w = container.getWidth();
	        int h = container.getHeight();
	        int size =  Math.min(w, h);
	        innerPanel.setPreferredSize(new Dimension(size, size));
	        container.revalidate();
	    }
	   
	//Définition de l'action au moment du choix sur le bouton de selection des terrains
	public ActionListener ConfigJoueurs = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		
	        //Pour afficher le Terrain de Jeu correspondant au Joueur dans l'EcranSud
	        String s = (String) SelectionDefilante.getSelectedItem();
            switch (s) {
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
            
            PageJeu.lbl.setText("Vous êtes sur le " + ((JComboBox) e.getSource()).getItemAt(ValeurSelection));
            PageJeu.lblPlateau.setText("Plateau du joueur #" + ValeurSelection);
            PageJeu.PlusieursTerrainsSud.show(PageJeu.test, PageJeu.IndiceTerrain[ValeurSelection]);
            
			//Pour afficher les choix possibles selon le nombre de joueurs
	        switch (PageAccueil.NombreDeJoueursString) {
	        	case "2 joueurs":
	        		SelectionDefilante.removeAllItems();
	        		SelectionDefilante.addItem("Choissisez votre Terrain...");
	        		SelectionDefilante.addItem("Terrain 1");
	        		SelectionDefilante.addItem("Terrain 2");
	        		break;
	        	case "3 joueurs":
	        		SelectionDefilante.removeAllItems();
	        		SelectionDefilante.addItem("Choissisez votre Terrain...");
	        		SelectionDefilante.addItem("Terrain 1");
	        		SelectionDefilante.addItem("Terrain 2");
	        		SelectionDefilante.addItem("Terrain 3");
	        		break;
	        	case "4 joueurs":
	        		SelectionDefilante.removeAllItems();
	        		SelectionDefilante.addItem("Choissisez votre Terrain...");
	        		SelectionDefilante.addItem("Terrain 1");
	        		SelectionDefilante.addItem("Terrain 2");
	        		SelectionDefilante.addItem("Terrain 3");
	        		SelectionDefilante.addItem("Terrain 4");
	        		break;
	        }
		}
	};
	
	public int getnbjoueurs (){
		return PageAccueil.nbjoueurs;
	}
            /**
	public ActionListener ChangerPage = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
	        if(++indice > 2)
	            indice = 0;
			PlusieursPages.show(FenetreJeu, listContent[indice]);
		}
	};*/

}




	
