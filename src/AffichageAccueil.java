import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class AffichageAccueil extends JPanel {
	
	String V ;
	String B ;
	String R ;
	String J ;
	
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
	
	GridBagLayout Layout = new GridBagLayout();
	
	GridBagConstraints gbc_textField = new GridBagConstraints();
	GridBagConstraints gbc_textField_1 = new GridBagConstraints();
	GridBagConstraints gbc_textField_2 = new GridBagConstraints();
	GridBagConstraints gbc_textField_3 = new GridBagConstraints();


	public AffichageAccueil() {

		this.setLayout(Layout);
		this.setFocusable(true);
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
		gbc_lblNombreDeJoueurs.gridy = 4;
		this.add(lblNombreDeJoueurs, gbc_lblNombreDeJoueurs);
		DeuxJoueurs.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		DeuxJoueurs.setForeground(Color.WHITE);
		DeuxJoueurs.setSelected(false);
		DeuxJoueurs.setRequestFocusEnabled(false);
		DeuxJoueurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DeuxJoueurs.setBounds(76, 126, 91, 23);
		GridBagConstraints gbc_DeuxJoueurs = new GridBagConstraints();
		gbc_DeuxJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_DeuxJoueurs.gridx = 1;
		gbc_DeuxJoueurs.gridy = 6;
		this.add(DeuxJoueurs, gbc_DeuxJoueurs);
		TroisJoueurs.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		
		TroisJoueurs.setForeground(Color.WHITE);
		TroisJoueurs.setSelected(false);
		TroisJoueurs.setRequestFocusEnabled(false);
		TroisJoueurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TroisJoueurs.setBounds(179, 126, 91, 23);
		GridBagConstraints gbc_TroisJoueurs = new GridBagConstraints();
		gbc_TroisJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_TroisJoueurs.gridx = 1;
		gbc_TroisJoueurs.gridy = 7;
		this.add(TroisJoueurs, gbc_TroisJoueurs);
		QuatreJoueurs.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		QuatreJoueurs.setForeground(Color.WHITE);
		QuatreJoueurs.setSelected(false);
		QuatreJoueurs.setRequestFocusEnabled(false);
		QuatreJoueurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
		QuatreJoueurs.setBounds(282, 126, 91, 23);
		GridBagConstraints gbc_QuatreJoueurs = new GridBagConstraints();
		gbc_QuatreJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_QuatreJoueurs.gridx = 1;
		gbc_QuatreJoueurs.gridy = 8;
		this.add(QuatreJoueurs, gbc_QuatreJoueurs);
		
		BoutonRegles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BoutonRegles.setBounds(312, 243, 132, 29);
		GridBagConstraints gbc_BoutonRegles = new GridBagConstraints();
		gbc_BoutonRegles.insets = new Insets(0, 0, 0, 5);
		gbc_BoutonRegles.gridx = 1;
		gbc_BoutonRegles.gridy = 10;
		this.add(BoutonRegles, gbc_BoutonRegles);
		BoutonRegles.addActionListener(ActionRegles);
		
		btnJouer.setBounds(50, 243, 117, 29);
		GridBagConstraints gbc_btnJouer = new GridBagConstraints();
		gbc_btnJouer.gridx = 3;
		gbc_btnJouer.gridy = 10;
		this.add(btnJouer, gbc_btnJouer);
		
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 6;
		ChampJ1.setHorizontalAlignment(SwingConstants.CENTER);
		ChampJ1.setText("Joueur 1");
		ChampJ1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		ChampJ1.setBackground(SystemColor.inactiveCaptionText);
		ChampJ1.setForeground(Color.WHITE);
		add(ChampJ1, gbc_textField);
		ChampJ1.setColumns(10);

		
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 8;
		ChampJ2.setHorizontalAlignment(SwingConstants.CENTER);
		ChampJ2.setText("Joueur 2");
		ChampJ2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		ChampJ2.setBackground(SystemColor.inactiveCaptionText);
		ChampJ2.setForeground(Color.WHITE);
		add(ChampJ2, gbc_textField_1);
		ChampJ2.setColumns(10);


		
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 6;
		ChampJ3.setHorizontalAlignment(SwingConstants.CENTER);
		ChampJ3.setText("Joueur 3");
		ChampJ3.setFont(new Font("Tahoma", Font.ITALIC, 16));
		ChampJ3.setBackground(SystemColor.inactiveCaptionText);
		ChampJ3.setForeground(Color.WHITE);
		add(ChampJ3, gbc_textField_2);
		
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 8;
		ChampJ4.setHorizontalAlignment(SwingConstants.CENTER);
		ChampJ4.setText("Joueur 4");
		ChampJ4.setFont(new Font("Tahoma", Font.ITALIC, 16));
		ChampJ4.setBackground(SystemColor.inactiveCaptionText);
		ChampJ4.setForeground(Color.WHITE);
		add(ChampJ4, gbc_textField_3);

		
		ChampJ1.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(ChampJ1.getText().equals("Joueur 1")) {
					ChampJ1.setText("");
				}
				ChampJ1.setBackground(Color.WHITE);
				ChampJ1.setForeground(UIManager.getColor(new Color(102,102,102)));
			}
			public void focusLost(FocusEvent e) {
				if(ChampJ1.getText().equals("")) {
					ChampJ1.setText("Joueur 1");
				}
				ChampJ1.setBackground(new Color(102,102,102));
				ChampJ1.setForeground(UIManager.getColor("DesktopIcon.borderRimColor"));
			}
		});
		
		ChampJ2.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(ChampJ2.getText().equals("Joueur 2")) {
					ChampJ2.setText("");
				}
				ChampJ2.setBackground(Color.WHITE);
				ChampJ2.setForeground(UIManager.getColor(new Color(102,102,102)));
			}
			public void focusLost(FocusEvent e) {
				if(ChampJ2.getText().equals("")) {
					ChampJ2.setText("Joueur 2");
				}
				ChampJ2.setBackground(new Color(102,102,102));
				ChampJ2.setForeground(UIManager.getColor("DesktopIcon.borderRimColor"));
			}
		});
		
		ChampJ3.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(ChampJ3.getText().equals("Joueur 3")) {
					ChampJ3.setText("");
				}
				ChampJ3.setBackground(Color.WHITE);
				ChampJ3.setForeground(UIManager.getColor(new Color(102,102,102)));
			}
			public void focusLost(FocusEvent e) {
				if(ChampJ3.getText().equals("")) {
					ChampJ3.setText("Joueur 3");
				}
				ChampJ3.setBackground(new Color(102,102,102));
				ChampJ3.setForeground(UIManager.getColor("DesktopIcon.borderRimColor"));
			}
		});
		
		ChampJ4.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(ChampJ4.getText().equals("Joueur 4")) {
					ChampJ4.setText("");
				}
				ChampJ4.setBackground(Color.WHITE);
				ChampJ4.setForeground(UIManager.getColor(new Color(102,102,102)));
			}
			public void focusLost(FocusEvent e) {
				if(ChampJ4.getText().equals("")) {
					ChampJ4.setText("Joueur 4");
				}
				ChampJ4.setBackground(new Color(102,102,102));
				ChampJ4.setForeground(UIManager.getColor("DesktopIcon.borderRimColor"));
			}
		});


		ChampJ1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				ChampJ1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
				ChampJ2.grabFocus();
				String input = ChampJ1.getText();
				R=input; //Ouest
				System.out.println(input);

			}
		});
		
		ChampJ2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				ChampJ2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
				ChampJ3.grabFocus();
				String input = ChampJ2.getText();
				B=input; //Nord
				System.out.println(input);

			}
		});
		
		ChampJ3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				ChampJ3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
				ChampJ4.grabFocus();
				String input = ChampJ3.getText();
				J=input; //Est
				System.out.println(input);
				

			}
		});
		
		ChampJ4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				ChampJ4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
				String input = ChampJ4.getText();
				System.out.println(input);
				V=input; //Sud
			}
		});

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
			wewe.setText(" \\n\\t   \\t\\t\\t\\t\\1. Quelle mamie fait peur aux voleurs ? + \n\t   \t\t\t\t\"Mamie Traillette \\\\n\\"
					+ "+ \n\t   \t\t\t\t\"2. J'ai une blague sur les magasins\\n\" + \n\t   \t\t\t\t\"Mais elle a pas supermarché\\n\" + \n\t   \t\t\t\t\"3. Pourquoi est-ce c'est difficile de conduire dans le Nord ?\\n\" + \n\t   \t\t\t\t\"Parce que les voitures arrêtent PAS DE CALER\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"4. Comment est-ce que la chouette sait que son mari fait la gueule ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce qu’HIBOUDE\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"5. Pourquoi est-ce qu'on dit que les bretons sont tous frères et sœurs ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce qu’ils n’ont Quimper\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"6. Pourquoi est-ce qu'on met tous les crocos en prison ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce que les crocos dealent.\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"7. Comment fait-on pour allumer un barbecue breton ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"On utilise des breizh\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"8. Pourquoi dit-on que les poissons travaillent illégalement ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce qu’ils n’ont pas de FISH de paie.\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"9. Quel est le bar préféré des espagnols ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Le Bar-celone\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"10. Pourquoi est-ce que les mexicains mangent-ils aux toilettes ?\\n\" + \n\t   \t\t\t\t\"\\n\" + \n\t   \t\t\t\t\"Parce qu’ils aiment manger épicé\"");
			wewe.setBounds(429, 30, -376, 224);
			pan.add(wewe);
	   }
	};
	

	
	public void paintComponent(Graphics g){

		try {
	        Image img = ImageIO.read(this.getClass().getResource("/Cube.jpg"));
	        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

