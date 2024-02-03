class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int partialSum = 0;
        int n = nums.length;
		
        for(int i = 0; i < n; i++){
            sum += nums[i];
            partialSum += nums[i] * i;
        }

        int max = partialSum;
		
        for(int i = n - 1; i >= 1 ; i--){
            partialSum = partialSum + sum - n * nums[i];
            max = Math.max(max , partialSum);
        }
      
        return max;
    }
}
