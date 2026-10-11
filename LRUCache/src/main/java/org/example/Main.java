package org.example;

import java.util.LinkedHashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class LRUcache<K,V> extends LinkedHashMap<K,V>{
    private int capacity;

    public LRUcache(int initialCapacity, int capacity) {
        super(initialCapacity);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(){

    }
}

public class Main {
    static void main() {

    }
}
