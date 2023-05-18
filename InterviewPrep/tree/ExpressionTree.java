package tree;

import java.util.Stack;

// This was asked by MongoDB
//https://www.geeksforgeeks.org/expression-tree/
// postfix to binary expression tree

public class ExpressionTree {
    public static void main(String[] args) {
        Node node = buildExpressionTree("ABC*+D/");
        inorder(node);
    }

    private static Node buildExpressionTree(String postfix){
        Stack<Node> stack = new Stack<>();
        Node t1, t2, temp;

        for(char ch : postfix.toCharArray()){
            if (isOperator(ch)){
                temp = new Node(ch);
                t1 = stack.pop();
                t2 = stack.pop();

                temp.left = t2;
                temp.right = t1;
                stack.push(temp);
            } else {
                stack.push(new Node(ch));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(char ch){
        if (ch == '+' || ch == '-' || ch == '/' || ch == '*'){
            return true;
        }
        return false;
    }

    private static void inorder(Node root){
        if (root == null){
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    static class Node{
        char data;
        Node left, right;

        Node(char data){
            this.data = data;
            left = right =null;
        }
    }
}


