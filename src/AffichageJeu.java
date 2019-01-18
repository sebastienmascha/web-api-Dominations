import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class AffichageJeu extends JPanel {
	
	int compteurjoueur;
	Tuile choixtuiletour;
	int PosDomiSelection;
	int PosTuiSelection;
	JButton btnPioche = new JButton("Pioche");
	
	JLabel AquiLeTour = new JLabel();
	
	String R ;
	String J ;
	String V ;
	String B ;

	AffichagePlateau Ecran;
	
	AffichagePlateau EcranOuest = new AffichagePlateau(R,Color.RED);
	AffichagePlateau EcranNord = new AffichagePlateau(J,Color.YELLOW);
	AffichagePlateau EcranEst = new AffichagePlateau(V,Color.GREEN);
	AffichagePlateau EcranSud = new AffichagePlateau(B,Color.BLUE);

	
	AffichagePanelDeJeu NordOuest = new AffichagePanelDeJeu();
	AffichagePanelDeJeu2 NordEst = new AffichagePanelDeJeu2();
	JCentre Centre = new JCentre();
	AffichagePanelDeJeu3 SudOuest = new AffichagePanelDeJeu3();
	AffichagePanelDeJeu4 SudEst = new AffichagePanelDeJeu4();
	
	JLabel lblNbreJoueurs = new JLabel();
	
	JButton btnRetournerAuMenu = new JButton("Retourner au menu");

	//Instanciation de listes de boutons. Pour pouvoir modifier les boutons du jeu
	public ArrayList<JButton> ListTour1 = new ArrayList<>();
	public ArrayList<JButton> ListTour2 = new ArrayList<>();
	public ArrayList<JButton> List1BoutonRoi = new ArrayList<>();
	public ArrayList<JButton> List2BoutonRoi = new ArrayList<>();
	
	public AffichageJeu() {
			setLayout(new GridLayout(3, 4, 0, 0));
			
			this.add(NordOuest);
				NordOuest.setLayout(new GridLayout(2,0,2,2));
				NordOuest.add(btnPioche);
				NordOuest.add(lblNbreJoueurs);
				lblNbreJoueurs.setForeground(Color.WHITE);
				lblNbreJoueurs.setHorizontalAlignment(SwingConstants.CENTER);
				lblNbreJoueurs.setFont(new Font("Tahoma", Font.ITALIC, 16));
			
			this.add(EcranNord);
						
			this.add(NordEst);
			
			this.add(EcranOuest);
			
			this.add(Centre);
			Centre.setBackground(Color.red);
			Centre.setLayout(new GridLayout(6, 6, 0, 0));
			CreerPanelCentral_ET_ImplementerListesDeBoutons();

			
			this.add(EcranEst);
			
			this.add(SudOuest);
			SudOuest.add(AquiLeTour);
			AquiLeTour.setForeground(Color.WHITE);
			AquiLeTour.setFont(new Font("Tahoma", Font.ITALIC, 16));
			
			this.add(EcranSud);
				
			this.add(SudEst);
			SudEst.setLayout(new GridLayout(3,3,2,2));
			SudEst.add(btnRetournerAuMenu);
			//btnRetournerAuMenu.setBounds(281, 45, 163, 29);
        }
	
	public void setEcran (int compteurjoueur) {
		switch (compteurjoueur+1) {
		case 1 :
			Ecran = EcranOuest;
			break;
		case 2 :
			Ecran = EcranNord;
			break;
		case 3 :
			Ecran = EcranEst;
			break;
		case 4 :
			Ecran = EcranSud;
			break;
		}
	}
	
	public void CreerPanelCentral_ET_ImplementerListesDeBoutons () {
		JSeparator separator = new JSeparator();
		JSeparator separator1 = new JSeparator();
		JSeparator separator2 = new JSeparator();
		JSeparator separator3 = new JSeparator();
		JSeparator separator4 = new JSeparator();
		JSeparator separator5 = new JSeparator();

		separator.setBackground(new Color(102, 0, 51));
		separator1.setBackground(new Color(102, 0, 51));
		separator2.setBackground(new Color(102, 0, 51));
		separator3.setBackground(new Color(102, 0, 51));
		separator4.setBackground(new Color(102, 0, 51));
		separator5.setBackground(new Color(102, 0, 51));
		
		for (int i = 0; i < 6; i++) {
			JLabel ligneduhaut = new JLabel();
			Centre.add(ligneduhaut);		
		}

		for (int i = 0; i < 4; i++) {
			PanelRoi R = new PanelRoi();
			JButton NouvelleTuile1 = new JButton();
			JButton NouvelleTuile2 = new JButton();
			Centre.add(R);
			Centre.add(NouvelleTuile1);
			Centre.add(NouvelleTuile2);

			ListTour1.add(NouvelleTuile1);
			ListTour1.add(NouvelleTuile2);
			List1BoutonRoi.add(R.Roibtn);
		}
		
			Centre.add(separator);
			Centre.add(separator1);
			Centre.add(separator2);
			Centre.add(separator3);
			Centre.add(separator4);
			Centre.add(separator5);
			
		

		for (int i = 0; i < 4; i++) {
			PanelRoi R = new PanelRoi();
			JButton NouvelleTuile1 = new JButton();
			JButton NouvelleTuile2 = new JButton();

			Centre.add(R);
			Centre.add(NouvelleTuile1);
			Centre.add(NouvelleTuile2);

			ListTour2.add(NouvelleTuile1);
			ListTour2.add(NouvelleTuile2);
			List2BoutonRoi.add(R.Roibtn);
		}
	}
	
	public void setChoixTuileTour(Tuile tuile) {
		this.choixtuiletour = tuile;
	}
	
	
}

