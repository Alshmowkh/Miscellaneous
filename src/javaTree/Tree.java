package javaTree;

import java.util.Stack;

public class Tree {

    Node root;

    public Tree() {
        root = null;
    }

    void insert(int id, String name, String value) {
        Node node = new Node();
        node.id = id;
        node.name = name;
        node.value = value;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                }
                if (current == null) {
                    parent.rightChild = node;
                    return;
                }
            }
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int banks = 32;
        boolean isRowEmpty = false;
        System.out.println("............................................");

        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int i = 0; i < banks; i++) {
                System.out.print(" ");
                while (globalStack.isEmpty() == false) {
                    Node temp = (Node) globalStack.pop();
                    if (temp != null) {
                        System.out.print(temp.id + " " + temp.name);
                        localStack.push(temp.leftChild);
                        localStack.push(temp.rightChild);

                        if (temp.leftChild != null | temp.rightChild != null) {
                            isRowEmpty = false;
                        } else {
                            System.out.print("--");
                            localStack.push(null);
                            localStack.push(null);
                        }
                        for (int j = 0; j < banks * 2 - 2; j++) {
                            System.out.print(' ');
                        }
                    }
//                    System.out.println();
                    banks /= 2;
                    while (localStack.isEmpty() == false) {
                        globalStack.push(localStack.pop());
                    }
                    System.out.println();
                }
            }
        }
 System.out.println("............................................");
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(20, "A", "a");
        tree.insert(25, "B", "b");
        tree.insert(30, "C", "c");
        tree.insert(4, "D", "d");
        tree.insert(5, "E", "e");
        tree.insert(61, "F", "f");
        tree.insert(7, "G", "g");
        tree.insert(8, "H", "h");
        tree.insert(97, "K", "k");
        tree.insert(10, "J", "j");
//        tree.insert(1, "I", "i");
        tree.displayTree();

    }
}
