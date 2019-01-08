import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.awt.List;
import java.io.File;

public class Domino {

	// attributs des dominos
	public int nbCouronne1, nbCouronne2, num;
	public String type1, type2;
	public static int nombreinitialdominos;

	// liste des dominos
	public static ArrayList<Domino> listedetouslesDominos = new ArrayList<Domino>();
	static Domino[] dominos = new Domino[48];

	// constructeur d'un Domino
	public Domino(int num, int nbCouronne1, String type1, int nbCouronne2, String type2) {
		this.num = num - 1;
		this.nbCouronne1 = nbCouronne1;
		this.type1 = type1;
		this.nbCouronne2 = nbCouronne2;
		this.type2 = type2;

	}

	// creation de la liste initiale des dominos en extrayant le fichier csv
	public static ArrayList<Domino> extraireCsv(String nomcsv) {
		String fileName = nomcsv;
		File file = new File(fileName);

		try {
			Scanner inputStream = new Scanner(file);
			inputStream.next();
			nombreinitialdominos = 0;
			while (inputStream.hasNext()) {
				String data = inputStream.next();
				String[] values = data.split(",");

				Domino domi = new Domino(Integer.parseInt(values[4]), Integer.parseInt(values[0]), values[1],
						Integer.parseInt(values[2]), values[3]);

				listedetouslesDominos.add(domi);
				nombreinitialdominos += 1;
			}
			inputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Fichier csv non trouvé");
		}
		// This prints out the working directory
		return listedetouslesDominos;

	}

	

	public static Domino[] creationListeDominos() {
		/*
		 * Domino.listeDominos.get(1).gettype1();
		 * 
		 * Domino d1= Domino.listeDominos.get(1);
		 */
		
		for (int i = 0; i < dominos.length; i++) {
			dominos[i] = Domino.listedetouslesDominos.get(i);
		}

		return dominos;

	}

	// affiche les attributs d'un domino de la liste initiale
	public String toString() {
		return "numéro: " + num + "\nnbcouronne1: " + nbCouronne1 + "\ntype1: " + type1 + "\nnbCouronne2: "
				+ nbCouronne2 + "\ntype 2: " + type2;

	}

	// Getters & Setters
	public int getnum() {
		return num;
	}

	public void setnum(int num) {
		this.num = num;
	}

	public String gettype1() {
		return type1;
	}

	public void settype1(String type1) {
		this.type1 = type1;
	}

	public String gettype2() {
		return type2;
	}

	public void settype2(String type2) {
		this.type2 = type2;
	}

	public int getnbCouronne1() {
		return nbCouronne1;
	}

	public void setnbCouronne1(int nbCouronne1) {
		this.nbCouronne1 = nbCouronne1;
	}

	public int getnbCouronne2() {
		return nbCouronne2;
	}

	public void setnbCouronne2(int nbCouronne2) {
		this.nbCouronne2 = nbCouronne2;
	}

	// afficher un Domino par son numéro
	public static void afficherDominoParNum(int num) {
		System.out.println(listedetouslesDominos.get(num));
	}

	// afficher un Domino depuis une liste de dominos
	public static void afficherDomino(Domino undomi) {
		System.out.println(undomi);
	}

}
