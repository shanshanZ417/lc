public class Main {
    public static void main(String[] args) {
        System.out.println(lessOrEqual(new int[]{2, 7, 11, 15}, 24));
    }
    public static int lessOrEqual(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int j = len - 1;
            while (j > i && nums[i] + nums[j] > target) {
                j--;
            }
            res += j - i;
        }
        return res;
    }
}
