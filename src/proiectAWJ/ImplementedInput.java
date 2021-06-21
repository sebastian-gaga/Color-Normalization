package proiectAWJ;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

//Clasa ce mosteneste clasa abstracta, implementand metodele
public class ImplementedInput extends UserInput implements Normalize{
	
	//Functia de citire a path-ului
	public String getFileName() {
		Scanner scanner = new Scanner(System.in);
	    String fileName = scanner.nextLine();
		return fileName;
	}
	
	public void getPathFromUser() {
		System.out.println("Path-ul introdus este:");
	}
	
	//Functia de Normalizare - Procesare Imagine
	public BufferedImage normalize(int x, int y, BufferedImage img) {
		int[][] pixels = new int[x][y];
		int sum = 0;
		int average = 0;
		BufferedImage imagineOutput = new BufferedImage(x,y,BufferedImage.TYPE_INT_ARGB);
        for( int i = 0; i < x; i++ )
        {
        	for( int j = 0; j < y; j++ )
        	{
                pixels[i][j] = img.getRGB(i, j);
                
                sum += pixels[i][j];            
        	}    	
        }
        average = sum / (x*y);
        for( int i = 0; i < x; i++ )
        {
        	for( int j = 0; j < y; j++ )
        	{	
        		pixels[i][j] = (int)(pixels[i][j]+Math.sqrt((double)((1/average)*x*y))+9);
        		imagineOutput.setRGB(i, j, pixels[i][j]);
        		 
        	}
        }
        
        return imagineOutput;
	}
	
}
