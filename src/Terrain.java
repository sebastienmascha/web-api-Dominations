import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Terrain {
    private List<Domino> listeDomino;
    private int tourJoueur = 1;
    public int Score;
    
    Tuile terrain[][] = new Tuile[9][9];
    
    public Terrain() {
        //tabChateau = new Chateau[2];
        //listeDomino = new ArrayList<Domino>();
    }
    
    

	
	public void remplirTerrain(Tuile tuile, int posx, int posy) {

		terrain[posx][posy] = tuile;

	}
	
	
	
	

    public List<Domino> getListeDomino() {
        return listeDomino;
    }
    
    public int getTourJoueur() {
        return tourJoueur;
    }

    public void setTourJoueur(int tourJoueur) {
        this.tourJoueur = tourJoueur;
    }
    
    public ArrayList<Integer> getPositionTuile(Tuile tuile, Terrain terrain) {
    	ArrayList<Integer> positionTuile = new ArrayList<Integer>();
    	int i = 0;
		int j =0;
		while (i <= 8) {
			while (j <= 8) {
				if (!(Regles.isTuileVide(i, j, terrain))) {
					if (terrain.terrain[i][j].getnumdomi() == tuile.getnumdomi()) {
						if (terrain.terrain[i][j].getnumtuile() == tuile.getnumtuile()) {
							positionTuile.add(i);
							positionTuile.add(j);
						}
					}
				}
				j++;
			}
			i++;
		}
        return positionTuile;
    }

    public ArrayList<Tuile> getTuilesVoisines(Tuile tuile, Terrain terrain) {
    	ArrayList<Tuile> tuilesVoisines = new ArrayList<Tuile>();
    	int i = 0;
		int j =0;
		if (Regles.isTuileDroiteVide(getPositionTuile(tuile, terrain).get(0),getPositionTuile(tuile, terrain).get(1), terrain)) {
			//tuilesVoisines.add(tuile)
		}
        return tuilesVoisines;
    }
    

	

}
