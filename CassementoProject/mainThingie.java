package CassementoProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class mainThingie
{
    public static File points = new File("/Users/gbancroft25/Documents/GitHub/FileSync2/CassementoProject/hello.txt");
	public String pout = "";	
	public static FileWriter fw = null;
	public static BufferedWriter bw = null;
	public static PrintWriter pw = null;
	public boolean thereAreLines = false;

    public mainThingie()
    {
        // this.add(new FileChooserComponent());
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        
        FileReader fr = new FileReader(points);
        BufferedReader br = new BufferedReader(fr);
        Scanner sc;
		try {
			sc = new Scanner(points);
		} catch (FileNotFoundException e1) {
			sc = new Scanner(System.in);
		}

        try {
            fw = new FileWriter("/Users/gbancroft25/Documents/GitHub/FileSync2/CassementoProject/hello.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println("I dont know, something cool I guess.");

            System.out.println("Data Successfully added to file");
            pw.flush();

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                fr.close();
                pw.close();
                bw.close();
                fw.close();
                sc.close();
            } catch (IOException io) {
                System.out.println("Close failed");
            }
        }

        

    }

    public void openPic()
    {
      String[] allFiles = imageFiles();
      String filename = (String) JOptionPane.showInputDialog(null,
             "Select an image to open:",
             "Open An Image",
             JOptionPane.INFORMATION_MESSAGE,
             null,
             allFiles,
             allFiles[0]);
      
        if(filename != null) {
            System.out.println("Hello");
        }
    }
    public String[] imageFiles()
   {
      String[] imageFileList;

      File f = new File("/Users/gbancroft25/Documents/GitHub/FileSync2/CassementoProject/mainThingie.java");
      File[] files = f.listFiles();
//      System.out.println("ALL FILES: " + Arrays.toString(files));
      //count only files that are images (png, jpeg, jpg)
      int counter = 0;
      for(File x : files)
         if(x.getName().length() >= 4 
            && (
                x.getName().substring(x.getName().length()-4).equals(".png")
            ||  x.getName().substring(x.getName().length()-4).equals(".jpg")
            ||  x.getName().substring(x.getName().length()-4).equals(".jpeg")
            ))
            counter++;
      
      imageFileList = new String[counter];
      int index = 0;
      for(File x : files){
         if(x.getName().length() >= 4 
               && (x.getName().substring(x.getName().length()-4).equals(".png")
               ||  x.getName().substring(x.getName().length()-4).equals(".jpg")
               ||  x.getName().substring(x.getName().length()-4).equals(".jpeg")
               ))
         {
            imageFileList[index] = x.getName();
            index++;
         }
      }
      System.out.println("IMAGE FILES: " + Arrays.toString(imageFileList));
      
      return imageFileList;
   }
}
