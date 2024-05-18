package com.crackingthecodeinterview.exceptions;

public class MakeLoopInTreeException extends RuntimeException {
    private final String parentName;
    private final String childName;
    private final String treeName;

    public MakeLoopInTreeException(String parentName, String childName, String treeName) {
        super(String.
                format("node %s with new connection to node %s makes loop in tree %s!",
                        parentName,childName,treeName));
        this.parentName = parentName;
        this.childName = childName;
        this.treeName = treeName;
    }

    public String getParentName() {
        return parentName;
    }

    public String getChildName() {
        return childName;
    }

    public String getTreeName() {
        return treeName;
    }
}
