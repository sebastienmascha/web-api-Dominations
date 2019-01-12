import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {
	
	static Affichage window = new Affichage();
	
	static Jeu jeu1 = new Jeu();
	

	public static void initialisation() {
		jeu1.setNbJoueurs(window.getnbjoueurs());
		//jeu1.setChoixDomiTour(1,0,2,3);
		jeu1.initialisationpartie();
		jeu1.preparationtour();
		
		window.setDominosTour(jeu1.dominostour);
		window.setnbrois(jeu1.getnbrois());
		
		jeu1.tourjoueur();
		
	}
	

	public static void main(String[] args) {
		

		Domino.extraireCsv("dominos.csv");
		System.out.println("Voici le nombre de dominos extraits du csv : " + Domino.nombreinitialdominos);
		System.out.println(
				"Voici la longueur de la liste des dominos extraits du csv : " + Domino.listedetouslesDominos.size());

		Domino.creationListeDominos();
		System.out.println("La liste dominos a correctement ete creee.");

		Tuile.remplirlistetuile(Domino.dominos);
		System.out.println("La liste tuiles a ete remplie e partir de la liste dominos.");

	
		window.FenetreJeu.setVisible(true);


		System.out.println("\n_____________Nouvelle Partie_____________\n");
	}
	
	

}
