import java.util.ArrayList;

public class Regles {
	// VARIABLES SCORE
	public static int N;
	public static int C = 0;
	public static ArrayList<Integer> listTuilePositionX = new ArrayList<Integer>();
	public static ArrayList<Integer> listTuilePositionY = new ArrayList<Integer>();
	public static ArrayList<Tuile> listTuile;
	
	
	public static boolean placementTuile(Tuile tuile, Terrain terrain, int posx, int posy) {
		if (isTuileVide(posx,posy,terrain)) {
			if (terrain.terrain[posx+1][posy].gettype() == tuile.gettype() ) {//|| terrain.terrain[posx-1][posy].gettype() == tuile.gettype() || terrain.terrain[posx][posy+1].gettype() == tuile.gettype() || terrain.terrain[posx][posy-1].gettype() == tuile.gettype()) {
				return true;
			}
		}
		return false;
	}

	public static boolean isTile(int posx, int posy, Terrain terrain) {
		return terrain.terrain[posx][posy] == null;
	}

	public static boolean isTuileVide(int posx, int posy, Terrain terrain) {
		try {
			return terrain.terrain[posx][posy] == null;
		}catch(Exception e) {
			return true;
		}
	}
	
	public static boolean isTuileDroiteVide(int posx, int posy, Terrain terrain) {
		try {
			return terrain.terrain[posx+1][posy] == null;
		}catch(Exception e) {
			return true;
		}
	}
	
	public static boolean isTuileGaucheVide(int posx, int posy, Terrain terrain) {
		try {
			return terrain.terrain[posx-1][posy] == null;
		}catch(Exception e) {
			return true;
		}
		
	}
	
	public static boolean isTuileHautVide(int posx, int posy, Terrain terrain) {
		try {
			return terrain.terrain[posx][posy-1] == null;
		}catch(Exception e) {
			return true;
		}
	}
	
	public static boolean isTuileBasVide(int posx, int posy, Terrain terrain) {
		try {
			return terrain.terrain[posx][posy+1] == null;
		}catch(Exception e) {
			return true;
		}
	}

	// FIN DE PARTIE : PLUS DE DOMINO
	public static boolean isFinDePartie(int taillePioche, int nbrois) {
		return taillePioche < nbrois;
	}
	
	// SCORE CODE GENERAL
	public static int score(Terrain terrain) {
		int i = 0; // il faudra mettre un Affichage.getPosxRoyaume()
		int j =0;  // Pareil
		while (i <= 8) { // Aussi
			while (j <= 8) { // Aussi
				if (!(Regles.isTuileVide(i, j, terrain))){
					listTuilePositionX.add(i);
					listTuilePositionY.add(j);
					recursive(listTuilePositionX, listTuilePositionY, terrain);
					terrain.setScore(C*N);
					C=0;
					N=0;
					
				}
				j++;
			}
			i++;
		}
		return terrain.Score;
	}
	
	public static void recursive(ArrayList<Integer> listTuilePositionX, ArrayList<Integer> listTuilePositionY, Terrain terrain) {
		ArrayList<Integer> histolistTuilePositionX = new ArrayList<Integer>();
		ArrayList<Integer> histolistTuilePositionY = new ArrayList<Integer>();
		if (listTuilePositionX.size() != 0) {
			while (listTuilePositionX.size() == 0) {
				histolistTuilePositionX.add(0);
				histolistTuilePositionY.add(0);
				int j1 = 0; 
				int j2 =0;  
				while (0 <= histolistTuilePositionX.size()) { 
					while (j2 <= histolistTuilePositionX.size()) { 
						if (!(Regles.isTuileVide(j1, j2, terrain))){
							N += 1;
							C += terrain.terrain[listTuilePositionX.get(j1)][listTuilePositionY.get(j2)].getnbcouronne();
							ArrayList<Integer> tuilesVoisinesPositionX = terrain.getTuilesVoisinesPositionX(listTuilePositionX.get(0),listTuilePositionY.get(0), terrain);
							ArrayList<Integer> tuilesVoisinesPositionY = terrain.getTuilesVoisinesPositionY(listTuilePositionX.get(0),listTuilePositionY.get(0), terrain);
							//ArrayList<Tuile> tuilesVoisines = terrain.getTuilesVoisines(listTuilePositionX.get(i),listTuilePositionY.get(i),terrain);
							//listTuile.remove(i);
							listTuilePositionX.remove(0);
							listTuilePositionY.remove(0);
							recursive(tuilesVoisinesPositionX,tuilesVoisinesPositionX,terrain);
						}
						j2++;
					}
					j1++;
				}
			}
		}
	}
	// TESTS
	/*
	System.out.println("\nListe dominotours apres tri :");
	afficherListe(dominostour);
	System.out.println("----------------------------------------------------------");
	System.out.println(dominostour[3][0]);
	System.out.println("---------------------------------------");
	Terrain terrain1 = new Terrain();
	terrain1.remplirTerrain(dominostour[3][0], 0, 0);
	terrain1.remplirTerrain(dominostour[3][0], 0, 1);
	terrain1.remplirTerrain(dominostour[3][0], 1, 0);
	terrain1.remplirTerrain(dominostour[3][0], 1, 1);
	//System.out.println("\n"+terrain1.getTuilesVoisinesPositionX(2, 3, terrain1));
	System.out.println("\n"+terrain1.getTuilesVoisinesPositionX(0, 0, terrain1));
	System.out.println("\n"+terrain1.getTuilesVoisinesPositionX(0, 0, terrain1));
	System.out.println("\n"+Regles.score(terrain1));
	
	*/
	
	
	
	
	
	// REGLES ADDITIONNELLES BONUS
	// Empire du milieu
	public static boolean isChateauAuMilieu(int posChateauX, int posChateauY,int positionRoyaumeX, int positionRoyaumeY, Terrain terrain) {
		boolean chateauMilieu = false;
		if (posChateauX==positionRoyaumeX) {
			if (posChateauX==positionRoyaumeX) {
				chateauMilieu=true;
			}
		}
		return chateauMilieu;
	}
	// HARMONIE
	public static boolean isDynastie(Terrain terrain) {
		boolean isDynastie = true;
		int i = 0;
		int j = 0;
		while (i <= 8) {
			while (j <= 8) {
				if (terrain.terrain[i][j] == null)
					j++;
			}
			i++;
		}
		return isDynastie;
	}
	
	// Dynastie
	// Le Grand Duel
	

}
