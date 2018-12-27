import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.awt.List;
import java.io.File;



/* Fonctions � faire:
 * 
 * affichageTerrain(Terrain terrain)
 * 
 * pour cela il faut parcourir le tableau terrain et
 * afficher en ASCII les attributs de chaque tuile pr�sente dans le tableau.
 * 
 */





public class AffichageASCII {

	public static void DessineDomino (Domino dom) {
		
	ArrayList<String> lettre = new ArrayList<String>();
	String lettreG = null;
	String lettreD = null;
	lettre.add(lettreG);
	lettre.add(lettreD);
	
	ArrayList<String> type = new ArrayList<String>();
	type.add(dom.gettype1());
	type.add(dom.gettype2());
	
	for (int i=0;i<type.size();++i) {
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

	System.out.println(" _____________");
	System.out.println("| "+ dom.getnbCouronne1() + ", " + lettre.get(0) + " | " + dom.getnbCouronne2() + ", " + lettre.get(1) + " |");
	System.out.println("|______|______|");
}

	
	
	
	
	
	
	
	
	
	
	
}
