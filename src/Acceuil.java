import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JToggleButton;

public class Acceuil {
	
	Jeu jeu1 = new Jeu();

	private JFrame frame;
	private final JToggleButton BoutonSortie = new JToggleButton("Quitter");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil window = new Acceuil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Acceuil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblChoisissezLeNombre = new JLabel("Choisissez le nombre de joueurs");
		lblChoisissezLeNombre.setBounds(121, 98, 205, 16);
		panel.add(lblChoisissezLeNombre);
		
		JRadioButton DeuxJoueurs = new JRadioButton("2 joueurs");
		DeuxJoueurs.setBounds(76, 126, 91, 23);
		panel.add(DeuxJoueurs);

		
		JRadioButton TroisJoueurs = new JRadioButton("3 joueurs");
		TroisJoueurs.setSelected(true);
		TroisJoueurs.setBounds(179, 126, 91, 23);
		panel.add(TroisJoueurs);

		
		JRadioButton QuatreJoueurs = new JRadioButton("4 joueurs");
		QuatreJoueurs.setSelected(true);
		QuatreJoueurs.setBounds(282, 126, 91, 23);
		panel.add(QuatreJoueurs);

		
		JLabel lblKingdomino = new JLabel("KingDomino");
		lblKingdomino.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblKingdomino.setBounds(179, 16, 114, 32);
		panel.add(lblKingdomino);
		BoutonSortie.setBounds(312, 243, 132, 29);
		panel.add(BoutonSortie);

		
		if (DeuxJoueurs.isSelected()) {
			jeu1.nbjoueurs=2;
		}
		else if (TroisJoueurs.isSelected()) {
			jeu1.nbjoueurs=3;
		}
		else if (QuatreJoueurs.isSelected()) {
			jeu1.nbjoueurs=4;
		}
		else {jeu1.nbjoueurs=0;}
		JLabel lblNombreDeJoueurs = new JLabel("Nombre de joueurs :" + jeu1.nbjoueurs);
		lblNombreDeJoueurs.setBounds(153, 191, 164, 16);
		panel.add(lblNombreDeJoueurs);
	}
}