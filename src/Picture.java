import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
    /** Method to set to only blue */
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        //pixelObj.setBlue(0);
        pixelObj.setGreen(0);
        pixelObj.setRed(0);
      }
    }
  }
  
    /** Method to set to only Red */
  public void keepOnlyRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
        pixelObj.setGreen(0);
        //pixelObj.setRed(0);
      }
    }
  }
  
     /** Method to negate colors */
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(255-pixelObj.getBlue());
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setRed(255-pixelObj.getRed());
      }
    }
  }
  
     /** Method to make gray picture */
  public void grayScale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue((pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3);
        pixelObj.setGreen((pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3);
        pixelObj.setRed((pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3);
      }
    }
  }
  
     /** Method to make gray picture */
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue((int)(pixelObj.getBlue() / 1.5));
        pixelObj.setGreen((int)(pixelObj.getGreen() / 2));
        pixelObj.setRed((int)(pixelObj.getRed() * 1.5));
      }
    }
  }

  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        rightPixel = pixels[row][col];
        leftPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int col = 0; col < pixels[0].length; col++)
    {
      for (int row = 0; row < height / 2; row++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  
   public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int col = 0; col < pixels[0].length; col++)
    {
      for (int row = 0; row < height / 2; row++)
      {
        bottomPixel = pixels[row][col];
        topPixel = pixels[height - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
   
    public void mirrorDiagonal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height; row++)
    {
      for (int col = 0; col <= row; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[col][row];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }
  
   /** Mirror just the arms */
  public void mirrorArms()
  {
    int mirrorPoint = 196;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 159; row < 196; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 105; col < 294; col++)
      {
        
        topPixel = pixels[row][col];      
        bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        if(col < 170|| col > 239)bottomPixel.setColor(topPixel.getColor());      }
    }
  }
  
    /** Mirror just the arms */
  // 234,238 - 322,344
  public void mirrorGull()
  {
    int mirrorPoint = 344;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 234; row < 322; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 238; col < 344; col++)
      {
        
        topPixel = pixels[row][col];      
        bottomPixel = pixels[row - 15][mirrorPoint - col + mirrorPoint - 250];
        bottomPixel.setColor(topPixel.getColor());      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    //this.write("collage.jpg");
  }
  
  //New copy method with more parameters
   public void copyTwo(Picture fromPic, int toStartRow, int toStartCol, 
                        int fromStartRow, int fromEndRow, 
                        int fromStartCol, int fromEndCol)
  {
    int toEndRow = toStartRow + (fromEndRow - fromStartRow);
    int toEndCol = toStartCol + (fromEndCol - toStartCol);
      
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    //FIX LOOP CONDITIONS
    for (int fromRow = fromStartRow, toRow = toStartRow; 
         fromRow < fromEndRow && toRow < toEndRow; 
         fromRow++, toRow++)
    {
      for (int fromCol = fromStartCol, toCol = toStartCol; 
           fromCol < fromEndCol && toCol < toEndCol;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
   //New collage that incorporates copyTwo
   public void myCollage()
  {
    Picture blueMark = new Picture("blue-mark.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    Picture moonSurface = new Picture("moon-surface.jpg");
    
    this.copyTwo(moonSurface, 0, 0, 0, 0, 479, 639);
    this.copyTwo(blueMark, 85, 35, 160, 300, 280, 280);
    this.copyTwo(blueMark, 327, 160, 160, 300, 280, 280);
    
    Picture flower2Negate = new Picture(flower2);
    flower2Negate.negate();
    this.copyTwo(flower2Negate, 120, 325, 22, 20, 95, 81);
    this.mirrorDiagonal();
    
    //this.write("myCollage.jpg");
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    //left to right
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] pixels2 = this.getPixels2D();
    Color rightColor = null;

    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
    // New top/bottom loop
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Color bottomColor = null;
    for (int col = 0; col < pixels[0].length; col++)
    {
      for (int row = 0; row < pixels.length-1; row++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[row+1][col];
        bottomColor = bottomPixel.getColor();
        
        if (topPixel.colorDistance(bottomColor) > edgeDist)
            topPixel.setColor(Color.BLACK);
        else
            topPixel.setColor(Color.WHITE);
      }
    }
  }

  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
   public static void main(String[] args) {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
