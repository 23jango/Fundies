package week6;


import java.io.File;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class ImageTest {
	
	
	//main throws exception with handles excpetions from
	//file, imageIO, color, and bufferedImage
   public static void main(String args[])throws Exception {
	   

      //Code to read image into a image buffer
      File originalFile= new File("Images/ponyo.png");
      BufferedImage oldImg = ImageIO.read(originalFile);//called it on a class name
      //this read method is a static method
      //bufferedimage saves it into a convienient format to work with
      
      
      //new file to store altered image
      File newFile = new File("Images/ponyoaltered.png"); //allow us to save file after we alter
      
      //new buffer for alteredImage
      BufferedImage newImg = 
    		  new BufferedImage(oldImg.getWidth(), 
    				  oldImg.getHeight(), 
    				  BufferedImage.TYPE_INT_RGB);
      
      //creatig a grid and populating it
      ArrayList<ArrayList<Color>> grid = new ArrayList<ArrayList<Color>>(); 
      //creatig a grid and populating it
      
      
      //This loops through the image pixel by pixel
      //we will read in the original color then change
      //the color and store into new buffer
      for (int y = 0; y < oldImg.getHeight(); y++) { //rows
    	  
    	  ArrayList<Color> row = new ArrayList<Color>(); //makes a new copy of row eveytime for loop
    	  
         for (int x = 0; x < oldImg.getWidth(); x++) { //columns
            
        	 //Retrieving contents of a pixel
            int pixel = oldImg.getRGB(x,y);
            //pixel is one value in grid
            
            //Creating a Color object from pixel value
            Color originalColor = new Color(pixel);
            
            
            row.add(originalColor); //originalcolor copies into row
            
            //Retrieving the R G B values
            int red = originalColor.getRed();
            int green = originalColor.getGreen();
            int blue = originalColor.getBlue();
            Color cyan = Color.CYAN;
            
            //these are to make sure colors are within range
//            red = Math.min(255,  red*2);
//            blue = Math.min(255,  blue*2);
//            green = Math.min(255,  green*2);
            
            
           //add a line like turn the image into a linked list and add a node with all red or smth
           //from 
            
            //making a row a specific color
//            if(y >100 && y < 102) {
//            	red = 0;
//            	green = 255;
//            	blue = 0;
//            }
            
            Color newColor = new Color(red, green, blue);
            //Color newColor = Color.cyan;
            
            if (x == 5) {
            	newImg.setRGB(x, 5, cyan.getRGB());
            }
            else {
            	newImg.setRGB(x, y, newColor.getRGB());  
            }
            
            newImg.setRGB(x, y, newColor.getRGB());   
         }
         
         grid.add(row);
      }
      
      
      PixelGrid pixelGrid = new PixelGrid(grid);//saves a copy of grid
      ImageIO.write(newImg, "png", newFile);
      System.out.println("Altered image stored");
   }
}



