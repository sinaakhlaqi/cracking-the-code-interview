package com.crackingthecodeinterview.chapter4;

import java.util.function.BiConsumer;

import static com.crackingthecodeinterview.chapter4.GraphUtils.*;
import static com.crackingthecodeinterview.utilities.Constants.*;

public class Chapter4Problem10Solution {
    public static void main(String[] args) {

        // 4.1O Check Subtree: Tl and T2 are two very large binary trees,
        //      with Tl much bigger than T2. Create an
        //      algorithm to determine ifT2 is a subtree of Tl.
        //      A tree T2 is a subtree of Tl if there exists a node n in Tl such
        //      that the subtree of n is identical to T2.
        //      That is, if you cut off the tree at node n,
        //      the two trees would be identical.
        BinaryTree<Integer> bigBinaryTree =
                new BinaryTree<>("Problem10BigBinaryTree");
        BinaryTree<Integer> smallBinaryTree =
                new BinaryTree<>("Problem10SmallBinaryTree");
        String[] bigTreeNodeNames = {"A", "B", "C", "D", "E", "F", "G"};
        Label[] bigLabel = {new Label(ROOT_LABEL), new Label(LEFT_LABEL), new Label(RIGHT_LABEL),
                new Label(LEFT_LABEL), new Label(RIGHT_LABEL), new Label(LEFT_LABEL), new Label(RIGHT_LABEL)};
        Label[] smallLabel = {new Label(ROOT_LABEL), new Label(LEFT_LABEL), new Label(RIGHT_LABEL)};
        String[] smallTreeNodeNames = {"B", "D", "E"};

        int[][] bigAdj = {
//                       A  B  C  D  E  F  G
                /*A*/   {0, 1, 1, 0, 0, 0, 0},
                /*B*/   {0, 0, 0, 1, 1, 0, 0},
                /*C*/   {0, 0, 0, 0, 0, 1, 1},
                /*D*/   {0, 0, 0, 0, 0, 0, 0},
                /*E*/   {0, 0, 0, 0, 0, 0, 0},
                /*F*/   {0, 0, 0, 0, 0, 0, 0},
                /*G*/   {0, 0, 0, 0, 0, 0, 0},

        };
        int[][] smallAdj = {
//                       B  D  E
                /*B*/   {0, 1, 1,},
                /*D*/   {0, 0, 0,},
                /*E*/   {0, 0, 0,},

        };

        /* the binaryTree looks like

                   bigBinaryTree         smallBinaryTree

                         (A)                   (B)
                        /   \                 /   \
                     (B)     (C)           (D)     (E)
                    /   \   /   \
                  (D)  (E) (F)  (G)

        * */
        bigBinaryTree.setRootName("A");
        smallBinaryTree.setRootName("B");
        initGraphNodes(bigBinaryTree.asGraph(), bigTreeNodeNames, bigLabel);
        initGraphNodes(smallBinaryTree.asGraph(), smallTreeNodeNames, smallLabel);
        initGraphEdges(bigBinaryTree.asGraph(), bigAdj);
        initGraphEdges(smallBinaryTree.asGraph(), smallAdj);
        StringBuilder bigTreeTrack = new StringBuilder();
        StringBuilder smallTreeTrack = new StringBuilder();
        BiConsumer<Node<Integer>, StringBuilder> visitor = (node, track) -> {
            track.append(node.getName());
            if (node.getAdj((LEFT_LABEL)) == null)
                track.append(LEFT_CHILD_NULL_TOKEN);
            if (node.getAdj(RIGHT_LABEL) == null)
                track.append(RIGHT_CHILD_NULL_TOKEN);
        };

        depthFirstSearch(bigBinaryTree.getNodeByName("B"), visitor, bigTreeTrack);
        depthFirstSearch(smallBinaryTree.getRoot(), visitor, smallTreeTrack);

        System.out.println(bigTreeTrack);
        System.out.println(smallTreeTrack);
        if (smallTreeTrack.toString().contentEquals(bigTreeTrack))
            System.out.printf(" small tree %s is subtree of big tree %s", smallBinaryTree.getTreeName(), bigBinaryTree.getTreeName());
    }
}