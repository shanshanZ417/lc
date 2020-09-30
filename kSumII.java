import java.util.*;
// https://www.jiuzhang.com/solution/k-sum-ii/
public class Main {
    public static void main(String[] args) {
        System.out.println(kSum(new int[]{1,3,4,6}, 3, 8).toString());
    }
    private static List<List<Integer>> kSumII(int[] candidates, int k, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, k, target, cur, res);
        return res;
    }
    private static void helper(int[] candidates, int index, int k, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0 && cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target <= 0 || cur.size() > k) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            helper(candidates, i + 1, k, target - candidates[i], cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
