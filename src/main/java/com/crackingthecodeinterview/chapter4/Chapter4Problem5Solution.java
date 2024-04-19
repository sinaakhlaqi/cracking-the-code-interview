package com.crackingthecodeinterview.chapter4;


import static com.crackingthecodeinterview.chapter4.GraphUtils.initGraphEdges;
import static com.crackingthecodeinterview.chapter4.GraphUtils.initGraphNodes;
import static com.crackingthecodeinterview.utilities.Constants.*;

public class Chapter4Problem5Solution {

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>("Problem5BinaryTree");
        String[] nodeNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        Label[] label = {new Label(LEFT_LABEL), new Label(LEFT_LABEL),
                new Label( RIGHT_LABEL),new Label( RIGHT_LABEL), new Label(LEFT_LABEL),
                new Label( RIGHT_LABEL), new Label(LEFT_LABEL), new Label(LEFT_LABEL),
                new Label( RIGHT_LABEL), new Label(ROOT_LABEL)};
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[][] adj = {
//                       A  B  C  D  E  F  G  H  I  J
                /*A*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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
        System.out.printf("the binaryTree %s test for BST is: %s",
                binaryTree.getTreeName(),
                isBSTTree((binaryTree.getRoot()),
                        null));
    }

    //4.5 Validate BST: Implement a function to check if a binary tree is a binary search tree.
    public static boolean isBSTTree(Node<Integer> root, Node<Integer> parent) {
        Node<Integer> left = root.getAdj(LEFT_LABEL);
        Node<Integer> right = root.getAdj(RIGHT_LABEL);
        boolean isBSTTreeLeftChild = true;
        boolean isBSTTreeRightChild = true;

        if (parent != null) {
            if (root.getData().compareTo(parent.getData()) < 0) {
                if (right != null)
                    if (right.getData().compareTo(parent.getData()) > 0)
                        return false;
            }
            if (root.getData().compareTo(parent.getData()) > 0) {
                if (left != null)
                    if (left.getData().compareTo(parent.getData()) < 0)
                        return false;
            }
        }
        if (left != null)
            isBSTTreeLeftChild = isBSTTree(left, root);
        if (right != null)
            isBSTTreeRightChild = isBSTTree(right, root);

        return isBSTTreeLeftChild && isBSTTreeRightChild;
    }
}