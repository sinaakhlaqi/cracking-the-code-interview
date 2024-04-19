package com.crackingthecodeinterview.chapter4;

import java.util.*;

import static com.crackingthecodeinterview.chapter4.GraphUtils.*;

public class Chapter4Problem1Solution {


    public static void main(String[] args) {
        int[][] adj = {
//                       A  B  C  D  E  F  G
                /*A*/   {0, 0, 0, 0, 0, 0, 0},
                /*B*/   {0, 0, 1, 0, 0, 0, 0},
                /*C*/   {0, 0, 0, 0, 0, 1, 0},
                /*D*/   {1, 0, 0, 0, 0, 0, 0},
                /*E*/   {0, 1, 0, 1, 0, 0, 0},
                /*F*/   {0, 1, 0, 0, 1, 0, 0},
                /*G*/   {0, 0, 0, 0, 0, 0, 0},
        };
        /*
        the graph looks like this
                          -----------------------|
                          |                      |
                          v                      |
        (A)              (B)------------->(C)    |
         ^                ^                |     |
         |                |                |     |
         |                |                |     |
         |                |                v     |
        (D)<-------------(E)<-------------(F)----|

                         (G)
         */
        String[] nodeNames = {"A", "B", "C", "D", "E", "F", "G"};
        Integer[] data = {0, 0, 0, 0, 0, 0, 0};
        Graph<Node<Integer>> graph = new DirectedGraph<>("Problem1 Graph");
        initGraphNodes(graph, nodeNames, data);
        initGraphEdges(graph, adj);
        System.out.println(graph);

        System.out.println("there exists a route between B and A: " +
                bidirectionalBFSSearch(graph, "B", "A"));

        System.out.println("there exists a route between A and C: " +
                bidirectionalBFSSearch(graph, "A", "C"));

        System.out.println("there exists a route between C and G: " +
                bidirectionalBFSSearch(graph, "C", "G"));

    }

    //4.1 Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
    //    route between two nodes.
    //*** I shall write this search in perspective of thread programming with shared resource in the future;
    public static boolean bidirectionalBFSSearch(Graph<Node<Integer>> directedGraph, String sourceName, String destinationName) {
        Node<Integer> sourceNode = directedGraph.getNodeByName(sourceName);
        ArrayList<Node<Integer>> sourceNodeAdj = new ArrayList<>();
        Map<Node<Integer>, Boolean> sourceNodeVisited = new Hashtable<>();
        Node<Integer> destinationNode = directedGraph.getNodeByName(destinationName);
        ArrayList<Node<Integer>> destinationNodeAdj = new ArrayList<>();
        Map<Node<Integer>, Boolean> destinationNodeVisited = new Hashtable<>();
        boolean sourceTurn = true;
        sourceNodeAdj.add(sourceNode);
        destinationNodeAdj.add(destinationNode);

        while (!sourceNodeAdj.isEmpty() || !destinationNodeAdj.isEmpty()) {
            ArrayList<Node<Integer>> pathfinder =
                    (sourceTurn) ? sourceNodeAdj : destinationNodeAdj;
            ArrayList<Node<Integer>> steady =
                    (sourceTurn) ? destinationNodeAdj : sourceNodeAdj;
            Map<Node<Integer>, Boolean> visited =
                    (sourceTurn) ? sourceNodeVisited : destinationNodeVisited;
            Node<Integer> target = (sourceTurn) ? destinationNode : sourceNode;

            Node<Integer> nodePathfinder = pathfinder.remove(0);
            visited.put(nodePathfinder, true);
            if (steady.contains(nodePathfinder)) {
                return true;
            } else {
                if (!nodePathfinder.getAdjList().isEmpty())
                    for (Node<Integer> node : nodePathfinder.getAdjList()) {
                        if (!visited.containsKey(node)) {
                            if (node == target)
                                return true;
                            pathfinder.add(node);
                        }
                    }
            }
            if (sourceTurn && !destinationNodeAdj.isEmpty())
                sourceTurn = false;
            else if (!sourceTurn && !sourceNodeAdj.isEmpty())
                sourceTurn = true;
        }
        return false;
    }
}