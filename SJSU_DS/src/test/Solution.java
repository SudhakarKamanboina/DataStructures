package test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;

public class Solution {
	
	static int val =64;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFormat formatter = new DecimalFormat("#0.00");
		System.out.println(formatter.format(4));
	}

}
