import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AffichagePlateau extends JPanel {
	
	public AffichagePlateau(){
		this.setLayout(new GridLayout(9, 9, 0, 0));
		for (int i=1; i <=40; i++) {
			this.add(new JButton("Domino " + i), BorderLayout.CENTER);}
		this.add(new JButton(new ImageIcon("//Users/lebens/Desktop/Dominations/images/chateau.jpg")), BorderLayout.CENTER);
		for (int i=42; i <=81; i++) {
			this.add(new JButton("Domino " + i), BorderLayout.CENTER);}
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
