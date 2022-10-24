package misc;

import java.util.*;

// Amazon Test
/*

Write a function to parse the log data to find distinct users that meet or cross a certain threshold.
The function will take in 2 inputs:

Input 1: Log data in form an array of arrays ["sender_user_id, recipient_user_id, transac_amount", ""]
Input 2: threshold as an integer

Output should be an array of userids that are sorted.

Sample input:
["88 99 200", "99 32 100", "12 12 15"]  threshold=2
output -> ["88", "99"]

If same userid appears in the transaction as userid1 and userid2,
it should count as one occurence, not two.
 */

public class TransactionsLogs {
    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("88 99 200");
        logs.add("88 99 300");
        logs.add("99 32 100");
        logs.add("12 12 15");

        List<String> result = processLogs(logs, 2);
        for (String userId : result)
            System.out.println(userId);
    }

    public static List<String> processLogs(List<String> logs, int threshold){
        Map<String, Integer> users = new HashMap<>();

        for(String log : logs){
            String[] logEnteries = log.split(" ");
            for(int i=0; i<logEnteries.length-1; i++){
                if(i>0 && logEnteries[0].equals(logEnteries[1])){
                    break;
                }
                users.put(logEnteries[i], users.getOrDefault(logEnteries[i], 0)+1);
            }
        }

        List<String> result = new ArrayList<>();
        for(String k : users.keySet()){
            if (users.get(k) >= threshold){
                result.add(k);
            }
        }

        Collections.sort(result, (a, b) -> Integer.valueOf(a) - Integer.valueOf(b));
        return result;
    }


}
