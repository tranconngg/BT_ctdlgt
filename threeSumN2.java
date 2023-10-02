package BTtuan1CTGL;

import java.util.Arrays;

public class threeSumN2 {
    static int cnt = 0;
    public static void threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    cnt++;
                    System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
        System.out.println("có"+" "+cnt+" "+"bộ 3 số có tổng bằng 0");
    }
}
