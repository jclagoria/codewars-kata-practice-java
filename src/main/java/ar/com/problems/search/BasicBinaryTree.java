package ar.com.problems.search;

/**
 * Basic binary search tree implementation.
 * Supports insertion and various tree traversals.
 */
public class BasicBinaryTree {

    Node root;

    /**
     * Constructs an empty binary tree.
     */
    public BasicBinaryTree() {
        root = null;
    }

    /**
     * Inserts a new value into the binary search tree.
     * Values smaller than the root go to the left subtree;
     * values greater than or equal to the root go to the right subtree.
     *
     * @param data the integer value to insert
     */
    public void insert(int data) {
        root = insertRec(root, data);
    }

    /**
     * Recursively inserts a new node at the appropriate position.
     *
     * @param root the current root of the subtree
     * @param data the value to insert
     * @return the updated root of the subtree
     */
    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Traversals

    /**
     * Performs inorder traversal (Left, Root, Right) and prints each node.
     * For BST, this outputs values in sorted order.
     */
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    /**
     * Recursively performs inorder traversal.
     *
     * @param root the current root of the subtree
     */
    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data + " ");
            inorderRec(root.right);
        }
    }

    /**
     * Performs postorder traversal (Left, Right, Root) and prints each node.
     * Useful for tree deletion or evaluating expressions.
     */
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    /**
     * Recursively performs postorder traversal.
     *
     * @param root the current root of the subtree
     */
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.data + " ");
        }
    }

}
