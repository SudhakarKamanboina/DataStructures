package String;

import java.util.Arrays;


//Rotate string by k elements
public class RotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] input = "SUDHA".toCharArray();
		rotate(input,2);
		System.out.println(Arrays.toString(input));
	}
	
	private static void rotate(char[] str, int k){
		
		reverse(str, 0, k-1);
		reverse(str, k, str.length-1);
		reverse(str, 0, str.length-1);
		//return str.toString();
	}

	private static void reverse(char[] str, int i, int j) {
		char temp;
		while(i<j)
		{
			temp = str[i];
			str[i] = str[j];
			str[j] = temp;
			i++;
			j--;
		}
	}

}
