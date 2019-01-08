import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Jeu {

	public int nbjoueurs, nbrois;
	public Tuile[][] pioche = new Tuile[48][2];
	public Tuile[][] dominostour = new Tuile[48][2];

	public void preparation() {
		/*
		 * System.out.println("______________________ Avant suppr dominos");
		 * 
		 * for (int i = 0; i <= Tuile.tuiles.length - 1; i++) {
		 * System.out.println(Tuile.tuiles[i][0]); System.out.println("____"); }
		 * 
		 * System.out.println("\nlongueur de la liste avant suppr :" +
		 * Tuile.tuiles.length);
		 */

		supprimerdominosinitial();
		System.out.println("Les dominos ont correctements été supprimés de la liste tuiles initiale.");

		/*
		 * System.out.println("______________________ Après suppr dominos");
		 * 
		 * for (int i = 0; i <= Tuile.tuiles.length - 1; i++) {
		 * System.out.println(Tuile.tuiles[i][0]); System.out.println("____"); }
		 * 
		 * System.out.println("\nlongueur de la liste apres suppr :" +
		 * Tuile.tuiles.length);
		 */

		pioche = reconstruirepioche(Tuile.tuiles);
		System.out.println(
				"La pioche a été creee en fonction de la liste tuiles et a été reconstruite pour enlever les elements null.");

		definirnbrois();
		System.out.println("Le nombre de rois a été correctement défini, nbrois= " + nbrois + ".");

		piocherdominos(nbrois);
		System.out.println("On a pioché " + nbrois + " dominos depuis la pioche vers la liste dominostour.");

		// affichage pioche

		for (int i = 0; i <= pioche.length - 1; i++) {
			System.out.println("____");
			System.out.println(pioche[i][0]);
			System.out.println("____");
			System.out.println(pioche[i][1]);
			System.out.println("____");
		}

		System.out.println("\nlongueur de la pioche :" + pioche.length);

	}

	public void premiertour() {
		dominostour = trierdominostour(dominostour);
	}

	private void supprimerdominosinitial() {
		int randomNum;

		for (int i = 0; i < (48 - (12 * nbjoueurs)); i++) {

			randomNum = ThreadLocalRandom.current().nextInt(0, 48 + 1);

			Tuile.supprimerdominodetuile(randomNum);
		}

	}

	private void supprimerdomino(Tuile tuile, Tuile listetuiles[][]) {
		int i=0;
		try {
		
			do {
				i++;
			}
			while (listetuiles[i][0].getnumdomi()!=tuile.getnumdomi());
		}
		catch (Exception e) {
			
		}

		listetuiles[i][0] = null;
		listetuiles[i][1] = null;
		

	}

	private void definirnbrois() {
		if (nbjoueurs <= 2) {
			this.nbrois = 2 * nbjoueurs;
		} else {
			this.nbrois = nbjoueurs;

		}

	}

	// la fonction va "rebuild" la pioche comportant des trous en créant une pioche
	// sans trous
	private Tuile[][] reconstruirepioche(Tuile listetuiles[][]) {

		Tuile[][] piochetemporaire = new Tuile[listetuiles.length][2];
		int nombrededominosrestants = 0;

		for (int i = 0; i <= listetuiles.length - 1; i++) {
			try {
				if ((listetuiles[i][0].getnbcouronne() == 1) || (listetuiles[i][0].getnbcouronne() == 2)
						|| (listetuiles[i][0].getnbcouronne() == 0)) {
					piochetemporaire[nombrededominosrestants] = listetuiles[i];
					nombrededominosrestants += 1;
				}
			} catch (Exception e) {

			}
		}

		/*
		 * System.out.println("______________________ Pioche temporaire");
		 * 
		 * for (int i = 0; i <= piochetemporaire.length - 1; i++) {
		 * System.out.println(piochetemporaire[i][0]); System.out.println("____");
		 * 
		 * }
		 * 
		 * System.out.println("longueur de la pioche temporaire :" +
		 * piochetemporaire.length); System.out.println("nb domi restants :" +
		 * nombrededominosrestants);
		 */

		Tuile[][] piochetemporairecoupee = new Tuile[nombrededominosrestants][2];
		for (int i = 0; i <= piochetemporairecoupee.length - 1; i++) {
			piochetemporairecoupee[i] = piochetemporaire[i];

		}
		// System.out.println("longueur de la pioche temporaire coupee:" +
		// piochetemporairecoupee.length);
		return piochetemporairecoupee;
		// on utilise un return comme ça on peut l'utiliser dans piocherdominos

	}

	private void piocherdominos(int n) {

		ArrayList<Integer> numpioche = new ArrayList<Integer>();

		for (int j = 0; j <= this.pioche.length - 1; j++) {
			numpioche.add(this.pioche[j][0].getnumdomi());
			// System.out.println("Numero pioche " + this.pioche[j][0].getnumdomi());
		}

		for (int j = 0; j <= numpioche.size() - 1; j++) {
			// System.out.println("Numero pioche " + numpioche.get(j));
		}

		System.out.println("Numpioche size=" + numpioche.size());

		int randomNum;
		for (int i = 0; i <= n - 1; i++) {

			randomNum = ThreadLocalRandom.current().nextInt(0, numpioche.size());

			System.out.println("\nRandomnum :" + randomNum);
			System.out.println("vrai numero :" + numpioche.get(randomNum));

			this.dominostour[i] = this.pioche[randomNum];

			supprimerdomino(this.pioche[randomNum][0], pioche);

		}
		reconstruirepioche(this.pioche);

	}

	private Tuile[][] trierdominostour(Tuile[][] dominostour) {
		/*
		 * for (int i = 0; i <= dominostour.length - 1; i++) { //trier une liste par
		 * ordre croissant en fonction des dominostour[i].getnumdomi(); if
		 * (dominostour[i][0].getnumdomi() > dominostour[i+1][0].getnumdomi()) {
		 * 
		 * } }
		 */

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
		// on return car plus facile et safe de travailler en local pour permuter les
		// elements d'une liste
	}

	public void echanger(int i, int j, Tuile[][] dominostour2) {
		Tuile val = dominostour2[i][0];

		dominostour2[i][0] = dominostour2[j][0];
		dominostour2[j][0] = val;

	}

	/* ______________________________________________________________________ */

}
