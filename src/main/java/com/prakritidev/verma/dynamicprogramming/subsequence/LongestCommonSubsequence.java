package com.prakritidev.verma.dynamicprogramming.subsequence;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTABASDFGHJKLPOIUYTREWQZXCBNML";
        String s2 = "GXTXAYBMNBVCFGHJKASDFGHJKL";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Length of LCS is" + " " +
                lcs.lcs(X, Y, m, n, dp));
        System.out.println("Length of LCS is" + " " +
                lcs.lcsNonRecursive(X, Y, m, n));
        
    }

    private int lcsNonRecursive(char[] x, char[] y, int m, int n) {

        int[][] cache = new int[m + 1][n + 1];
        
        for (int i = 0; i <=m; i++) {
            for (int j = 0; j <=n; j++) {
                if (i == 0 || j == 0)
                    cache[i][j] = 0;
                else if (x[i-1] == y[j-1]) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
                }
            }
        }
        return cache[m][n];
    }

    private int lcs(char[] x, char[] y, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1)
            return dp[m][n];

        if (x[m - 1] == y[n - 1])
            return dp[m][n] = 1 + lcs(x, y, m - 1, n - 1, dp);
        else

            return dp[m][n] = Math.max(lcs(x, y, m - 1, n, dp), lcs(x, y, m, n - 1, dp));
    }
    


}
