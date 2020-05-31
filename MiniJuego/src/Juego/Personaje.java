package Juego;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Personaje {
	protected int X;
	protected int Y;
	private String Direccion;
	
	private JPanel MiJP;

	Personaje(JPanel MiJ) {
		this.X = 0;
		this.Y = 0;
		this.MiJP = MiJ;
	}

	public void DibujarPersonaje(Graphics g, int X, int Y, String Direccion) {
		this.X = X;
		this.Y = Y;
		this.MiJP.update(g);
		ImageIcon MiImagen = new ImageIcon(Direccion);
		g.drawImage(MiImagen.getImage(), X, Y, MiJP);
	}
	public int Coordx() {
		return this.X;
	}
	public int Coordy() {
		return this.Y;
	}
}
