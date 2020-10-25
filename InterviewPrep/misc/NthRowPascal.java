package misc;

import java.util.ArrayList;
import java.util.List;


/*

Pascal's triangle

1
1 1
1 2 1
1 3 3  1
1 4 6  4  1
1 5 10 10 5 1
1 6 15 20 15 6 1


*/
public class NthRowPascal {
    public static void main (String[] args) {
        System.out.println("Hello Java");

        List<Integer> result = getKthRowPascal(3);
        for(int val : result){
            System.out.println(val);
        }
    }

    public static List<Integer> getKthRowPascal(int k) {

        // getKthRowPascal(5) -> [1, 4, 6, 4, 1]
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(1);

        if (k == 0){
            return curr;
        }

        List<Integer> prev = getKthRowPascal(k-1);

        for (int i=1; i<prev.size(); i++){
            int sum = prev.get(i-1) + prev.get(i);
            curr.add(sum);
        }

        curr.add(1);
        return curr;

    }
}
