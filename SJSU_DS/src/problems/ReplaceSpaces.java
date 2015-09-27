package problems;

// Replace space with %20 in String
public class ReplaceSpaces
{
    // Assume string has sufficient free space at the end
    public static void main(String arg[])
    {
        String s1 = "This is a String";
        char[] arr = new char[s1.length()+ 2*3+ 1];//s1.toCharArray();
        for(int i=0; i<s1.length(); i++)
            arr[i] = s1.charAt(i);
        
        ReplaceSpaces obj = new ReplaceSpaces();
        obj.replace(arr, s1.length());
    }
    
    private void replace(char[] arr, int OLength)
    {
        int newLength, spaceCount=0;
        
        for(int i=0; i<OLength; i++)
        {
            if(arr[i] == ' ')
                spaceCount++;
        }
        
        newLength = OLength + (spaceCount *2);
        
        arr[newLength] = '\0';
        for(int j=OLength-1; j>=0; j--)
        {
            if(arr[j] == ' ')
            {
                arr[newLength - 1] = '0';
                arr[newLength - 2] = '2';
                arr[newLength - 3] = '%';
                newLength = newLength -3;
            }
            else
            {
                arr[newLength - 1] = arr[j];
                newLength = newLength - 1;
            }
        }
            System.out.println(new String(arr));
    }
}
