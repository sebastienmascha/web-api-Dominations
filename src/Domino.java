import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.awt.List;
import java.io.File;

public class Domino {
	int nbCouronne1, nbCouronne2, numeroDomino;
	int xtype1, xtype2, ytype1, ytype2;
	String type1, type2;
	static ArrayList<Object> listeDominos = new ArrayList<Object>();

	public Domino(int num, int nbCouronne1, String type1, int nbCouronne2, String type2) {
		numeroDomino = num;
		nbCouronne1 = nbCouronne1;
		type1 = type1;
		nbCouronne2 = nbCouronne2;
		type2 = type2;

	}

	public static ArrayList<Object> extraireCsv(String nomcsv) {
		String fileName = nomcsv;
		File file = new File(fileName);
		


		try {
			Scanner inputStream = new Scanner(file);
			inputStream.next();
			while (inputStream.hasNext()) {
				String data = inputStream.next();
				String[] values = data.split(",");
				Domino domi = new Domino(Integer.parseInt(values[4]), Integer.parseInt(values[0]), values[1],
						Integer.parseInt(values[2]), values[3]);
				listeDominos.add(domi);
			}
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// This prints out the working directory
		return listeDominos;

	}
	

	
	public static void afficherDomino(int num) {
		System.out.println(listeDominos.get(num));
		//arriver à printer l'objet de la liste
		
	}

}
