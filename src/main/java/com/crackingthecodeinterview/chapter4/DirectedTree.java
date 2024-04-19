package com.crackingthecodeinterview.chapter4;

import com.crackingthecodeinterview.exceptions.FullyConnectedNode;
import com.crackingthecodeinterview.exceptions.MakeLoopInTreeException;

import java.util.*;

import static com.crackingthecodeinterview.chapter4.GraphUtils.*;


public class DirectedTree<T extends Comparable<?>> {
    private final Graph<Node<T>> tree;
    private final String treeName;
    private String rootName;
    private final int countOfChildes;

    public DirectedTree(String treeName, int countOfChildes) {
        this.treeName = treeName;
        tree = new DirectedGraph<>(treeName);
        this.countOfChildes = countOfChildes;
    }

    public Node<T> getRoot() {
        return tree.getNodeByName(rootName);
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public String getRootName() {
        return rootName;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setChild(Node<T> parent, Node<T> child) {
        if (parent.getAdjList().size() >= countOfChildes) {
            throw new FullyConnectedNode(parent.getName());
        }

        tree.setLink(parent, child);
        if (makesLoop(child, parent))
            throw new MakeLoopInTreeException(parent.getName(), child.getName(), treeName);
        child.setParentName(parent.getName());
    }
    public void setChild(Node<T> parent, Node<T> child,Integer label) {
        if (parent.getAdjList().size() >= countOfChildes) {
            throw new FullyConnectedNode(parent.getName());
        }

        child.setLabel(new Label(label));
        tree.setLink(parent, child);
        if (makesLoop(child, parent))
            throw new MakeLoopInTreeException(parent.getName(), child.getName(), treeName);
        child.setParentName(parent.getName());
    }

    private boolean makesLoop(Node<T> start, Node<T> end) {
        if (start == null)
            return false;
        Stack<Node<T>> path = new Stack<>();
        Set<String> visited = new HashSet<>();
        path.push(start);
        while (!path.isEmpty()) {
            Node<T> nodeInPath = path.pop();
            for (Node<T> nodeInPathChild : nodeInPath.getAdjList()) {
                if (nodeInPathChild == end) {
                    return true;
                } else if (!visited.contains(nodeInPathChild.getName())) {
                    path.push(nodeInPathChild);
                }
                visited.add(nodeInPath.getName());
            }
        }
        return false;
    }

    public Graph<Node<T>> asGraph() {
        return tree;
    }

    public Node<T> getNodeByName(String nodeName) {
        return tree.getNodeByName(nodeName);
    }

    public boolean hasRoot() {
        return this.rootName != null;
    }

    @Override
    public String toString() {
        StringBuilder listOfDepthsString = new StringBuilder();
        List<List<Node<T>>> siblingNodes = new ArrayList<>();
        getListOfDepths(getRoot(), siblingNodes, 0);
        for (List<Node<T>> list : siblingNodes) {
            for (Node<T> nodeInDepth : list) {
                listOfDepthsString.append(String.format("\t%s", nodeInDepth.getName()));
            }
            listOfDepthsString.append("\n");
        }
        return listOfDepthsString.toString();
    }
}