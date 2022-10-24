package tree;

import java.util.*;

/*
                    0
                /   |     \
            5       3         6
       /          /    \    /   \
     4         2       9    1      5

Given the rootNode of the tree in diagram above
Your function would return: 5 since it’s the minimal Sales Path cost
(there are actually two Sales Paths in the tree whose cost is 5: 0→3→2 )
*/

public class SalesPath {

    public static void main(String[] args) {
        Node input = new Node(0); //level1

        input.children.add(new Node(5)); // level2
        input.children.add(new Node(3));
        input.children.add(new Node(6));

        input.children.get(0).children.add(new Node(4)); // level3
        input.children.get(1).children.add(new Node(2));
        input.children.get(1).children.add(new Node(9));
        input.children.get(2).children.add(new Node(1));
        input.children.get(2).children.add(new Node(5));

        int res = getCheapestCost(input);
        System.out.println(res);
    }

    private static int getCheapestCost(Node root){
        if (root.children == null || root.children.size() == 0){
            return root.cost;
        }

        int minCost = Integer.MAX_VALUE;

        for(Node child : root.children){
            System.out.println(child.cost);
            int currCost = getCheapestCost(child);
            minCost = Math.min(currCost, minCost);
        }

        return minCost + root.cost;
    }


}

class Node{
    int cost;
    List<Node> children;

    Node(int c){
        cost = c;
        children = new ArrayList<>();
    }
}
