
public class Principal {

	public static void main(String[] args) {
		
		//Initialisations
		Domino.extraireCsv("dominos.csv");
		
		System.out.println("\nVoici le nombre de dominos extraits du csv : " + Domino.nombredominos);
		Jeu.creationListeDominos();
		
		System.out.println("\nRemplir la liste des tuiles avec toutes les tuiles.");
		Tuile.remplirlistetuile(Jeu.dominos);
		
		
		
		// Test des fonctions
			
		
			
		System.out.println("\nAfficher domino depuis liste :");
			Domino.afficherDomino(Jeu.dominos[2]);
			
		System.out.println("\nAfficher domino depuis son attribut numéro :");
			Domino.afficherDominoParNum(2);
			
		System.out.println("\nRécupérer le type 1 du domino 2 :");
			System.out.println(Jeu.dominos[2].gettype1());
			
		System.out.println("\nAjouter une tuile à la liste des tuiles depuis la liste des dominos.");
			Tuile.ajoutertuile(Jeu.dominos[2]);
			
		System.out.println("\nAfficher une tuile depuis la liste des tuiles :");
			System.out.println(Tuile.positionTuiles[2][0]);
			
		System.out.println("\nAfficher une tuile depuis la liste des tuiles :");
			System.out.println(Tuile.positionTuiles[45][0]);
			

	}

}
