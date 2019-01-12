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
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class AffichageFenetreJeu extends JPanel {
	
	JScrollBar scrollBar = new JScrollBar();
	JButton btnPioche = new JButton("Pioche");
	
	AffichagePlateau EcranSud = new AffichagePlateau("Seb", Color.GREEN);
	AffichagePlateau EcranNord = new AffichagePlateau("Tristan", Color.BLUE);
	AffichagePlateau EcranEst = new AffichagePlateau("Amine", Color.YELLOW);
	AffichagePlateau EcranOuest = new AffichagePlateau("Hugo", Color.RED);
	
	AffichagePanelDeJeu NordOuest = new AffichagePanelDeJeu();
	AffichagePanelDeJeu2 NordEst = new AffichagePanelDeJeu2();
	JPanel Centre = new JPanel();
	AffichagePanelDeJeu3 SudOuest = new AffichagePanelDeJeu3();
	AffichagePanelDeJeu4 SudEst = new AffichagePanelDeJeu4();

	//String[] IndiceTerrain = {"Choix", "Terrain pour le 1er joueur", "Terrain pour le 2ème joueur", "Terrain pour le 3ème joueur", "Terrain pour le 4ème joueur"};
	 
	JButton btnRetournerAuMenu = new JButton("Retourner au menu");

	public AffichageFenetreJeu() {
			setLayout(new GridLayout(3, 4, 0, 0));
			
			this.add(NordOuest);
				NordOuest.setLayout(new GridBagLayout());
				NordOuest.add(btnPioche);
			
			this.add(EcranNord);
						
			this.add(NordEst);
			
			this.add(EcranEst);
			
			this.add(Centre);
			Centre.setLayout(new GridLayout(6, 6, 0, 0));
				
			this.add(EcranOuest);
			
			this.add(SudOuest);
			
			this.add(EcranSud);
				
			this.add(SudEst);
			SudEst.setLayout(new GridLayout(3,3,0,0));
			SudEst.add(btnRetournerAuMenu);
			//btnRetournerAuMenu.setBounds(281, 45, 163, 29);
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
