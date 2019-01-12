import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {
	
	static Affichage window = new Affichage();
	
	static Jeu jeu1 = new Jeu();
	
	public static void lancerDebut(){
		jeu1.setNbJoueurs(window.nbjoueurs);
		jeu1.preparation();
		jeu1.premiertour();
		window.setDominosTour(jeu1.dominostour);
	}
	

	public static void main(String[] args) {
		

		// Initialisations
		Domino.extraireCsv("dominos.csv");
		System.out.println("Voici le nombre de dominos extraits du csv : " + Domino.nombreinitialdominos);
		System.out.println(
				"Voici la longueur de la liste des dominos extraits du csv : " + Domino.listedetouslesDominos.size());

		Domino.creationListeDominos();
		System.out.println("La liste dominos a correctement �t� creee.");

		Tuile.remplirlistetuile(Domino.dominos);
		System.out.println("La liste tuiles a �t� remplie � partir de la liste dominos.");

		/*
		 * // Fonctions Tests
		 * 
		 * Domino.afficherDomino(Domino.dominos[3]);
		 * 
		 * System.out.println("\nAfficher domino depuis son attribut numero :");
		 * Domino.afficherDominoParNum(0);
		 * 
		 * System.out.println("\nRecuperer le type 1 du domino 2 :");
		 * System.out.println(Domino.dominos[2].gettype1());
		 * 
		 * System.out.
		 * println("\nAjouter une tuile a la liste des tuiles depuis la liste des dominos."
		 * ); Tuile.ajoutertuile(Domino.dominos[2]);
		 * 
		 * System.out.println("\nAfficher une tuile depuis la liste des tuiles :");
		 * System.out.println(Tuile.tuiles[0][1]);
		 * 
		 * System.out.println("\nAfficher une tuile depuis la liste des tuiles :");
		 * System.out.println(Tuile.tuiles[45][0]);
		 * 
		 */

		// creation d'une partie
		

		// Test de l'interface graphique
		window.FenetreJeu.setVisible(true);


	
		
		/*
		 * System.out.println("\nAfficher liste dominostour :");
		 * System.out.println(jeu1.dominostour);
		 */

	}

}
