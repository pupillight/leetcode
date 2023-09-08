package org.yj.leetcode;

enum Side {NONE, LEFT, RIGHT}

public class ChainLink {
    private ChainLink left, right;

    public void append(ChainLink rightPart) {
        if (this.right != null)
            throw new IllegalStateException("Link is already connected.");

        this.right = rightPart;
        rightPart.left = this;
    }

    public Side longerSide() {

        if(this.left == this.right)
        {
            return Side.NONE;
        }
        int countRight = 0;
        ChainLink curRight = this.right;
        while (curRight != null && countRight<=Integer.MAX_VALUE) {
            countRight++;
            curRight = curRight.right;
        }


        int countLeft = 0;
        ChainLink curLeft = this.left;
        while (curLeft != null) {
            countLeft++;
            curLeft = curLeft.left;
        }

        if (countLeft > countRight) {
            return Side.LEFT;
        } else if (countLeft < countRight) {
            return Side.RIGHT;
        } else {
            return Side.NONE;
        }


        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        ChainLink left = new ChainLink();
        ChainLink middle = new ChainLink();
        ChainLink right = new ChainLink();
        left.append(middle);
        middle.append(right);
        System.out.println(left.longerSide());
    }
}
