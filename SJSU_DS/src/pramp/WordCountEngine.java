/******************************************************************************

 input:  document = "Practice makes perfect. you'll only
 get Perfect by practice. just practice!"

 output: [ ["practice", "3"], ["perfect", "2"],
 ["makes", "1"], ["youll", "1"], ["only", "1"],
 ["get", "1"], ["by", "1"], ["just", "1"] ]

 *******************************************************************************/
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main
{
    static String[][] wordCountEngine(String document){
        String[] words = document.split(" ");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word : words){
            word = word.toLowerCase();
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()){
                if (Character.isLetter(c)) // c >= 'a' and c <= 'z'
                    sb.append(c);
            }
            frequencyMap.put(sb.toString(), frequencyMap.getOrDefault(sb.toString(), 0)+1);
        }

        /*PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> (e2.getValue() - e1.getValue()));
        for (Map.Entry<String, Integer> e : frequencyMap.entrySet()){
          pq.add(e);
        }

        String[][] res = new String[frequencyMap.size()][2];
        int i=0;
        while(!pq.isEmpty()){
          Map.Entry<String, Integer> e = pq.poll();
          res[i++] = new String[]{e.getKey(), String.valueOf(e.getValue())};
        }*/

        Map<String, Integer> sorted = frequencyMap.entrySet().stream().sorted(
                Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(
                Collectors.toMap(Map.Entry :: getKey, Map.Entry:: getValue, (e1, e2) -> e2, LinkedHashMap::new));

        String[][] res = new String[frequencyMap.size()][2];
        int i=0;
        for (String key : sorted.keySet()){
            res[i++] = new String[]{key, String.valueOf(sorted.get(key))};
        }
        return res;
    }

    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        String[][] res = wordCountEngine(document);
        for (String[] rec : res){
            System.out.println(rec[0].toString() + " : "+ rec[1].toString());
        }
    }
}
