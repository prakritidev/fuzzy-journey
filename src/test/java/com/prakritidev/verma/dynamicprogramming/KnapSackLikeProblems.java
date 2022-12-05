package com.prakritidev.verma.dynamicprogramming;

public class KnapSackLikeProblems {
    public static void main(String[] args) {

        KnapSackLikeProblems knapSackLikeProblems = new KnapSackLikeProblems();
        /**
         * Knapsack initialization.
         */
        int[] zeroOneKnapSackWeight = {10,1000,6,40,59,56,17,38,95,1};
        int[] zeroOneKnapSackValue = {1,2,3,4,5,6,7,8,9,10};
        int size = 500;
        int zeroOneKnapSackWeightSize = zeroOneKnapSackValue.length;
        Long start = System.currentTimeMillis();
        System.out.println("Total runtime: ====== for recursive knapSack ======" );
        System.out.println("Knapsack output : " + knapSackLikeProblems.zeroOneKnapSack(size, zeroOneKnapSackWeight, zeroOneKnapSackValue, zeroOneKnapSackWeightSize) + " Total runtime in millisecond: " + (System.currentTimeMillis() - start));

    }
    public int zeroOneKnapSack(int size, int[] zeroOneKnapSackWeight, int[] zeroOneKnapSackValue, int zeroOneKnapSackWeightSize) {

        // If I don't have one of this, I cant process it.
        if(size == 0 || zeroOneKnapSackWeightSize == 0) return 0;

        if(zeroOneKnapSackWeight[zeroOneKnapSackWeightSize - 1] > size){
            return zeroOneKnapSack(size, zeroOneKnapSackWeight, zeroOneKnapSackValue, zeroOneKnapSackWeightSize - 1);
        } else {
            return Math.max(
                    zeroOneKnapSackWeight[zeroOneKnapSackWeightSize - 1] + zeroOneKnapSack(size - zeroOneKnapSackWeight[zeroOneKnapSackWeightSize - 1], zeroOneKnapSackWeight, zeroOneKnapSackValue, zeroOneKnapSackWeightSize - 1),
                    zeroOneKnapSack(size, zeroOneKnapSackWeight, zeroOneKnapSackWeight, zeroOneKnapSackWeightSize-1)
            );
        }
    }


}
