class Solution {
    public int maxRotateFunction(int[] nums) {
    int n = nums.length;
    int sum = 0;
    int iterationSum = 0;

    for (int i = 0; i < n; i++) {
        sum += nums[i];
        iterationSum += i * nums[i];
    }

    int maxSum = iterationSum;
    for (int i = 1; i < n; i++) {
        iterationSum += sum - n * nums[n - i];
        maxSum = Math.max(maxSum, iterationSum);
    }

    return maxSum;
}

}