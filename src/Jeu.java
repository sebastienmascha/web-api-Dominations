import java.util.concurrent.ThreadLocalRandom;

public class Jeu {

	public int nbjoueurs, nbrois, nombrededominosrestants;
	public Tuile[][] pioche = reconstruirepioche(Tuile.tuiles);
	public Tuile[][] dominostour = new Tuile[48][2];

	public void preparation() {
		supprimerdominos();
		definirnbrois();
		piocherdominos(nbrois);
		dominostour=trierdominostour(dominostour);

	}

	public void premiertour() {

	}

	private void supprimerdominos() {
		int randomNum;
		for (int i = 0; i <= (Domino.nombreinitialdominos - (12 * nbjoueurs)) - 1; i++) {
			randomNum = ThreadLocalRandom.current().nextInt(0, 48 + 1);
			Tuile.supprimerdominodetuile(randomNum);
		}

	}

	private void definirnbrois() {
		if (nbjoueurs <= 2) {
			this.nbrois = 2 * nbjoueurs;
		} else {
			this.nbrois = nbjoueurs;

		}

	}
	
	
	//la fonction va "rebuild" la pioche comportant des trous en créant une pioche sans trous
		private Tuile[][] reconstruirepioche(Tuile listetuiles[][]) {
			Tuile[][] piochetemporaire = new Tuile[listetuiles.length][2];
			this.nombrededominosrestants = 0;

			for (int i = 0; i <= listetuiles.length - 1; i++) {

				if (listetuiles[i] != null) {
					piochetemporaire[nombrededominosrestants] = listetuiles[i];
					this.nombrededominosrestants += 1;
				}
			}
			return piochetemporaire;
			//on utilise un return comme ça on peut l'utiliser dans piocherdominos

		}
	
	

	private void piocherdominos(int n) {
		int randomNum;
		for (int i = 0; i <= n - 1; i++) {
			randomNum = ThreadLocalRandom.current().nextInt(0, this.nombrededominosrestants + 1);
			this.dominostour[i] = pioche[randomNum];
			pioche[randomNum]=null;
		}
		//recreer la pioche à partir de la précédente pioche ("rebuild")
		this.pioche=reconstruirepioche(pioche);

	}

	
	
	
	private Tuile[][] trierdominostour(Tuile[][] dominostour) {
		
		for (int i = 0; i <= dominostour.length - 1; i++) {
			//trier une liste par ordre croissant en fonction des dominostour[i].getnumdomi();
			if (dominostour[i][0].getnumdomi() > dominostour[i+1][0].getnumdomi()) {
				
				
			}
			
		}
		
		return dominostour;
		//on return car plus facile et safe de travailler en local pour permuter les elements d'une liste
	}

	/* ______________________________________________________________________ */

}
