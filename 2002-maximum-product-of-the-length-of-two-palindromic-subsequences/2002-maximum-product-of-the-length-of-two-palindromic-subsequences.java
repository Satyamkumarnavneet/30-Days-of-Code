class Solution {
    
    int ans =  1;
    
    public int maxProduct(String s) {
        
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        
        for(int[] d: dp)
            Arrays.fill(d, -1);
        
        int res = solve(s, "", "", 0, dp);
        
        return res;
        
    }
    public int solve(String s, String s1, String s2, int i, int[][] dp)
    {
        int s1l = s1.length();
        int s2l = s2.length();
        
        

        if(isPali(s1) && isPali(s2))
        {
            ans = Math.max(ans, s1.length()*s2.length());
        }
        
        dp[s1l][s2l] = ans;
        
        
        if(i >= s.length())
        {
            return dp[s1l][s2l];
        }
           
        int op1 = solve(s, s1 + s.charAt(i), s2, i + 1, dp);
        int op2 = solve(s, s1, s2 + s.charAt(i), i + 1, dp);
        int op3 = solve(s, s1, s2, i + 1, dp);
        
        return dp[s1l][s2l];
    }
    public boolean isPali(String s)
    {
        int i = 0;
        int j = s.length() - 1;
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}