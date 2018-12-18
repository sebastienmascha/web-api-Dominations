
public class Principal {

	public static void main(String[] args) {
		
		//Initialisations
		Domino.extraireCsv("dominos.csv");
		
		System.out.println("\nVoici le nombre de dominos extraits du csv : " + Domino.nombreinitialdominos);
		Domino.creationListeDominos();
		
		System.out.println("\nRemplir la liste des tuiles avec toutes les tuiles.");
		Tuile.remplirlistetuile(Domino.dominos);
		
		//création d'une partie
		Jeu jeu1 = new Jeu();
		jeu1.nbjoueurs=3;
		
		jeu1.preparation();
		jeu1.premiertour();
		
		
		
		// Test des fonctions
			
		
			
		System.out.println("\nAfficher domino depuis liste :");
			Domino.afficherDomino(Domino.dominos[2]);
			
		System.out.println("\nAfficher domino depuis son attribut numï¿½ro :");
			Domino.afficherDominoParNum(2);
			
		System.out.println("\nRï¿½cupï¿½rer le type 1 du domino 2 :");
			System.out.println(Domino.dominos[2].gettype1());
			
		System.out.println("\nAjouter une tuile ï¿½ la liste des tuiles depuis la liste des dominos.");
			Tuile.ajoutertuile(Domino.dominos[2]);
			
		System.out.println("\nAfficher une tuile depuis la liste des tuiles :");
			System.out.println(Tuile.tuiles[2][0]);
			
		System.out.println("\nAfficher une tuile depuis la liste des tuiles :");
			System.out.println(Tuile.tuiles[45][0]);
			

	}

}
