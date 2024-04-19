package com.crackingthecodeinterview.chapter4;

import java.util.*;


public class Node<T extends Comparable<?>> {

    private final Map<String, Node<T>> adjacent;
    private final String name;
    private T data;
    private final List<String> parentsName;
    private Label label;

    public Node(String name) {
        this.name = name;
        this.adjacent = new LinkedHashMap<>();
        this.parentsName = new ArrayList<>();
    }

    public Node(String name, T data) {
        this(name);
        this.data = data;
    }

    public Node(String name, Label label) {
        this(name);
        this.label = label;
    }

    public Node(String name, T data, Label label) {
        this(name, data);
        this.label = label;
    }

    public boolean setAdj(Node<T> adj) {
        if (adjacent.containsKey(adj.getName()))
            return false;
        adjacent.put(adj.getName(), adj);
        return true;
    }

    public boolean setAdj(Node<T> adj, Label label) {
        if (adjacent.containsKey(adj.getName()))
            return false;
        adj.setLabel(label);
        adjacent.put(adj.getName(), adj);
        return true;
    }

    public boolean removeAdj(Node<T> adj) {
        if (adjacent.containsKey(adj.getName())) {
            adjacent.remove(adj.getName());
            return true;
        }
        return false;
    }

    public List<Node<T>> getAdjList() {
        return adjacent.values().stream().toList();
    }

    @Override
    public String toString() {
        StringBuilder output =
                new StringBuilder(String.format("%s |->", name));
        for (Map.Entry<String, Node<T>> adj : adjacent.entrySet()) {
            output.append(String.format("%s , ", adj.getKey()));
        }
        return String.format("%s\n", output.substring(0, output.length() - 3));
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public List<String> getParentsName() {
        return List.copyOf(parentsName);
    }

    public void setParentName(String parentName) {
        this.parentsName.add(parentName);
    }

    public Label getLabel() {
        return label;
    }

    public Node<T> getAdj(int label) {
        for (Map.Entry<String, Node<T>> adj : adjacent.entrySet()) {
            if (adj.getValue().getLabel().label() == label)
                return adj.getValue();
        }
        return null;
    }

    public Node<T> getAdj(String name) {
        for (Map.Entry<String, Node<T>> adjEntry : adjacent.entrySet()) {
            if (adjEntry.getKey().equals(name))
                return adjEntry.getValue();
        }
        return null;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}