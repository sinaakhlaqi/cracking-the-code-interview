package com.crackingthecodeinterview.chapter4;

import java.util.*;
import java.util.function.*;

import static com.crackingthecodeinterview.utilities.Constants.*;

public class GraphUtils {

    public static <T extends Comparable<?>> void
    initGraphNodes(Graph<Node<T>> graph, String[] nodeNames, T[] data) {
        for (int i = 0; i < nodeNames.length; i++) {
            graph.setNode(new Node<>(nodeNames[i], data[i]));
        }
    }

    public static <T extends Comparable<?>> void
    initGraphNodes(Graph<Node<T>> graph, String[] nodeNames, T[] data, Label[] label) {
        for (int i = 0; i < nodeNames.length; i++) {
            graph.setNode(new Node<>(nodeNames[i], data[i], label[i]));
        }
    }

    public static <T extends Comparable<?>> void
    initGraphNodes(Graph<Node<T>> graph, String[] nodeNames, Label[] label) {
        for (int i = 0; i < nodeNames.length; i++) {
            graph.setNode(new Node<>(nodeNames[i], label[i]));
        }
    }

    public static <T extends Comparable<?>> void initGraphNodes(Graph<Node<T>> graph, String[] nodeNames) {
        for (String nodeName : nodeNames) {
            graph.setNode(new Node<>(nodeName));
        }
    }

    public static <T extends Comparable<?>> void
    getListOfDepths(Node<T> root, List<List<Node<T>>> listOfDepths, int depth) {
        if (root == null)
            return;
        if (listOfDepths.size() == depth)
            listOfDepths.add(new ArrayList<>());
        listOfDepths.get(depth).add(root);
        for (Node<T> child : root.getAdjList()) {
            getListOfDepths(child, listOfDepths, (depth + 1));
        }
    }

    public static <T extends Comparable<?>, N extends Node<T>> void initGraphEdges(Graph<N> graph, int[][] adj) {
        String[] nodeNames = graph.getAllNodeNames();
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[0].length; j++) {
                if (adj[i][j] == 1) {
                    graph.setLink(graph.getNodeByName(nodeNames[i]),
                            graph.getNodeByName(nodeNames[j]));
                }
            }
        }
    }

    public static <T extends Comparable<?>, N extends Node<T>> int longestPath(N root) {
        int childHeight = 0;
        if ((root == null) || (root.getAdjList().isEmpty())) {
            return 0;
        }
        int max = -1;
        for (Node<T> child : root.getAdjList()) {
            childHeight = longestPath(child) + 1;
            if (childHeight > max)
                max = childHeight;
        }
        return childHeight;
    }

    public static <O, T extends Comparable<?>> void
    breathFirstVisit(Node<T> root, BiConsumer<Node<T>, O> visitor,
                     O output) {
        List<Node<T>> queue = new ArrayList<>();
        Set<Node<T>> visited = new HashSet<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> temp = queue.remove(0);
            visitor.accept(temp, output);
            for (Node<T> adj : temp.getAdjList()) {
                if (!visited.contains(adj) && !queue.contains(adj)) {
                    queue.add(adj);
                }
            }
            visited.add(temp);
        }
    }

    public static <O, T extends Comparable<?>> void
    depthFirstSearch(Node<T> root, BiConsumer<Node<T>, O> visitor, O output) {
        Stack<Node<T>> stack = new Stack<>();
        Set<Node<T>> visited = new HashSet<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node<T> temp = stack.pop();
            visitor.accept(temp, output);
            for (Node<T> adj : temp.getAdjList()) {
                if (!visited.contains(adj) && !stack.contains(adj)) {
                    stack.push(adj);
                }
            }
            visited.add(temp);
        }
    }
    public static <T extends Comparable<?>>
    void inOrderVisit(Node<T> root, Consumer<Node<T>> visitor) {
        Node<T> left = root.getAdj(LEFT_LABEL);
        Node<T> right = root.getAdj(RIGHT_LABEL);
        if (left != null)
            inOrderVisit(left, visitor);
        visitor.accept(root);
        if (right != null)
            inOrderVisit(right, visitor);
    }
}