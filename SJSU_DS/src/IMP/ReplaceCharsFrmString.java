package IMP;

public class ReplaceCharsFrmString {

	public static void main(String[] args) {
		
		ReplaceCharsFrmString obj = new ReplaceCharsFrmString();
		System.out.println("Output "+obj.manipulateString("samsung", new char[]{'s','a'}));
	}
	
	private String manipulateString(String input, char[] charArray)
	{
		char[] temp = input.toCharArray();
        int pos=0;
        int i=0;
        boolean[] charFlag = new boolean[128];
        for(i=0; i<charArray.length; i++)
        {
        	System.out.println(charArray[i]);
            charFlag[charArray[i]]=true;
        }
        
        for(i=0; i<temp.length; i++)
        {
        	if(!charFlag[temp[i]])
        	{
        		temp[pos++]=temp[i];
        	}
        }
        
        return new String(temp, 0, pos);
	}

}
