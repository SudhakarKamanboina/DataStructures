package problems;

    import java.util.Scanner;

    public class SquareSolution {
        
    public static int findSquareRange(long start, long end)
        {
            int squareCnt=0;
            long increment=0;
            long oddNum=1;
            while(increment <= end)
            {           
                increment=increment+oddNum;
                System.out.println("oddNum: "+oddNum);
                System.out.println("increment: "+increment);
                if( increment >= start){
                    squareCnt++;
                }
                oddNum = oddNum +2;
            }       
            int returnVal = squareCnt-1;
            return returnVal;
        }
    
    public static void main(String[] args)
    {
        Scanner sn = new Scanner(System.in);
        int lines = sn.nextInt();
        for(int i=0; i<lines; i++)
        {
            findSquareRange(sn.nextInt(), sn.nextInt());
        }
    }
    
    }
