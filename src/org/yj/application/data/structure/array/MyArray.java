package org.yj.application.data.structure.array;

public class MyArray<T> {
    public T[] data;
    private int size;
    private final static int defaultCapacity = 10;

    public MyArray(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public MyArray() {
        this(defaultCapacity);
    }

    public MyArray(T[] array) {
        data = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        size = array.length;
    }


    public int size() {
        return this.size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        return data[index];
    }

    public void set(int index, T e) {
        if (index < 0 || index >= size()) {
            System.out.println("illegal parameter.");
            return;
        }
        data[index] = e;
    }

    public void addFirst(T e) {
        this.add(e, 0);
    }

    public void addLast(T e) {
        add(e, size);
    }

    public void add(T e, int index) {
        if (index < 0 || index > size) {
            System.out.println("illegal parameter.");
            return;
        }

        if (size == data.length) {
            this.resize(data.length * 2);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    public void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    public T removeFirst() {
        return this.remove(0);
    }

    public T removeLast() {
        return this.remove(size - 1);
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("illegal parameter.");
            return null;
        }
        if (size == 0) {
            System.out.println("data is empty.");
        }

        T tmp = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        //data[index] = null;
        size--;
        if (size <= data.length / 2 && size >= defaultCapacity) {
            resize(data.length / 2);
        }
        return tmp;
    }

    public int find(T e) {

        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;

    }

    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || i > data.length - 1 || j < 0 || j > data.length - 1) {
            return;
        }
        T tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    @Override
    public String toString() {
        return String.format("data capacity=%d, size=%d", this.getCapacity(), this.size).toString();

    }


    public static void main(String[] args) {
        MyArray<Integer> array = new MyArray(10);
        for (int i = 0; i < 5; i++) {
            array.addLast(i);
        }

        array.addFirst(200);
        array.print();
        System.out.println(array);
        System.out.println("------------------");
        array.removeFirst();
        array.removeLast();
//        array.print();
//        array.swap(7, 8);
        array.print();

        //System.out.println(array.find(0));
        System.out.println("size = " + array.size);
        System.out.println(array);


    }

}
