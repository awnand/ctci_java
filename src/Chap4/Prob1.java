package Chap4;

import java.util.HashSet;
import java.util.Stack;

public class Prob1  {
    // A simple DFS algorithm to test the existence of a path between two Nodes.
    public static boolean containsPath(Node start, Node end) {
        HashSet<Node> visted = new HashSet<>();
        Stack<Node> queue = new Stack<>();
        queue.push(start);
        while (!queue.isEmpty()) {
            Node currNode = queue.pop();
            for (Node adjNode : currNode.children) {
                if (!visted.contains(adjNode)) {
                    if (adjNode == end) {
                        return true;
                    }
                    visted.add(adjNode);
                    queue.push(adjNode);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Create a graph that resembles a simple line like path except with a cycle in the middle.
        Node start = new Node("Start");
        Node node1 = new Node("Node 1");
        Node node2 = new Node("Node 2");
        Node node3 = new Node("Node 3");
        Node node4 = new Node("Node 4");
        Node node5 = new Node("Node 5");
        Node node6 = new Node("Node 6");
        Node node7 = new Node("Node 7");
        // The cycle starts with node2 and it exits from node5 to node6.
        start.addChild(node1);
        node1.addChild(node2);
        node2.addChild(node3);
        node2.addChild(node4);
        node3.addChild(node5);
        node4.addChild(node5);
        node5.addChild(node6);
        // Expected true
        System.out.println(containsPath(start, node6));
        // Expected false
        System.out.println(containsPath(start, node7));
    }
}
