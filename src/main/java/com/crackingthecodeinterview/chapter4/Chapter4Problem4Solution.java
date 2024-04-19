package com.crackingthecodeinterview.chapter4;

import static com.crackingthecodeinterview.chapter4.GraphUtils.*;
import static com.crackingthecodeinterview.utilities.Constants.*;

public class Chapter4Problem4Solution {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>("Problem4BinaryTree");
        String[] nodeNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        int[][] adj = {
//                       A  B  C  D  E  F  G  H  I  J  K
                /*A*/   {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                /*B*/   {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                /*C*/   {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                /*D*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                /*E*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                /*F*/   {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                /*G*/   {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                /*H*/   {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                /*I*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                /*J*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                /*K*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        initGraphNodes(binaryTree.asGraph(), nodeNames);
        initGraphEdges(binaryTree.asGraph(), adj);
        binaryTree.setRootName("A");//A is root of binaryTree
        /*the binaryTree looks like
                                    (A)
                                   /   \
                                 (B)   (C)
                               /   \     \
                             (E)   (D)   (F)
                                           \
                                           (G)
                                             \
                                             (H)
                                               \
                                               (I)
                                                 \
                                                 (G)
        * */
        boolean balance = isBalance(binaryTree.getRoot());
        System.out.printf("Tree %s is balance: %s", binaryTree.getTreeName(), balance);
    }

    //4.4 Check Balanced: Implement a function to check if a binary
    //    tree is balanced. For the purposes of
    //    this question, a balanced tree is defined to
    //    be a tree such that the heights of the two subtrees of any
    //    node never differ by more than one.
    public static boolean isBalance(Node<Integer> root) {
        if (root == null || root.getAdjList().isEmpty())
            return true;
        Node<Integer> leftChild = root.getAdj(LEFT_LABEL);
        Node<Integer> rightChild = root.getAdj(RIGHT_LABEL);
        int leftChildHeight = (leftChild != null) ?
                longestPath(leftChild) :
                0;
        int rightChildHeight = (rightChild != null) ?
                longestPath(rightChild) :
                0;

        if (Math.abs(leftChildHeight - rightChildHeight) > 1)
            return false;

        boolean isBalancedLeftChild = true;
        if (leftChild != null)
            isBalancedLeftChild = isBalance(leftChild);

        boolean isBalancedRightChild = true;
        if (rightChild != null)
            isBalancedRightChild = isBalance(rightChild);
        return isBalancedLeftChild && isBalancedRightChild;
    }
}