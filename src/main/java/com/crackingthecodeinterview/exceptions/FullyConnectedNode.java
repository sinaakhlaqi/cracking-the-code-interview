package com.crackingthecodeinterview.exceptions;

public class FullyConnectedNode extends RuntimeException {
    private final String nodeName;

    public FullyConnectedNode(String nodeName) {
        super(String.format("node %s is fully connected!", nodeName));
        this.nodeName = nodeName;
    }

    public String getNodeName() {
        return nodeName;
    }
}
