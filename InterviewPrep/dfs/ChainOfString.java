package dfs;

import java.util.*;


/*
Given a list of words, determine whether the words can be chained to form a circle.
A word X can be placed in front of another word Y in a circle if the last character of X is same as the first character of Y.

For example, the words ['chair', 'height', 'racket', touch', 'tunic'] can form the following circle:
 chair --> racket --> touch --> height --> tunic --> chair
 */


/*

Notes:
How to check eulerian circuit.... ( in directed graph )
-> Then we need to make sure that there is single strongly connected component, and since we know that all nodes have their indegree and outdegree same, therefore we can apply DFS and check if all nodes are visited by a single DFS........ we can also use kosaraju here and check if there is a single connected component.
-> We need to make sure that all the nodes have their indegree and outdegree same ( if not, it will not be eulerian ckt. )

Checking eulerian ckt in undirected graph
-> here, we need to make sure that all nodes have even degree
-> then here also , we can apply DFS and check if all nodes are in single component



How to check if a directed graph is eulerian?

A directed graph has an eulerian cycle if following conditions are true

All vertices with nonzero degree belong to a single strongly connected component.
In degree is equal to the out degree for every vertex.
* */

public class ChainOfString {

    public static void main(String[] args){
        String[] input = new String[]{"chair", "height", "racket", "touch", "tunic"};
        possibleChainOfStrings(input);
    }

    static void possibleChainOfStrings(String[] input){
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, Integer> outDegree = new HashMap<>();

        for(String word : input){
            char fc = word.charAt(0);
            char lc = word.charAt(word.length()-1);

            graph.putIfAbsent(fc, new ArrayList<>());
            graph.get(fc).add(lc);

            inDegree.put(lc, inDegree.getOrDefault(lc, 0)+1);
            outDegree.put(fc, outDegree.getOrDefault(fc,0)+1);
        }

        Set<Character> visited = new HashSet<>();
        dfs(graph, input[0].charAt(0), visited);

        boolean isConnected = graph.keySet().size() == visited.size();

        if (isConnected && isInOutDegreeEqual(inDegree, outDegree)){
            System.out.println("Strings are chained");
        } else {
            System.out.println("unchained");
        }

    }

    static void dfs(Map<Character, List<Character>> graph, Character source, Set<Character> visited){

        if (visited.contains(source))
            return;

        visited.add(source);

        if (!graph.containsKey(source))
            return;

        for(char c : graph.get(source)){
            dfs(graph, c, visited);
        }
    }

    static boolean isInOutDegreeEqual(Map<Character, Integer> inDegree, Map<Character, Integer> outDegree){
        for(char c : inDegree.keySet()){
            if (inDegree.get(c) != outDegree.get(c))
                return false;
        }
        return true;
    }
}
