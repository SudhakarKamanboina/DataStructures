package problems;

public class BstToDll
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}


class Node
{
    int data;
    Node left;
    Node right;
    
    
    Node(int d)
    {
        this.data = d;
        this.left = null;
        this.right = null;
    }
    
    public int getData()
    {
        return data;
    }
    public void setData(int data)
    {
        this.data = data;
    }
    public Node getLeft()
    {
        return left;
    }
    public void setLeft(Node left)
    {
        this.left = left;
    }
    public Node getRight()
    {
        return right;
    }
    public void setRight(Node right)
    {
        this.right = right;
    }
    
    
}