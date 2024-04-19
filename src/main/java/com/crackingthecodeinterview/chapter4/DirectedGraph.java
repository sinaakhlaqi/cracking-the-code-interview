package com.crackingthecodeinterview.chapter4;

import com.crackingthecodeinterview.exceptions.NotGraphNodeException;

import java.util.*;

// This is the simple implementation of Directed graph. Disconnected graphs are
// Also taken into account.
public class DirectedGraph<T extends Comparable<?>> implements Graph<Node<T>> {

    private final String name;
    private final Map<String, Node<T>> graph;

    public DirectedGraph(String graphName) {
        this.name = graphName;
        graph = new LinkedHashMap<>();
    }

    @Override
    public boolean setLink(Node<T> nodeA, Node<T> nodeB) {
        if (nodeA.getAdjList().contains(nodeB))
            return false;
        nodeA.setAdj(nodeB);
        nodeB.setParentName(nodeA.getName());
        return true;
    }

    @Override
    public boolean setLink(Node<T> nodeA, Node<T> nodeB, Integer label) {
        if (nodeA.getAdjList().contains(nodeB))
            return false;
        nodeB.setLabel(new Label(label));
        nodeA.setAdj(nodeB);
        nodeB.setParentName(nodeA.getName());
        return true;
    }

    @Override
    public boolean unsetLink(Node<T> nodeA, Node<T> nodeB) {
        if (nodeA.getAdjList().contains(nodeB)) {
            nodeA.getAdjList().remove(nodeB);
            return true;
        }
        return false;
    }

    @Override
    public Node<T> getNodeByName(String nodeName) {
        if (graph.containsKey(nodeName))
            return graph.get(nodeName);
        throw new NotGraphNodeException(nodeName, name);
    }

    @Override
    public Collection<Node<T>> getAllNodes() {
        return List.copyOf(graph.values());
    }

    public void setNode(Node<T> node) {
        if (!graph.containsKey(node.getName())) {
            this.graph.put(node.getName(), node);
        }
    }

    @Override
    public boolean removeNode(Node<T> node) {
        if (graph.containsKey(node.getName())) {
            for (Map.Entry<String, Node<T>> nodeEntry : graph.entrySet()) {
                for (Node<T> adjacent : nodeEntry.getValue().getAdjList()) {
                    if (adjacent == node)
                        getNodeByName(nodeEntry.getKey()).removeAdj(adjacent);
                }
            }
            graph.remove(node.getName());
            return true;
        }
        return false;
    }

    @Override
    public String[] getAllNodeNames() {
        return graph.keySet().toArray(new String[0]);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        int i = 0;
        for (Map.Entry<String, Node<T>> nodeEntry : graph.entrySet()) {
            output.append(String.format("node %s ", nodeEntry.getKey()));
            if (nodeEntry.getValue().getData() != null) {
                output.append(String.format("value: %s\n", nodeEntry.getValue().getData()));
            }
            output.append("adjacent:\n{");
            for (Node<T> adj : nodeEntry.getValue().getAdjList()) {
                output.append(String.format(" %s,", adj.getName()));
            }
            output.append("}\n");
        }
        return output.toString();
    }
}