// 不知道对不对。。。
public class Main {
    public static void main(String[] args) {
        int[] vals = {3, 2, 4, 7};
        copyBooks(vals, 2);
        System.out.println(copyBooks(vals, 2));
    }
    public static int copyBooks(int[] val, int k) {
        if (val == null || val.length == 0) {
            return 0;
        }
        int n = val.length;
        int[][] dp = new int[k + 1][n + 1];
        
        int[] sum = new int[n];
        sum[0] = val[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + val[i];
        }
        for (int p = 1; p <= k; p++) {
            // [3, 2, 4]
            //     i
            for (int i = 1; i <= n; i++) {
                dp[p][i] = sum[i - 1];
                if (p == 1) {
                    continue;
                }
                int current = sum[i - 1];
                for (int j = 1; j <= i; j++) {
                    // sum is books from j i-1
                    // [3, 2, 4]
                    current -= val[j - 1];
                    dp[p][i] = Math.min(Math.max(current, dp[p - 1][j]), dp[p][i]);
                }
            }
        }
        return dp[k][n];
    }
}
