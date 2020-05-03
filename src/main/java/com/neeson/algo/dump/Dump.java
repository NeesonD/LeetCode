package com.neeson.algo.dump;

/**
 * @author daile
 * @version 1.0
 * @date 2020/5/2 10:26
 */
public class Dump<Key extends Comparable<Key>> {

    private Key[] dataKey;

    private int cap;

    private int count;

    public Dump(int cap) {
        this.dataKey = (Key[]) new Comparable[cap+1];
        this.cap = cap;
        this.count = 0;
    }

    public Dump(Key[] keys) {
        this.dataKey = keys;
        this.cap = keys.length;
        this.count = keys.length;
        buildHeap(keys);
    }

    public void insert(Key data) {
        if (count == cap) {
            throw new RuntimeException("full");
        }
        dataKey[++count] = data;
        up(count);
    }

    public Key remove() {
        if (count == 0) {
            throw new RuntimeException("empty");
        }
        swap(1,count );
        Key max = dataKey[count];
        dataKey[--count] = null;
        down(1);
        return max;
    }

    public void sort(Key[] keys) {
        buildHeap(keys);
        int k = keys.length;
        while (k > 1) {
            swap(1, k);
            --k;
            down(1);
        }
    }

    private void buildHeap(Key[] keys) {
        for (int i = keys.length/2; i >=1 ; i--) {
            down(i);
        }
    }

    private void up(int k) {
        while (k > 1 && less(parent(k), k)) {
            swap(parent(k), k);
            k = parent(k);
        }
    }

    private void down(int k) {
        while (left(k) <= count) {
            int sub = left(k);
            if (right(k) <= count && less(left(k), right(k))) {
                sub = right(k);
            }
            if (less(k, sub)) {
                swap(k,sub);
            }
            k = sub;
        }
    }

    private boolean less(int i, int j) {
        return dataKey[i].compareTo(dataKey[j]) < 0;
    }

    private void swap(int i, int j) {
        Key temp = dataKey[i];
        dataKey[i] = dataKey[j];
        dataKey[j] = temp;
    }

    private int parent(int k) {
        return k / 2;
    }

    private int left(int k) {
        return k * 2;
    }

    private int right(int k) {
        return k * 2 + 1;
    }

}
