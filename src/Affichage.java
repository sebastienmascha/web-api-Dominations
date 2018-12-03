import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.awt.List;
import java.io.File;

public class Affichage {
public static void main (String[] args) {
Domino test= new Domino(4, 2, "Foret", 3, "Mer");
affiche(test);
}
	
	

	public static void affiche(Domino dom) {
		
	ArrayList<String> lettre = new ArrayList<String>();
	String lettreG = null;
	String lettreD = null;
	lettre.add(lettreG);
	lettre.add(lettreD);
	
	ArrayList<String> type = new ArrayList<String>();
	type.add(dom.gettype1());
	type.add(dom.gettype2());
	
	System.out.println("Avant boucle for : 0) "+type.get(0));
	System.out.println("Avant boucle for : 1) "+type.get(1));
	
	for (int i=0;i<type.size();++i) {
	System.out.println(i+") "+type.get(i));
	switch(type.get(i)) {
	case "Mer":
		lettre.set(i,"Me");
		break;
	case "Montagne":
		lettre.set(i,"Mo");
		break;
	case "Mine":
		lettre.set(i,"Mi");
		break;
	case "Prairie":
		lettre.set(i,"P");
		break;
	case "Foret":
		lettre.set(i,"F");
		break;
	case "Champs":
		lettre.set(i,"C");
		break;
	}
	}

	System.out.println(" ______________");
	System.out.println("| "+ dom.getnbCouronne1() + ", " + lettre.get(0) + " | " + dom.getnbCouronne2() + ", " + lettre.get(1) + " |");
	System.out.println("|______|_______|");
}

	
	
	
	
	
	
	
	
	
	
	
}
/*
public Domino(int num, int nbCouronne1, String type1, int nbCouronne2, String type2) {
numeroDomino = num;
nbCouronne1 = nbCouronne1;
type1 = type1;
nbCouronne2 = nbCouronne2;
type2 = type2;

/*/