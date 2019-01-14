import java.util.ArrayList;

public class Regles {
	// VARIABLES SCORE
	public static int N;
	public static int C = 0;
	
	static ArrayList<Tuile> ZonesTuiles = new ArrayList<Tuile>();
	
	/*
	public static ArrayList<Integer> listTuilePositionX = new ArrayList<Integer>();
	public static ArrayList<Integer> listTuilePositionY = new ArrayList<Integer>();
	public static ArrayList<Integer> histolistTuilePositionX = new ArrayList<Integer>();
	public static ArrayList<Integer> histolistTuilePositionY = new ArrayList<Integer>();
	*/
	
	public static boolean placementTuile(Tuile tuile, Terrain terrain, int posx, int posy) {
		if (isTuileVide(posx,posy,terrain)) {
			if (terrain.terrain[posx+1][posy].gettype() == tuile.gettype() ) {//|| terrain.terrain[posx-1][posy].gettype() == tuile.gettype() || terrain.terrain[posx][posy+1].gettype() == tuile.gettype() || terrain.terrain[posx][posy-1].gettype() == tuile.gettype()) {
				return true;
			}
		}
		return false;
	}

	public static boolean isTuile(int posx, int posy, Terrain terrain) {
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
	
	
	
	
	
	// rechercher une zone (un ensemble de mêmes tuiles)
	public static void rechercheZone(int x, int y, Terrain terrain) {
		
		if(terrain.terrain[x][y]!=null) {
			ZonesTuiles.add((Tuile) terrain.terrain[x][y]);
			terrain.terrain[x][y]= null; // pour indiquer que la tuile a déjà été compté
			
			
			if (terrain.terrain[x + 1][y]!=null && ((Tuile) terrain.terrain[x + 1][y]).gettype() == ((Tuile) terrain.terrain[x][y]).gettype() && (x + 1 != 10)) {

				scoreZone(x + 1, y, terrain);

			}

			if (terrain.terrain[x - 1][y]!=null && (((Tuile) terrain.terrain[x - 1][y]).gettype() == ((Tuile) terrain.terrain[x][y]).gettype()) && (x - 1 != -1)) {
				scoreZone(x - 1, y, terrain);

			}

			if (terrain.terrain[x][y + 1]!=null && ((Tuile) terrain.terrain[x][y + 1]).gettype() == ((Tuile) terrain.terrain[x][y]).gettype() && (y + 1 != 10)) {
				scoreZone(x, y + 1, terrain);

			}

			if (terrain.terrain[x][y - 1]!=null && ((Tuile) terrain.terrain[x][y - 1]).gettype() == ((Tuile) terrain.terrain[x][y]).gettype() && (y - 1 != -1)) {
				scoreZone(x, y - 1, terrain);

			}
		}
		
		
		
        
	}
	
	
	public static void scoreZone(int x, int y, Terrain terrain) {
		rechercheZone(x, y, terrain); // on trouve la zone
		int nbCouronnes = 0;
		for (int i = 0; i < ZonesTuiles.size(); i++) {
			nbCouronnes += ZonesTuiles.get(i).getnbcouronne();
		} // on calcule le nb de couronnes dans la zone
		terrain.Score += (ZonesTuiles.size() * nbCouronnes);
		ZonesTuiles = new ArrayList<Tuile>(); // on initialise la zone à liste vide
	}

	// exécuter cette fonction pour calculer le nb de points total du plateau
	public static int scorePlateau(Terrain terrain) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				scoreZone(j, i, terrain); // on compte 
			}
		}
		return terrain.Score;

	}
	
	
	
	
	
	/*
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
		
		while (listTuilePositionX.size() != 0) {
			histolistTuilePositionX.add(listTuilePositionX.get(0));
			histolistTuilePositionY.add(listTuilePositionY.get(0));
			N += 1;
			C += terrain.terrain[listTuilePositionX.get(0)][listTuilePositionY.get(0)].getnbcouronne();
			ArrayList<Integer> tuilesVoisinesPositionX = terrain.getTuilesVoisinesPositionX(listTuilePositionX.get(0),listTuilePositionY.get(0), terrain);
			ArrayList<Integer> tuilesVoisinesPositionY = terrain.getTuilesVoisinesPositionY(listTuilePositionX.get(0),listTuilePositionY.get(0), terrain);
			int j1=0;
			int j2=0;
			while (j1 <= tuilesVoisinesPositionX.size()-1) { 
				while (j2 <= histolistTuilePositionY.size()-1) { 
					if (histolistTuilePositionX.get(j2) == tuilesVoisinesPositionX.get(j1)){
						if (histolistTuilePositionY.get(j2) == tuilesVoisinesPositionY.get(j1)){
							tuilesVoisinesPositionX.remove(j1);
							tuilesVoisinesPositionY.remove(j1);
						}else {
							j2++;
						}
					}else {
						j2++;
					}
				}
				j1++;
			}
			listTuilePositionX.remove(0);
			listTuilePositionY.remove(0);
			recursive(tuilesVoisinesPositionX,tuilesVoisinesPositionY,terrain);
		}
	}
	// TESTS
	
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
