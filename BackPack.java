// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] w = {2, 3, 5};
        System.out.println(backpack(w, 11));
    }
    private static int backpack(int[] w, int pack) {
        int n = w.length;
        // 1 ~ n package to get weight j
        boolean[][] backpack = new boolean[n + 1][pack + 1];
        for (int i = 0; i <= n; i++) {
            backpack[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int p = 1; p <= pack; p++) {
                backpack[i][p] = backpack[i - 1][p];
                if (w[i - 1] <= p && backpack[i - 1][p - w[i - 1]]) {
                    backpack[i][p] = true;
                }
            }
        }
        for (int p = pack; p >= 0; p--) {
            if (backpack[n][p]) {
                return p;
            }
        }
        return 0;
    }
}
