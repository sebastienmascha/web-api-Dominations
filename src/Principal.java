import java.awt.EventQueue; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
 
public class Principal { 
	 
	static Affichage window = new Affichage(); 
	 
	static Jeu jeu1 = new Jeu(); 
	 
 
	public static void initialisation() { 
		jeu1.setNbJoueurs(2); 
		//jeu1.setChoixDomiTour(1,0,2,3); 
		jeu1.initialisationpartie(); 
		jeu1.preparationtour(); 
		
		System.out.println("----------------------------------------------------------");
		System.out.println(jeu1.dominostour[3][0]);
		System.out.println(jeu1.dominostour[2][0]);
		System.out.println("---------------------------------------");
		System.out.println("CALCUL DU SCORE (voir Regles et Principal)");
		System.out.println("--On place 5 fois le meme domino :\n "+jeu1.dominostour[3][0]+"\n");
		Terrain terrain1 = new Terrain();
		terrain1.remplirTerrain(jeu1.dominostour[3][0], 0, 0);
		terrain1.remplirTerrain(jeu1.dominostour[3][0], 0, 1);
		terrain1.remplirTerrain(jeu1.dominostour[3][0], 1, 0);
		terrain1.remplirTerrain(jeu1.dominostour[3][0], 1, 1);
		terrain1.remplirTerrain(jeu1.dominostour[3][0], 2, 1);
		
		
		System.out.println("--On place 4 fois le meme domino :\n "+jeu1.dominostour[2][0]+"\n");
		terrain1.remplirTerrain(jeu1.dominostour[2][0], 3, 3);
		terrain1.remplirTerrain(jeu1.dominostour[2][0], 3, 4);
		terrain1.remplirTerrain(jeu1.dominostour[2][0], 4, 3);
		terrain1.remplirTerrain(jeu1.dominostour[2][0], 4, 4);
		//System.out.println("\n"+terrain1.getTuilesVoisinesPositionX(2, 3, terrain1));
		System.out.println("LE SCORE EST : \n"+Regles.scorePlateau(terrain1));
		System.out.print("------------------------------------");
		
		
		
		
		
		
		
		
		
		
		 
		
		 
		//jeu1.setChoixDomiTour(window.numdomitour,window.numtuiletour,window.PageJeu.) 
		 
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
 
	 
		//window.FenetreJeu.setVisible(true); 
		Principal.initialisation();
 
		System.out.println("\n_____________Nouvelle Partie_____________\n"); 
	} 
	 
	 
 
} 
