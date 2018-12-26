import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class FenetreAccueil extends PanelDeJeu {
	
	Jeu jeu1 = new Jeu();
	
	JRadioButton DeuxJoueurs = new JRadioButton("2 joueurs");
	JRadioButton TroisJoueurs = new JRadioButton("3 joueurs");
	JRadioButton QuatreJoueurs = new JRadioButton("4 joueurs");
	JToggleButton BoutonRegles = new JToggleButton("Règles du jeu");
	JButton btnJouer = new JButton("Jouer !");

	JLabel lblChoisissezLeNombre = new JLabel("Choisissez le nombre de joueurs");
	JLabel lblNombreDeJoueurs = new JLabel("Nombre de joueurs :" + jeu1.nbjoueurs);
	JLabel lblKingdomino = new JLabel("KingDomino");


	public FenetreAccueil() {

		//BorderLayout.CENTER
		this.setLayout(null);
		
		lblChoisissezLeNombre.setForeground(Color.WHITE);
		lblChoisissezLeNombre.setBounds(121, 98, 205, 16);
		this.add(lblChoisissezLeNombre);
		
		DeuxJoueurs.setForeground(Color.WHITE);
		DeuxJoueurs.setSelected(false);
		DeuxJoueurs.setRequestFocusEnabled(false);
		DeuxJoueurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DeuxJoueurs.setBounds(76, 126, 91, 23);
		this.add(DeuxJoueurs);
		
		TroisJoueurs.setForeground(Color.WHITE);
		TroisJoueurs.setSelected(false);
		TroisJoueurs.setRequestFocusEnabled(false);
		TroisJoueurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TroisJoueurs.setBounds(179, 126, 91, 23);
		this.add(TroisJoueurs);
		
		QuatreJoueurs.setForeground(Color.WHITE);
		QuatreJoueurs.setSelected(false);
		QuatreJoueurs.setRequestFocusEnabled(false);
		QuatreJoueurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
		QuatreJoueurs.setBounds(282, 126, 91, 23);
		this.add(QuatreJoueurs);
		
		lblKingdomino.setForeground(Color.WHITE);
		lblKingdomino.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblKingdomino.setBounds(179, 16, 114, 32);
		this.add(lblKingdomino);
		BoutonRegles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BoutonRegles.setBounds(312, 243, 132, 29);
		this.add(BoutonRegles);
		lblNombreDeJoueurs.setForeground(Color.WHITE);

		lblNombreDeJoueurs.setBounds(153, 191, 250, 16);
		this.add(lblNombreDeJoueurs);
		
		btnJouer.setBounds(50, 243, 117, 29);
		this.add(btnJouer);
		
		
		DeuxJoueurs.addActionListener(ActionChoixJoueurs);
		TroisJoueurs.addActionListener(ActionChoixJoueurs);
		QuatreJoueurs.addActionListener(ActionChoixJoueurs);
		BoutonRegles.addActionListener(ActionRegles);

	}
	
	public void Actionner() {
		
		if (DeuxJoueurs.isSelected()) {
			TroisJoueurs.setSelected(false);
			QuatreJoueurs.setSelected(false);
		}
		
		if (TroisJoueurs.isSelected()) {
			DeuxJoueurs.setSelected(false);
			QuatreJoueurs.setSelected(false);
		}
		
		if (QuatreJoueurs.isSelected()) {
			TroisJoueurs.setSelected(false);
			DeuxJoueurs.setSelected(false);
		}
	}
	
	public ActionListener ActionChoixJoueurs = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		   	Object source=e.getSource();
			lblNombreDeJoueurs.setText("Vous êtes " + ((JRadioButton) source).getText());
			DeuxJoueurs.setSelected(false);
			TroisJoueurs.setSelected(false);
			QuatreJoueurs.setSelected(false);
			((JRadioButton) source).setSelected(true);				
		}
	};
	
	public ActionListener ActionRegles = new ActionListener() {
	   	@Override
		public void actionPerformed(ActionEvent e) {
			//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   		JFrame FenetreRegles = new JFrame("Règles du jeu");
	   		FenetreRegles.setVisible(true);
	   		FenetreRegles.setSize(200, 200);
	   		JPanel pan = new JPanel();
	   		JLabel label = new JLabel("mdrrr");
	   		FenetreRegles.getContentPane().add(pan);
	   		pan.add(label);	 
			JTextPane wewe = new JTextPane();
			wewe.setText("\t\t\t\t\1. Quelle mamie fait peur aux voleurs ? + \n\t   \t\t\t\t\"Mamie Traillette \\\\n\\"
					+ "+ \n\t   \t\t\t\t\"2. J'ai une blague sur les magasins\\n\" + \n\t   \t\t\t\t\"Mais elle a pas supermarché\\n\" + \n\t   \t\t\t\t\"3. Pourquoi est-ce c'est difficile de conduire dans le Nord ?\\n\" + \n\t   \t\t\t\t\"Parce que les voitures arrêtent PAS DE CALER\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"4. Comment est-ce que la chouette sait que son mari fait la gueule ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce qu’HIBOUDE\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"5. Pourquoi est-ce qu'on dit que les bretons sont tous frères et sœurs ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce qu’ils n’ont Quimper\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"6. Pourquoi est-ce qu'on met tous les crocos en prison ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce que les crocos dealent.\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"7. Comment fait-on pour allumer un barbecue breton ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"On utilise des breizh\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"8. Pourquoi dit-on que les poissons travaillent illégalement ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce qu’ils n’ont pas de FISH de paie.\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"9. Quel est le bar préféré des espagnols ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Le Bar-celone\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"10. Pourquoi est-ce que les mexicains mangent-ils aux toilettes ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce qu’ils aiment manger épicé\"");
			wewe.setBounds(429, 30, -376, 224);
			pan.add(wewe);
	   }
	};
}

