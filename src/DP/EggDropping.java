package DP;

import java.util.Arrays;

public class EggDropping {
    static final int MAX = 10000;

    static int[][] memo = new int[MAX][MAX];

    static int solveEggDrop(int n, int k)
    {

        if (memo[n][k] != -1) {
            return memo[n][k];
        }

        if (k == 1 || k == 0)
            return k;

        if (n == 1)
            return k;

        int min = Integer.MAX_VALUE, x, res;

        for (x = 1; x <= k; x++) {
            res = Math.max(solveEggDrop(n - 1, x - 1),
                           solveEggDrop(n, k - x));
            if (res < min)
                min = res;
        }

        memo[n][k] = min + 1;
        return min + 1;
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);
        //k-floors, n-no of drops
        int n = 4, k = 1000;
        System.out.print(solveEggDrop(n, k));
    }
}

// This code IS contributed by umadevi9616
