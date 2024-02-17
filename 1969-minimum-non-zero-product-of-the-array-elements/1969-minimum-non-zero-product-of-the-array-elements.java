class Solution {
    int mod = 1000_000_007;
    public int minNonZeroProduct(int p) {
        if(p==1) return 1;
        long n= (long)Math.pow(2,p)-1;
        long res = ((n%mod) * power((n-1), n/2) );
        return (int)(res%mod);
    }
    long power(long x, long y) {
        long res = 1;
        if (x == 0)
          return 0; 
        while (y > 0) {
          if (y %2 != 0) res = ((res%mod) * (x%mod)) % mod;
          y/=2;
          x = ((x%mod) * (x%mod)) % mod;
        }
        return (res%mod);
  }
}