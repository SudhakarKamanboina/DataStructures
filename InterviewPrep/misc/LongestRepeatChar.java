package misc;

//longest repeating consecutive char in a String (return the char, index and length)
// asked in microsoft

public class LongestRepeatChar {



    public static void main(String args[]){

        String s = "aaaabbcbbbb";
        int[] res = helper(s);
        System.out.println(res[1]-res[0]+1);
        System.out.println(s.charAt(res[0]));
    }

    //sudhaaakar

    public static int[] helper(String s){
        if (s.length() == 1){
            return new int[]{0,0};
        }
        int l=0,r=0,x=0,y=0;

        char[] charArray = s.toCharArray();
        for(int i=1; i<charArray.length; i++){

            if (charArray[i] == charArray[i-1]){
                y = i;
            }else{
                if (r -l < y - x){
                    l = x;
                    r = y;
                }
                x = i;
            }
        }
        if (r -l < y - x){
            l = x;
            r = y;
        }
        return new int[]{l ,r};
    }
}
