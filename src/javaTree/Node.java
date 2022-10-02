package javaTree;

public class Node {

    int id;
    String name;
    String value;
    Node leftChild;
    Node rightChild;

    void displayNode() {
        System.out.print(id + "\t");
        System.out.print(name + "\t");
        System.out.println(value + "\t");

    }
}
