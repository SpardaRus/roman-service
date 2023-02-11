package ru.spardarus.roman.service;

import java.util.Collection;
import java.util.Iterator;

public class EvenIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;

    public EvenIterator(Collection<Integer> collection) {
        this.iterator = collection.stream()
                .filter(i -> i % 2 == 0)
                .iterator();
    }

    public boolean hasNext() {
        return iterator
                .hasNext();
    }

    public Integer next() {
        return iterator
                .next();
    }
}
