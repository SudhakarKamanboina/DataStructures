import java.io.*;
import java.util.*;
public class Solution {
   public static void main(String args[] ) throws Exception {
       /* Enter your code here. Read input from STDIN. Print output to STDOUT */
      
       Solution solution = new Solution();
       Scanner scanner = new Scanner(System.in);
       int length = scanner.nextInt();
       
       for(int i=0;i<length;i++)
           {
           solution.add(scanner.nextLine());
       }
      }
   
   public static void add(String input){
       String[] arrayInput = input.split(" ");
       System.out.println(getSquareCount(Integer.parseInt(arrayInput[0].trim()), Integer.parseInt(arrayInput[1].trim())));
   }
   
   public static int getSquareCount(int lower, int higher)
       {
           // 7 30
           int oddCount=1;
           int square = 1;
           int squareCount = 0;
           while(higher<square)
               {
               oddCount = oddCount+2;
               square = square + oddCount;
               if(square>lower)
                   {
                   squareCount++;
               }
           }
           return squareCount;
       }
 }