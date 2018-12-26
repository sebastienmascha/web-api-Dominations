import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class ExecutionAffichage {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExecutionAffichage window = new ExecutionAffichage();
					window.FenetreJeu.setVisible(true);
		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//On définit notre application
	JFrame FenetreJeu = new JFrame("Projet Kingdomino" );
	
	//On définit les différentes pages de notre application
	FenetreJeu PageJeu = new FenetreJeu();
	FenetreAccueil PageAccueil = new FenetreAccueil();
	JLayeredPane layeredPane = new JLayeredPane();
	JPanel pane = new JPanel();
	CardLayout PlusieursPages = new CardLayout(0, 0);

	String[] listeIndice = {"Accueil", "Principal"};
	//int indice = 0;

	public ExecutionAffichage() {
		Initialisation();
	}

	private void Initialisation() {
		FenetreJeu.setBounds(100, 100, 450, 300);
		FenetreJeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//FenetreJeu.getContentPane().add(layeredPane);
		FenetreJeu.getContentPane().setLayout(PlusieursPages);
		
		//PageAccueil.setBounds(0, 0, 450, 300);
		//layeredPane.add(PageAccueil);
		//PageJeu.setBounds(0, 0, FenetreJeu.getWidth(), FenetreJeu.getHeight());
		//layeredPane.add(PageJeu);
		FenetreJeu.getContentPane().add(PageAccueil,listeIndice[0]);
		FenetreJeu.getContentPane().add(PageJeu,listeIndice[1]);
		
		PageAccueil.btnJouer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlusieursPages.show(FenetreJeu.getContentPane(), listeIndice[1]);
			}
		});
		
		PageJeu.btnRetournerAuMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlusieursPages.show(FenetreJeu.getContentPane(), listeIndice[0]);
			}
		});

	}
	
	public ActionListener ChangerDePage = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layeredPane.removeAll();
			layeredPane.add(((JPanel) e.getSource()).getParent());
			layeredPane.repaint();
			layeredPane.revalidate();
		}
	};
	/**
	public ActionListener ChangerPage = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
	        if(++indice > 2)
	            indice = 0;
			PlusieursPages.show(FenetreJeu, listContent[indice]);
		}
	};*/
}
