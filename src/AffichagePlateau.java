import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class AffichagePlateau extends Carre {
	
	JPanel PlanCentral = new JPanel();
	JLabel Nom = new JLabel();
	BorderLayout Lay = new BorderLayout(0, 0);
	ImageIcon Bulle = new ImageIcon("//Users/lebens/Desktop/Dominations/images/bulle.jpg");
	JButton C = new JButton(Bulle);
	GridLayout Layout = new GridLayout(9, 9, 0, 0);
	List<JButton> ListeBoutons = new ArrayList<JButton>();
	String[] MaListe = {"Mon Zero", "Mon premier", "Mon second", "Mon troisième", "Mon quatrième", "Mon cinquième", "Mon sixième", "Mon septième", "Mon huitième", "Mon neuvième"};
	public  AffichagePlateau(String nom, Color couleur){
		
		this.setBackground(couleur);
		this.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 1, true), new LineBorder(couleur, 4, true)));

		this.setLayout(Lay);
		
			Nom.setBackground(couleur);
			Nom.setHorizontalAlignment(SwingConstants.CENTER);		
			Nom.setText(nom);
			Nom.setFont(new Font("Hiragino Sans GB", Font.BOLD | Font.ITALIC, 18));								
			Nom.setForeground(new Color(102, 102, 102));
		this.add(Nom, BorderLayout.NORTH);

		

		this.add(PlanCentral, BorderLayout.CENTER);
			PlanCentral.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
			PlanCentral.setBackground(couleur);
			PlanCentral.setLayout(Layout);
	        for (int i = 0; i < 9 * 9; i++) {
	            int ligne = i / 9;
	            int colonne = i % 9;
	            JButton gb = CreerBoutonOrganise(ligne, colonne);
	            ListeBoutons.add(gb);
	            PlanCentral.add(gb);
	        }		
	}
	
    private JButton getBoutton(int x, int y) {
        int index = x * 9 + y;
        return ListeBoutons.get(index);
    }
	
	
	public JButton CreerBoutonOrganise(int x, int y) {
	     final BoutonsPlateau b = new BoutonsPlateau("[" + x + "][" + y + "]","//Users/lebens/Desktop/Dominations/images/A.jpg" ,"//Users/lebens/Desktop/Dominations/images/montagne.jpg");
	     b.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                //JButton gb = getBoutton(x, y);
	                System.out.println("[" + x + "][" + y + "]"
	                    + " enclenché sur le terrain " + ((JButton) e.getSource()).getParent());
	                ((JButton) e.getSource()).setText("Cliqué !");
	                ((JButton) e.getSource()).setIcon(Bulle);
	            }
	        });
	        return b;
	    }
	
	/**
	public void paintComponent(Graphics g){
		try {
	        Image img = ImageIO.read(new File ("//Users/lebens/Desktop/Dominations/images/Wallpaper.jpg"));
	        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*/	
        
}

class Carre extends JPanel {

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        Container c = getParent();
        if (c != null) {
            d = c.getSize();
        } else {
            return new Dimension(10, 10);
        }
        int w = (int) d.getWidth();
        int h = (int) d.getHeight();
        int s = (w < h ? w : h);
        return new Dimension(s, s);
    }
}

class BoutonsPlateau extends JButton {
	AffichagePanelDeJeu4 a = new AffichagePanelDeJeu4();
	public BoutonsPlateau(String Titre, String img, String imgflottante) {
		super(Titre);
		//this.add(a);
		setForeground(Color.WHITE);
        
        setOpaque(false);
        setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
        setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
        setFocusPainted(false); // On n'affiche pas l'effet de focus.
         
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
          
        setIcon(new ImageIcon(img));
        setRolloverIcon(new ImageIcon(imgflottante));
        //Rajouter la main survolante
	}

}
