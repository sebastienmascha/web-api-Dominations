
public class Jeu {
	
	static Domino[] dominos=new Domino[48];

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
