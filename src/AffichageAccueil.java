import java.awt.BorderLayout;
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
	
	String R ;
	String J ;
	String V ;
	String B ;
	
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
		Layout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, -71, 0, 0, 0, 0, 0, 0, 0};
		Layout.columnWidths = new int[]{0, 0, 0, 0, 119, 74, 77, 113};

		this.setLayout(Layout);
		this.setFocusable(true);
		lblKingdomino.setForeground(Color.WHITE);
		lblKingdomino.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblKingdomino.setBounds(179, 16, 114, 32);
		GridBagConstraints gbc_lblKingdomino = new GridBagConstraints();
		gbc_lblKingdomino.insets = new Insets(0, 0, 5, 5);
		gbc_lblKingdomino.gridx = 4;
		gbc_lblKingdomino.gridy = 0;
		this.add(lblKingdomino, gbc_lblKingdomino);
		

		
		lblNombreDeJoueurs.setForeground(Color.WHITE);
		lblNombreDeJoueurs.setBounds(153, 191, 250, 16);
		GridBagConstraints gbc_lblNombreDeJoueurs = new GridBagConstraints();
		gbc_lblNombreDeJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeJoueurs.gridx = 2;
		gbc_lblNombreDeJoueurs.gridy = 9;
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
		gbc_DeuxJoueurs.gridy = 10;
		this.add(DeuxJoueurs, gbc_DeuxJoueurs);
		TroisJoueurs.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		
		TroisJoueurs.setForeground(Color.WHITE);
		TroisJoueurs.setSelected(false);
		TroisJoueurs.setRequestFocusEnabled(false);
		TroisJoueurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TroisJoueurs.setBounds(179, 126, 91, 23);
		GridBagConstraints gbc_TroisJoueurs = new GridBagConstraints();
		gbc_TroisJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_TroisJoueurs.gridx = 2;
		gbc_TroisJoueurs.gridy = 10;
		this.add(TroisJoueurs, gbc_TroisJoueurs);
		QuatreJoueurs.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		QuatreJoueurs.setForeground(Color.WHITE);
		QuatreJoueurs.setSelected(false);
		QuatreJoueurs.setRequestFocusEnabled(false);
		QuatreJoueurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
		QuatreJoueurs.setBounds(282, 126, 91, 23);
		GridBagConstraints gbc_QuatreJoueurs = new GridBagConstraints();
		gbc_QuatreJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_QuatreJoueurs.gridx = 3;
		gbc_QuatreJoueurs.gridy = 10;
		this.add(QuatreJoueurs, gbc_QuatreJoueurs);
				
				btnJouer.setBounds(50, 243, 117, 29);
				GridBagConstraints gbc_btnJouer = new GridBagConstraints();
				gbc_btnJouer.insets = new Insets(0, 0, 5, 5);
				gbc_btnJouer.gridx = 2;
				gbc_btnJouer.gridy = 11;
				this.add(btnJouer, gbc_btnJouer);
		
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 13;
		ChampJ1.setHorizontalAlignment(SwingConstants.CENTER);
		ChampJ1.setText("Joueur 1");
		ChampJ1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		ChampJ1.setBackground(SystemColor.inactiveCaptionText);
		ChampJ1.setForeground(Color.WHITE);
		add(ChampJ1, gbc_textField);
		ChampJ1.setColumns(10);
		
				
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
				
				
						ChampJ1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent f) {
								ChampJ1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
								ChampJ2.grabFocus();
								String input = ChampJ1.getText();
								R=input; //Ouest
								System.out.println(input);
				
							}
						});
		
				
				gbc_textField_1.insets = new Insets(0, 0, 5, 0);
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.gridx = 7;
				gbc_textField_1.gridy = 13;
				ChampJ2.setHorizontalAlignment(SwingConstants.CENTER);
				ChampJ2.setText("Joueur 2");
				ChampJ2.setFont(new Font("Tahoma", Font.ITALIC, 16));
				ChampJ2.setBackground(SystemColor.inactiveCaptionText);
				ChampJ2.setForeground(Color.WHITE);
				add(ChampJ2, gbc_textField_1);
				ChampJ2.setColumns(10);
				
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
				
				ChampJ2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent f) {
						ChampJ2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
						ChampJ3.grabFocus();
						String input = ChampJ2.getText();
						J=input; //Nord
						System.out.println(input);

					}
				});
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		
		
				
				gbc_textField_2.insets = new Insets(0, 0, 5, 5);
				gbc_textField_2.gridx = 6;
				gbc_textField_2.gridy = 14;
				ChampJ3.setHorizontalAlignment(SwingConstants.CENTER);
				ChampJ3.setText("Joueur 3");
				ChampJ3.setFont(new Font("Tahoma", Font.ITALIC, 16));
				ChampJ3.setBackground(SystemColor.inactiveCaptionText);
				ChampJ3.setForeground(Color.WHITE);
				add(ChampJ3, gbc_textField_2);
				
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
				
				ChampJ3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent f) {
						ChampJ3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
						ChampJ4.grabFocus();
						String input = ChampJ3.getText();
						V=input; //Est
						System.out.println(input);
			

					}
				});
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 7;
		gbc_textField_3.gridy = 14;
		ChampJ4.setHorizontalAlignment(SwingConstants.CENTER);
		ChampJ4.setText("Joueur 4");
		ChampJ4.setFont(new Font("Tahoma", Font.ITALIC, 16));
		ChampJ4.setBackground(SystemColor.inactiveCaptionText);
		ChampJ4.setForeground(Color.WHITE);
		add(ChampJ4, gbc_textField_3);
		
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
		
		ChampJ2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				ChampJ2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
				ChampJ3.grabFocus();
				String input = ChampJ2.getText();
				J=input; //Nord
				System.out.println(input);

			}
		});
		
		ChampJ3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				ChampJ3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
				ChampJ4.grabFocus();
				String input = ChampJ3.getText();
				V=input; //Est
				System.out.println(input);
				

			}
		});
		
		ChampJ4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				ChampJ4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
				String input = ChampJ4.getText();
				System.out.println(input);
				B=input; //Sud
			}
		});
		
		BoutonRegles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BoutonRegles.setBounds(312, 243, 132, 29);
		GridBagConstraints gbc_BoutonRegles = new GridBagConstraints();
		gbc_BoutonRegles.insets = new Insets(0, 0, 5, 5);
		gbc_BoutonRegles.gridx = 0;
		gbc_BoutonRegles.gridy = 15;
		this.add(BoutonRegles, gbc_BoutonRegles);
		BoutonRegles.addActionListener(ActionRegles);

	}
	
	
	public ActionListener ActionRegles = new ActionListener() {
	   	@Override
		public void actionPerformed(ActionEvent e) {
			//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   		JFrame FenetreRegles = new JFrame("Regles du jeu");
	   		FenetreRegles.setVisible(true);
	   		FenetreRegles.setSize(400, 400);
	   		
	   		JPanel pan = new JPanel();
	   		JLabel label = new JLabel("Règles du jeu");
	   		FenetreRegles.add(label,BorderLayout.NORTH);
	   		FenetreRegles.getContentPane().add(pan, BorderLayout.CENTER);
	   		pan.add(label);	 
			JTextPane wewe = new JTextPane();
			wewe.setText("À son tour de jeu, un joueur doit choisir parmi les dominos disponibles pour ce tour en plaçant son pion de roi sur la tuile qu’il veut recruter. Par la suite on sort des nouvelles tuiles et on répète le processus mais lorsqu’on enlève notre pion roi d’un domino on doit le placer dans notre royaume en respectant les règles de placement. On doit toujours agencer au moins un des paysages du domino lors du placement, et les quatre côtés de notre château sont considérés comme des jokers."+"Certaines cases des dominos ont des symboles de couronnes qui nous permettront de marquer des points en fin de partie pour nos différents domaines pour chaque sorte de territoires du jeu. Notre royaume ne peut pas dépasser un carré de 5X5 cases alors il faut positionner nos tuiles de façon intelligente et toujours en prévision de la prochaine tuile que nous avons choisie. On peut aussi ajouter des variantes pour marquer des points bonus si notre château termine au centre de notre royaume ou si nous réussissons à construire un royaume sans aucun trou"+"Kingdomino est un jeu très simple et accessible à tous les niveaux de joueurs. Il est le jeu parfait pour introduire des nouveaux joueurs ou pour initier vos enfants aux jeux de société. C’est un jeu qui mérite une place dans la collection de n’importe quel joueur.\n" + 
					"\n");
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

