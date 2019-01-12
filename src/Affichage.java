import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Affichage implements ActionListener {

	int nbjoueurs = 0;
	String NombreDeJoueursString = String.valueOf(nbjoueurs);
	JLabel lblNombreDeJoueurs = new JLabel("Nombre de joueurs :" + nbjoueurs + ", veuillez choisir ...");

	JFrame FenetreJeu = new JFrame("Projet Kingdomino");
	Cote Panel = new Cote();

	AffichageFenetreJeu PageJeu = new AffichageFenetreJeu();
	AffichageFenetreAccueil PageAccueil = new AffichageFenetreAccueil();
	JPanel pane = new JPanel();
	JPanel pan = new JPanel();

	JPanel pa = new JPanel();
	CardLayout PlusieursPages = new CardLayout(0, 0);
	GridBagLayout recadrage = new GridBagLayout();
	String[] listeIndice = { "Accueil", "Principal" };

	JComboBox<String> SelectionDefilante = new JComboBox<String>();
	int ValeurSelection = 0;

	public Tuile[][] dominostour = new Tuile[4][2];

	public Affichage() {
		
		FenetreJeu.setIconImage(new ImageIcon("//Users/lebens/Desktop/Dominations/images/ISEP.png").getImage());
		FenetreJeu.setBounds(100, 100, 450, 300);
		FenetreJeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FenetreJeu.getContentPane().setLayout(PlusieursPages);

		FenetreJeu.getContentPane().add(PageAccueil, listeIndice[0]);
		FenetreJeu.getContentPane().add(Panel, listeIndice[1]);
		
		SelectionDefilante.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Choissisez votre Terrain...", "Terrain 1", "Terrain 2", "Terrain 3", "Terrain 4" }));
		PageJeu.SudOuest.add(SelectionDefilante);

		Panel.setLayout(recadrage);
		Panel.add(PageJeu);
		Panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				resizePreview(PageJeu, Panel);
			}
		});
		
		PageAccueil.QuatreJoueurs.addActionListener((ActionListener) this);
		PageAccueil.DeuxJoueurs.addActionListener((ActionListener) this);
		PageAccueil.TroisJoueurs.addActionListener((ActionListener) this);
		PageJeu.btnRetournerAuMenu.addActionListener((ActionListener) this);
		PageAccueil.btnJouer.addActionListener((ActionListener) this);
		
	}

	private static void resizePreview(JPanel innerPanel, JPanel container) {
		int w = container.getWidth();
		int h = container.getHeight();
		int size = Math.min(w, h);
		innerPanel.setPreferredSize(new Dimension(size, size));
		container.revalidate();
	}

	public int getnbjoueurs() {
		return nbjoueurs;
	}

	public void setDominosTour(Tuile[][] dominostour) {
		this.dominostour = dominostour;
	}


	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source==PageAccueil.QuatreJoueurs || source==PageAccueil.TroisJoueurs || source==PageAccueil.DeuxJoueurs) {
			PageAccueil.lblNombreDeJoueurs.setText("Vous êtes " + ((JRadioButton) source).getText());
			PageAccueil.DeuxJoueurs.setSelected(false);
			PageAccueil.TroisJoueurs.setSelected(false);
			PageAccueil.QuatreJoueurs.setSelected(false);
			((JRadioButton) source).setSelected(true);

			switch (((JRadioButton) source).getText()) {
			case "2 joueurs":
				nbjoueurs = 2;
				break;
			case "3 joueurs":
				nbjoueurs = 3;
				break;
			case "4 joueurs":
				nbjoueurs = 4;
				break;
			}
			System.out.println(nbjoueurs);
			lblNombreDeJoueurs.setText("Nombre de joueurs :" + nbjoueurs + ", veuillez choisir ...");
		}
		
		
		if (source==PageJeu.btnRetournerAuMenu) {
			PlusieursPages.show(FenetreJeu.getContentPane(), listeIndice[0]);
		}
		
		if (source==PageAccueil.btnJouer) {
			Principal.lancerDebut();
			PlusieursPages.show(FenetreJeu.getContentPane(), listeIndice[1]);
			System.out.println("__Liste dominostour dans affichage__");
			for (int i = 0; i <= nbjoueurs - 1; i++) {
				System.out.println("____");
				System.out.println(dominostour[i][0]);
				System.out.println(dominostour[i][1]);
			}
			for (int i=0; i<nbjoueurs; i++) { 
				AffichageBoutonTuile NouvelleTuile1 = new AffichageBoutonTuile(dominostour[i][0]);
				AffichageBoutonTuile NouvelleTuile2 = new AffichageBoutonTuile(dominostour[i][1]);
				PageJeu.Milieu.add(NouvelleTuile1); 
				PageJeu.Milieu.add(NouvelleTuile2); 
			}
		}
	}
	
	

}

class Cote extends JPanel {
	public Cote() {
	}

	public void paintComponent(Graphics g) {
		// x1, y1, width, height, arcWidth, arcHeight
		try {
			File chemin = new File("//Users/lebens/Desktop/Dominations/images/dom.jpg");
			Image img = ImageIO.read(chemin);
			// g.drawImage(img, 0, 0, this);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
