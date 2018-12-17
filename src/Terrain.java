import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Terrain {
	private Chateau[] tabChateau;
    private List<Domino> listeDomino;
    private int tourJoueur = 1;
    
    Tuile terrain[][] = new Tuile[9][9];
    
    public Terrain() {
        //tabChateau = new Chateau[2];
        //listeDomino = new ArrayList<Domino>();
    }
    
    

	
	public void remplirTerrain(Tuile tuile, int posx, int posy) {

		terrain[posx][posy] = tuile;

	}
	
	
	
	
	public Chateau getChateau(int indice) {
        return tabChateau[indice];
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
    
    

	

}
