
public class Principal {

	public static void main(String[] args) {
		Domino.extraireCsv("dominos.csv");
		Domino.afficherDominoParNum(2);
		Jeu.creationListeDominos();
		System.out.println("______________");
		Domino.afficherDomino(Jeu.dominos[2]);
		System.out.println(Jeu.dominos[2].gettype1());
		
	}
	
	/* sert � construire un tableau de dominos o� chaque element est la r�f�rence �
	 * un domino dont le nom est cr�� par l'index de sa position dans le tableau
	 *
	 */
	 
	

}
