package proiectAWJ;

import java.awt.image.BufferedImage;

//Interfata ce contine functia de Normalizare
public interface Normalize {
	//Functia de normalizare neimplementata
	public BufferedImage normalize(int x, int y, BufferedImage img);
}
