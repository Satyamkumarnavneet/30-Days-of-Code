import java.util.Arrays;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0, right = 1, count = 0;
        while (left < nums.length && right < nums.length) {
            if (left == right || nums[right] - nums[left] < k) {
                right++;
            } else if (nums[right] - nums[left] > k) {
                left++;
            } else {
                count++;
                left++;
                while (left < nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
            if (right <= left) {
                right = left + 1;
            }
        }
        return count;
    }
}
