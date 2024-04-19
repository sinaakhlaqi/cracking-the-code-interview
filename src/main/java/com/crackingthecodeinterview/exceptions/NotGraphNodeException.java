package com.crackingthecodeinterview.exceptions;

import com.crackingthecodeinterview.chapter4.Node;

public class NotGraphNodeException extends RuntimeException {
    private final String nodeName;
    private final String graphName;
    public NotGraphNodeException(String nodeName, String graphName) {
        super(String.format("node %s does not belongs to %s"));
        this.nodeName = nodeName;
        this.graphName = graphName;
    }

    public String getGraphName() {
        return graphName;
    }

    public String getNodeName() {
        return nodeName;
    }
}
