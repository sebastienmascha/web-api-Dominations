
public class Principal {

	public static void main(String[] args) {
		//initialisation
		Domino.extraireCsv("dominos.csv");
		System.out.println(Domino.nombredominos);
		
		Domino.afficherDomino(Jeu.dominos[2]);
		Jeu.creationListeDominos();
		
		Tuile.ajoutertuile(Jeu.dominos[2]);
		Tuile.ajoutertuile(Jeu.dominos[46]);
		
		//tests fonctions
		Domino.afficherDominoParNum(2);
		System.out.println("______________");
		
		Domino.afficherDomino(Jeu.dominos[2]);
		System.out.println("______________");
		
		Domino.afficherDomino(Domino.listeDominos[2]);
		System.out.println("______________");
		
		System.out.println(Jeu.dominos[2].gettype1());
		System.out.println("______________");

		System.out.println(Tuile.positionTuiles[46][1]);
		System.out.println("______________");
		
	}


}
