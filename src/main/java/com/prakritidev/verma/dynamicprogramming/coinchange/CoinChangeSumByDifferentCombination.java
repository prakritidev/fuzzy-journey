package com.prakritidev.verma.dynamicprogramming.coinchange;

import java.util.Arrays;


/**
 * Created by Prakritidev Verma on 25/12/22.
 * Problem statement: given coin n[] and integer sum, find the number of ways to make sum from given coin.
 */

public class CoinChangeSumByDifferentCombination {


    public static void main(String[] args) {
        
        int coins[] = { 1, 2, 3, 4, 5 };
        int n = coins.length;
        int sum = 10;
        long start = System.nanoTime();
        System.out.println(count(coins, n, sum));
        long end = System.nanoTime();
        System.out.printf("Running time is : %s", end - start);

        int[][] dp = new int[n + 1][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("\n");
        start = System.nanoTime();
        System.out.println(countDP(coins, n, sum, dp));
       
        end = System.nanoTime();
        System.out.printf("Running time is : %s", end - start);
    }

    private static int countDP(int[] coins, int n, int sum, int[][] dp) {
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        if (n <= 0)
            return 0;
        if (dp[n][sum]!= -1)
            return dp[n][sum];
        dp[n][sum] = count(coins, n - 1, sum) + count(coins, n, sum - coins[n - 1]);
        return dp[n][sum];
    }

    private static int count(int[] coins, int n, int sum) {
        
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        if (n <= 0)
            return 0;
        return count(coins, n - 1, sum) + count(coins, n, sum - coins[n-1]);
        
    }
}
