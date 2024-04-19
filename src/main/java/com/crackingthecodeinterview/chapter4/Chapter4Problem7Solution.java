package com.crackingthecodeinterview.chapter4;

import javax.lang.model.type.NullType;
import javax.swing.event.ListDataEvent;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.crackingthecodeinterview.chapter4.GraphUtils.*;
import static com.crackingthecodeinterview.utilities.Constants.*;

public class Chapter4Problem7Solution {


    public static void main(String[] args) {

        //  For this problem, I'm using following algorithm

        //   1. Divide dependency graph to subgraph(s) (if any exists)
        //      1.1 find each connected subgraph in the dependency graph
        //
        //   2. Make each subgraph a dependency tree with the root of highest depth
        //      2.1. for all nodes in a subgraph;
        //           find maximum spanning tree in order to find root for subgraph
        //      2.2  make each subgraph as tree with root that
        //           has the longest depth along all spanning trees;
        //      2.3. since each tree can build independently
        //           (in order to build project);
        //           make ap BFS trajectory for each tree;

        Graph<Node<String>> dependecyGraph = new DirectedGraph<>("Problem5BinaryTree");
        String[] nodeNames = {"A", "B", "C", "D", "E", "F"};

        int[][] adj = {
//                       A  B  C  D  E  F
                /*A*/   {0, 0, 0, 1, 0, 0},
                /*B*/   {0, 0, 0, 1, 0, 0},
                /*C*/   {0, 0, 0, 0, 0, 0},
                /*D*/   {0, 0, 1, 0, 0, 0},
                /*E*/   {0, 0, 0, 0, 0, 0},
                /*F*/   {1, 1, 0, 0, 0, 0},

        };

        /* the graph looks like

               ---(F)---       (E)
               |       |
               V       V
              (B)     (A)
               |       |
               |       V
               |----->(D)
                       |
                       V
                      (C)
        it consists of two connected trees;
        * */

        Graph<Node<String>> graph = new DirectedGraph<>("Problem7Graph");
        initGraphNodes(graph, nodeNames);
        initGraphEdges(graph, adj);
        List<Set<Node<String>>> subGraphList = getAllConnectedSubGraphs(graph);
        List<DirectedTree<String>> dependencyTrees = getDependencyTrees(subGraphList);

        BiConsumer<Node<String>, StringBuilder> visitor = (node, track) -> {
            track.append(node.getName());
        };

        StringBuilder[] allTrajectories = new StringBuilder[dependencyTrees.size()];

        for (int i = 0; i < dependencyTrees.size(); i++) {
            allTrajectories[i] = new StringBuilder();
            breathFirstVisit(dependencyTrees.get(i).getRoot(),
                    visitor,
                    allTrajectories[i]);
        }
        for (int j = 0; j < dependencyTrees.size(); j++) {
            System.out.println(String.format(SEPARATOR, dependencyTrees.get(j).getTreeName()));
            System.out.println(allTrajectories[j]);
        }
    }

//    4.7 Build Order: You are given a list of projects and a list of dependencies
//    (which is a list of pairs of
//    projects, where the second project is dependent on the first project).
//    All of a project's dependencies
//    must be built before the project is.
//    Find a build order that will allow the projects to be built. If there
//    is no valid build order, return an error.
//    EXAMPLE
//    Input:
//    projects: a, b, c, d, e, f
//    dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
//    Output: f, e, a, b, d, c
    public static List<DirectedTree<String>> getDependencyTrees(List<Set<Node<String>>> subGraphList) {
        List<DirectedTree<String>> treeNodes = new ArrayList<>();
        int treeCounter = 0;
        for (Set<Node<String>> subgraphNodeSet : subGraphList) {
            List<Node<String>> sortedByNameNodeList;
            sortedByNameNodeList = subgraphNodeSet.stream()
                    .sorted(Comparator.comparing(Node::getName))
                    .collect(Collectors.toList());
            Node<String> root = null;
            int rootPathLength = 0;
            int rootCandidatePathLength;
            int index = 0;
            String[] nodeNames = new String[subgraphNodeSet.size()];
            for (Node<String> rootCandid : sortedByNameNodeList) {
                nodeNames[index++] = rootCandid.getName();
                rootCandidatePathLength = longestPath(rootCandid);
                if (rootCandidatePathLength >= rootPathLength) {
                    root = rootCandid;
                    rootPathLength = rootCandidatePathLength;
                }
            }
            int[][] adj = getAdjacencyMatrix(sortedByNameNodeList);
            DirectedTree<String> tree = new DirectedTree<>(String.format("DependencyTree%d", ++treeCounter), 2);
            tree.setRootName(root.getName());
            initGraphNodes(tree.asGraph(), nodeNames);
            initGraphEdges(tree.asGraph(), adj);
            treeNodes.add(tree);
        }
        return treeNodes;
    }

    public static int[][] getAdjacencyMatrix(List<Node<String>> sortedNodeList) {
        int[][] adj = new int[sortedNodeList.size()][sortedNodeList.size()];

        for (Node<String> node : sortedNodeList) {
            for (Node<String> child : node.getAdjList())
                adj[sortedNodeList.indexOf(node)][sortedNodeList.indexOf(child)] = 1;
        }
        return adj;
    }

    public static void maximumSpanningTree(Node<String> root, Set<Node<String>> treeNodes) {
        treeNodes.add(root);
        if (root.getAdjList().isEmpty())
            return;
        treeNodes.addAll(root.getAdjList());
        for (Node<String> adj : root.getAdjList())
            maximumSpanningTree(adj, treeNodes);
    }

    public static List<Set<Node<String>>> getAllConnectedSubGraphs(Graph<Node<String>> graph) {
        List<Set<Node<String>>> subGraphSetList = new ArrayList<>();
        for (Node<String> node : graph.getAllNodes()) {
            Set<Node<String>> subGraphSet = new HashSet<>();
            maximumSpanningTree(node, subGraphSet);
            Iterator<Set<Node<String>>> iterator = subGraphSetList.iterator();
            boolean connectdSet = false;
            while (iterator.hasNext() && !connectdSet) {
                Set<Node<String>> listElement = iterator.next();
                if (listElement.containsAll(subGraphSet)) {
                    connectdSet = true;
                    break;
                }
                for (Node<String> subGraphNode : subGraphSet) {
                    if (listElement.contains(subGraphNode)) {
                        listElement.addAll(subGraphSet);
                        connectdSet = true;
                        break;
                    }
                }
            }
            if (!connectdSet)
                subGraphSetList.add(subGraphSet);
        }
        return subGraphSetList;
    }
}