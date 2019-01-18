import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Jeu {

	public int nbjoueurs, nbrois, numtour;

	public Tuile[][] pioche = new Tuile[48][2];
	public Tuile[][] dominostour = new Tuile[4][2];
	public Tuile[][] dominostourpreselect;
	public Joueur[][] joueurs = new Joueur[4][2];
	public Joueur[][] ordrejoueurs = new Joueur[4][2];
	public boolean piochevide = false;
	public boolean partieterminee = false;

	public List<String> couleurs = Arrays.asList("RED", "YELLOW", "GREEN", "BLUE");
	public ArrayList<String> ordrecouleurs = new ArrayList<String>();

	// provenant de affichage
	Joueur joueurencours;
	public ArrayList<Integer> choixdomitour = new ArrayList<Integer>();
	Tuile choixtuiletour;
	boolean bonchoix;
	int posx;
	int posy;

	public void initialisationpartie() {

		// initialiser la pioche
		pioche = reconstruirepioche(Tuile.tuiles);

		supprimerdominosinitial();
		System.out.println(
				"Les dominos ont correctements ete supprimes de la liste tuiles initiale en fonction du nombre de joueurs.");

		System.out.println("La pioche a ete creee (longueur: " + pioche.length
				+ ") en fonction de la liste tuiles et a ete reconstruite pour enlever les elements null.");

		definirnbrois();
		System.out.println("Le nombre de rois a ete correctement defini, nbrois= " + nbrois + ".");

		creerJoueurs();

	}

	public void preparationtour() {

		System.out.println("\n_____________Premier tour_____________\n");
		int lginitpioche = pioche.length;
		piocherdominos(nbrois);

		// afficherListe(pioche);

		System.out.println("Longueur pioche: " + pioche.length + " (avant: " + lginitpioche + ")");

		dominostour = reconstruirepioche(dominostour);
		dominostour = trierdominostour(dominostour);
		dominostourpreselect = new Tuile[4][2];
		dominostourpreselect = reconstruirepioche(dominostour);

		Collections.shuffle(ordrecouleurs);
		System.out.println("\n" + ordrecouleurs + "\n");

		creerOrdreAPartirDeCouleur();

		// System.out.println("\nListe dominotours apres tri :");
		// afficherDoubleListe(dominostour);

		// afficherDoubleListeJoueur(joueurs);
		// afficherDoubleListeJoueur(ordrejoueurs);

	}

	public void preselection() {

		if (nbjoueurs == 2) {
			System.out.println("Nous sommes dans une configuration � deux joueurs");

			try {
				/*
				 * int binary = 0;
				 * 
				 * if (ordrejoueurs[j][0].getPremiereSelection()) { binary = 0;
				 * ordrejoueurs[j][0].setPremiereSelection(false); } else { binary = 1; }
				 * 
				 * ordrejoueurs[j][binary]
				 * .setPreSelection(dominostourpreselect[this.choixdomitour.get(0)][this.
				 * choixdomitour.get(1)]);
				 */

				this.joueurencours
						.setPreSelection(dominostourpreselect[this.choixdomitour.get(0)][this.choixdomitour.get(1)]);

				dominostourpreselect = supprimerdomino(
						dominostourpreselect[this.choixdomitour.get(0)][this.choixdomitour.get(1)],
						dominostourpreselect);
				this.bonchoix = true;

			} catch (Exception e) {
				System.out.println("Le domino a deje ete selectionne ! Descriptif erreur: \n" + e);
				this.bonchoix = false;
			}

			// reset
			ordrejoueurs[0][0].setPremiereSelection(true);
			ordrejoueurs[1][0].setPremiereSelection(true);
			ordrejoueurs[0][1].setPremiereSelection(true);
			ordrejoueurs[1][1].setPremiereSelection(true);

			System.out.println("\nAffichage de la tuile en position 1,0 sur le terrain du joueur 0 : \n"
					+ joueurs[0][0].terrain1.terrain[2][3]);
			System.out.println("\nAffichage de la tuile en position 1,0 sur le terrain du joueur 0, roi 2 : \n"
					+ joueurs[0][1].terrain1.terrain[2][3]);
			System.out.println("\nAffichage de la tuile en position 1,0 sur le terrain du joueur 0 : \n"
					+ joueurs[1][0].terrain1.terrain[2][3]);
			System.out.println("\nAffichage de la tuile en position 1,0 sur le terrain du joueur 0, roi 2: \n"
					+ joueurs[1][1].terrain1.terrain[2][3]);

		} else {

			try {
				System.out.println("\nTuile cliquee : " + this.choixtuiletour);

				this.joueurencours.setPreSelection(this.choixtuiletour);
				this.dominostourpreselect = supprimerdomino(this.choixtuiletour, this.dominostourpreselect);
				this.bonchoix = true;

			} catch (Exception e) {
				System.out.println("Le domino a deja ete selectionne ! Descriptif erreur: \n" + e);
				this.bonchoix = false;
			}

			System.out.println("\nAffichage de la liste de tuiles restantes (dominostourpreselect :\n");
			for (int j = 0; j <= this.dominostourpreselect.length - 1; j++) {
				System.out.println("________");
				System.out.println(dominostourpreselect[j][0]);
				System.out.println("_");
				System.out.println(dominostourpreselect[j][1]);
			}

			System.out.println("\nAffichage de la liste de tuiles dominostour :\n");
			for (int j = 0; j <= this.dominostour.length - 1; j++) {
				System.out.println("________");
				System.out.println(this.dominostour[j][0]);
				System.out.println("_");
				System.out.println(this.dominostour[j][1]);
			}

			/*
			 * System.out.
			 * println("\nAffichage de la tuile en position 2,3 sur le terrain du joueur 0 : \n"
			 * + joueurs[0][0].terrain1.terrain[2][3]); System.out.
			 * println("\nAffichage de la tuile en position 1,0 sur le terrain du joueur 0, roi 2 : \n"
			 * + joueurs[1][0].terrain1.terrain[2][3]); System.out.
			 * println("\nAffichage de la tuile en position 1,0 sur le terrain du joueur 0 : \n"
			 * + joueurs[2][0].terrain1.terrain[2][3]); System.out.
			 * println("\nAffichage de la tuile en position 1,0 sur le terrain du joueur 0, roi 2: \n"
			 * + joueurs[3][0].terrain1.terrain[2][3]);
			 * 
			 */

		}

	}

	public void definirnouvelordre() {
		// reset de la liste
		this.ordrejoueurs = new Joueur[nbrois][2];
		this.dominostourpreselect = new Tuile[nbrois][2];

		for (int j = 0; j <= this.nbrois - 1; j++) {

			this.dominostourpreselect[j][0] = joueurs[j][0].activetuile;
			this.ordrejoueurs[j] = joueurs[j];
		}

		trierOrdre(dominostourpreselect, ordrejoueurs);

		System.out.println("Ceci est un nouvel ordre de domino:\n");
		for (int j = 0; j <= this.dominostourpreselect.length - 1; j++) {
			System.out.println(this.dominostourpreselect[j][0].num1);
		}

		System.out.println("Ceci est un ordre de couleurs:\n");
		for (int j = 0; j <= this.ordrejoueurs.length - 1; j++) {
			System.out.println(this.ordrejoueurs[j][0].numjoueur);
		}

	}

	// tri une liste de dominos par ordre croissant en fonction de leur numero
	private Tuile[][] trierOrdre(Tuile[][] dominostour, Joueur[][] joueurs) {

		int i = 0;

		while (i < dominostour.length) {

			for (int j = dominostour.length - 1; j >= i + 1; j--) {

				if (dominostour[j][0].getnumdomi() < dominostour[j - 1][0].getnumdomi()) {

					echangertuiles(j - 1, j, dominostour);
					echangerjoueurs(j - 1, j, joueurs);

				}

			}

			i = i + 1;
		}

		return dominostour;
	}

	public void tourjoueur() {
		
		if (!this.piochevide) {

		this.numtour += 1;

		if (nbjoueurs == 2) {

			for (int j = 0; j <= this.nbrois - 1; j++) {

				System.out.println("C'est a " + ordrejoueurs[j][0].numjoueur + " de jouer");
				try {

					int binary = 0;
					// on verifie si c'est bien la premiere fois que le joueur ayant ce roi a place
					// une tuile
					if (ordrejoueurs[j][0].getPremiereSelection()) {
						binary = 0;
						ordrejoueurs[j][0].setPremiereSelection(false);
					} else {
						binary = 1;
					}
					// essayer ici la verif de placement
					ordrejoueurs[j][binary].terrain1.remplirTerrain(
							dominostour[this.choixdomitour.get(0)][this.choixdomitour.get(1)],
							this.choixdomitour.get(2), this.choixdomitour.get(3));
					// supprimerdomino(dominostour[this.choixdomitour.get(0)][this.choixdomitour.get(1)],
					// dominostour);
					// il faut ici update la liste dominostour dans affichage afin de montrer la
					// suppression

				} catch (Exception e) {
					System.out.println("Le domino a deje ete selectionne ! Descriptif erreur: \n" + e);
				}

			}

			// reset
			ordrejoueurs[0][0].setPremiereSelection(true);
			ordrejoueurs[1][0].setPremiereSelection(true);
			ordrejoueurs[0][1].setPremiereSelection(true);
			ordrejoueurs[1][1].setPremiereSelection(true);

			System.out.println("\nAffichage de la tuile en position 1,0 sur le terrain du joueur 0 : \n"
					+ joueurs[0][0].terrain1.terrain[2][3]);
			System.out.println("\nAffichage de la tuile en position 1,0 sur le terrain du joueur 0, roi 2 : \n"
					+ joueurs[0][1].terrain1.terrain[2][3]);
			System.out.println("\nAffichage de la tuile en position 1,0 sur le terrain du joueur 0 : \n"
					+ joueurs[1][0].terrain1.terrain[2][3]);
			System.out.println("\nAffichage de la tuile en position 1,0 sur le terrain du joueur 0, roi 2: \n"
					+ joueurs[1][1].terrain1.terrain[2][3]);

		} else {

			 try { 
			if (Regles.placementTuile(this.joueurencours.terrain1, this.choixtuiletour, this.posx, this.posy)) {
				this.joueurencours.terrain1.remplirTerrain(this.choixtuiletour, this.posx, this.posy);
				//this.joueurencours.terrain1.remplirTerrain(this.choixtuiletour, this.posx, this.posy);
				
				if (this.pioche.length<nbrois+1) {
					this.piochevide=true;
				}
				
				this.bonchoix = true;
			} else {
				this.bonchoix = false;
			}
			
			  } catch (Exception e) {
			  System.out.println("Le domino a deje ete selectionne ! Descriptif erreur: \n"
			  + e); this.bonchoix = false; }
			 

			System.out.println("\nAffichage de la tuile en position " + this.posx + " & " + this.posy
					+ " sur le terrain du joueur " + this.joueurencours.couleur + " : \n"
					+ joueurencours.terrain1.terrain[this.posx][this.posy]);

			// System.out.println("\nAffichage de la tuile en position 1,0 sur le terrain du
			// joueur 0, roi 2: \n"
			// + joueurs[3][0].terrain1.terrain[2][3]);

		}
	}
		else {
			System.out.println("\n\n\n\n\n________Partie Termin�e!______\n\n");
			this.partieterminee=true;
		}

	}

	// ____________________________________________________________________
	/* Fonctions de la classe Jeu */

	// suppression des dominos en fonction du nombre de joueurs
	private void supprimerdominosinitial() {

		// liste temporaire afin d'eviter de piocher deux fois le meme domino
		ArrayList<Integer> numpioche = new ArrayList<Integer>();
		for (int j = 0; j <= this.pioche.length - 1; j++) {
			numpioche.add(this.pioche[j][0].getnumdomi());
		}

		int randomNum;
		for (int i = 0; i < (48 - (12 * nbjoueurs)); i++) {

			randomNum = ThreadLocalRandom.current().nextInt(0, numpioche.size());
			numpioche.remove(randomNum);
			supprimerdominodepioche(this.pioche[randomNum][0], pioche);

		}

	}

	// supprimer un domino d'une liste (dominostour, tuiles etc.)
	private void supprimerdominodepioche(Tuile tuile, Tuile listetuiles[][]) {
		int i = 0;

		while (listetuiles[i][0] == null || listetuiles[i][0].getnumdomi() != tuile.getnumdomi()) {
			i++;
		}

		// System.out.println(i + "\n " + (listetuiles[i][0].getnumdomi() + "=" +
		// tuile.getnumdomi()));
		// System.out.println("Tuile " + listetuiles[i][1].getnumdomi() + "
		// supprimee.");

		listetuiles[i][0] = null;
		listetuiles[i][1] = null;
		// System.out.println("La tuile d'index " + i + " a ete supprimee");

		this.pioche = reconstruirepioche(listetuiles);

	}

	private Tuile[][] supprimerdomino(Tuile tuile, Tuile listetuiles[][]) {
		int i = 0;

		while (listetuiles[i][0] == null || listetuiles[i][0].getnumdomi() != tuile.getnumdomi()) {
			i++;
		}

		// System.out.println(i + "\n " + (listetuiles[i][0].getnumdomi() + "=" +
		// tuile.getnumdomi()));
		// System.out.println("Tuile " + listetuiles[i][1].getnumdomi() + "
		// supprimee.");

		listetuiles[i][0] = null;
		listetuiles[i][1] = null;
		// System.out.println("La tuile d'index " + i + " a ete supprimee");

		return reconstruirepioche(listetuiles);

	}

	// definir nombre de rois en fonction du nombre de joueurs
	private void definirnbrois() {
		if (nbjoueurs <= 2) {
			this.nbrois = 2 * nbjoueurs;
		} else {
			this.nbrois = nbjoueurs;

		}

	}

	private void creerJoueurs() {
		for (int j = 0; j <= this.nbjoueurs - 1; j++) {

			if (nbjoueurs == 2) {

				joueurs[j][0] = new Joueur(j, couleurs.get(j));
				ordrecouleurs.add(couleurs.get(j));
				joueurs[j][1] = new Joueur(j, couleurs.get(j));
				ordrecouleurs.add(couleurs.get(j));

			} else {
				System.out.println("Joueur numero: " + j + " Couleur: " + couleurs.get(j));
				joueurs[j][0] = new Joueur(j, couleurs.get(j));
				ordrecouleurs.add(couleurs.get(j));

			}
		}
	}

	private void creerOrdreAPartirDeCouleur() {

		for (int j = 0; j <= this.nbrois - 1; j++) {
			switch (this.ordrecouleurs.get(j)) {
			case "RED":
				this.ordrejoueurs[j] = this.joueurs[0];
				break;
			case "YELLOW":
				this.ordrejoueurs[j] = this.joueurs[1];
				break;
			case "GREEN":
				this.ordrejoueurs[j] = this.joueurs[2];
				break;
			case "BLUE":
				this.ordrejoueurs[j] = this.joueurs[3];
				break;

			}
		}

		for (int j = 0; j <= this.nbrois - 1; j++) {
			System.out.println("\nNumero ordre Joueur apres attribution " + j);
			System.out.println("Couleur ordreJoueur apres attribution " + this.ordrejoueurs[j][0].couleur);
			System.out.println(
					"Numero Joueur attribution " + this.joueurs[this.ordrejoueurs[j][0].numjoueur][0].numjoueur);
			System.out.println(
					"Couleur Joueur attribution " + this.joueurs[this.ordrejoueurs[j][0].numjoueur][0].couleur);

		}

	}

	// suppression des trous dans une liste apres avoir supprimer des dominos
	public Tuile[][] reconstruirepioche(Tuile listetuiles[][]) {

		Tuile[][] piochetemporaire = new Tuile[listetuiles.length][2];
		int nombrededominosrestants = 0;

		for (int i = 0; i <= listetuiles.length - 1; i++) {

			if ((listetuiles[i][0] != null)) {

				piochetemporaire[nombrededominosrestants] = listetuiles[i];
				nombrededominosrestants += 1;
			}

		}

		Tuile[][] piochetemporairecoupee = new Tuile[nombrededominosrestants][2];
		for (int i = 0; i <= piochetemporairecoupee.length - 1; i++) {
			piochetemporairecoupee[i] = piochetemporaire[i];

		}

		return piochetemporairecoupee;
		// on utilise un return comme ea on peut l'utiliser dans piocherdominos

	}

	// pioche n dominos de la pioche
	private void piocherdominos(int n) {

		// liste temporaire afin d'eviter de piocher deux fois le meme domino
		ArrayList<Integer> numpioche = new ArrayList<Integer>();
		for (int j = 0; j <= this.pioche.length - 1; j++) {
			numpioche.add(this.pioche[j][0].getnumdomi());
		}

		int randomNum;
		for (int i = 0; i <= n - 1; i++) {

			randomNum = ThreadLocalRandom.current().nextInt(0, numpioche.size());

			this.dominostour[i][0] = this.pioche[randomNum][0];
			this.dominostour[i][1] = this.pioche[randomNum][1];

			numpioche.remove(randomNum);
			System.out.println("Domino " + this.pioche[randomNum][0].getnumdomi() + " pioche.");
			supprimerdominodepioche(this.pioche[randomNum][0], pioche);

		}

	}

	// tri une liste de dominos par ordre croissant en fonction de leur numero
	private Tuile[][] trierdominostour(Tuile[][] dominostour) {

		int i = 0;

		while (i < dominostour.length) {

			for (int j = dominostour.length - 1; j >= i + 1; j--) {

				if (dominostour[j][0].getnumdomi() < dominostour[j - 1][0].getnumdomi()) {

					echanger(j - 1, j, dominostour);

				}

			}

			i = i + 1;
		}

		return dominostour;
	}

	// echange de place 2 dominos en fonction de leur indice dans la liste
	public void echanger(int i, int j, Tuile[][] dominostour2) {
		Tuile val1 = dominostour2[i][0];
		Tuile val2 = dominostour2[i][1];

		dominostour2[i][0] = dominostour2[j][0];
		dominostour2[j][0] = val1;
		dominostour2[i][1] = dominostour2[j][1];
		dominostour2[j][1] = val2;

	}

	// echange de place 2 dominos en fonction de leur indice dans la liste
	public void echangertuiles(int i, int j, Tuile[][] dominostour2) {
		Tuile val1 = dominostour2[i][0];
		Tuile val2 = dominostour2[i][1];

		dominostour2[i][0] = dominostour2[j][0];
		dominostour2[j][0] = val1;
		dominostour2[i][1] = dominostour2[j][1];
		dominostour2[j][1] = val2;

	}

	public void echangerjoueurs(int i, int j, Joueur[][] dominostour2) {
		Joueur val1 = dominostour2[i][0];
		Joueur val2 = dominostour2[i][1];

		dominostour2[i][0] = dominostour2[j][0];
		dominostour2[j][0] = val1;
		dominostour2[i][1] = dominostour2[j][1];
		dominostour2[j][1] = val2;

	}

	// GETTERS & SETTERS

	public void setNbJoueurs(int n) {
		this.nbjoueurs = n;
	}

	public void setPositionChoixTuileTour(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
	}

	public void setJoueurEnCours(Joueur joueur) {
		this.joueurencours = joueur;
	}

	public Joueur[][] getOrdreJoueurs() {
		return this.ordrejoueurs;
	}

	public boolean getBonChoix() {
		return this.bonchoix;
	}

	public void setChoixTuilePreselect(Tuile tuile) {
		this.choixtuiletour = tuile;
	}

	public int getNumTour() {
		return this.numtour;
	}

	public int getnbrois() {

		return nbrois;

	}

	// AFFICHAGE DES LISTES
	public void afficherDoubleListe(Tuile liste[][]) {
		System.out.println("\nListe dominostour :\n");
		for (int i = 0; i <= liste.length - 1; i++) {
			System.out.println("Domino ______________ " + i);
			System.out.println(liste[i][0]);
			System.out.println("__");
			System.out.println(liste[i][1]);
		}
	}

	public void afficherDoubleListeJoueur(Joueur liste[][]) {
		for (int i = 0; i <= nbrois - 1; i++) {
			System.out.println("____");
			System.out.println(liste[i][0].numjoueur);
		}
	}

	public void afficherMonoListe(Joueur liste[][]) {
		for (int i = 0; i <= nbjoueurs - 1; i++) {
			System.out.println("____");
			if (nbjoueurs == 2) {

				System.out.println(liste[i][0].couleur);
				System.out.println(liste[i][1].couleur);
			} else {

				System.out.println(liste[i][0].couleur);
			}

		}
	}

}
