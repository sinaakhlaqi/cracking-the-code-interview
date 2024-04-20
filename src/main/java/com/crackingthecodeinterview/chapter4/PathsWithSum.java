package com.crackingthecodeinterview.chapter4;


import java.util.Hashtable;
import java.util.Map;

import static com.crackingthecodeinterview.chapter4.GraphUtils.initGraphEdges;
import static com.crackingthecodeinterview.chapter4.GraphUtils.initGraphNodes;
import static com.crackingthecodeinterview.utilities.Constants.*;

public class PathsWithSum {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>("Problem12BinaryTree");

        Integer[] data = {10, 5, -3, 3, 2, 11, 3, -2, 1, 1};

        int[][] adj = {
//                       A  B  C  D  E  F  G  H  I  J
                /*A*/   {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                /*B*/   {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                /*C*/   {0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                /*D*/   {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                /*E*/   {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                /*F*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                /*G*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                /*H*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                /*I*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                /*J*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        String[] nodeNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        Label[] label = {new Label(ROOT_LABEL), new Label(LEFT_LABEL),
                new Label(RIGHT_LABEL), new Label(LEFT_LABEL), new Label(RIGHT_LABEL),
                new Label(RIGHT_LABEL), new Label(LEFT_LABEL), new Label(RIGHT_LABEL),
                new Label(RIGHT_LABEL), new Label(LEFT_LABEL)};
        /* the binaryTree looks like

                                  (A=10)
                                /        \
                            (B=5)        (C=-3)
                           /     \       /     \
                       (D=3)     (E=2) (J=1)   (F=11)
                      /     \        \
                  (G=3)    (H=-2)    (I=1)

        * */
        binaryTree.setRootName("A");
        initGraphNodes(binaryTree.asGraph(), nodeNames, data, label);
        initGraphEdges(binaryTree.asGraph(), adj);
        printAllPath(binaryTree, 8);

    }

    //4.12 Paths with Sum: You are given a binary tree in which each node contains an
    //     integer value (which might be positive or negative). Design an algorithm to
    //     count the number of paths that sum to a given value. The path does not need
    //     to start or end at the root or a leaf, but it must go downwards
    //     (traveling only from parent nodes to child nodes).
    public static void
    pathWithSum(Node<Integer> root, Map<String, Integer> pathSum,
                String trajectory) {
        int currentSum = pathSum.getOrDefault(trajectory, 0);
        pathSum.put(trajectory += root.getName(),
                currentSum + root.getData());
        for (Node<Integer> adj : root.getAdjList()) {
            pathWithSum(adj, pathSum, trajectory);
        }
    }

    public static void printAllPath(BinaryTree<Integer> binaryTree, int desiredSum) {
        for (Node<Integer> node : binaryTree.asGraph().getAllNodes()) {
            Hashtable<String, Integer> pathWithSum = new Hashtable<>();
            pathWithSum(binaryTree.getNodeByName(node.getName()),
                    pathWithSum, "");
            for (Map.Entry<String, Integer> entry : pathWithSum.entrySet()) {
                if (entry.getValue() == desiredSum)
                    System.out.println(entry.getKey());
            }
        }
    }
}