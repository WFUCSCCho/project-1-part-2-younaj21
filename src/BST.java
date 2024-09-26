import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/*
 * @file: BST.java
 * @description: This program creates the BST class which implements iterable. This uses the node class to create the overall binary search tree.
 * @author: Andrew Young
 * @date: September 25th 2024
 */

//@Class: BST - class for the total binary search tree which implements Iterable in order to be traversal
public class BST<T extends Comparable<T>> implements Iterable {
    // Declare class attributes
    private Node<T> root;
    private int nodeAmount;

    // Implement the constructor
    public BST(){
        root = null;
        nodeAmount = 0;
    }

    // Implement the constructor with a length specified
    public BST(Node<T> rootNode, int count){
        root = rootNode;
        nodeAmount = count;
    }

    // Implement the clear method, which resets the BST back to being blank
    public void clear(){
        root = null;
        nodeAmount = 0;
    }

    // Implement the size method, which returns the size of the BST
    public int size(){
        return nodeAmount;
    }

    // Implement the insert method, which takes the input value and creates a node for it
    public void insert(T keyValue){
        root = insertHelper(root, keyValue);
    }

    // Implement the insertHelper function, a helper function that assists insert by placing the node within the BST
    private Node<T> insertHelper(Node<T> rootHelp, T key) {
        if (rootHelp == null) return new Node<T>(key); //if the root is null, then create the tree
        if (rootHelp.getElement().compareTo(key) > 0) // if the new node is greater than the compared to node recursively move to the left subtree
            rootHelp.setLeft(insertHelper(rootHelp.getLeft(), key));
        else // if the new node is less than or equal than the compared to node recursively move to the right subtree
            rootHelp.setRight(insertHelper(rootHelp.getRight(), key));
        return rootHelp;
    }

    // Implement the remove method, which removes the specified value and its node from the BST
    public T remove(T keyValue){
        T temporary = searchHelper(root, keyValue);
        if (temporary != null){
            root = removeHelper(root, keyValue); // function that removes the specified node
            nodeAmount--;
            return temporary;
        }
        return null; // if the value does not have a node in the BST then return null
    }

    // Implement the search method, which initiates the search for the node with the specified value
    public T search(T keyValue) {
        return searchHelper(root, keyValue);
    }

    // Implement the searchHelper method, which performs the search for the node with the specified value. If no such node exists, then the method returns null
    private T searchHelper(Node<T> node, T keyValue) {
        if (node == null) {
            return null; // Base case: If the node is null, the value isn't in the tree
        }

        if (node.getElement().equals(keyValue)) {
            return node.getElement(); // Found the value and return it
        } else if (node.getElement().compareTo(keyValue) > 0) {
            return searchHelper(node.getLeft(), keyValue); // Search in the left subtree
        } else {
            return searchHelper(node.getRight(), keyValue); // Search in the right subtree
        }
    }

    // Implement the deleteMaximum method, which finds and removes the largest value node in the BST
    private Node<T> deleteMaximum(Node<T> chosenNode){
        if (chosenNode.getRight() == null) return chosenNode.getLeft(); // if there is no longer a right child then the largest node has been discovered
        chosenNode.setRight(deleteMaximum(chosenNode.getRight())); // continue moving rightwards otherwise
        return chosenNode;
    }

    // Implement the getMaximum method, which finds and returns the node with the maximum value within the BST
    private Node<T> getMaximum(Node<T> chosenNode) {
        if (chosenNode.getRight() == null) return chosenNode; // Once again if there are no more right children than the largest node has been discovered
        return getMaximum(chosenNode.getRight());
    }

    // Implement the removeHelper method, which assists the remove method by performing the actual removal of the specified node
    private Node<T> removeHelper(Node<T> rootNode, T keyValue) {
        if (rootNode == null) {
            return null;
        }
        if (rootNode.getElement().compareTo(keyValue) > 0)
            rootNode.setLeft(removeHelper(rootNode.getLeft(), keyValue)); // recursive calls to move to the left or right subtree depending on how the value compares to the inputted Node
        else if (rootNode.getElement().compareTo(keyValue) < 0)
            rootNode.setRight(removeHelper(rootNode.getRight(), keyValue));
        else { // Executes if the keyValue is equal to the rootNode's element, which means it has found the node
            if (rootNode.getLeft() == null) {
                return rootNode.getRight();
            } else if (rootNode.getRight() == null) {
                return rootNode.getLeft();
            } else {
                Node<T> temporary = getMaximum(rootNode.getLeft());
                rootNode.setElement(temporary.getElement());
                rootNode.setLeft(deleteMaximum(rootNode.getLeft()));
            }
        }
        return rootNode;
    }


    // Implement the iterator method, which is an override with the new BSTIterator class
    @Override
    public Iterator<T> iterator() {
        return new BSTIterator(root);
    }

    //@Class: BSTIterator - class which adds the functionality of making the BST iterable
    private class BSTIterator implements Iterator<T> {
        // Use a stack to implement the iterable BST
        private Stack<Node<T>> stack = new Stack<>();

        // Implement the constructor for the iterator
        public BSTIterator(Node<T> root) {
            pushLeftNodes(root);
        }

        // Implement the pushLeftNodes method to tell the stack to push left nodes onto the BST stack
        private void pushLeftNodes(Node<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }

        // Implement the override hasNext() method, which is used to check if there are any additional nodes in the iteration
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        // Implement the override next() method, which in this implementation operates in the inOrder traversal method
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the BST");
            }

            // Pop the top node from the stack (smallest remaining node)
            Node<T> current = stack.pop();
            T result = current.getElement();

            // If the node has a right child, push all its left descendants
            if (current.getRight() != null) {
                pushLeftNodes(current.getRight());
            }

            return result;
        }
    }
}