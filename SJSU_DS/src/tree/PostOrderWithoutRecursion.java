package tree;


//do have a look
public class PostOrderWithoutRecursion {
	
	// An iterative function to do postorder traversal of a given binary tree
	/*void postOrderIterative(struct Node* root)
	{
	    // Check for empty tree
	    if (root == NULL)
	        return;
	     
	    struct Stack* stack = createStack(MAX_SIZE);
	    do
	    {
	        // Move to leftmost node
	        while (root)
	        {
	            // Push root's right child and then root to stack.
	            if (root->right)
	                push(stack, root->right);
	            push(stack, root);
	 
	            // Set root as root's left child  
	            root = root->left;
	        }
	 
	        // Pop an item from stack and set it as root    
	        root = pop(stack);
	 
	        // If the popped item has a right child and the right child is not
	        // processed yet, then make sure right child is processed before root
	        if (root->right && peek(stack) == root->right)
	        {
	            pop(stack);  // remove right child from stack
	            push(stack, root);  // push root back to stack
	            root = root->right; // change root so that the right 
	                                // child is processed next
	        }
	        else  // Else print root's data and set root as NULL
	        {
	            printf("%d ", root->data);
	            root = NULL;
	        }
	    } while (!isEmpty(stack));
	}*/

}
