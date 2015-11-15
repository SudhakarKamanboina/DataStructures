package paypal;

import java.util.Scanner;

public class SortString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String sortedInput = sort(input.toCharArray(), 0, input.length()-1);
		System.out.println(sortedInput);

	}

	private static String sort(char[] inputArray, int low, int high) {
		int pivot;
		if(low < high)
		{
			pivot = partition(inputArray, low, high);
			sort(inputArray, low, pivot-1);
			sort(inputArray, pivot+1, high);
		}
		return String.valueOf(inputArray);
	}

	private static int partition(char[] inputArray, int low, int high) {
		int left =low;
		int right = high;
		int pivot = inputArray[low];
		char chPivot = inputArray[low];
		char temp;
		
		while(left < right)
		{
			if(inputArray[left] <= pivot)
				left++;
			if(inputArray[right] > pivot)
				right--;
			
			if(left < right)
			{
				temp = inputArray[left];
				inputArray[left] = inputArray[right];
				inputArray[right] = temp;
			}
		}
		inputArray[low] = inputArray[right];
		inputArray[right] = chPivot;
		return right;
	}

}
