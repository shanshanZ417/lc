// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(win(5));
    }
    private static boolean win(int n) {
        boolean[] wins = new boolean[n + 1];
        wins[1] = true;
        wins[2] = true;
        for (int i = 3; i <= n; i++) {
            wins[i] = !wins[i - 1] || !wins[i - 2];
        }
        return wins[n];
    }
}
