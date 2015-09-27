package com.miscellaneous;

import java.util.ArrayList;

public class StringManupulations {

	
	public void moveZerotoLast()
	{
		String temp="ab00cd0e00f";
		char[] tempArray=temp.toCharArray();
		
		int i=0,j=0;
		while(j<(tempArray.length-1))
		{
			while(tempArray[i]!='0')i++;
			//if(tempArray[i]=='0') break;
			
			if(j<=i) j=i+1;
			
			while(tempArray[j]=='0') j++;
			//if(tempArray[j]=='0') break;
			
			char char_temp=tempArray[i];
			tempArray[i]= tempArray[j];
			tempArray[j]=char_temp;
		}
		
		System.out.println(" "+ String.valueOf(tempArray));
		
	}
	
	public void append()
	{
		String str="ABCD";
		//Char[] strArray= str.toCharArray();	
		for(int i=0; i<= str.length();i++)
		{
		  	for(int j=0;j<i;j++)
		  	{
		  		System.out.print(str.charAt(j));
		  	}
		}	
		//
	}
	
	public void uniqueChar()
	{
		String str="GeeksforGeeks";
		
		ArrayList<Character> charArr=new ArrayList<Character>();
		
		for(int i=0;i<str.length();i++){
		
			char temp = str.charAt(i);
			//System.out.println(temp);
			
			if(charArr.contains(temp))
			{
				int index=charArr.indexOf(temp);
				charArr.remove(index);
			}
			else
			{
				charArr.add(temp);
			}
			
		}
		for(int i=0;i<charArr.size();i++)
		{
			System.out.print(charArr.get(i));
		}
	}
	
	public void convertCase()
	{
		String str="AbcD";
		
		
		for(int i=0;i<str.length();i++)
		{
			
		}
	}
	
	public void makePalindrome()
	{
		String str="abcdc";
		char[] tempStr = str.toCharArray();
		
		int i=0,count=0;
		int j= str.length()-1;

		while(i<=j)
		{
			if(tempStr[i]==tempStr[j])
			{
				i++;j--;
			}
			else
			{
				tempStr[j] = tempStr[i];
				i++;
				j--;
				count++;
				
			}
		}
		
		System.out.println("Number of characters needs to be added :"+count + "  " + new String(tempStr));
		
//		String s1="abc";
//		String s2="def";
//		String s3=s1.concat(s2.toUpperCase());
//			
//		System.out.println(s1+s2+s3);
	}

	public void add(int a)
	{
		loop : for (int i=1;i< 3;i++)
		{
			for(int j=1;j<3;j++)
			{
				if(a==5)
				{
					break loop;
				}
				System.out.println(i*j);
			}
		}
	}
	
	
	void increment(int[] i)
	{
		i[i.length-1]++;
	}
	
	public void divide(int a, int b)
	{
		try{
			int c=a/b;
			
		} catch(Exception e)
		{
			System.out.println("exp");
		}
		finally
		{
			System.out.println("final");
		}
	}
	
	public static void main(String[] args)
	{
		StringManupulations strm= new StringManupulations();
		//strm.moveZerotoLast();
		//strm.append();
		strm.uniqueChar();
		
	//	strm.makePalindrome();
		//strm.add(5);
		
//		int[] a= {1};
//		strm.increment(a);
//		System.out.println(a[a.length-1]);
			
	//	strm.divide(4, 0);
	}
}
