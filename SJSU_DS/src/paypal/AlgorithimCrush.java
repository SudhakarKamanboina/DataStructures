package paypal;

import java.util.Scanner;

public class AlgorithimCrush {

	public static void main(String[] args) {
		// Naive approach :(
		
		Scanner scan = new Scanner(System.in);
		int arrLength = scan.nextInt();
		int operations = scan.nextInt();
		
		int[] arrInput = new int[arrLength];
		
		int index1=0;
		int index2=0;
		int val=0;
		for(int i=0; i<operations; i++)
		{
			 index1 = scan.nextInt();
			 index2 = scan.nextInt();
			 
			 val = scan.nextInt();
			 
			 for(int j=index1-1; j<=index2-1; j++)
			 {
				 arrInput[j]=arrInput[j]+val;
			 }
		}
		
		int max=0;
		for(int k=0; k<arrInput.length; k++)
		{
			if(arrInput[k]>max)
				max= arrInput[k];
		}
		System.out.println(max);
	}

}

