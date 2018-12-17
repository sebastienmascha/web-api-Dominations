
public class Jeu {
	
	/* A faire:
	 * 
	 * règles de placement dans le terrain : prend en argument le terrain actuel et voir si le placement
	 * demandé par le joueur est possible ou pas
	 * 
	 */
	
	
	
	static Domino[] dominos=new Domino[Domino.nombredominos];
	

	public static Domino[] creationListeDominos() {
		/*
		Domino.listeDominos.get(1).gettype1();
		
		Domino d1= Domino.listeDominos.get(1);
		*/
		
		
		  
		  for (int i = 0; i < dominos.length; i++) {
			  dominos[i]=Domino.listeDominos.get(i);
		  }
		  
		  return dominos;
		
		 
		
	}
	
	
	
}
