package org.yj.application.data.collections;

import java.util.TreeMap;
import java.util.function.Supplier;

public class HashTable<K, V> {

    public final static int[] capacityList = {31, 97, 199, 397};
    private TreeMap<K, V>[] array;
    private int size;
    private int capacityIndex = 0;
    private int m;
    private int mini = 10;
    private int max = 20;

    public HashTable() {
        size = 0;
        m = capacityList[capacityIndex];
        array = new TreeMap[m];
        for (int i = 0; i < array.length; i++) {
            array[i] = new TreeMap();
        }
    }

    private int hash(K key) {
        int res = key.hashCode() % m;
        return res;
    }

    public void put(K key, V value) {
        array[hash(key)].put(key, value);
        size++;
        if (size >= max * m && capacityIndex + 1 < capacityList.length) {
            resize(capacityList[++capacityIndex]);
        }
    }

    public boolean contain(K key) {
        return array[hash(key)].containsKey(key);
    }

    public void remove(K key) {
        array[hash(key)].remove(key);
        size--;
        if (size <= mini * m && capacityIndex - 1 >= 0) {
            resize(capacityList[--capacityIndex]);
        }
    }

    public V get(K key) {
        return array[hash(key)].get(key);
    }

    public void resize(int t) {
        int oldM = m;
        m = t;
        TreeMap<K, V>[] newArray = new TreeMap[t];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = new TreeMap<>();
        }
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = array[i];
            for (K key : array[i].keySet()) {
                //newArray[hash(key)].put(key, get(key));
                newArray[hash(key)].put(key, map.get(key));
            }
        }
        this.array = newArray;
    }

    public int length() {
        return this.m;
    }

    public static void main(String[] args) {
        HashTable<Integer, Integer> hTable = new HashTable<>();
/*
        hTable.put(1, 91);
        System.out.println(hTable.size);
        System.out.println(hTable.get(1));*/

        for (int i = 0; i < 1000; i++) {
            hTable.put(i, i + 1);
        }
        System.out.println(hTable.size);
        System.out.println(hTable.m);

    }
}
