package com.prakritidev.verma.dynamicprogramming.knapsack;

public class ZeroOneKnapSack {

    public static void main(String[] args) {

        int val[] = new int[] { 60, 100, 120, 10, 90 };
        int wt[] = new int[] { 10, 20, 30, 40, 50 };
        int W = 10;
        int n = val.length;
        long start = System.nanoTime();
        System.out.println(knapSack(W, wt, val, n));
        long end = System.nanoTime();
        System.out.printf("Running time is : %s", end - start);

        System.out.println("\n");
        start = System.nanoTime();
        System.out.println("" + knapSackDP(W, wt, val, n));
        end = System.nanoTime();
        System.out.printf("Running time is : %s", end - start);

    }

    private static int knapSackDP(int w, int[] wt, int[] val, int n) {

        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= w ; j++) {
                dp[i][j] = -1;
            }
        }
        return knapSackDPImpl(w, wt, val, n, dp);
    }

    private static int knapSackDPImpl(int w, int[] wt, int[] val, int n, int[][] dp) {
        
        if (w == 0 || n == 0) {
            return 0;
        }

        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (wt[n - 1] > w) {
            dp[n][w] = knapSackDPImpl(w, wt, val, n - 1, dp);
            return dp[n][w];
        }
        else {
            dp[n][w] = Math.max(val[n - 1] + knapSackDPImpl(w - val[n - 1], wt, val, n - 1, dp),
                    knapSackDPImpl(w, wt, val, n - 1, dp));
            return dp[n][w];
        }
    }

    private static int knapSack(int w, int[] wt, int[] val, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (wt[n - 1] > w)
            return knapSack(w, wt, val, n - 1);
        else
            return Math.max(val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1), knapSack(w, wt, val, n - 1));

    }

}
