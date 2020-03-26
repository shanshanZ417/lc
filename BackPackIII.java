public class Main {
    public static void main(String[] args) {
        int[] w = {2, 3, 5, 7};
        int[] val = {1, 5, 2, 4};
        System.out.println(backpack(w, val, 10));
    }
    private static int backpack(int[] w, int[] val, int total) {
        int n = w.length;
        // 1 ~ n package to get weight j
        int[][] dp = new int[n + 1][total + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= total; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i - 1] <= j ) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - w[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][total];
    }
}
