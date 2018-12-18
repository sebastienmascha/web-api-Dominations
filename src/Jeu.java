import java.util.concurrent.ThreadLocalRandom;

public class Jeu {

	public int nbjoueurs, nbrois;

	public void preparation() {
		supprimerdominos();
		definirnbrois();

	}
	
	public void premiertour() {
		
	}

	private void supprimerdominos() {
		int randomNum;
		for (int i = 0; i <= (Domino.nombreinitialdominos-(12 * nbjoueurs)) - 1; i++) {
			randomNum = ThreadLocalRandom.current().nextInt(0, 48 + 1);
			Tuile.supprimerdominodetuile(randomNum);
		}

	}

	private int definirnbrois() {
		if (nbjoueurs < 2) {
			this.nbrois = 2 * nbjoueurs;
		} else {
			this.nbrois = nbjoueurs;

		}
		return nbrois;
	}
	
	
	private void piocherdominos(int n) {
		int randomNum;
		for (int i = 0; i <= n - 1; i++) {
			randomNum = ThreadLocalRandom.current().nextInt(0, 48 + 1);
			//il faut creer une liste pioche qui se rebuild à chaque fois qu'on supprime un domino
			// ou alors creer une liste des numéros des dominos supprimés pour les exclure du random
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
