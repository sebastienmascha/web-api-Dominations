import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tuile {

	int nbCouronne, num1, num2;
	String type;

	static ArrayList<Tuile> listeTuiles = new ArrayList<Tuile>();

	public Tuile(int num1, int num2, int nbCouronne, String type) {
		this.num1 = num1;
		this.num2 = num2;
		this.nbCouronne = nbCouronne;
		this.type = type;

	}

	public static ArrayList<Tuile> creerUneTuile(Domino domi) {

			
		Tuile tuile = new Tuile(domi.num, 1, domi.nbCouronne1, domi.type1);
		Tuile tuile2 = new Tuile(domi.num, 2, domi.nbCouronne2, domi.type2);

		listeTuiles.set(domi.num,tuile);
		listeTuiles.set(domi.num,tuile);
		listeTuiles.add(tuile);
		listeTuiles.add(tuile2);
		
	// This prints out the working directory
	return listeTuiles;


}

}
