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
	
    JButton BtnChateau = new JButton();
	JPanel PlanCentral = new JPanel();
	JLabel Nom = new JLabel();
	BorderLayout Lay = new BorderLayout(0, 0);
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
	        
            //BtnChateau.setIcon(new ImageIcon(this.getClass().getResource("/chateau.png")));
           // BtnChateau.setRolloverIcon(new ImageIcon(this.getClass().getResource("/Champs2.png")));

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
    
	
    
    public void lireTerrain_et_AfficheTuilesurTerrain(Tuile[][] terrain) {
    	for (int i = 0; i <= terrain.length - 1; i++) {
    		for (int j = 0; j <= terrain.length - 1; j++) {
    			if (terrain[i][j]!=null) {
    				getBoutton(i,j).setBackground(Color.BLACK);
    				display(terrain[i][j], getBoutton(i,j));
    				System.out.println("La (ou les) tuile(s) du terrain est remplacée sur l'interface graphique ");
    				//if vide alors rien afficher sinon utiliser fonction changerboutton
    			}	
    		}  		
    	}
    }
    
    public void setTerrain(Tuile[][] terrain) {
    	this.terrain=terrain;
    }

	
	public JButton CreerBoutonOrganise(int x, int y) {
	     JButton b = new JButton();
	     /**b.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.out.println("[" + x + "][" + y + "]"
	                    + " enclenché sur le terrain " + ((JButton) e.getSource()).getParent());
	                
	                setPosX(x);
	                setPosY(y);
	                System.out.println("posx "+getPosX());
	                System.out.println("posy "+getPosY());
	            }
	        });*/
	        return b;
	    }
	
	public int getPosX() {
		return this.posx;
	}
	
	public int getPosY() {
		return this.posy;
	}
	
	public void setPosX(int posx) {
		this.posx=posx;
	}
	
	public void setPosY(int posy) {
		this.posy=posy;
	}
	
	public void display(Tuile Tuile, JButton T) {

		ImageIcon img = new ImageIcon(this.getClass().getResource("/" + Tuile.gettype() + Tuile.getnbcouronne() + ".png"));
		Image newimg = img.getImage().getScaledInstance(T.getWidth(), T.getHeight(), java.awt.Image.SCALE_SMOOTH);
		ImageIcon Icone = new ImageIcon(newimg);
		T.setIcon(Icone);
		
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
	public BoutonsPlateau(String Titre, URL img) {
		//super(Titre);
		//this.add(a);
		//setForeground(Color.WHITE);
        /*
        setOpaque(false);
        setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
        setBorderPainted(true); // De même, on ne veut pas afficher les bordures.
        setFocusPainted(false); // On n'affiche pas l'effet de focus.
         */
        //setHorizontalAlignment(SwingConstants.CENTER);
        //setHorizontalTextPosition(SwingConstants.CENTER);
        
        
        setIcon(new ImageIcon(img));
        //setRolloverIcon(new ImageIcon(imgflottante));
        //setRolloverIcon(Survole);
        //Rajouter la main survolante
	}

}
