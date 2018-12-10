
public class Principal {

	public static void main(String[] args) {
		//initialisation
		Domino.extraireCsv("dominos.csv");
		Jeu.creationListeDominos();
		Tuile.creerUneTuile(Jeu.dominos[2]);
		
		//tests fonctions
		Domino.afficherDominoParNum(2);
		System.out.println("______________");
		
		Domino.afficherDomino(Jeu.dominos[2]);
		System.out.println("______________");
		
		System.out.println(Jeu.dominos[2].gettype1());
		System.out.println("______________");

		System.out.println(Terrain.positionTuiles[2][1]);
		System.out.println("______________");
		
	}


}
