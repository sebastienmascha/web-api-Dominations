import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AffichagePlateau extends JPanel {
	ImageIcon Chateau = new ImageIcon("//Users/lebens/Desktop/Dominations/images/bulle.jpg");
	JButton C = new JButton(Chateau);
	GridLayout Layout = new GridLayout(9, 9, 0, 0);
	List<JButton> ListeBoutons = new ArrayList<JButton>();
	
	public  AffichagePlateau(){
		this.setLayout(Layout);
        for (int i = 0; i < 9 * 9; i++) {
            int ligne = i / 9;
            int colonne = i % 9;
            JButton gb = CreerBoutonOrganise(ligne, colonne);
            ListeBoutons.add(gb);
            this.add(gb);
        }		
	}
	
    private JButton getGridButton(int x, int y) {
        int index = x * 9 + y;
        return ListeBoutons.get(index);
    }
	
	
	public JButton CreerBoutonOrganise(final int x, final int y) {
	     final MBouton b = new MBouton("[" + x + "][" + y + "]","//Users/lebens/Desktop/Dominations/images/champ.jpg" ,"//Users/lebens/Desktop/Dominations/images/montagne.jpg" );
	     b.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JButton gb = getGridButton(x, y);
	                System.out.println("[" + x + "][" + y + "]"
	                    + " enclenché sur le terrain " + ((JButton) e.getSource()).getParent());
	                ((JButton) e.getSource()).setText("Cliqué !");
	                ((JButton) e.getSource()).setIcon(Chateau);
	            }
	        });
	        return b;
	    }
	
	public void paintComponent(Graphics g){
		try {
	        Image img = ImageIO.read(new File ("//Users/lebens/Desktop/Dominations/images/Wallpaper.jpg"));
	        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
        
}


