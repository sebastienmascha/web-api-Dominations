import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
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
	ImageIcon IMG = new ImageIcon("//Users/lebens/Desktop/Dominations/images/mer1.png");
	//JButton C = new JButton(Bulle);
	JButton C = new JButton();
	GridLayout Layout = new GridLayout(9, 9, 0, 4);
	List<JButton> ListeBoutons = new ArrayList<JButton>();

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
	        for (int i = 0; i < 40; i++) {
	            int ligne = i / 9;
	            int colonne = i % 9;
	            JButton gb = CreerBoutonOrganise(ligne, colonne);
	            ListeBoutons.add(gb);
	            PlanCentral.add(gb);
	        }	
	        
	        JButton BtnChateau = new JButton();
            BtnChateau.setIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/chateau.png"));
            BtnChateau.setRolloverIcon(new ImageIcon("//Users/lebens/Desktop/Dominations/images/champs.png"));

	        ListeBoutons.add(BtnChateau);
	        PlanCentral.add(BtnChateau);
	        
	        for (int i = 41; i < 81; i++) {
	            int ligne = i / 9;
	            int colonne = i % 9;
	            JButton gb = CreerBoutonOrganise(ligne, colonne);
	            ListeBoutons.add(gb);
	            PlanCentral.add(gb);
	        }
	}
	
    public JButton getBoutton(int x, int y) {
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
	                Image newimg = IMG.getImage().getScaledInstance( ((JButton)e.getSource()).getWidth(), ((JButton)e.getSource()).getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;
	                ((JButton) e.getSource()).setIcon(new ImageIcon(newimg));
	            }
	        });
	        return b;
	    }
        
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
