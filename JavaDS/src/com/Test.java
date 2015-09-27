package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Test {

	public int countVowelsRegex(String str) {
        int count = 0;
		
        if (str.length() > 0) {
                // Create a pattern that detects vowels.
                Pattern vowelPattern = Pattern.compile("[aeiouAEIOU]");
                Matcher vowelMatcher = vowelPattern.matcher(str);

                // Look for the next match and if found, add to count and repeat.
                while (vowelMatcher.find()) 
                        count++;
		}
		
		return count;
}


	public static void main(String[] args)
	{
		String s1="abc";
		String s2="def";
		String s3=s1.concat(s2.toUpperCase());
	//	StringBuffer str = new StringBuffer();
	
		//System.out.println(s1+s2+s3);
		
		Test test = new Test();
		System.out.println(test.countVowelsRegex("AEIgtyhtgy"));
	}
}
