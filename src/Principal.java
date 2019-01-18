import java.awt.EventQueue; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
 
public class Principal { 
	 
	static Affichage window = new Affichage(); 
	 
	static Jeu jeu1 = new Jeu(); 
	 
 
	public static void initialisation() { 
		jeu1.setNbJoueurs(window.getnbjoueurs()); 
		//jeu1.setChoixDomiTour(1,0,2,3); 
		jeu1.initialisationpartie(); 
		jeu1.preparationtour(); 
		 
		window.setDominosTour(jeu1.dominostour); 
		window.setnbrois(jeu1.nbrois);
		window.setJoueurs(jeu1.joueurs);
		
		 
		//jeu1.setChoixDomiTour(window.numdomitour,window.numtuiletour,window.PageJeu.) 
		
		//jeu1.tourjoueur(); 
		 
	} 
	
	public static void preselection(AffichagePlateau Ecran, Joueur Joueur, Tuile Tuile1, Tuile Tuile2, int i, int j) {
		
		jeu1.setChoixTuilePreselect(Tuile1);
		jeu1.setJoueurEnCours(window.joueurs[window.compteurjoueur][0]);
		jeu1.preselection();
		window.setBonChoix(jeu1.getBonChoix());
		
		//REMPLIE CHAQUE TERRAIN
		Joueur.terrain1.remplirTerrain(Tuile1, Ecran.posx, Ecran.posy);
		


		
			//jeu1.joueurs[3][0].terrain1.remplirTerrain(jeu1.reconstruirepioche(jeu1.pioche)[j][0], j+1, j+2);
			jeu1.joueurs[2][0].terrain1.remplirTerrain(jeu1.reconstruirepioche(jeu1.pioche)[1][0], 3, 4);
			jeu1.joueurs[1][0].terrain1.remplirTerrain(jeu1.reconstruirepioche(jeu1.pioche)[1][0], 4, 5);
			jeu1.joueurs[0][0].terrain1.remplirTerrain(jeu1.reconstruirepioche(jeu1.pioche)[1][0], 5, 6);
			
			
		
		
		
		
		
		
		
		//window.PageJeu.EcranSud.setTerrain(jeu1.ordrejoueurs[3][0].terrain1.terrain);
		window.PageJeu.EcranOuest.setTerrain(jeu1.ordrejoueurs[0][0].terrain1.terrain);
		window.PageJeu.EcranNord.setTerrain(jeu1.ordrejoueurs[1][0].terrain1.terrain);
		window.PageJeu.EcranEst.setTerrain(jeu1.ordrejoueurs[2][0].terrain1.terrain);
		
		//window.PageJeu.EcranSud.lireTerrain(window.PageJeu.EcranSud.terrain);
		window.PageJeu.EcranOuest.lireTerrain(window.PageJeu.EcranOuest.terrain);
		window.PageJeu.EcranNord.lireTerrain(window.PageJeu.EcranNord.terrain);
		window.PageJeu.EcranEst.lireTerrain(window.PageJeu.EcranEst.terrain);
		
		 
		
	}
	
	public static void definirordre() {
		jeu1.definirnouvelordre();
		window.setOrdreJoueurs(jeu1.getOrdreJoueurs());
		
		
		
		
		
	}
	
	
	public static void tourJeu() {
		jeu1.setChoixTuilePreselect(window.PageJeu.choixtuiletour);
		jeu1.setJoueurEnCours(window.joueurs[window.compteurjoueur][0]);
		jeu1.setPositionChoixTuileTour(window.getPosX(),window.getPosY());
		jeu1.tourjoueur();
		
		window.PageJeu.EcranOuest.setTerrain(jeu1.joueurs[0][0].terrain1.terrain);
		window.PageJeu.EcranOuest.lireTerrain(jeu1.joueurs[0][0].terrain1.terrain);
		
		window.PageJeu.EcranNord.setTerrain(jeu1.joueurs[1][0].terrain1.terrain);
		window.PageJeu.EcranNord.lireTerrain(jeu1.joueurs[1][0].terrain1.terrain);

		window.PageJeu.EcranEst.setTerrain(jeu1.joueurs[2][0].terrain1.terrain);
		window.PageJeu.EcranEst.lireTerrain(jeu1.joueurs[2][0].terrain1.terrain);
		
		if (jeu1.nbjoueurs==4) {
		window.PageJeu.EcranSud.setTerrain(jeu1.joueurs[3][0].terrain1.terrain);
		window.PageJeu.EcranSud.lireTerrain(jeu1.joueurs[3][0].terrain1.terrain);
		}
		
		//window.PageJeu.EcranSud.setTerrain(jeu1.joueurs[3][0].terrain1.terrain);
		//window.PageJeu.EcranSud.lireTerrain(jeu1.joueurs[3][0].terrain1.terrain);
		
	
		window.setBonChoix(jeu1.getBonChoix());
	}

	
	public static void main(String[] args) {

		Domino.extraireCsv("dominos.csv");
		System.out.println(
				"Voici la longueur de la liste des dominos extraits du csv : " + Domino.listedetouslesDominos.size());

		Domino.creationListeDominos();
		System.out.println("La liste dominos a correctement ete creee.");

		Tuile.remplirlistetuile(Domino.dominos);
		System.out.println("La liste tuiles a ete remplie e partir de la liste dominos.");

		System.out.println("\n_____________Nouvelle Partie_____________\n");
		
		window.FenetreJeu.setVisible(true); 
		window.initialisation();
		while(!jeu1.partieterminee) {
			
			window.deroulement();
			jeu1.preparationtour();
			
		}
		
		
		
		

	}
	 
 
	 
		
 


