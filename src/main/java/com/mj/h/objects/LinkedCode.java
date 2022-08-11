package com.mj.h.objects;

public class LinkedCode implements Code{

    Node top;


    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String read() {
        if(isEmpty()) return null;
        Node node = top;
        top = node.next;
        return node.code;
    }


    @Override
    public void delete() {
        if(isEmpty()) return;
        top = top.next;
    }

    @Override
    public void register(String code) {
        Node node = new Node();
        node.code = code;
        node.next = top;
        top = node;
    }
}
