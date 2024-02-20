class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(Integer i : nums)
        {
            pq.add(i);
        }
        long ans = 1;
        long mod = (long)(1e9 + 7);
        while(k>0)
        {
            int x = pq.remove();
            x += 1;
            pq.add(x);
            k--;
        }
        for(Integer i : pq)
        {
            ans *= i;
            ans = ans%mod;
        }
        return (int) (ans%mod);
    }
}