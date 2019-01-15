import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class Affichage implements ActionListener {

	// vers Jeu
	int numdomitour = 0;
	int numtuiletour = 0;
	Tuile choixtuiletour;
	Joueur joueurencours;
	int posx=0;
	int posy=0;

	// provenant de Jeu
	int nbjoueurs = 0;
	int nbrois = 0;
	public Joueur[][] ordrejoueurs = new Joueur[4][2];
	public Joueur[][] joueurs = new Joueur[4][2];
	boolean bonchoix;
	
	//Instanciation de Compteurs
	int compteurpioche = 0;
	public int compteurjoueur = 0;
	public int compteurclictuile = 0;
	

	//Instanciation de la fenêtre et de ses pages
	JFrame FenetreJeu = new JFrame("Projet Kingdomino");
	CardLayout PlusieursPages = new CardLayout(0, 0);
	String[] listeIndice = { "Accueil", "Principal" };
		AffichageAccueil PageAccueil = new AffichageAccueil();
		Cote Panel = new Cote();
			GridBagLayout recadrage = new GridBagLayout();
			AffichageJeu PageJeu = new AffichageJeu();
			

	//Instanciation de listes de boutons. Pour pouvoir modifier les boutons du jeu
	public ArrayList<JButton> ListTour1 = new ArrayList<>();
	public ArrayList<JButton> ListTour2 = new ArrayList<>();
	public ArrayList<JButton> List1BoutonRoi = new ArrayList<>();
	public ArrayList<JButton> List2BoutonRoi = new ArrayList<>();
	
	public Tuile[][] dominostour = new Tuile[4][2];

	public Affichage() {

		DefinitionFenetre();
		AjouterLesActionsListner();
		DefinitionPageCarreQuiContientPageJeu();
		InitialiselesChampdeTexte();

	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == PageAccueil.QuatreJoueurs || source == PageAccueil.TroisJoueurs || source == PageAccueil.DeuxJoueurs) {
			ChoixDuNombreDeJoueurs(source);
			DefinitNbreJoueursEnFonctionDuChoix(source);
			PageAccueil.lblNombreDeJoueurs.setText("Vous êtes " + ((JRadioButton) source).getText()); //Affiche en texte le nombre de joueurs sur l'accueil
			PageJeu.lblNbreJoueurs.setText("Partie à " + ((JRadioButton) source).getText()); //Affiche en texte le nombre de joueurs sur le jeu principal
			System.out.println("Il y a " + nbjoueurs +" joueurs !"); //Affiche en texte le nombre de joueurs sur la console
			AfficherChampdeTexteAccueilSelonNbreJoueurs();
		}
		

		if (source == PageJeu.btnRetournerAuMenu) {
			PlusieursPages.show(FenetreJeu.getContentPane(), listeIndice[0]);
		}

		if (source == PageAccueil.btnJouer) {
			PlusieursPages.show(FenetreJeu.getContentPane(), listeIndice[1]);
			Principal.initialisation();
			AffecteAOrdrejoueursETauxEcransleNomdeChaqueJoueur();
			CreerPanelCentral_ET_ImplementerListesDeBoutons ();
			DefinirChateauPourTousEcran();
			DefinirNombreEcrans ();
		}

		if (source == PageJeu.btnPioche) {
			if (compteurpioche == 0) {

				for (int k = 0; k < ListTour1.size() / 2; k++) {

					JButton jButton1 = ListTour1.get(2 * k);
					JButton jButton2 = ListTour1.get(2 * k + 1);

					int numdomituile1 = dominostour[k][0].getnumdomi();
					int numdomituile2 = dominostour[k][1].getnumdomi();

					Tuile tuile1 = dominostour[k][0];
					Tuile tuile2 = dominostour[k][1];
					
					display(dominostour[k][0], jButton1);
					display(dominostour[k][1], jButton2);

					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Object source = e.getSource();
							if (compteurclictuile == 0) {
								if (compteurjoueur < nbrois) {
									setJoueurEnCours(ordrejoueurs[compteurjoueur][0]);

									/*
									 * setNumDomiTour(numdomituile1); setNumTuileTour(0);
									 */

									setChoixTuileTour(tuile1);

									Principal.preselection();
									if (bonchoix == true) {
										compteurjoueur += 1;

									} else if (bonchoix == false) {
										System.out.println("\nMauvais Domino ! ");
									}

									if (compteurjoueur >= nbrois) {
										System.out.println("Il faut piocher a nouveau");
										appelDefinitionNouvelOrdre();
										//setRoiTour(ordrejoueurs[compteurjoueur][0].couleur, tuile1, dominostour);
										System.out.println(
												"\nC'est a " + ordrejoueurs[0][0].getNomJoueur() + " de jouer.");
										compteurclictuile = 1;
										compteurjoueur = 0;
									} else {
										
										
										System.out.println("\nC'est a " + ordrejoueurs[compteurjoueur][0].getNomJoueur()
												+ " de jouer");

									}

								} else {
									System.out.println("Il faut piocher a nouveau 2");
									appelDefinitionNouvelOrdre();
									//pour la suite
									System.out.println("\nCliquez sur la case du terrain desiree, puis sur la tuile a placer.");
									System.out.println("\nC'est a " + ordrejoueurs[0][0].getNomJoueur() + " de jouer.");
									compteurclictuile = 1;
									compteurjoueur = 0;
								}
							} else if (compteurclictuile == 1) {

								if (compteurjoueur < nbrois) {
									setJoueurEnCours(ordrejoueurs[compteurjoueur][0]);

									setChoixTuileTour(tuile1);
									

									if (joueurs[compteurjoueur][0].numjoueur == 0) {
										setPosX(PageJeu.EcranOuest.posx);
										setPosY(PageJeu.EcranOuest.posy);
									}

									if (joueurs[compteurjoueur][0].numjoueur == 1) {
										setPosX(PageJeu.EcranNord.posx);
										setPosY(PageJeu.EcranNord.posy);
									}
									if (joueurs[compteurjoueur][0].numjoueur == 2) {
										setPosX(PageJeu.EcranEst.posx);
										setPosY(PageJeu.EcranEst.posy);
									}
									if (joueurs[compteurjoueur][0].numjoueur == 3) {
										setPosX(PageJeu.EcranSud.posx);
										setPosY(PageJeu.EcranSud.posy);
									}
									
									Principal.tourJeu();
									
									
									

									if (bonchoix == true) {
										compteurjoueur += 1;

									} else if (bonchoix == false) {
										System.out.println("\nMauvais domino");
									}

									if (compteurjoueur >= nbrois) {
										System.out.println("Il faut piocher a nouveau");
										appelDefinitionNouvelOrdre();
									} else {

										System.out.println("\nC'est a " + ordrejoueurs[compteurjoueur][0].getNomJoueur()
												+ " de jouer");

									}

								}

							}

						}
					});
					// pour bouton tuile2 excatement la meme qu'au dessus
					jButton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Object source = e.getSource();

							if (compteurjoueur < nbrois) {
								setJoueurEnCours(ordrejoueurs[compteurjoueur][0]);

								/*
								 * setNumDomiTour(numdomituile1); setNumTuileTour(0);
								 */

								setChoixTuileTour(tuile2);

								Principal.preselection();
								if (bonchoix == true) {
									compteurjoueur += 1;

								} else if (bonchoix == false) {
									System.out.println("\nMauvais Domino ! ");
								}

								if (compteurjoueur >= nbrois) {
									System.out.println("Il faut piocher a nouveau");
									appelDefinitionNouvelOrdre();

								} else {

									System.out.println("\nC'est a " + ordrejoueurs[compteurjoueur][0].getNomJoueur()
											+ " de jouer");

								}

							} else {
								System.out.println("Il faut piocher a nouveau 2");
								appelDefinitionNouvelOrdre();

							}

						}
					});

				}

			}

			else if (compteurpioche == 1) {

				// Retour couleur selectionn�e

			}

			else if (compteurpioche == 2) {

			}

		}
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

	public void setnbrois(int n) {
		this.nbrois = n;
	}

	public void setRoiTour(String clr, Tuile T,Tuile[][] dominostour) {
		Color Couleur = Color.WHITE;
		switch (clr) {
		case "GREEN":
			Couleur = Color.GREEN;
			break;
		case "BLUE":
			Couleur = Color.BLUE;
			break;
		case "RED":
			Couleur = Color.RED;
			break;
		case "YELLOW":
			Couleur = Color.YELLOW;
			break;
		}
		for (int j = 0; j < List1BoutonRoi.size(); j++) {
			if (T.getnumdomi() == dominostour[j][0].getnumdomi()) {
				List1BoutonRoi.get(j).setBackground(Couleur);
				List1BoutonRoi.get(j).setForeground(Color.WHITE);
				List1BoutonRoi.get(j).setText("R");
			}
		}
	}

	public void appelDefinitionNouvelOrdre() {
		// definition nouvel ordre
		
		Principal.definirordre();

		System.out.println("Ceci est un nouvel ordre de joueurs :\n");
		for (int j = 0; j <= ordrejoueurs.length - 1; j++) {
			System.out.println(ordrejoueurs[j][0].nomjoueur);
		}
	}

	public void setNumDomiTour(int num) {
		this.numdomitour = num;
		System.out.println("Num domi clique: " + this.numdomitour);

	}
	
	public void display(Tuile Tuile, JButton T) {

		ImageIcon img = new ImageIcon(
				this.getClass().getResource("/" + Tuile.gettype() + Tuile.getnbcouronne() + ".png"));
		Image newimg = img.getImage().getScaledInstance(T.getWidth(), T.getHeight(), java.awt.Image.SCALE_SMOOTH);
		T.setIcon(new ImageIcon(newimg));
	}
	
	public void setNumTuileTour(int num) {
		this.numtuiletour = num;
		System.out.println("Num tuile clique: " + this.numtuiletour);

	}

	public void setChoixTuileTour(Tuile tuile) {
		this.choixtuiletour = tuile;

	}

	public void setOrdreJoueurs(Joueur[][] ordrejoueurs) {
		this.ordrejoueurs = ordrejoueurs;
	}
	
	public void setJoueurs(Joueur[][] joueurs) {
		this.joueurs = joueurs;
	}

	public void setJoueurEnCours(Joueur joueur) {
		this.joueurencours = joueur;
	}

	public Joueur getJoueurEnCours() {
		return this.joueurencours;
	}

	public Tuile getChoixTuileTour() {
		return this.choixtuiletour;
	}

	public void setBonChoix(boolean bonchoix) {
		this.bonchoix = bonchoix;
	}
	
	public int getPosX() {
		return this.posx;
	}
	
	public int getPosY() {
		return this.posy;
	}
	
	public void setPosX(int posx) {
		this.posx=posx;
	}
	
	public void setPosY(int posy) {
		this.posy=posy;
	}


	
	public void InitialiselesChampdeTexte() {
	PageAccueil.ChampJ1.setEnabled(false);
	PageAccueil.ChampJ1.setVisible(false);
	PageAccueil.ChampJ2.setEnabled(false);
	PageAccueil.ChampJ2.setVisible(false);
	PageAccueil.ChampJ3.setEnabled(false);
	PageAccueil.ChampJ3.setVisible(false);
	PageAccueil.ChampJ4.setEnabled(false);
	PageAccueil.ChampJ4.setVisible(false);
	}
	
	public void AfficherChampdeTexteAccueilSelonNbreJoueurs() {
		
		if (nbjoueurs==2) {
			PageAccueil.ChampJ1.setEnabled(true);
			PageAccueil.ChampJ1.setVisible(true);
			PageAccueil.ChampJ2.setEnabled(true);
			PageAccueil.ChampJ2.setVisible(true);
			PageAccueil.ChampJ3.setEnabled(false);
			PageAccueil.ChampJ3.setVisible(false);
			PageAccueil.ChampJ4.setEnabled(false);
			PageAccueil.ChampJ4.setVisible(false);
		}
		else if (nbjoueurs==3) { 
			PageAccueil.ChampJ1.setEnabled(true);
			PageAccueil.ChampJ1.setVisible(true);
			PageAccueil.ChampJ2.setEnabled(true);
			PageAccueil.ChampJ2.setVisible(true);
			PageAccueil.ChampJ3.setEnabled(true);
			PageAccueil.ChampJ3.setVisible(true);
			PageAccueil.ChampJ4.setEnabled(false);
			PageAccueil.ChampJ4.setVisible(false);
		}
		else if (nbjoueurs==4) {
			PageAccueil.ChampJ1.setEnabled(true);
			PageAccueil.ChampJ1.setVisible(true);
			PageAccueil.ChampJ2.setEnabled(true);
			PageAccueil.ChampJ2.setVisible(true);
			PageAccueil.ChampJ3.setEnabled(true);
			PageAccueil.ChampJ3.setVisible(true);
			PageAccueil.ChampJ4.setEnabled(true);
			PageAccueil.ChampJ4.setVisible(true);
		}
	}

	public void AjouterLesActionsListner() {
		PageAccueil.QuatreJoueurs.addActionListener((ActionListener) this);
		PageAccueil.DeuxJoueurs.addActionListener((ActionListener) this);
		PageAccueil.TroisJoueurs.addActionListener((ActionListener) this);
		PageJeu.btnRetournerAuMenu.addActionListener((ActionListener) this);
		PageAccueil.btnJouer.addActionListener((ActionListener) this);
		PageJeu.btnPioche.addActionListener((ActionListener) this);
	}

	public void CreerPanelCentral_ET_ImplementerListesDeBoutons () {
		JSeparator separator = new JSeparator();
		JSeparator separator1 = new JSeparator();
		JSeparator separator2 = new JSeparator();
		JSeparator separator3 = new JSeparator();
		JSeparator separator4 = new JSeparator();
		JSeparator separator5 = new JSeparator();
		
		for (int i = 0; i < 6; i++) {
			JLabel ligneduhaut = new JLabel();
			PageJeu.Centre.add(ligneduhaut);		
		}

		for (int i = 0; i < nbrois; i++) {
			PanelRoi R = new PanelRoi();
			JButton NouvelleTuile1 = new JButton();
			JButton NouvelleTuile2 = new JButton();

			PageJeu.Centre.add(R);
			PageJeu.Centre.add(NouvelleTuile1);
			PageJeu.Centre.add(NouvelleTuile2);

			ListTour1.add(NouvelleTuile1);
			ListTour1.add(NouvelleTuile2);
			List1BoutonRoi.add(R.Roibtn);
		}

		separator.setBackground(new Color(102, 0, 51));
		separator1.setBackground(new Color(102, 0, 51));
		separator2.setBackground(new Color(102, 0, 51));
		separator3.setBackground(new Color(102, 0, 51));
		separator4.setBackground(new Color(102, 0, 51));
		separator5.setBackground(new Color(102, 0, 51));

		if (nbrois == 3) {
			for (int i = 0; i < 3; i++) {
				PageJeu.Centre.add(new JLabel());
			}
			PageJeu.Centre.add(separator);
			PageJeu.Centre.add(separator1);
			PageJeu.Centre.add(separator2);
			PageJeu.Centre.add(separator3);
			PageJeu.Centre.add(separator4);
			for (int j = 0; j < 21 - (6 * nbrois); j++) {
				PageJeu.Centre.add(new JLabel());
			}
		} else {
			PageJeu.Centre.add(separator);
			PageJeu.Centre.add(separator1);
			PageJeu.Centre.add(separator2);
			PageJeu.Centre.add(separator3);
			PageJeu.Centre.add(separator4);
			PageJeu.Centre.add(separator5);
			for (int i = 0; i < 24 - (6 * nbrois); i++) {
				PageJeu.Centre.add(new JLabel());
			}
		}

		for (int i = 0; i < nbrois; i++) {
			PanelRoi R = new PanelRoi();
			JButton NouvelleTuile1 = new JButton();
			JButton NouvelleTuile2 = new JButton();

			PageJeu.Centre.add(R);
			PageJeu.Centre.add(NouvelleTuile1);
			PageJeu.Centre.add(NouvelleTuile2);

			ListTour2.add(NouvelleTuile1);
			ListTour2.add(NouvelleTuile2);
			List2BoutonRoi.add(R.Roibtn);
		}
	}

	public void DefinirNombreEcrans () {
		Icon drole = new ImageIcon(this.getClass().getResource("/giphy.gif"));
		Icon ImgIcon = new ImageIcon(this.getClass().getResource("/Giph.gif"));
		
		switch (String.valueOf(nbjoueurs)) {
		case "2":
			PageJeu.EcranSud.setBackground(new Color(0, 0, 0, 64));
			PageJeu.EcranSud.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 1, true),
					new LineBorder(new Color(0, 0, 0, 64), 4, true)));
			PageJeu.EcranSud.Nom.setBackground(new Color(0, 0, 0, 64));
			PageJeu.EcranSud.PlanCentral.setBackground(new Color(0, 0, 0, 64));
			PageJeu.EcranSud.removeAll();
			JLabel label1 = new JLabel(ImgIcon);
			PageJeu.EcranSud.add(label1);
			PageJeu.EcranOuest.setBackground(new Color(0,0,0,64));
			PageJeu.EcranOuest.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 1, true), new LineBorder(new Color(0,0,0,64), 4, true)));
			PageJeu.EcranOuest.Nom.setBackground(new Color(0,0,0,64));
			PageJeu.EcranOuest.PlanCentral.setBackground(new Color(0,0,0,64));
			PageJeu.EcranOuest.removeAll();
			JLabel label = new JLabel(drole);
			PageJeu.EcranOuest.add(label);
			break;
		case "3" :
			PageJeu.EcranSud.setBackground(new Color(0,0,0,64));
			PageJeu.EcranSud.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 1, true), new LineBorder(new Color(0,0,0,64), 4, true)));
			PageJeu.EcranSud.Nom.setBackground(new Color(0,0,0,64));
			PageJeu.EcranSud.PlanCentral.setBackground(new Color(0,0,0,64));
			PageJeu.EcranSud.removeAll();
			JLabel label2 = new JLabel(drole);
			PageJeu.EcranSud.add(label2);
			break;
		}
	}
	
	public void DefinirChateauPourTousEcran() {
		ImageIcon ChateauIcone = new ImageIcon(this.getClass().getResource("/chateau.png"));
		Image ChateauIconeResize = ChateauIcone.getImage().getScaledInstance(PageJeu.EcranEst.BtnChateau.getWidth(), PageJeu.EcranEst.BtnChateau.getHeight(), java.awt.Image.SCALE_SMOOTH);
		PageJeu.EcranOuest.BtnChateau.setIcon(new ImageIcon(ChateauIconeResize));
		PageJeu.EcranNord.BtnChateau.setIcon(new ImageIcon(ChateauIconeResize));
		PageJeu.EcranEst.BtnChateau.setIcon(new ImageIcon(ChateauIconeResize));
		PageJeu.EcranSud.BtnChateau.setIcon(new ImageIcon(ChateauIconeResize));
	}

	public void DefinitionFenetre () {
		FenetreJeu.setIconImage(new ImageIcon(this.getClass().getResource("/chateau.png")).getImage());
		FenetreJeu.setBounds(0, 0, 1440, 900);
		FenetreJeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FenetreJeu.getContentPane().setLayout(PlusieursPages);
		FenetreJeu.getContentPane().add(PageAccueil, listeIndice[0]);
		FenetreJeu.getContentPane().add(Panel, listeIndice[1]);
	}

	public void DefinitionPageCarreQuiContientPageJeu () {
		Panel.setLayout(recadrage);
		Panel.add(PageJeu);
		Panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				resizePreview(PageJeu, Panel);
			}
		});
	}

	public void AffecteAOrdrejoueursETauxEcransleNomdeChaqueJoueur() {
		ordrejoueurs[0][0].setNomJoueur(PageAccueil.R);
		ordrejoueurs[1][0].setNomJoueur(PageAccueil.J);
		if (nbjoueurs == 3) {
			ordrejoueurs[2][0].setNomJoueur(PageAccueil.V);
		}
		if (nbjoueurs == 4) {
			ordrejoueurs[2][0].setNomJoueur(PageAccueil.V);
			ordrejoueurs[3][0].setNomJoueur(PageAccueil.B);
		}
		
		PageJeu.EcranOuest.Nom.setText(PageAccueil.R);
		PageJeu.EcranNord.Nom.setText(PageAccueil.J);
		PageJeu.EcranEst.Nom.setText(PageAccueil.V);
		PageJeu.EcranSud.Nom.setText(PageAccueil.B);
	}

	public void ChoixDuNombreDeJoueurs(Object source) {
		PageAccueil.DeuxJoueurs.setSelected(false);
		PageAccueil.TroisJoueurs.setSelected(false);
		PageAccueil.QuatreJoueurs.setSelected(false);
		((JRadioButton) source).setSelected(true);
	}

	public void DefinitNbreJoueursEnFonctionDuChoix(Object source) {
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
	}
}
	
class Cote extends JPanel {
	public Cote() {
	}

	public void paintComponent(Graphics g) {
		// x1, y1, width, height, arcWidth, arcHeight
		try {
			Image img = ImageIO.read(this.getClass().getResource("/Rid.jpg"));
			// g.drawImage(img, 0, 0, this);
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
