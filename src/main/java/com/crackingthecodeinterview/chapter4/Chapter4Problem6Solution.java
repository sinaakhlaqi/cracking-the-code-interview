package com.crackingthecodeinterview.chapter4;

import static com.crackingthecodeinterview.chapter4.GraphUtils.initGraphEdges;
import static com.crackingthecodeinterview.chapter4.GraphUtils.initGraphNodes;
import static com.crackingthecodeinterview.utilities.Constants.*;

public class Chapter4Problem6Solution {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>("Problem5BinaryTree");

        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[][] adj = {
//                       A  B  C  D  E  F  G  H  I  J
                /*A*/   {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                /*B*/   {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                /*C*/   {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                /*D*/   {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                /*E*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                /*F*/   {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                /*G*/   {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                /*H*/   {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                /*I*/   {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                /*J*/   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        String[] nodeNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        Label[] label = {new Label(LEFT_LABEL), new Label(LEFT_LABEL),
                new Label( RIGHT_LABEL),new Label( RIGHT_LABEL), new Label(LEFT_LABEL),
                new Label( RIGHT_LABEL), new Label(LEFT_LABEL), new Label(LEFT_LABEL),
                new Label( RIGHT_LABEL), new Label(ROOT_LABEL)};
        /* the binaryTree looks like

                  (J=10)
                   /
                (A=1)
                   \
                  (I=9)
                   /
                (H=8)
                 /
              (G=7)
               /
            (B=2)
               \
              (C=3)
                 \
                 (D=4)
                    \
                   (F=6)
                    /
                 (E=5)
        * */
        binaryTree.setRootName("J");
        initGraphNodes(binaryTree.asGraph(), nodeNames, data, label);
        initGraphEdges(binaryTree.asGraph(), adj);
        String nodeName = "J";
        Node<Integer> next = getNextBSTNode(binaryTree, binaryTree.getNodeByName(nodeName));
        if (next != null)
            System.out.printf("the next node of %s is %s", nodeName, next.getName());
        else
            System.out.printf("the node %s has not next", nodeName);
    }

    //4.6 Successor: Write an algorithm to find the "next" node
    //    (i.e., in-order successor) of a given node in a
    //    binary search tree. You may assume that each node has a link to its parent.
    public static Node<Integer> getNextBSTNode(BinaryTree<Integer> tree,
                                               Node<Integer> node) {
        Node<Integer> parent;
        Node<Integer> next;
        Node<Integer> right;
        if (node == tree.getRoot()) {
            parent = null;
        } else {
            parent = tree.getNodeByName(node.getParentsName().get(0));
        }
        right = node.getAdj(RIGHT_LABEL);
        if (right == null) {
            if (parent != null) {
                if (node.getData().compareTo(parent.getData()) > 0) {
                    next = node;
                    while (next.getData().compareTo(parent.getData()) > 0) {
                        next = tree.getNodeByName(next.getParentsName().get(0));
                        parent = tree.getNodeByName(next.getParentsName().get(0));
                    }
                }
                next = parent;
            } else {
                return null;
            }
        } else {
            next = right;
            next = getLeftmost(next);
        }
        return next;
    }

    public static Node<Integer> getLeftmost(Node<Integer> node) {
        Node<Integer> leftmost = (node.getAdj(LEFT_LABEL) != null) ?
                node.getAdj(LEFT_LABEL) :
                node;
        while (leftmost.getAdj(LEFT_LABEL) != null) {
            leftmost = leftmost.getAdj(LEFT_LABEL);
        }
        return leftmost;
    }
}