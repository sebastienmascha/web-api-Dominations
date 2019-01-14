import java.util.ArrayList;

public class Regles {
	// VARIABLES SCORE
	public static int N;
	public static int C = 0;
	
	public static boolean memeZone = true;
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
			String typeZone = terrain.terrain[x][y].gettype();
			terrain.terrain[x][y]= null; // pour indiquer que la tuile a déjà été compté
			
			
			if ((x + 1 != 10) && terrain.terrain[x + 1][y]!=null && ((Tuile) terrain.terrain[x + 1][y]).gettype() == typeZone) {

				scoreZone(x + 1, y, terrain);

			}

			if (x - 1 != -1 && terrain.terrain[x - 1][y]!=null && ((Tuile) terrain.terrain[x - 1][y]).gettype() == typeZone) {
				scoreZone(x - 1, y, terrain);

			}

			if ((y + 1 != 10)  && terrain.terrain[x][y + 1]!=null && ((Tuile) terrain.terrain[x][y + 1]).gettype() == typeZone) {
				scoreZone(x, y + 1, terrain);
			}

			if ((y - 1 != -1) && terrain.terrain[x][y - 1]!=null && ((Tuile) terrain.terrain[x][y - 1]).gettype() == typeZone){
				scoreZone(x, y - 1, terrain);

			}
		}
        
	}
	
	
	public static void scoreZone(int x, int y, Terrain terrain) {
		rechercheZone(x, y, terrain); // recursivité pour délimiter la zone
		if (memeZone) {
			memeZone = false;
			int nbCourrones = 0;
			for (int i = 0; i < ZonesTuiles.size(); i++) { // calcul du nb de courronne par zone
				nbCourrones += ZonesTuiles.get(i).getnbcouronne();
			} 
			terrain.Score += (ZonesTuiles.size()*nbCourrones);
			System.out.println(ZonesTuiles.size()*nbCourrones);
		}		
	}

	// Calcul du score pour un terrain donné
	public static int scorePlateau(Terrain terrain) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				scoreZone(j, i, terrain); // on compte 
				ZonesTuiles = new ArrayList<Tuile>(); // on initialise la zone à liste vide
				memeZone = true;
			}
		}
		return terrain.Score;

	}
	
	
	
	// TESTS
	/*
	System.out.println("----------------------------------------------------------");
		System.out.println(dominostour[3][0]);
		System.out.println(dominostour[2][0]);
		System.out.println("---------------------------------------");
		Terrain terrain1 = new Terrain();
		terrain1.remplirTerrain(dominostour[3][0], 0, 0);
		terrain1.remplirTerrain(dominostour[3][0], 0, 1);
		terrain1.remplirTerrain(dominostour[3][0], 1, 0);
		terrain1.remplirTerrain(dominostour[3][0], 1, 1);
		terrain1.remplirTerrain(dominostour[3][0], 2, 1);
		
		terrain1.remplirTerrain(dominostour[2][0], 3, 3);
		terrain1.remplirTerrain(dominostour[2][0], 3, 4);
		terrain1.remplirTerrain(dominostour[2][0], 4, 3);
		terrain1.remplirTerrain(dominostour[2][0], 4, 4);
		//System.out.println("\n"+terrain1.getTuilesVoisinesPositionX(2, 3, terrain1));
		System.out.println("\n"+Regles.scorePlateau(terrain1));
		System.out.print("------------------------------------");
	
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
