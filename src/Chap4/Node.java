package Chap4;

import java.util.ArrayList;

public class Node {
    public String name;
    public ArrayList<Node> children;

    public Node(String n) {
        name = n;
        children = new ArrayList<>();
    }

    public void addChild(Node n) {
        children.add(n);
    }
}
