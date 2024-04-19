package com.crackingthecodeinterview.chapter4;

import com.crackingthecodeinterview.exceptions.FullyConnectedNode;
import com.crackingthecodeinterview.exceptions.NodeAlreadyHasConnectionException;


public class BinaryTree<T extends Comparable<?>> {
    private final DirectedTree<T> binaryTree;

    public BinaryTree(String name) {
        binaryTree = new DirectedTree<>(name, 2);
    }

    public Node<T> getRoot() {
        return (Node<T>) binaryTree.getNodeByName(binaryTree.getRootName());
    }

    public void setRootName(String rootName) {
        binaryTree.setRootName(rootName);
    }

    public String getRootName() {
        return binaryTree.getRootName();
    }

    public String getTreeName() {
        return binaryTree.getTreeName();
    }

    public void setChild(Node<T> parent, Node<T> child, int label) {
        switch (parent.getAdjList().size()) {
            case 0 -> {
                binaryTree.setChild(parent, child, label);
            }
            case 1 -> {
                if (parent.getAdjList().get(0).getLabel().label() == label) {
                    throw new
                            NodeAlreadyHasConnectionException
                            (parent.getName(), child.getLabel().label());
                }
                binaryTree.setChild(parent, child, label);
            }
            case 2 -> {
                throw new FullyConnectedNode(parent.getName());
            }
        }
    }

    public Node<T> getChild(Node<T> parent, int label) {
        switch (parent.getAdjList().size()) {
            case 0 -> {
                return null;
            }
            case 1 -> {
                return (parent.getAdjList().get(0).getLabel().label() == label) ?
                        parent.getAdjList().get(0) : null;
            }
            case 2 -> {
                return (parent.getAdjList().get(0).getLabel().label() == label) ?
                        parent.getAdjList().get(0) :
                        parent.getAdjList().get(1);
            }
        }
        return null;
    }

    public Graph<Node<T>> asGraph() {
        return binaryTree.asGraph();
    }

    public Node<T> getNodeByName(String nodeName) {

        return binaryTree.getNodeByName(nodeName);
    }

    public boolean hasRoot() {
        return binaryTree.hasRoot();
    }
}
