import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.awt.List;
import java.io.File;

public class Domino {
	int nbCouronne1, nbCouronne2, num;
	int xtype1, xtype2, ytype1, ytype2;
	String type1, type2;
	static ArrayList<Domino> listeDominos = new ArrayList<Domino>();

	public Domino(int num, int nbCouronne1, String type1, int nbCouronne2, String type2) {
		this.num = num;
		this.nbCouronne1 = nbCouronne1;
		this.type1 = type1;
		this.nbCouronne2 = nbCouronne2;
		this.type2 = type2;

	}

	public static ArrayList<Domino> extraireCsv(String nomcsv) {
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
	
	public String toString() {
        return "numéro: "+ num  +"\nnbcouronne1: "+nbCouronne1+"\ntype1: "+  type1+"\nnbCouronne2: "+  nbCouronne2+"\ntype 2: "+  type2;
        
    }

	
	public String gettype1() {
		return type1;
	}
	
	public void settype1(String type1) {
		this.type1= type1;
	}

	public String gettype2() {
		return type1;
	}

	public void settype2(String type2) {
		this.type2= type2;
	}
	public int getnbCouronne1() {
		return nbCouronne1;
	}

	public void setnbCouronne1(int nbCouronne1) {
		this.nbCouronne1=nbCouronne1;
	}
	public int getnbCouronne2() {
		return nbCouronne2;
	}

	public void setnbCouronne2(int nbCouronne2) {
		this.nbCouronne2=nbCouronne2;
	}


	
	public static void afficherDominoParNum(int num) {
		System.out.println(listeDominos.get(num-1));
	}
	
	public static void afficherDomino(Domino dominos) {
		System.out.println(dominos);
	}





}
