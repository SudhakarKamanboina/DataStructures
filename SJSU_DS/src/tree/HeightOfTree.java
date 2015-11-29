package tree;

public class HeightOfTree {

	public static void main(String[] args) {
		 /*
        Constructing following tree
                        1
                    2         3
                4       5  6     7
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
        System.out.println(heightOfTree(root));
	}

	private static int heightOfTree(Node root) {
		int left , right;
		if(root == null)
			return 0;
		left = heightOfTree(root.left);
		right = heightOfTree(root.right);
		if(left > right)
			return left+1;
		else
			return right+1;
		
	}

}
