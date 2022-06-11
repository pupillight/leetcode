package org.yj.offer;

public class Offer4 {


    public boolean isExist(int[][] array, int target) {
        int row = array.length;
        int col = array[0].length;
        int k = Math.min(row, col);

        for (int i = 0; i < k; i++) {
            //looking for by row
            boolean isRow = findByRow(array, i, target);
            boolean isCol = findByCol(array, i, target);
            if (isRow || isCol) {
                return true;
            }
        }
        return false;
    }

    private boolean findByRow(int[][] array, int i, int target) {
        int left = i;
        int right = array[i].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[i][mid] > target) {
                right = mid - 1;
            } else if (array[i][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean findByCol(int[][] array, int i, int target) {
        int left = i;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid][i] > target) {
                right = mid - 1;
            } else if (array[mid][i] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Offer4 offer = new Offer4();
        int[][] array = {{1, 4, 7, 11}, {2, 5, 8, 12}, {3, 6, 9, 16}};


        System.out.println(offer.isExist(array, 13));

    }

}
