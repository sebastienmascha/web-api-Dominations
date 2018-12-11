import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tuile {

	int nbCouronne, num1, num2;
	String type;
	
	static Tuile[][] positionTuiles=new Tuile[48][2];
	static ArrayList<Tuile> listeTuiles = new ArrayList<Tuile>();

	public Tuile(int num1, int num2, int nbCouronne, String type) {
		this.num1 = num1;
		this.num2 = num2;
		this.nbCouronne = nbCouronne;
		this.type = type;

	}

	public static Tuile[][] creerUneTuile(Domino domi) {

			
		Tuile tuile1 = new Tuile(domi.getnum() , 1, domi.getnbCouronne1(), domi.gettype1());
		Tuile tuile2 = new Tuile(domi.getnum(), 2, domi.getnbCouronne2(), domi.gettype2());

		positionTuiles[domi.getnum()][0]=tuile1;
		positionTuiles[domi.getnum()][1]=tuile2;
		
		//old
		/*
		listeTuiles.set(domi.getnum(),tuile1);
		listeTuiles.set(domi.getnum(),tuile2);
		listeTuiles.add(tuile1);
		listeTuiles.add(tuile2);
		*/
		
	// This prints out the working directory
	return positionTuiles;


}

}
