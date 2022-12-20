package com.ttasjwi.stack;

import java.util.EmptyStackException;
import java.util.Vector;

public class Stack<E> {

    private final Vector<E> elements = new Vector<>();

    public E push(E item) {
        elements.addElement(item);
        return item;
    }

    public E pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }
}
