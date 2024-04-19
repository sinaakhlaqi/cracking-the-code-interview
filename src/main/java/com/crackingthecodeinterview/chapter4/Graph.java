package com.crackingthecodeinterview.chapter4;

import java.util.*;

public interface Graph<N extends Node<?>> {
    boolean setLink(N nodeA, N nodeB);

    boolean setLink(N nodeA, N nodeB, Integer label);

    boolean unsetLink(N nodeA, N nodeB);

    N getNodeByName(String nodeName);

    Collection<N> getAllNodes();

    void setNode(N node);

    boolean removeNode(N node);

    String[] getAllNodeNames();
}