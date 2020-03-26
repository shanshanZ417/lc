public class Main {
    public static void main(String[] args) {
        int[] w = {2, 3, 5};
        System.out.println(backpack(w, 11));
    }
    private static int backpack(int[] nums, int total) {
        int n = nums.length;
        // 1 ~ n package to get weight j
        boolean[][] dp = new boolean[n + 1][total + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= total; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j && dp[i - 1][j - nums[i - 1]]) {
                    dp[i][j] = true;
                }
            }
        }
        for (int i = total; i >= 0; i--) {
            if (dp[n][i]) {
                return i;
            }
        }
        return 0;
    }
}
