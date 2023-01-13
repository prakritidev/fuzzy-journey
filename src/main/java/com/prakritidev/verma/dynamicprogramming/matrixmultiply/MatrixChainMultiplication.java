package com.prakritidev.verma.dynamicprogramming.matrixmultiply;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 3 };
        int N = arr.length;
         // Function call
         System.out.println(
            "Minimum number of multiplications is "
            + MatrixChainOrder(arr, 1, N - 1));

    }

    private static int MatrixChainOrder(int[] arr, int i, int j) {
        if (i == j)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k = i ; k < j; k++){
            int count = MatrixChainOrder(arr, i, k) + MatrixChainOrder(arr, k+1, j) + arr[i -1] * arr[k] * arr[j];
            if(count < min) {
                min = count;
            }
            
        }
        return min;
    }

    private static int MatrixChainOrderRecDp(int[] arr, int i, int j) {
        if (i == j)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k = i ; k < j; k++){
            int count = MatrixChainOrder(arr, i, k) + MatrixChainOrder(arr, k+1, j) + arr[i -1] * arr[k] * arr[j];
            if(count < min) {
                min = count;
            }
            
        }
        return min;
    }
    

    
}
