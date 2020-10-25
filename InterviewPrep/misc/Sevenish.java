package misc;

import java.util.Arrays;


/* Asked in zillow
Let's define a sevenish number is a number that is one of a power of 7, or a number that is the sum of unique power of 7s
From the beginning the first few sevenish are:
1, 7, 8, 49, 50 and so on
You are to create an algorithm that finds the i'th sevenish number
'''

# i = 1, ret = 7^0 = 1 - base
# i = 2, ret = 7^1 = 7 - base
# i = 3, ret = 7^0 + 7^1 = 8 - base
# i = 4, ret = 7^2 = 49 - base
# i = 5, ret = 7^2 + 7^0 = 50
# i = 6, ret = 7^2 + 7^1 = 56
# i = 7, ret = 7^2 + 7^1 + 7^0 = 57 - base
# i = 8, ret = 7^3 = 343
# i = 9, ret = 7^3 + 7^0 = 344
# i = 10, ret = 7^3 + 7^1 = 350
# i = 11, ret = 7^3 + 7^1 + 7^0 = 351
# i = 12, ret = 7^3 + 7^2 = 392
# i = 13, ret = 7^3 + 7^2 + 7^0 =393
# i = 14, ret = 7^3 + 7^2 + 7^1 = 399
# i = 15, ret = 7^3 + 7^2 + 7^1 + 7^0 = 400 - base
 */

public class Sevenish {

    public static void main(String[] args){
        int res = SevenishNumber(8);
        System.out.print(res);
    }

    private static int SevenishNumber(int n){
        int addIndex =0, lastPowerIndex = 0;
        int[] memo = new int[n];
        Arrays.fill(memo, 1);

        for(int i=1; i<n; i++){
            if (addIndex == lastPowerIndex){
                addIndex = 0;
                memo[i] = memo[lastPowerIndex] * 7;
                lastPowerIndex = i;
            }else {
                memo[i] = memo[addIndex] + memo[lastPowerIndex];
                addIndex += 1;
            }
        }
        return memo[n-1];
    }
}
