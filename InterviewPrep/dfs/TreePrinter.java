package dfs;

import java.util.*;
// asked in google
/* Write a function to print given tree to stdout.
---> input is list of relations: paris of "parent -> child" relationships.
---> the input list may contain relations in any oder
* */

public class TreePrinter {

    public static void main(String[] args){
        List<Relation> input = new ArrayList<>();
        input.add(new Relation("animal", "mammal"));
        input.add(new Relation("animal", "bird"));
        input.add(new Relation("lifeform", "animal"));
        input.add(new Relation("cat", "lion"));
        input.add(new Relation("mammal", "cat"));
        input.add(new Relation("animal", "fish"));

        printTree(input);
    }

    public static void printTree(List<Relation> input){
        // parent -> list of childrens (adj list)
        Map<String, List<String>> map = new HashMap<>();
        // record all childs, this will be used later to figure out root
        Set<String> set = new HashSet<>();

        for(Relation record : input){
            set.add(record.child);
            List<String> childs = map.getOrDefault(record.parent, new ArrayList<>());
            childs.add(record.child);
            map.put(record.parent, childs);
        }

        // find root
        String root=null;
        for(String key : map.keySet()){
            if (!set.contains(key)){
                root = key;
                break; // break once root is found
            }
        }

        dfs(root, map, 0);
    }

    public static String getTabs(int val){
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<val){
            sb.append("\t");
            i++;
        }
        return sb.toString();
    }

    public static void dfs(String root, Map<String, List<String>> map, int depth){

        System.out.println(getTabs(depth) + root);
        List<String> childs = map.getOrDefault(root, new ArrayList<>());
        for(String child : childs){
            dfs(child, map, depth+1);
        }
    }


    public static class Relation{
        String parent;
        String child;

        Relation(String parent, String child){
            this.parent = parent;
            this.child = child;
        }
    }
}
