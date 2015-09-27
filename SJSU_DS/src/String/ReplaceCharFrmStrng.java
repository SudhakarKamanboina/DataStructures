package String;


//Replace characters from string with provided input(as char)  
class ReplaceCharFrmStrng
{
	public static void main(String[] arg)
	{
	    //FIXME: Take input from user
	    String input = "coded @ 1AM on 3/3/13";
		String result = "";
		char replaceWith = 'd';
		ReplaceCharFrmStrng obj = new ReplaceCharFrmStrng();
		
		result = obj.replaceChar(input, replaceWith);
		
		System.out.println("replace : "+result);
	}

	
	private String replaceChar(String word, char replaceWith)
	{
		char temp [] = new char[word.length()];
		char local ;
		for(int i=0; i<=word.length()-1; i++)
		{
		    local = word.charAt(i);
			if(local == 'd')
			{
			    local = 'z';
			}
			temp[i] = local;
		}
		return new String(temp);
	}
	
}

