package com.challenges;

public class MyHashMap<K, V> {

    private Object[] array;

    MyHashMap() {
        array = new Object[1000];
    }

    void put(K key, V value) {
        int index = key.hashCode();
        array[index] = value;
    }

    V get(K key) {
        return (V) array[key.hashCode()];
    }


    public static void doTestsPass() {
        int[][] testCases = {{1, 2}, {3, 4}, {5, 6}};
        boolean passed = true;

        MyHashMap<Integer, Integer> map = new MyHashMap<>();

        for (int test[] : testCases) {
            Integer key = test[0];
            Integer value = test[1];

            map.put(key, value);

            if (!value.equals(map.get(key))) {
                System.out.println("test Failed[" + key + "," + value + "]");
                passed = false;

            }
        }

        if (passed) {
            System.out.println("All test passed");
        }
    }

    public static void main(String[] args) {
        doTestsPass();
    }
}

