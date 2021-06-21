package proiectAWJ;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Main
{
    public static void main(String args[]) throws IOException
    {	
    	String outputFile = args[0];
        BufferedImage imagineSursa = null;
        File fisier = null;
        FileParameters file = new FileParameters();
        
        file.getPathFromUser();
        
        //Bloc de citire a fisierului
        final long startTime1 = System.nanoTime();
        try
        {	
            fisier = new File(file.getFileName());
            imagineSursa = ImageIO.read(fisier);
        }
        catch(IOException e)
        {
            System.out.println("Eroare: " + e);
        }
        final long duration1 = System.nanoTime() - startTime1;
        System.out.println("Durata Proces Citire Poza: " + (double)duration1 + " nanosecunde");
        
        
        file.setWidth(imagineSursa.getWidth());
        file.setHeight(imagineSursa.getHeight());
       
        //Bloc de atribuire si procesare
        final long startTime2 = System.nanoTime();
        BufferedImage imagineOutput = new BufferedImage(file.getWidth(), file.getHeight(), BufferedImage.TYPE_INT_ARGB);
        imagineOutput = file.normalize(file.getWidth(),file.getHeight(),imagineSursa);
        final long duration2 = System.nanoTime() - startTime2;
        System.out.println("Durata Proces Normalizare: " + (double)duration2/1000000 + " milisecunde");
        
        
        //Bloc de scriere a fisierului
        final long startTime3 = System.nanoTime();
        try
        {
            fisier = new File(outputFile);
            ImageIO.write(imagineOutput, "PNG", fisier);
        }
        catch(IOException e)
        {
            System.out.println("Eroare: " + e);
        }
        final long duration3 = System.nanoTime() - startTime3;
        System.out.println("Durata Proces Scriere Poza: " + (double)duration3 + " nanosecunde");
        
        DisplayTime displayTime = new DisplayTime();
        displayTime.showTotalTime(duration1, duration2, duration3);
        
        System.out.println("Imaginea procesata a fost salvata cu succes in: " + args[0]);
    }
            
}
//clasa auxiliara
class DisplayTime{
	//Metoda cu varargs ce primeste timpii de procesare si afisaza timpul total
	public void showTotalTime(long ... a) {
		long sum = 0;
		for(long i : a) {
			sum+=i;
		}
		System.out.println("Timpul total de procesare: "+ sum + " nanosecunde");
	}
}
