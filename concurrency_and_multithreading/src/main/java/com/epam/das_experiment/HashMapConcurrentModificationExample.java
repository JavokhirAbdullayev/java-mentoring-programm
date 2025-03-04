package com.epam.das_experiment;

import java.util.HashMap;

public class HashMapConcurrentModificationExample {

    public static void main(String[] args) {
        var map = new HashMap<Integer, Integer>();

        var writer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, i);
            }
        });

        var reader = new Thread(() -> {
            var sum = 0;
            for (var value : map.values()) {
                sum += value;
            }
            System.out.println("Sum: " + sum);
        });

        writer.start();
        reader.start();
    }
}
