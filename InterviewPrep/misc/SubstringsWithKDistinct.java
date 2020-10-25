package misc;

import java.util.*;

/*
Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.

Example 1:

Input: s = "abcabc", k = 3
Output: ["abc", "bca", "cab"]
Example 2:

Input: s = "abacab", k = 3
Output: ["bac", "cab"]
Example 3:

Input: s = "awaglknagawunagwkwagl", k = 4
Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
Explanation:
Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl"
"wagl" is repeated twice, but is included in the output once.
Constraints:

The input string consists of only lowercase English letters [a-z]
0 ≤ k ≤ 26
 */

public class SubstringsWithKDistinct {


    public static void main(String args[]){
        String s = "awaglknagawunagwkwagl";
        int k = 4;
        List<String> res = possibleSubstringsWithKDistinct(s, k);
        for (String s1 : res){
            System.out.println(s1);
        }
    }

    public static List<String> possibleSubstringsWithKDistinct(String s, int k){

        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int start =0, end =0, counter =0;

        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0)+1);
            if (map.get(c) == 1){
                counter++;
            }
            end++;

            while(counter == k){
                c = s.charAt(start);
                map.put(c, map.getOrDefault(c, 0)-1);
                if (map.get(c) == 0){
                    counter--;
                }
                if (end - start == k){
                    if (!res.contains(s.substring(start, end))){
                        res.add(s.substring(start, end));}
                }
                start++;
            }
        }
        return res;
    }
}
