package ar.com.problems.search;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BasicBinaryTreeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private void captureOutput() {
        System.setOut(new PrintStream(outContent));
    }

    private void restoreOutput() {
        System.setOut(System.out);
    }

    @Test
    void testInsertSingleNode() {
        BasicBinaryTree tree = new BasicBinaryTree();
        tree.insert(5);

        assertNotNull(tree.root);
        assertEquals(5, tree.root.data);
        assertNull(tree.root.left);
        assertNull(tree.root.right);
    }

    @Test
    void testInsertMultipleNodes() {
        BasicBinaryTree tree = new BasicBinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        assertEquals(5, tree.root.data);
        assertEquals(3, tree.root.left.data);
        assertEquals(7, tree.root.right.data);
        assertEquals(2, tree.root.left.left.data);
        assertEquals(4, tree.root.left.right.data);
        assertEquals(6, tree.root.right.left.data);
        assertEquals(8, tree.root.right.right.data);
    }

    @Test
    void testInsertDuplicates() {
        BasicBinaryTree tree = new BasicBinaryTree();
        tree.insert(5);
        tree.insert(5);

        assertEquals(5, tree.root.data);
        assertEquals(5, tree.root.right.data);
    }

    @Test
    void testInorderTraversal() {
        BasicBinaryTree tree = new BasicBinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        captureOutput();
        tree.inorder();
        restoreOutput();

        String expected = "2 \n3 \n4 \n5 \n6 \n7 \n8 \n\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testPostorderTraversal() {
        BasicBinaryTree tree = new BasicBinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        captureOutput();
        tree.postorder();
        restoreOutput();

        String expected = "2 \n4 \n3 \n6 \n8 \n7 \n5 \n\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testEmptyTreeInorder() {
        BasicBinaryTree tree = new BasicBinaryTree();

        captureOutput();
        tree.inorder();
        restoreOutput();

        assertEquals("\n", outContent.toString());
    }

    @Test
    void testEmptyTreePostorder() {
        BasicBinaryTree tree = new BasicBinaryTree();

        captureOutput();
        tree.postorder();
        restoreOutput();

        assertEquals("\n", outContent.toString());
    }

    @Test
    void testSingleNodeInorder() {
        BasicBinaryTree tree = new BasicBinaryTree();
        tree.insert(42);

        captureOutput();
        tree.inorder();
        restoreOutput();

        assertEquals("42 \n\n", outContent.toString());
    }

    @Test
    void testSingleNodePostorder() {
        BasicBinaryTree tree = new BasicBinaryTree();
        tree.insert(42);

        captureOutput();
        tree.postorder();
        restoreOutput();

        assertEquals("42 \n\n", outContent.toString());
    }

    @Test
    void testInsertLeftSkewedTree() {
        BasicBinaryTree tree = new BasicBinaryTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        assertEquals(5, tree.root.data);
        assertEquals(4, tree.root.left.data);
        assertEquals(3, tree.root.left.left.data);
        assertEquals(2, tree.root.left.left.left.data);
        assertEquals(1, tree.root.left.left.left.left.data);
    }

    @Test
    void testInsertRightSkewedTree() {
        BasicBinaryTree tree = new BasicBinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        assertEquals(1, tree.root.data);
        assertEquals(2, tree.root.right.data);
        assertEquals(3, tree.root.right.right.data);
        assertEquals(4, tree.root.right.right.right.data);
        assertEquals(5, tree.root.right.right.right.right.data);
    }

    @Test
    void testInorderRecWithNullRoot() {
        BasicBinaryTree tree = new BasicBinaryTree();

        captureOutput();
        tree.inorderRec(null);
        restoreOutput();

        assertEquals("", outContent.toString());
    }

}
