package binarysearchtree;

/**
 *
 * @author anastasios
 */
public class BinarySearchTree {
    private Node root;

    public void add(int v){
        root = add(root, v);
    }
    
    public boolean search(int v){
        return searchNode(root, v);
    }
    
    public Node add(Node current, int addingValue) {
        if (current == null) {
            return new Node(addingValue);
        }
        if (addingValue < current.getValue()) {
            current.setLeft(add(current.getLeft(), addingValue));
        } else if (addingValue == current.getValue()) {
            return current;
        } else {
            current.setRight(add(current.getRight(), addingValue));
        }
        return current;
    }

    public boolean searchNode(Node current, int findingValue) {
        if (current == null) {
            return false;
        }
        if (findingValue == current.getValue()) {
            return true;
        } else if (findingValue > current.getValue()) {
            return searchNode(current.getRight(), findingValue);
        } else {
            return searchNode(current.getLeft(), findingValue);
        }
    }

    public void printTreeInOrder(Node rootNode) {
        if (rootNode != null) {
            printTreeInOrder(rootNode.getLeft());
            System.out.print(rootNode.getValue() + " ");
            printTreeInOrder(rootNode.getRight());
        }
    }
    
    public static void main(String [] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(13);
        System.out.println("ldfk="+tree.search(30));
        tree.printTreeInOrder(tree.root);
        
    }
}
