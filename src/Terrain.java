import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Terrain {
	
	
	static Tuile[][] positionTuiles=new Tuile[48][2];
	
	
	public static Tuile[][] creationListeTuilesDominos() {
		/*
		Domino.listeDominos.get(1).gettype1();
		
		Domino d1= Domino.listeDominos.get(1);
		*/
		
		
		  
		  for (int i = 0; i < positionTuiles.length; i++) {
			  positionTuiles[i][1]=Tuile.listeTuiles.get(i);
			  positionTuiles[i][2]=Tuile.listeTuiles.get(i+1);
			  
		  }
		  
		  return positionTuiles;
		
		 
		
	}
	
	//creer tableau tuiles

	
	
	
	
	
	
	
	
static Map<String, ArrayList<String>> bibliotheque = new HashMap<>();
	
	static ArrayList<String> artisteliste = new ArrayList<String>();
	static ArrayList<String> albumliste = new ArrayList<String>();

	public static ArrayList<Integer> remplirListe(ArrayList<Integer> liste) {
		ArrayList<Integer> liste1 = new ArrayList<>(Arrays.asList());

		System.out.println("Voulez-vous saisir une nouvelle valeur ? (y/n)");
		Scanner scanner = new Scanner(System.in);
		String yesno = scanner.nextLine();
		if (yesno == "y") {
			try {
				System.out.println("Quelle valeur voulez-vous ajouter ?");
				liste.add(Integer.valueOf(scanner.nextLine()));
				remplirListe(liste);

			} catch (NumberFormatException e) {
				System.out.println("vous devez mettre un entier");
				remplirListe(liste);
			}
		} else {
			System.out.println("Vous avez décidé de ne pas ajouter de valeur ");

		}
		return liste;

	}
	
	
	
	

}
