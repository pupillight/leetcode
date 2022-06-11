package org.yj.application.data.structure.tree;

public class UnionFind1 implements UF {

    private int size;
    private int[] nums;

    public UnionFind1(int size) {
        this.size = size;
        nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = i;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int find(int num) {
        if (num < 0 || num >= nums.length) {
            throw new IllegalArgumentException("error index");
        }
        return nums[num];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pRoot) {
                nums[i] = qRoot;
            }
        }
    }


    public static void main(String[] args) {
        UF uf = new UnionFind1(10);
        uf.union(3, 8);
        uf.union(8, 1);
        System.out.println(uf.isConnected(3, 1));

    }
}
