package String;

public class RemoveDuplicates
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String str = "SUDHAKAR";
        System.out.println(removeDuplicatesFrom1(str));
        System.out.println(removeDups2(str));
    }

    private static String removeDuplicatesFrom1(String original) {
        if (original == null) 
            return "";
        char[] chars = original.toCharArray();
        int length = chars.length;
        for (int current = 0; current < length; current++) {
            // compare the current char with all following chars
            // and delete it if one of them is the same
            for (int next = current + 1; next < length;) {
                if (chars[current] == chars[next]) { 
                    // found a duplicate, need to delete it
                    length--;
                    for (int gap = next; gap < length; gap++) {
                        // delete the duplicate and left-shift all remaining chars
                        chars[gap] = chars[gap + 1];
                    }
                } else
                    next++;
                    // current character is unique, move on
            }
        }
        return new String(chars, 0, length);
    }
    
    private static String removeDups2(String original)
    {
        if(original.length()<2)
            return original;
        boolean[] temp = new boolean[256];
        StringBuilder sb = new StringBuilder();
        
        int asci;
        for(int i=0; i<original.length();i++)
        {
            asci = original.charAt(i);
            if(!temp[asci])
            {
                temp[asci] = true;
                sb.append(original.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
}
