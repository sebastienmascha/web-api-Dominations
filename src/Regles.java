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
					recursive(listTuilePositionX, listTuilePositionY, N,C, terrain);
					terrain.Score += C*N;
				}
				j++;
			}
			i++;
		}
		return C;
	}
	
	public static void recursive(ArrayList<Integer> listTuilePositionX, ArrayList<Integer> listTuilePositionY, int N, int C, Terrain terrain) {
		
		if (listTuilePositionX.size() != 0) {
			for (int i = 0; i <= listTuilePositionX.size() - 1; i++) {
				N += 1;
				C += terrain.terrain[listTuilePositionX.get(i)][listTuilePositionY.get(i)].getnbcouronne();
				ArrayList<Integer> tuilesVoisinesPositionX = terrain.getTuilesVoisinesPositionX(listTuilePositionX.get(i),listTuilePositionY.get(i), terrain);
				ArrayList<Integer> tuilesVoisinesPositionY = terrain.getTuilesVoisinesPositionY(listTuilePositionX.get(i),listTuilePositionY.get(i), terrain);
				//ArrayList<Tuile> tuilesVoisines = terrain.getTuilesVoisines(listTuilePositionX.get(i),listTuilePositionY.get(i),terrain);
				//listTuile.remove(i);
				listTuilePositionX.remove(i);
				listTuilePositionY.remove(i);
				recursive(tuilesVoisinesPositionX,tuilesVoisinesPositionX,N,C,terrain);
			}
		}
	}
	
	// SCORE CODE GENERAL
	
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
