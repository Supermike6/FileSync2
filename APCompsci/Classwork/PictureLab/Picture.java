package APCompsci.Classwork.PictureLab;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

//Mr. Uhl
//Program description: Starter code for the Picture Lab
//Dec 12, 2022

public class Picture
{
   private BufferedImage pic;
   private Pixel[][] pix;
   
   public Picture(String filename)
   {
      //THE IMAGE FROM THE FILE IS LOADED AS A BUFFERED IMAGE
      try{
         File imageFile = new File(filename);
         pic = ImageIO.read(imageFile);
      } catch (IOException e){e.printStackTrace();}

      pix = getPixels2D(pic);
   }
   
   public Picture()
   {
      pic = createDefaultTitleImage("UPic Picture Lab~~No images found~in src folder.");
      pix = getPixels2D(pic);
   }
   
   public Pixel[][] getPixels2D(BufferedImage image)
   {
      final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
      final int width = image.getWidth();
      final int height = image.getHeight();
      final boolean hasAlphaChannel = image.getAlphaRaster() != null;

      Pixel[][] result = new Pixel[height][width];
      if (hasAlphaChannel) {
         final int pixelLength = 4;
         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
            int r = 0; int g = 0; int b = 0; int a = 0;
            a = (((int) pixels[pixel] & 0xff));     // alpha
            b = ((int) pixels[pixel + 1] & 0xff);   // blue
            g = (((int) pixels[pixel + 2] & 0xff)); // green
            r = (((int) pixels[pixel + 3] & 0xff)); // red
            result[row][col] = new Pixel(r, g, b, a);
            col++;
            if (col == width) {
               col = 0;
               row++;
            }
         }
      } else {
         final int pixelLength = 3;
         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
            int r = 0; int g = 0; int b = 0; int a;
            a = 255;                                // alpha
            b = ((int) pixels[pixel] & 0xff);       // blue
            g = (((int) pixels[pixel + 1] & 0xff)); // green
            r = (((int) pixels[pixel + 2] & 0xff)); // red
            result[row][col] = new Pixel(r, g, b, a);
            col++;
            if (col == width) {
               col = 0;
               row++;
            }
         }
      }
      
      return result;
   }
   
   public void drawPixels(Graphics2D g2, int x, int y)
   {
      for(int r = 0; r < pix.length; r++)
         for(int c = 0; c < pix[r].length; c++)
         {
            g2.setColor(pix[r][c].getColor());
            g2.fillRect(c+x, r+y, 1, 1);
         }
   }
   
   public int getWidth()
   {
      return pix[0].length;
   }
   
   public int getHeight()
   {
      return pix.length;
   }
   
   public void restore()
   {
      pix = getPixels2D(pic);
   }
   
   public Pixel getPixel(int row, int col)
   {
      return pix[row][col];
   }
   
   public BufferedImage createDefaultTitleImage(String message)
   {
      BufferedImage titleImage = null;
      int width = 400;
      int height = 500;
      //Create blank buffered image
      titleImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
      
      //Add the text to the newly created buffered image
      Graphics2D g2 = titleImage.createGraphics();
      g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                               RenderingHints.VALUE_ANTIALIAS_ON));
      g2.setColor(Color.WHITE);
      g2.fillRect(0, 0, width, height);
      g2.setColor(new Color(50, 0, 150));
      int fontSize = 40;
      g2.setFont(new Font("Cooper Black", Font.BOLD, fontSize));
