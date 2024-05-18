package com.crackingthecodeinterview.exceptions;

public class NodeAlreadyHasConnectionException extends RuntimeException {
    private final String nodeName;
    private final int label;

    public NodeAlreadyHasConnectionException(String nodeName, int label) {
        super(String.format("node %s already has connection with label %d", nodeName, label));
        this.nodeName = nodeName;
        this.label = label;
    }

    public String getNodeName() {
        return nodeName;
    }

    public int getLabel() {
        return label;
    }
}
