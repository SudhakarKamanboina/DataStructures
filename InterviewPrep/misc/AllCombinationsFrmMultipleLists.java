/*

Write an iterator to go through combinations of multiple arrays E.g.
input [1,2,3] [4,5,6] [7,8]
output 147, 148, 157, 158, 167, 168..., 368
 */


package misc;

import java.util.*;

public class AllCombinationsFrmMultipleLists {


    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(4);
        l2.add(5);
        l2.add(6);

        List<Integer> l3 = new ArrayList<>();
        l3.add(7);
        l3.add(8);

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        List<Integer> result = new ArrayList<>();
        allCombinations(lists, result, 0, "");

        for(Integer i: result){
            System.out.println(i);
        }
    }

    public static void allCombinations(List<List<Integer>> lists, List<Integer> result, int depth, String current){

        if(depth == lists.size()){
            result.add(Integer.parseInt(current));
            return;
        }

        for(int i=0; i<lists.get(depth).size(); i++){
            allCombinations(lists, result, depth+1, current + lists.get(depth).get(i));
        }
    }

}
