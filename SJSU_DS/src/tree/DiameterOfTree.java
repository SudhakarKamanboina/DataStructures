package tree;
import java.util.*;

public class DiameterOfTree
{
    public DiameterOfTree()
    {
    }
 
    public int diameterOfBinaryTree(Node node)
    {
        if (node == null)
        {
            return 0;
        }
 
        int leftHeight = heightOfBinaryTree(node.left);
        int rightHeight = heightOfBinaryTree(node.right);
 
        int leftDiameter = diameterOfBinaryTree(node.left);
        int rightDiameter = diameterOfBinaryTree(node.right);
 
        return Math.max(leftHeight + rightHeight + 1,
            Math.max(leftDiameter, rightDiameter));
    }
    
    public int diameterOfTree(Node root, int diameter)
    {
        int left, right;
        if(root == null)
            return 0;
        left = diameterOfTree(root.left, diameter);
        right = diameterOfTree(root.right, diameter);
        if((left + right) > diameter)
            diameter = left+right;
        return Math.max(Math.max(left, right)+1, diameter);
    }
 
    public int heightOfBinaryTree(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        else
        {
            return 1 +
            Math.max(heightOfBinaryTree(node.left),
                heightOfBinaryTree(node.right));
        }
    }
 
    public static void main(String[] args)
    {
        /*
        Constructing following tree
                        1
                    2         3
                4       5  6     7
            8       9
                 10     11
                                                        */
        BinaryTree binaryTree = new BinaryTree();
 
        binaryTree.create(1);
 
        Node root = binaryTree.search(1);
        binaryTree.add(root, 2, BinaryTree.LEFT);
        binaryTree.add(root, 3, BinaryTree.RIGHT);
        binaryTree.add(binaryTree.search(2), 4, BinaryTree.LEFT);
        binaryTree.add(binaryTree.search(2), 5, BinaryTree.RIGHT);
        binaryTree.add(binaryTree.search(3), 6, BinaryTree.LEFT);
        binaryTree.add(binaryTree.search(3), 7, BinaryTree.RIGHT);
        binaryTree.add(binaryTree.search(4), 8, BinaryTree.LEFT);
        binaryTree.add(binaryTree.search(4), 9, BinaryTree.RIGHT);
        binaryTree.add(binaryTree.search(9), 10, BinaryTree.LEFT);
        binaryTree.add(binaryTree.search(9), 11, BinaryTree.RIGHT);
        System.out.println("Binary Tree in level order is .... ");
        binaryTree.printLevelOrder();
 
        DiameterOfTree diaTree = new DiameterOfTree();
        System.out.println("Diameter is ....  " +
            diaTree.diameterOfBinaryTree(root) + " new one " +diaTree.diameterOfTree(root, 1));
    }
}

class Node
{
    Node left;
    Node right;
    Node parent;
    int data;
}


class BinaryTree
{
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";
    private Node root;
 
    public BinaryTree()
    {
    }
 
    public void create(int currentData)
    {
        if (root == null)
        {
            root = new Node();
        }
 
        root.data = currentData;
    }
 
    public void add(Node node, int currentData, String currentPosition)
    {
        if (node == null)
        {
            return;
        }
 
        Node currentNode = new Node();
        currentNode.data = currentData;
 
        if (LEFT.equals(currentPosition))
        {
            node.left = currentNode;
        }
        else if (RIGHT.equals(currentPosition))
        {
            node.right = currentNode;
        }
    }
    
    public Node search(int searchData)
    {
        if (root == null)
        {
            return null;
        }
 
        return search(searchData, root);
    }
 
    private Node search(int searchData, Node node)
    {
        if (node == null)
        {
            return null;
        }
 
        // Level order traversal to return the node
        LinkedList queueList = new LinkedList();
        queueList.add(node);
 
        Node currNode = null;
 
        while (!queueList.isEmpty())
        {
            currNode = (Node) queueList.removeFirst();
 
            if (currNode.data == searchData)
            {
                break;
            }
            else
            {
                if (currNode.left != null)
                {
                    queueList.add(currNode.left);
                }
 
                if (currNode.right != null)
                {
                    queueList.add(currNode.right);
                }
            }
        }
 
        return currNode;
    }
 
    public void printLevelOrder()
    {
        printLevelOrder(root);
        System.out.println();
    }
 
    public void printLevelOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
 
        LinkedList queueList = new LinkedList();
        queueList.add(node);
 
        Node currNode = null;
 
        while (!queueList.isEmpty())
        {
            currNode = (Node) queueList.removeFirst();
            System.out.print(currNode.data + "    ");
 
            if (currNode.left != null)
            {
                queueList.add(currNode.left);
            }
 
            if (currNode.right != null)
            {
                queueList.add(currNode.right);
            }
        }
        System.out.println();
    }
}