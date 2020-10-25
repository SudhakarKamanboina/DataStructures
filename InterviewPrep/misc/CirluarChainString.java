package misc;

/*

This problem was asked by Dropbox.

Given a list of words, determine whether the words can be chained to form a circle.
A word X can be placed in front of another word Y in a circle if the last character of X is same
as the first character of Y.

For example, the words ['chair', 'height', 'racket', touch', 'tunic']
can form the following circle: chair --> racket --> touch --> height --> tunic --> chair
 */

import java.util.*;

public class CirluarChainString {

    private static boolean checkCircular(String[] words){
        /*Map<Character, List<Character>> map = new HashMap<>();
        for(String word : words){
            char s = word.charAt(0);
            char e = word.charAt(word.length()-1);
            List<Character> neigh = map.getOrDefault(s, new ArrayList<>());
            neigh.add(e);
            map.put(s, neigh);
        }

        for(String word : words){

        }*/
        System.out.println("todo");
        return false;
    }

    //private boolean dfs(Character c, Map<Character, List<Character>> map, visited){

    //}
}
