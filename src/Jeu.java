import java.util.concurrent.ThreadLocalRandom;

public class Jeu {

	public int nbjoueurs, nbrois;

	public void initialisation() {
		supprimerdominos();
		if (nbjoueurs < 2) {
			nbrois=2*nbjoueurs;
		}
		else {
			nbrois=nbjoueurs;

		}

	}

	private void supprimerdominos() {

		for (int i = 0; i <= 12 * nbjoueurs - 1; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 48 + 1);
			Tuile.supprimerdominodetuile(randomNum);
		}

	}

	/*
	 * A faire:
	 * 
	 * FONCTION TOUR DE BOUCLE
	 * 
	 * règles de placement dans le terrain : prend en argument le terrain actuel et
	 * voir si le placement demandé par le joueur est possible ou pas
	 * 
	 */

}
