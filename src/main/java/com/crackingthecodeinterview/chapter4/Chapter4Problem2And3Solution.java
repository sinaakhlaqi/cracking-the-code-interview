package com.crackingthecodeinterview.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.crackingthecodeinterview.chapter4.GraphUtils.*;
import static com.crackingthecodeinterview.utilities.Constants.*;

public class Chapter4Problem2And3Solution {

    public static void main(String[] args) {
        // test 4.2
        System.out.println(String.format(SEPARATOR, "test 4.2"));

        Integer[] sortedArray = {1, 2, 3, 4, 5, 6};

        String[] nodeNames = {"A", "B", "C", "D", "E", "F"};

        BinaryTree<Integer> binaryTree = new BinaryTree<>("BST");

        initGraphNodes(binaryTree.asGraph(), nodeNames, sortedArray);

        makeBST(binaryTree, nodeNames, 0, nodeNames.length - 1);

        Consumer<Node<Integer>> visitor = (node) -> {
            System.out.print(node.getData());
        };
        inOrderVisit(binaryTree.getRoot(), visitor);
        System.out.println();

        /* the binaryTree locks like this

                               C(3)
                               /   \
                              /     \
                           A(1)    E(5)
                              \     / \
                               \   /   \
                             B(2) D(4) F(6)

        * */


        //test 4.3
        System.out.println(String.format(SEPARATOR, "test 4.3"));
        List<List<Node<Integer>>> listOfDepths = new ArrayList<>();
        getListOfDepths(binaryTree.getRoot(), listOfDepths, 0);
        StringBuilder listOfDepthsString = new StringBuilder();
        int depth = 0;
        for (List<Node<Integer>> list : listOfDepths) {
            listOfDepthsString.append(String.format("Depth %d nodes\n", depth++));
            for (Node<Integer> nodeInDepth : list) {
                listOfDepthsString.append(String.format("\t%s", nodeInDepth.getName()));
            }
            listOfDepthsString.append("\n");
        }
        System.out.println(listOfDepthsString.toString());
    }

    //4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
    //    algorithm to create a binary search tree with minimal height.
    public static void
    makeBST(BinaryTree<Integer> tree, String[] nodeNames, int start, int end) {
        if (start < 0 || end >= nodeNames.length || start > end)
            return;
        int mid = (start + end) / 2;
        placeNode(tree.getNodeByName(nodeNames[mid]), tree);
        int newStart = mid + 1;
        int newEnd = mid - 1;
        if (newStart <= end)
            makeBST(tree, nodeNames, newStart, end);
        if (newEnd >= start)
            makeBST(tree, nodeNames, start, newEnd);
    }


    //4.3 List of Depths: Given a binary tree, design an algorithm which
    //    creates a linked list of all the nodes
    //    at each depth
    //    (e.g., if you have a tree with depth D, you'll have D linked lists).


    //problem 2 helpers
    public static void placeNode(Node<Integer> node, BinaryTree<Integer> tree) {
        if (!tree.hasRoot()) {
            tree.setRootName(node.getName());
            return;
        }
        Node<Integer> root = tree.getRoot();
        while (true) {
            Node<Integer> leftChild = root.getAdj(LEFT_LABEL);
            Node<Integer> rightChild = root.getAdj(RIGHT_LABEL);
            if (node.getData().compareTo(root.getData()) <= 0) {
                if (leftChild == null) {
                    node.setLabel(new Label(LEFT_LABEL));
                    root.setAdj(node);
                    return;
                } else {
                    root = leftChild;
                }
            } else {
                if (rightChild == null) {
                    node.setLabel(new Label(RIGHT_LABEL));
                    root.setAdj(node);
                    return;
                } else {
                    root = rightChild;
                }
            }
        }
    }
}