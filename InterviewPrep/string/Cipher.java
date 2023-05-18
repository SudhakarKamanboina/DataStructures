package string;

/* Asked by HP
problem statement
One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
Given a string and a rotation factor, return an encrypted string.
Signature
string rotationalCipher(string input, int rotationFactor)
Input
1 <= |input| <= 1,000,000
0 <= rotationFactor <= 1,000,000
Output
Return the result of rotating input a number of times equal to rotationFactor.

Example 1
input = Zebra-493?
rotationFactor = 3
output = Cheud-726?

Example 2
input = abcdefghijklmNOPQRSTUVWXYZ0123456789
rotationFactor = 39
output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 */

public class Cipher {
    public static void main(String[] args) {
        String result = cipher("Zebra-493?", 3);
        System.out.println(result);
    }

    private static String cipher(String input, int rotation) {
        StringBuilder sb = new StringBuilder();
        for(char ch : input.toCharArray()){
            if (Character.isDigit(ch)){
                sb.append((Character.getNumericValue(ch) + rotation) % 10);
            } else if (Character.isAlphabetic(ch)){
                if (Character.isLowerCase(ch)){
                    int temp = ((ch - 'a' + rotation) % 26);
                    ch = (char) ('a' + temp);
                }else{
                    int temp = (char) ((ch - 'A' + rotation) % 26);
                    ch = (char) ('A' + temp);
                }
                sb.append(ch);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
