import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
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
	
	public int posx; 
	public int posy; 
	Tuile terrain[][]= new Tuile[9][9];
	
	JPanel PlanCentral = new JPanel();
	JLabel Nom = new JLabel();
	BorderLayout Lay = new BorderLayout(0, 0);
	ImageIcon IMG = new ImageIcon(this.getClass().getResource("/mer1.png"));
	//JButton C = new JButton(Bulle);
	JButton C = new JButton();
	GridLayout Layout = new GridLayout(9, 9, 0, 0);
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
            BtnChateau.setIcon(new ImageIcon(this.getClass().getResource("/chateau.png")));
            BtnChateau.setRolloverIcon(new ImageIcon(this.getClass().getResource("/Champs2.png")));

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
    
    public void lireTerrain(Tuile[][] terrain) {
    	for (int i = 0; i <= terrain.length - 1; i++) {
    		for (int j = 0; j <= terrain.length - 1; j++) {
    			if (terrain[i][j]==null) {
    				//if vide alors rien afficher sinon utiliser fonction changerboutton
    			}
    			else {
    				changeBoutton(i,j,terrain[i][j].gettype(),terrain[i][j].getnbcouronne());
    			}
    			
    		}
    		
    		
    	}
    	
    }
    
    public void setTerrain(Tuile[][] terrain) {
    	this.terrain=terrain;
    }
    
    public void changeBoutton(int x , int y, String type,int nbcour) {
    	getBoutton(x,y).setIcon(new ImageIcon(this.getClass().getResource("/"+type+nbcour+".png")));
    }
	
	
	public JButton CreerBoutonOrganise(int x, int y) {
	     final BoutonsPlateau b = new BoutonsPlateau("[" + x + "][" + y + "]",this.getClass().getResource("/A.jpg"), this.getClass().getResource("/Mine1.png"));
	     b.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                //JButton gb = getBoutton(x, y);
	                System.out.println("[" + x + "][" + y + "]"
	                    + " enclenché sur le terrain " + ((JButton) e.getSource()).getParent());
	                ((JButton) e.getSource()).setText("Cliqué !");
	                Image newimg = IMG.getImage().getScaledInstance( ((JButton)e.getSource()).getWidth(), ((JButton)e.getSource()).getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;
	                ((JButton) e.getSource()).setIcon(new ImageIcon(newimg));
	                posx=x;
	                posy=y;
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
	public BoutonsPlateau(String Titre, URL img, URL imgflottante) {
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
