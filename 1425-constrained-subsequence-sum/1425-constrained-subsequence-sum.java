class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=Integer.MIN_VALUE;
        max=Math.max(dp[0],max);

        Deque<Integer> q=new ArrayDeque();
        q.offer(nums[0]);
        for(int i=1;i<nums.length;i++){
            dp[i]=nums[i];
            if(i>k && q.peekFirst()==dp[i-k-1]){
                q.removeFirst();
            }
            dp[i]=Math.max(dp[i],q.peek()+nums[i]);
            while(!q.isEmpty()&& q.peekLast()<dp[i]){
                q.pollLast();
            }
            q.offerLast(dp[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}