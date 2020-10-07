// https://www.jiuzhang.com/solution/split-string/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(stringSplit("12345").toString());
    }
    private static List<List<String>> stringSplit(String str) {
        List<List<String>> res = new ArrayList<>();
        helper(0, str, new ArrayList<>(), res);
        return res;
    }
    private static void helper(int index, String str, List<String> cur, List<List<String>> res) {
        if (index == str.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        // or we can add it seperately
        for (int i = 1; i < 3; i++) {
            if (index + i > str.length()) {
                continue;
            }
            cur.add(str.substring(index, index + i));
            helper(index + i, str, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
