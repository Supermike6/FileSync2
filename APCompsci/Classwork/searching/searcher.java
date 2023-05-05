public class searcher
{
    public static int binarySearch2(String target, String[] list)
   {
      int index1 = 0;
      int index2 = list.length-1;
      if(target.compareToIgnoreCase(list[(index1+index2)/2])<0)
      {
         index2/=2;
      } else {}
      
      return 0;
   }
   public static int binarySearch1(String target, String[] list)
   {
      int start = 0;
      int end = list.length-1;
      while (target.equalsIgnoreCase(list[(start+end)/2]))
      {
         if(target.compareToIgnoreCase(list[(start+end)/2])<0)
            end-=(start+end)/2;
         else 
            start+=(start+end)/2;
      }
      
      return 0;
   }
}
