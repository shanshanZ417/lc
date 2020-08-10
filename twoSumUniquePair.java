// https://www.jiuzhang.com/solutions/two-sum-unique-pairs/
public class Main {
    public static void main(String[] args) {
        System.out.println(twoSumUniquePair(new int[]{1,1,2,45,46,46}, 47));

    }
    public static int twoSumUniquePair(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            while (s < e && nums[s] == nums[s + 1]) {
                s++;
            }
            while (s < e && nums[e] == nums[e - 1]) {
                e--;
            } 
            if (nums[s] + nums[e] == target) {
                res++;
                s++;
                e--;
            } else if (nums[s] + nums[e] > target) {
                e--;
            } else {
                s++;
            }
        }
        return res;
    }
}
