package com.crackingthecodeinterview.chapter4;


import java.util.*;

import static com.crackingthecodeinterview.chapter4.GraphUtils.*;

public class Chapter4Problem9Solution {
    public static void main(String[] args) {

        // todo: This approach needs some modification
        // Since the root determine the shape of BST tree; all incoming sibling with any
        // Order; do not modify the shape of tree. so I use this algorithm.
        // 1. Make a list of sibling in each level.
        // 2. Generate the permutation of each list
        // 3. put it all together: make a sequence starting from root with each permutation list
        //    in each level of siblings;
        // 4. do this till rich to end of the sibling list

        BinaryTree<Integer> binaryTree = new BinaryTree<>("Problem5BinaryTree");
        String[] nodeNames = {"A", "B", "C", "D", "E"};
        Integer[] data = {1, 2, 3, 4, 5};
        int[][] adj = {
//                       A  B  C  D  E
                /*A*/   {0, 0, 0, 0, 0},
                /*B*/   {1, 0, 0, 1, 0},
                /*C*/   {0, 0, 0, 0, 0},
                /*D*/   {0, 0, 1, 0, 1},
                /*E*/   {0, 0, 0, 0, 0},

        };

        /* the binaryTree looks like

                            (B=2)
                           /     \
                      (A=1)       (D=4)
                                 /     \
                            (C=3)       (E=5)
         * */
        binaryTree.setRootName("B");
        initGraphNodes(binaryTree.asGraph(), nodeNames, data);
        initGraphEdges(binaryTree.asGraph(), adj);
        List<List<Node<Integer>>> allPossibleSequences = new ArrayList<>();
        List<List<Node<Integer>>> listOfDepthNodes = new ArrayList<>();
        getListOfDepths(binaryTree.getRoot(), listOfDepthNodes, 0);
        getBSTSequence(allPossibleSequences, listOfDepthNodes, 0);

        for (List<Node<Integer>> sequence : allPossibleSequences) {
            StringBuilder sequenceString = new StringBuilder("[");
            for (Node<Integer> node : sequence) {
                sequenceString.append(String.format("%s,", node.getName()));
            }
            sequenceString.append("]");
            System.out.println(sequenceString);
        }
    }

    //4.9 BST Sequences: A binary search tree was created by traversing through an array from left to right
    //    and inserting each element. Given a binary search tree with distinct elements, print all possible
    //    arrays that could have led to this tree.

    /*
    EXAMPLE
           Input:

            (2)
           /   \
         (1)   (3)

         Output: {2, 1, 3}, {2, 3, 1}
    */
    public static <T extends Comparable<?>> void
    getBSTSequence(List<List<Node<T>>> allPossibleSequences,
                   List<List<Node<T>>> listOfDepthNodes, int depth) {
        if (depth < listOfDepthNodes.size()) {
            List<List<Node<T>>> listOfSiblingPermutations = new ArrayList<>();
            permutation(listOfDepthNodes.get(depth),
                    listOfSiblingPermutations,
                    0);
            if (allPossibleSequences.isEmpty())
                allPossibleSequences.addAll(listOfSiblingPermutations);
            else {
                //since list elements are immutable
                List<List<Node<T>>> tempAllSequence = new ArrayList<>();
                while (!allPossibleSequences.isEmpty()) {
                    List<Node<T>> tempSequenceList = allPossibleSequences.get(0);
                    allPossibleSequences.remove(0);
                    List<Node<T>> newSequence;
                    for (List<Node<T>> permutiationList : listOfSiblingPermutations) {
                        newSequence = new ArrayList<>(tempSequenceList);
                        newSequence.addAll(permutiationList);
                        tempAllSequence.add(newSequence);
                    }
                }
                allPossibleSequences.addAll(tempAllSequence);
            }
            getBSTSequence(allPossibleSequences, listOfDepthNodes, (depth + 1));
        }
    }

    public static <E> void
    permutation(List<E> elements,
                List<List<E>> listOfPermutations, int positionIndex) {
        if (elements.size() - 1 - positionIndex == 0) {
            listOfPermutations.add(elements.stream().toList());
            return;
        }
        for (int i = positionIndex; i < elements.size(); i++) {
            swapList(elements, positionIndex, i);
            permutation(elements,
                    listOfPermutations,
                    (positionIndex + 1));
            swapList(elements, positionIndex, i);
        }
    }

    public static <E> void swapList(List<E> list, int firstElementIndex, int secondElementIndex) {
        E tempA = list.get(firstElementIndex);
        E tempB = list.get(secondElementIndex);
        list.remove(secondElementIndex);
        list.add(secondElementIndex, tempA);
        list.remove(firstElementIndex);
        list.add(firstElementIndex, tempB);
    }
}