//      int messageWidth = g2.getFontMetrics().stringWidth(message);
//      while(messageWidth > width - 40) {
//         fontSize--;
//         g2.setFont(new Font("Cooper Black", Font.BOLD, fontSize));
//         messageWidth = g2.getFontMetrics().stringWidth(message);
//      }
      String[] messageList = message.split("~");
      int gap = 42;
      int heightOfMessage = messageList.length * gap;
      int startY = height/2 - heightOfMessage/2 + 32;
      for(String s:messageList) {
         g2.drawString(s, 20, startY);
         startY += gap;
      }
      return titleImage;
   }
   
   public void savePic()
   {
      String filename = JOptionPane.showInputDialog("Enter the filename to save as:");
      filename += ".png";
      try{
         int width = pix[0].length;
         int height = pix.length;
         System.out.println(width + ", " + height);
         BufferedImage img = new BufferedImage( 
            width, height, BufferedImage.TYPE_INT_RGB);

         File f = new File(filename);

         for(int x = 0; x < height; x++){
            for(int y = 0; y < width; y++){
               int rgb = pix[x][y].getColor().getRGB();
               img.setRGB(y, x, rgb);
            }
         }
         ImageIO.write(img, "png", f);
      }
      catch(Exception ex){ex.printStackTrace();}
   }

   
   
   //ALL THE PICTURE LAB METHODS SHOULD BE WRITTEN BELOW

  public void photoNegative()
  {
   Pixel temp = new Pixel(0, 0, 0,0);
   for(int i = 0; i<pix.length;i++)
      for(int j = 0; j<pix[i].length;j++)
      {
         temp = new Pixel(255-pix[i][j].Red, 255-pix[i][j].Green, 255-pix[i][j].Blue, pix[i][j].Alpha);
         pix[i][j] = temp;
      }
  }

   public void grayscale()
   {
      for(int i = 0; i<pix.length;i++)
      for(int j = 0; j<pix[i].length;j++)
      {
         int avg = (pix[i][j].Red+pix[i][j].Blue+pix[i][j].Green)/3;
         pix[i][j] = new Pixel(avg, avg, avg,pix[i][j].Alpha);
      }
   }

   public void zeroRed()
   {
      for(int i = 0; i<pix.length;i++)
      for(int j = 0; j<pix[i].length;j++)
      {
         pix[i][j].setRed(0);
      }
   }

   public void zeroGreen()
   {
      for(int i = 0; i<pix.length;i++)
      for(int j = 0; j<pix[i].length;j++)
      {
         pix[i][j].setGreen(0);
      }
   }

   public void zeroBlue()
   {
      for(int i = 0; i<pix.length;i++)
      for(int j = 0; j<pix[i].length;j++)
      {
         pix[i][j].setBlue(0);
      }
   }

   public void mirrorRightToLeft()
   {
      for(int i = 0; i<pix.length;i++)
      for(int j = 0; j<pix[i].length/2;j++)
      {
         pix[i][j] = pix[i][pix[i].length-j-1];
      }
   }

   public void mirrorBottomToTop()
   {
      for(int i = 0; i<pix.length/2;i++)
      for(int j = 0; j<pix[i].length;j++)
      {
         pix[i][j] = pix[pix.length-i-1][j];
      }
   }

   public void mirrorLeftToRight()
   {
      for(int i = 0; i<pix.length;i++)
      for(int j = 0; j<pix[i].length/2;j++)
      {
         pix[i][pix[i].length-j-1] = pix[i][j];
      }
   }

   public void mirrorTopToBottom()
   {
      for(int i = 0; i<pix.length/2;i++)
      for(int j = 0; j<pix[i].length;j++)
      {
         pix[pix.length-i-1][j] = pix[i][j];
      }
   }

   public void flipHorizontal()
   {
      Pixel temp = new Pixel(0,0,0,0);
      for(int i = 0; i<pix.length;i++)
      for(int j = 0; j<pix[i].length/2;j++)
      {
         temp = pix[i][j];
         pix[i][j] = pix[i][pix[i].length-j-1];
         pix[i][pix[i].length-j-1] = temp;
      }
   }

   public void flipVertical()
   {
      Pixel temp = new Pixel(0,0,0,0);
      for(int i = 0; i<pix.length/2;i++)
      for(int j = 0; j<pix[i].length;j++)
      {
         temp = pix[i][j];
         pix[i][j] = pix[pix.length-i-1][j];
         pix[pix.length-i-1][j] = temp;
      }
   }

   public void edgeDetection(int sensitivity)
   {

      for(int i = 1; i<pix.length-1;i++)
      for(int j = 1; j<pix[i].length-1;j++)
      {
         if(pix[i][j].colorDistance(pix[i-1][j-1].getColor())<sensitivity || pix[i][j].colorDistance(pix[i+1][j-1].getColor())<sensitivity || pix[i][j].colorDistance(pix[i+1][j+1].getColor())<sensitivity || pix[i][j].colorDistance(pix[i+1][j-1].getColor())<sensitivity)
         {
            pix[i][j] = new Pixel(0, 0, 0, 255);
         } else {
            pix[i][j] = new Pixel(255, 255, 255, 255);
         }

      }
   }

   public void blur()
   {
      for(int i = 0; i<pix.length;i++)
      for(int j = 0; j<pix[i].length;j++)
      {

      }
   }

   public void encodeUsingRed(Picture picture)
   {
      Pixel[][] msg = getPixels2D(picture.pic);

      for (int i = 0; i < pix.length; i++)
      {
         for (int j = 0; j < pix[i].length; j++)
         {
            pix[i][j].Red = (pix[i][j].Red%2==1) ? pix[i][j].Red : pix[i][j].Red+1;
         }
      }

      for(int i = 0; i<msg.length;i++)
         for(int j = 0; j<msg[i].length;j++)
         {
            if(msg[i][j].colorDistance(Color.black)<20&&pix[i][j].Red%2==1)
            {
               pix[i][j].Red--;
            } else {
            }
         }
   }

   public void decodeUsingRed()
   {
      for(int i = 0; i<pix.length;i++)
         for(int j = 0; j<pix[i].length;j++)
         {
            if(pix[i][j].Red%2==1)
            {
               pix[i][j] = new Pixel(0, 0, 0, 255);
            } else {
               pix[i][j] = new Pixel(255, 255, 255, 255);
            }

         }
   }

   }