package String;

// Reverse String in java without using API methods  
public class StringReverse
{
		//Reverse String with single input from cmd i.e first element from array
		/*public static void main(String arg[])
		{
			String reversed = "";
			
			for(int i=arg[0].length()-1;i>=0;i--)
			{
				reversed += arg[0].charAt(i);
			}
			System.out.println("output " +reversed);
		}*/
		
		//Reverse String array supplied from cmd  
		public static void main(String arg[])
		{
		    StringReverse obj = new StringReverse();
			String cmplete = "";
			for(int i=0;i<arg.length;i++)
			{
				if(i > 0)
				cmplete = cmplete + " " + obj.reverse(arg[i]);
				else
				cmplete = cmplete + obj.reverse(arg[i]);
			}
			
			System.out.println("pass "+cmplete);
		}
		
		private String reverse(String word)
		{
				String temp="";
				for(int i=word.length()-1; i>=0;i--)
					temp = temp + word.charAt(i);
				return temp;	
		}
    
    /*public static void main(String arg[])
    {
        String temp1= "SUDHAKAR";
        String temp2 = "";
        
        for(int i = temp1.length()-1; i>=0; i--)
        {
            temp1 += temp1.charAt(i);
        }
        
        System.out.println("output "+temp1);
    }*/
}		
		