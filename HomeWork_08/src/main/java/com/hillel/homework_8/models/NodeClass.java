package com.hillel.homework_8.models;

public class NodeClass {
    public String data;
    public NodeClass previous;
    public NodeClass next;

    public NodeClass(String data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    public NodeClass() {
        this.previous = null;
        this.next = null;
    }

    public void setData(String data) {
        this.data = data;
    }

    public NodeClass getPrevious() {
        return previous;
    }

    public void setPrevious(NodeClass previous) {
        this.previous = previous;
    }

    public NodeClass getNext() {
        return next;
    }

    public void setNext(NodeClass next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }
}
