import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class test extends JPanel {
	
	
	JTextField ChampJ1 = new JTextField();
	JTextField ChampJ2 = new JTextField();
	JTextField ChampJ3 = new JTextField();
	JTextField ChampJ4 = new JTextField();

	JRadioButton DeuxJoueurs = new JRadioButton("2 joueurs");
	JRadioButton TroisJoueurs = new JRadioButton("3 joueurs");
	JRadioButton QuatreJoueurs = new JRadioButton("4 joueurs");
	
	JToggleButton BoutonRegles = new JToggleButton("Regles du jeu");
	JButton btnJouer = new JButton("Jouer !");
	JLabel lblNombreDeJoueurs = new JLabel();
	JLabel lblKingdomino = new JLabel("KingDomino");
	
	GridLayout Layout = new GridLayout();
	
	GridBagConstraints gbc_textField = new GridBagConstraints();
	GridBagConstraints gbc_textField_1 = new GridBagConstraints();
	GridBagConstraints gbc_textField_2 = new GridBagConstraints();
	GridBagConstraints gbc_textField_3 = new GridBagConstraints();


	public test() {
		Layout.setColumns(7);
		Layout.setRows(7);

		//BorderLayout.CENTER
		this.setLayout(Layout);
		
		lblKingdomino.setForeground(Color.WHITE);
		lblKingdomino.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblKingdomino.setBounds(179, 16, 114, 32);
		GridBagConstraints gbc_lblKingdomino = new GridBagConstraints();
		gbc_lblKingdomino.insets = new Insets(0, 0, 5, 5);
		gbc_lblKingdomino.gridx = 2;
		gbc_lblKingdomino.gridy = 0;
		this.add(lblKingdomino, gbc_lblKingdomino);
		
		lblNombreDeJoueurs.setForeground(Color.WHITE);
		lblNombreDeJoueurs.setBounds(153, 191, 250, 16);
		GridBagConstraints gbc_lblNombreDeJoueurs = new GridBagConstraints();
		gbc_lblNombreDeJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeJoueurs.gridx = 2;
		gbc_lblNombreDeJoueurs.gridy = 3;
		this.add(lblNombreDeJoueurs, gbc_lblNombreDeJoueurs);
		
		DeuxJoueurs.setForeground(Color.WHITE);
		DeuxJoueurs.setSelected(false);
		DeuxJoueurs.setRequestFocusEnabled(false);
		DeuxJoueurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DeuxJoueurs.setBounds(76, 126, 91, 23);
		GridBagConstraints gbc_DeuxJoueurs = new GridBagConstraints();
		gbc_DeuxJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_DeuxJoueurs.gridx = 2;
		gbc_DeuxJoueurs.gridy = 5;
		this.add(DeuxJoueurs, gbc_DeuxJoueurs);
		
		
		TroisJoueurs.setForeground(Color.WHITE);
		TroisJoueurs.setSelected(false);
		TroisJoueurs.setRequestFocusEnabled(false);
		TroisJoueurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TroisJoueurs.setBounds(179, 126, 91, 23);
		GridBagConstraints gbc_TroisJoueurs = new GridBagConstraints();
		gbc_TroisJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_TroisJoueurs.gridx = 2;
		gbc_TroisJoueurs.gridy = 6;
		this.add(TroisJoueurs, gbc_TroisJoueurs);
		
		QuatreJoueurs.setForeground(Color.WHITE);
		QuatreJoueurs.setSelected(false);
		QuatreJoueurs.setRequestFocusEnabled(false);
		QuatreJoueurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
		QuatreJoueurs.setBounds(282, 126, 91, 23);
		GridBagConstraints gbc_QuatreJoueurs = new GridBagConstraints();
		gbc_QuatreJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_QuatreJoueurs.gridx = 2;
		gbc_QuatreJoueurs.gridy = 7;
		this.add(QuatreJoueurs, gbc_QuatreJoueurs);
		
		BoutonRegles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BoutonRegles.setBounds(312, 243, 132, 29);
		GridBagConstraints gbc_BoutonRegles = new GridBagConstraints();
		gbc_BoutonRegles.insets = new Insets(0, 0, 0, 5);
		gbc_BoutonRegles.gridx = 1;
		gbc_BoutonRegles.gridy = 9;
		this.add(BoutonRegles, gbc_BoutonRegles);
		BoutonRegles.addActionListener(ActionRegles);
		
		btnJouer.setBounds(50, 243, 117, 29);
		GridBagConstraints gbc_btnJouer = new GridBagConstraints();
		gbc_btnJouer.gridx = 3;
		gbc_btnJouer.gridy = 9;
		this.add(btnJouer, gbc_btnJouer);
		
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 5;
		add(ChampJ1, gbc_textField);
		ChampJ1.setColumns(10);

		
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 7;
		add(ChampJ2, gbc_textField_1);
		ChampJ2.setColumns(10);

		
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 5;
		add(ChampJ3, gbc_textField_2);
		
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 7;
		add(ChampJ4, gbc_textField_3);
		



	}
	
	
	public ActionListener ActionRegles = new ActionListener() {
	   	@Override
		public void actionPerformed(ActionEvent e) {
			//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   		JFrame FenetreRegles = new JFrame("Regles du jeu");
	   		FenetreRegles.setVisible(true);
	   		FenetreRegles.setSize(400, 400);
	   		
	   		JPanel pan = new JPanel();
	   		JLabel label = new JLabel("mdrrr");
	   		FenetreRegles.getContentPane().add(pan);
	   		pan.add(label);	 
			JTextPane wewe = new JTextPane();
			wewe.setText("\t\t\t\t SEB LE CHAT & TRISTAN EDOU DANS LA PLACE + \\n\\t   \\t\\t\\t\\t\\1. Quelle mamie fait peur aux voleurs ? + \n\t   \t\t\t\t\"Mamie Traillette \\\\n\\"
					+ "+ \n\t   \t\t\t\t\"2. J'ai une blague sur les magasins\\n\" + \n\t   \t\t\t\t\"Mais elle a pas supermarché\\n\" + \n\t   \t\t\t\t\"3. Pourquoi est-ce c'est difficile de conduire dans le Nord ?\\n\" + \n\t   \t\t\t\t\"Parce que les voitures arrêtent PAS DE CALER\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"4. Comment est-ce que la chouette sait que son mari fait la gueule ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce qu’HIBOUDE\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"5. Pourquoi est-ce qu'on dit que les bretons sont tous frères et sœurs ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce qu’ils n’ont Quimper\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"6. Pourquoi est-ce qu'on met tous les crocos en prison ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce que les crocos dealent.\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"7. Comment fait-on pour allumer un barbecue breton ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"On utilise des breizh\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"8. Pourquoi dit-on que les poissons travaillent illégalement ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce qu’ils n’ont pas de FISH de paie.\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"9. Quel est le bar préféré des espagnols ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Le Bar-celone\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"10. Pourquoi est-ce que les mexicains mangent-ils aux toilettes ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce qu’ils aiment manger épicé\"");
			wewe.setBounds(429, 30, -376, 224);
			pan.add(wewe);
	   }
	};
	

	
	public void paintComponent(Graphics g){

		try {
	        Image img = ImageIO.read(this.getClass().getResource("/Mine0.jpg"));
	        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

