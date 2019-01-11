import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Jeu {

	public int nbjoueurs, nbrois;
	public Tuile[][] pioche = new Tuile[48][2];
	public Tuile[][] dominostour = new Tuile[4][2];

	public void preparation() {

		pioche = reconstruirepioche(Tuile.tuiles);

		supprimerdominosinitial();
		System.out.println(
				"Les dominos ont correctements ete supprimes de la liste tuiles initiale en fonction du nombre de joueurs.");

		System.out.println("La pioche a ete creee (longueur: " + pioche.length
				+ ") en fonction de la liste tuiles et a ete reconstruite pour enlever les elements null.");

		definirnbrois();
		System.out.println("Le nombre de rois a ete correctement defini, nbrois= " + nbrois + ".");

	}

	public void premiertour() {

		System.out.println("\n_____________Premier tour_____________\n");
		int lginitpioche = pioche.length;
		piocherdominos(nbrois);

		// afficherListe(pioche);

		System.out.println("Longueur pioche: " + pioche.length + " (avant: " + lginitpioche + ")");

		dominostour = reconstruirepioche(dominostour);
		dominostour = trierdominostour(dominostour);

		System.out.println("\nListe dominotours apres tri :");
		afficherListe(dominostour);

	}

	public void tourdejeu() {

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
			supprimerdomino(this.pioche[randomNum][0], pioche);

		}

	}

	// supprimer un domino d'une liste (dominostour, tuiles etc.)
	private void supprimerdomino(Tuile tuile, Tuile listetuiles[][]) {
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

	// definir nombre de rois en fonction du nombre de joueurs
	private void definirnbrois() {
		if (nbjoueurs <= 2) {
			this.nbrois = 2 * nbjoueurs;
		} else {
			this.nbrois = nbjoueurs;

		}

	}

	// suppression des trous dans une liste apres avoir supprimer des dominos
	private Tuile[][] reconstruirepioche(Tuile listetuiles[][]) {

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
		// on utilise un return comme �a on peut l'utiliser dans piocherdominos

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
			supprimerdomino(this.pioche[randomNum][0], pioche);

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
		Tuile val = dominostour2[i][0];

		dominostour2[i][0] = dominostour2[j][0];
		dominostour2[j][0] = val;

	}

	// DEBUG permet l'affichage d'une liste
	public void afficherListe(Tuile liste[][]) {
		for (int i = 0; i <= liste.length - 1; i++) {
			System.out.println("____");
			System.out.println(liste[i][0]);
		}
	}

	public void setNbJoueurs(int n) {
		this.nbjoueurs = n;
	}

}
