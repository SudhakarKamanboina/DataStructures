package bfs;

import java.util.*;

/*
Given a start word, an end word, and a dictionary of valid words, find the shortest transformation sequence
from start to end such that only one letter is changed at each step of the sequence, and each transformed
word exists in the dictionary. If there is no possible transformation, return null.
Each word in the dictionary have the same length as start and end and is lowercase.

For example, given start = "dog", end = "cat", and dictionary = {"dot", "dop", "dat", "cat"},
 return ["dog", "dot", "dat", "cat"].
* */

public class WordLadderReturnWords {

    public static void main(String[] args) {

        String r = ladderLength("dog", "cat", Arrays.asList("dot", "dop", "dat", "cat"));
        System.out.println(r);
    }

    public static String ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComb = new HashMap<>();
        int l = beginWord.length();

        for(String word : wordList){
            for(int i=0; i<l; i++){
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.

                String newWord = word.substring(0, i) + "*" + word.substring(i+1, l);
                List<String> comb = allComb.getOrDefault(newWord, new ArrayList<>());
                comb.add(word);
                allComb.put(newWord, comb);
            }
        }

        // Queue for BFS --> we need BFS as multiple words might have same pattern so if one is visted then don't need to visit other
        Queue<Pair> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap();
        queue.add(new Pair(beginWord, beginWord));
        visited.put(beginWord, true);

        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            String word = pair.getKey();
            String wordLadder = pair.getValue();

            for(int i=0; i< l; i++){
                // Intermediate words for current word
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, l);

                // Next states are all the words which share the same intermediate state.
                List<String> adjWords = allComb.getOrDefault(newWord, new ArrayList());
                for(String adjecantWord : adjWords){

                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjecantWord.equals(endWord)){
                        return wordLadder+","+endWord;
                    }

                    if (!visited.containsKey(adjecantWord)){
                        visited.put(adjecantWord, true);
                        queue.add(new Pair(adjecantWord, wordLadder+","+adjecantWord));
                    }
                }
            }
        }

        return null;
    }
}

class Pair{
    String key;
    String val;

    Pair(String k, String i){
        this.key =k;
        this.val= i;
    }

    public String getKey(){
        return key;
    }

    public String getValue(){
        return val;
    }
}
