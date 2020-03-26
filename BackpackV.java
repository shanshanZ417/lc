public class Main {
    public static void main(String[] args) {
        int[] w = {1, 2, 3, 3, 7};
        System.out.println(backpack(w, 7));
    }
    private static int backpack(int[] nums, int total) {
        int n = nums.length;
        // 1 ~ n package to get weight j
        int[][] dp = new int[n + 1][total + 1];
        for (int i = 0; i <=n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= total; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j ) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][total];
    }
}