									if (compteurjoueur >= nbrois) {
										System.out.println("Il faut piocher a nouveau\n");
										appelDefinitionNouvelOrdre();
										//pour la suite
										System.out.println("\nCliquez sur la case du terrain desiree, puis sur la tuile a placer.");
										System.out.println("\nC'est au joueur "+ordrejoueurs[0][0].numjoueur+" (" + ordrejoueurs[0][0].getNomJoueur() + ", couleur "+ordrejoueurs[0][0].couleur+") de jouer.");
										compteurclictuile = 1;
										compteurjoueur = 0;
									} else {
										
										
										System.out.println("\nC'est au joueur "+ordrejoueurs[compteurjoueur][0].numjoueur+" (" + ordrejoueurs[compteurjoueur][0].getNomJoueur() + ", couleur "+ordrejoueurs[compteurjoueur][0].couleur+") de jouer.");

									}

								} else {
									System.out.println("Il faut piocher a nouveau 2");
									appelDefinitionNouvelOrdre();
									//pour la suite
									System.out.println("\nCliquez sur la case du terrain desiree, puis sur la tuile a placer.");
									System.out.println("\nC'est au joueur "+ordrejoueurs[0][0].numjoueur+" (" + ordrejoueurs[0][0].getNomJoueur() + ", couleur "+ordrejoueurs[0][0].couleur+") de jouer.");
									compteurclictuile = 1;
									compteurjoueur = 0;
								}
							} else if (compteurclictuile == 1) {

								if (compteurjoueur < nbrois) {
									setJoueurEnCours(ordrejoueurs[compteurjoueur][0]);
									System.out.println("Joueur en cours : "+ordrejoueurs[compteurjoueur][0].couleur);

									setChoixTuileTour(tuile1);
									
									System.out.println("\nLe joueur qui a clique est : "+ordrejoueurs[compteurjoueur][0].numjoueur);
								
									
									switch (ordrejoueurs[compteurjoueur][0].couleur) {
									case "RED":
										setPosX(PageJeu.EcranOuest.posx);
										setPosY(PageJeu.EcranOuest.posy);
										break;
									case "YELLOW":
										setPosX(PageJeu.EcranNord.posx);
										setPosY(PageJeu.EcranNord.posy);
										break;
									case "GREEN":
										setPosX(PageJeu.EcranEst.posx);
										setPosY(PageJeu.EcranEst.posy);
										break;
									case "BLUE":
										setPosX(PageJeu.EcranSud.posx);
										setPosY(PageJeu.EcranSud.posy);
										break;

									}
									
									
									
									Principal.tourJeu();
									
									
									

									if (bonchoix == true) {
										compteurjoueur += 1;

									} else if (bonchoix == false) {
										System.out.println("\nMauvais domino");
									}

									if (compteurjoueur >= nbrois) {
										System.out.println("Il faut piocher a nouveau");
										appelDefinitionNouvelOrdre();
									} else {

										System.out.println("\nC'est au joueur "+ordrejoueurs[0][0].numjoueur+" (" + ordrejoueurs[0][0].getNomJoueur() + ", couleur "+ordrejoueurs[0][0].couleur+") de jouer.");

									}

								}

							}

						}
					});
					// pour bouton tuile2 excatement la meme qu'au dessus
					jButton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Object source = e.getSource();

							if (compteurjoueur < nbrois) {
								setJoueurEnCours(ordrejoueurs[compteurjoueur][0]);

								
								  //setNumDomiTour(numdomituile1); setNumTuileTour(0);
								 

								setChoixTuileTour(tuile2);

								Principal.preselection();
								if (bonchoix == true) {
									compteurjoueur += 1;

								} else if (bonchoix == false) {
									System.out.println("\nMauvais Domino ! ");
								}

								if (compteurjoueur >= nbrois) {
									System.out.println("Il faut piocher a nouveau");
									appelDefinitionNouvelOrdre();

								} else {

									System.out.println("\nC'est a " + ordrejoueurs[compteurjoueur][0].getNomJoueur()
											+ " de jouer");

								}

							} else {
								System.out.println("Il faut piocher a nouveau 2");
								appelDefinitionNouvelOrdre();

							}

						}
					});
					 
	
*/

} 
