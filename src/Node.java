/*
 * @file: Node.java
 * @description: This program creates the node class used in the BST class to create the nodes for a binary tree.
 * @author: Andrew Young
 * @date: September 25th 2024
 */

//@Class: Node - class for the individual nodes to be used in the binary search trees.
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    // Declare class attributes
    private T element;
    private Node<T> left;
    private Node<T> right;

    // Implement the constructor method
    public Node(T value){
        this.element = value;
        this.left = null;
        this.right = null;
    }
    // Implement the constructor method when children are specified
    public Node(T value, Node<T> lchild, Node<T> rchild){
        this.element = value;
        this.left = lchild;
        this.right = rchild;
    }

    // Implement the setElement method, which sets the node element based on the input
    public void setElement(T newValue){
        element = newValue;
    }

    // Implement the setLeft method, which sets the left child node based on the input
    public void setLeft(Node<T> lchild){
        left = lchild;
    }

    // Implement the setRight method, which sets the right child node based on the input
    public void setRight(Node<T> rchild){
        right = rchild;
    }

    // Implement the getLeft method, which returns the left child
    public Node<T> getLeft(){
        return left;
    }

    // Implement the getRight method, which returns the right child
    public Node<T> getRight(){
        return right;
    }

    // Implement the getElement method, which returns the value of the node selected
    public T getElement(){
        return element;
    }

    // Implement the isLeaf method, which returns a boolean value stating whether the node is a leaf or not
    public boolean isLeaf(Node<T> leaf){
        return (leaf.left == null && leaf.right == null);
    }

    // Implement the Override for compareTo, necessary due to using comparable interface. Method is now able to handle null nodes properly
    @Override
    public int compareTo(Node<T> otherNode){
        if (otherNode == null) {
            throw new NullPointerException("Cannot compare to null Node.");
        }
        return this.element.compareTo(otherNode.getElement());
    }
}
