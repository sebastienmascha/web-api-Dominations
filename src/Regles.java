import java.util.ArrayList;

public class Regles {
	// VARIABLES SCORE
	public static int N;
	public static int C;
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
		return terrain.terrain[posx][posy] == null;
	}
	
	public static boolean isTuileDroiteVide(int posx, int posy, Terrain terrain) {
		return terrain.terrain[posx+1][posy] == null;
	}
	
	public static boolean isTuileGaucheVide(int posx, int posy, Terrain terrain) {
		return terrain.terrain[posx-1][posy] == null;
	}
	
	public static boolean isTuileHautVide(int posx, int posy, Terrain terrain) {
		return terrain.terrain[posx][posy+1] == null;
	}
	
	public static boolean isTuileBasVide(int posx, int posy, Terrain terrain) {
		return terrain.terrain[posx][posy-1] == null;
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
					listTuile.add(terrain.terrain[i][j]);
					recursive(listTuile, N,C, terrain);
					terrain.Score += C*N;
				}
			}
			i++;
		}
		return 1;
	}
	
	public static void recursive(ArrayList<Tuile> listTuile, int N, int C, Terrain terrain) {
		if (listTuile.size() != 0) {
			for (int i = 0; i <= listTuile.size() - 1; i++) {
				N += 1;
				C += listTuile.get(i).getnbcouronne();
				ArrayList<Tuile> tuilesVoisines = terrain.getTuilesVoisines(listTuile.get(i), terrain);
				listTuile.remove(i);
				recursive(tuilesVoisines,N,C,terrain);
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