class AffichagePanelDeJeu extends JPanel {

	public AffichagePanelDeJeu() {
	
	}
	public void paintComponent(Graphics g){
		    //x1, y1, width, height, arcWidth, arcHeight
		    try {
		        Image img = ImageIO.read(this.getClass().getResource("--NO.jpg"));
		        //g.drawImage(img, 0, 0, this);
		        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		  }          
}

class AffichagePanelDeJeu2 extends JPanel {
	
	public AffichagePanelDeJeu2() {
	
	}
	public void paintComponent(Graphics g){
		    //x1, y1, width, height, arcWidth, arcHeight
		    try {
		    	
		        Image img = ImageIO.read(this.getClass().getResource("--NE.jpeg"));
		        //g.drawImage(img, 0, 0, this);
		        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		  }          
}

class AffichagePanelDeJeu3 extends JPanel {
	
	public AffichagePanelDeJeu3() {
	
	}
	public void paintComponent(Graphics g){
		    //x1, y1, width, height, arcWidth, arcHeight
		    try {
		        Image img = ImageIO.read(this.getClass().getResource("--SO.jpeg"));
		        //g.drawImage(img, 0, 0, this);
		        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		  }          
}

class AffichagePanelDeJeu4 extends JPanel {	

	public AffichagePanelDeJeu4() {
	
	}
	public void paintComponent(Graphics g){
		    //x1, y1, width, height, arcWidth, arcHeight
		    try {
		        Image img = ImageIO.read(this.getClass().getResource("--SE.jpg"));
		        //g.drawImage(img, 0, 0, this);
		        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		  }          
}


class JCentre extends JPanel {	

	public JCentre() {
	
	}
	public void paintComponent(Graphics g){
		    //x1, y1, width, height, arcWidth, arcHeight
		    try {
		        Image img = ImageIO.read(this.getClass().getResource("Wallpaper.jpg"));
		        //g.drawImage(img, 0, 0, this);
		        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		  }  
}
	
	class PanelRoi extends JPanel {
		private final JLabel lblNewLabel1 = new JLabel();
		private final JLabel lblNewLabel2 = new JLabel();
		private final JLabel lblNewLabel3 = new JLabel();
		private final JLabel lblNewLabel4 = new JLabel();
		private final JLabel lblNewLabel5 = new JLabel();
		private final JLabel lblNewLabel6 = new JLabel();
		private final JLabel lblNewLabel7 = new JLabel();
		private final JLabel lblNewLabel8 = new JLabel();
		JButton Roibtn = new JButton();

		public PanelRoi() {
			this.setOpaque(false);
			setLayout(new GridLayout(3, 3, 0, 0));
			this.add(lblNewLabel1);
			this.add(lblNewLabel2);
			this.add(lblNewLabel3);
			this.add(lblNewLabel4);
			this.add(Roibtn);
			this.add(lblNewLabel5);
			this.add(lblNewLabel6);
			this.add(lblNewLabel7);
			this.add(lblNewLabel8);
		}
	}

