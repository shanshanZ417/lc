public class Main {
    public static void main(String[] args) {
        int[] w = {1, 2, 3, 3, 7};
        System.out.println(backpack(w, 7));
    }
    private static int backpack(int[] num, int total) {
        int n = num.length;
        // 1 ~ n number add up to part of total
        int[][] backpack = new int[n + 1][total + 1];
        for (int i = 0; i <= n; i++) {
            backpack[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int p = 1; p <= total; p++) {
                backpack[i][p] = backpack[i - 1][p];
                if (num[i - 1] <= p) {
                    backpack[i][p] += backpack[i - 1][p - num[i - 1]];
                }
            }
        }
        return backpack[n][total];
    }
}
