import java.util.Scanner;

public class Affichage2 {

	// vers Jeu
	int numdomitour = 0;
	int numtuiletour = 0;
	Tuile choixtuiletour;
	Joueur joueurencours;
	int posx = 0;
	int posy = 0;

	// provenant de Jeu
	int nbjoueurs = 0;
	int nbrois = 0;
	public Joueur[][] ordrejoueurs = new Joueur[4][2];
	public Joueur[][] joueurs = new Joueur[4][2];
	boolean bonchoix;
	public Tuile[][] dominostour = new Tuile[4][2];
	public Tuile[][] dominostourbackup = new Tuile[4][2];

	// compteurs
	int compteurpioche = 0;
	public int compteurjoueur = 0;
	public int compteurclictuile = 0;

	void initialisation() {

		// on choisit le nombre joueurs
		this.nbjoueurs = 3;

		// le nombre de joueur a été defini au préalable
		Principal.initialisation();

		// affichage du retour

		System.out.println("nbjoueurs : " + nbjoueurs);
		System.out.println("nbrois : " + nbrois);

	}

	void deroulement() {

		afficherDoubleListe(dominostour);

		// poser les rois

		for (int i = 0; i <= nbrois - 1; i++) {

			// choix tuile

			this.bonchoix = false;

			while (!bonchoix) {

				Scanner sc = new Scanner(System.in);
				System.out.println(
						"\n" + ordrejoueurs[i][0].couleur + ", veuillez choisir une tuile par son numéro :\n\n=>");
				int numtuile = sc.nextInt();

				setChoixTuileTour(dominostour[numtuile][0]);
				setJoueurEnCours(ordrejoueurs[i][0]);

				Principal.preselection();

			}

		}
		// recupérer ordre joueurs
		Principal.definirordre();

		// affichage du retour
		for (int i = 0; i <= nbrois - 1; i++) {
			System.out.println("Nouvel ordre : " + this.ordrejoueurs[i][0].couleur + " ("
					+ this.ordrejoueurs[i][0].numjoueur + ")");
		}

		// tour de jeu
		System.out.println("\nTOUR DE JEU");

		for (int i = 0; i <= nbrois - 1; i++) {

			// choix tuile

			this.bonchoix = false;

			while (!bonchoix) {

				System.out.println("\n______________________Affichage de la liste de tuiles dominostourbackup :\n");
				for (int j = 0; j <= this.dominostourbackup.length - 1; j++) {
					System.out.println("________");
					System.out.println(this.dominostourbackup[j][0]);
					System.out.println("_");
					System.out.println(this.dominostourbackup[j][1]);
				}

				Scanner sc = new Scanner(System.in);
				System.out.println(
						"\n" + ordrejoueurs[i][0].couleur + ", veuillez choisir une tuile par son numéro :\n\n=>");
				int numtuile = sc.nextInt();

				Scanner sc2 = new Scanner(System.in);
				System.out.println("\n" + ordrejoueurs[i][0].couleur
						+ ", veuillez choisir la position en x sur votre terrain :\n\n=>");
				int positionx = sc2.nextInt();

				Scanner sc3 = new Scanner(System.in);
				System.out.println("\n" + ordrejoueurs[i][0].couleur
						+ ", veuillez choisir la position en y sur votre terrain :\n\n=>");
				int positiony = sc3.nextInt();

				setPosX(positionx);
				setPosY(positiony);
				setChoixTuileTour(dominostourbackup[numtuile][0]);
				setJoueurEnCours(ordrejoueurs[i][0]);

				// lancement d'un tour
				Principal.tourJeu();
				joueurencours.setScore(Regles.scorePlateau(joueurencours.terrain1));

			}

		}
		// affichage score a chaque tour
		
		for (int j = 0; j <= nbrois - 1; j++) {
			System.out.println("Le score est :" + Regles.scorePlateau(joueurs[j][0].terrain1));
		}

	}

	// AFFICHAGE CONSOLE

	public void afficherDoubleListe(Tuile liste[][]) {
		System.out.println("\nListe dominostour :\n");
		for (int i = 0; i <= liste.length - 1; i++) {
			System.out.println("Domino ______________ " + i);
			System.out.println(liste[i][0]);
			System.out.println("__");
			System.out.println(liste[i][1]);
		}
	}

	// GETTERS & SETTERS

	public int getnbjoueurs() {
		return nbjoueurs;
	}

	public void setDominosTour(Tuile[][] dominostour) {
		this.dominostour = dominostour;
		dominostourbackup = new Tuile[dominostour.length][2];
		for (int i = 0; i <= dominostour.length - 1; i++) {
			this.dominostourbackup[i][0] = dominostour[i][0];
			this.dominostourbackup[i][1] = dominostour[i][1];
		}
	}

	public void setnbrois(int n) {
		this.nbrois = n;
	}

	public void setNumDomiTour(int num) {
		this.numdomitour = num;
		System.out.println("Num domi clique: " + this.numdomitour);

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
		this.posx = posx;
	}

	public void setPosY(int posy) {
		this.posy = posy;
	}

}
