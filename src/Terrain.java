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

		this.terrain[posx][posy] = tuile;
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
    
    public void setScore(int score) {
        this.Score = score;
    }
    
    /*public ArrayList<Integer> getPositionTuile(Tuile tuile, Terrain terrain) {
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
    }*/
/*
    public ArrayList<Integer> getTuilesVoisinesPosition(Tuile tuile, Terrain terrain) {
    	ArrayList<Integer> tuilesVoisinesPosition = new ArrayList<Tuile>();
    	int i = 0;
		int j =0;
		if (Regles.isTuileDroiteVide(getPositionTuile(tuile, terrain).get(0),getPositionTuile(tuile, terrain).get(1), terrain)) {
			//tuilesVoisines.add(tuile)
		}
        return tuilesVoisines;
    }
    */
    
    public ArrayList<Integer> getTuilesVoisinesPositionX(Tuile tuile, int posx, int posy, Terrain terrain) {
    	ArrayList<Integer> TuilesVoisinesPositionX = new ArrayList<Integer>();
    	String typeTuile = tuile.gettype();
    	int i = 0;
		int j =0;
		if (!(Regles.isTuileDroiteVide(posx, posy, terrain))) {
			if (terrain.terrain[posx+1][posy].gettype() == typeTuile) {
				TuilesVoisinesPositionX.add(posx+1);
			}
		}
		if (!(Regles.isTuileGaucheVide(posx, posy, terrain))) {
			if (terrain.terrain[posx-1][posy].gettype() == typeTuile) {
				TuilesVoisinesPositionX.add(posx-1);
			}
		}
		if (!(Regles.isTuileHautVide(posx, posy, terrain))) {
			if (terrain.terrain[posx][posy-1].gettype() == typeTuile) {
				TuilesVoisinesPositionX.add(posx);
			}
		}
		if (!(Regles.isTuileBasVide(posx, posy, terrain))) {
			if (terrain.terrain[posx][posy+1].gettype() == typeTuile) {
				TuilesVoisinesPositionX.add(posx);
			}
		}
		
		
        return TuilesVoisinesPositionX;
    }
    public ArrayList<Integer> getTuilesVoisinesPositionY(Tuile tuile, int posx, int posy, Terrain terrain) {
    	ArrayList<Integer> TuilesVoisinesPositionY = new ArrayList<Integer>();
    	String typeTuile = tuile.gettype();
    	int i = 0;
		int j =0;
		if (!(Regles.isTuileDroiteVide(posx, posy, terrain))) {
			if (terrain.terrain[posx+1][posy].gettype() == typeTuile) {
				TuilesVoisinesPositionY.add(posy);
			}
		}
		if (!(Regles.isTuileGaucheVide(posx, posy, terrain))) {
			if (terrain.terrain[posx-1][posy].gettype() == typeTuile) {
				TuilesVoisinesPositionY.add(posy);
			}
		}
		if (!(Regles.isTuileHautVide(posx, posy, terrain))) {
			if (terrain.terrain[posx][posy-1].gettype() == typeTuile) {
				TuilesVoisinesPositionY.add(posy-1);
			}
		}
		if (!(Regles.isTuileBasVide(posx, posy, terrain))) {
			if (terrain.terrain[posx][posy+1].gettype() == typeTuile) {
				TuilesVoisinesPositionY.add(posy+1);
			}
		}
        return TuilesVoisinesPositionY;
    }
    

	

}
