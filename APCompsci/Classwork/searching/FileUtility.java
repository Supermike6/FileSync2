import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;



public class FileUtility
{
    public static void main(String[] args) throws FileNotFoundException
    {
		// String[] words = null;
		String[] other = null;
		// words = readFromFile("/Users/gbancroft25/Documents/GitHub/FileSync2/APCompsci/Classwork/Searching/test.txt");
		other = readFromFile("/Users/gbancroft25/Documents/GitHub/FileSync2/APCompsci/Classwork/searching/FileUtility.java");
      // System.out.println(binarySearch1("Hello", words));
      // int[] nums = new int[words.length];
      // for(int i = 0; i<nums.length-1;i++)
      //    nums[i] = Integer.parseInt(words[i]);
      // System.out.println(binarySearch3(5001, nums));
      for(int i = 0; i<other.length;i++)
      {
         System.out.println(other[i]);
      }

   
   }

   public static String[] readFromFile(String fileName) throws FileNotFoundException
   {
      Scanner reader = new Scanner(new File(fileName));
      int count = 0;
      while(reader.hasNext())
      {
         count++;
         reader.nextLine();
      }
      System.out.println(fileName + " contains " + count + " items.");

      reader.close();
      reader = new Scanner(new File(fileName));

      String[] words = new String[count];
      count = 0;
      while(reader.hasNext())
      {
         words[count] = reader.nextLine();
         count++;
      }

      reader.close();

      return words;
   }

   public static int binarySearch1(String target, String[] list)
   {
      int start = 0;
      int end = list.length-1;
      int check = (start+end)/2;
      while (!target.equalsIgnoreCase(list[check]))      
      {
         check = (start+end)/2;
         if(target.compareToIgnoreCase(list[check]+"")<check)
         {
            end--;
            // end-=(start+end)/2;
            System.out.println(check+", "+list[check]);
         } else {
            start++;
            // start+=(start+end)/2;
            System.out.println(check+", "+list[check]);
         }
      }
      System.out.println("d");
      
      return 0;
   }

   public static int binarySearch3(int target, int[] nums)
   {
      int start = 0;
      int end = nums.length-1;
      double mid = (start+end)/2.0;

      while(target!=nums[(int)mid])
      {
         if(target<nums[(int)mid])
         {
            start++;
            System.out.println(start+", "+mid);
         } if(target>nums[(int)mid])
         {
            end--;
            System.out.println(end+", "+mid);
         } if(target==nums[(int)mid])
            return (int) mid;
      }
      return (int) mid;
   }

   public static int binarySearch4R(int target, int[] nums, int start, int end, int mid)
   {
      // if(target<nums[mid]
      // binarySearch4R(target, nums, mid+1, end, (mid+1+end)/2);
      
      
      return target;
   }

   public static int[] sort1(int[] nums)
   {
      
      return nums;
   }

}