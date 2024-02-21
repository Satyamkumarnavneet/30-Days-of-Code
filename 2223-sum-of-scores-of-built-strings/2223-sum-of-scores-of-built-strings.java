class Solution {
    int n;
    int base = 31;
    int mod = (int) 1e9 + 7;
    long[] hash;
    long[] pows;

    public long sumScores(String s) {
        n = s.length();
        if (n == 0) {
            return 0;
        }

        hash = new long[n];
        pows = new long[n];
        pows[0] = 1;
        hash[0] = s.charAt(0) - 'a' + 1;
        for (int i = 1; i < n; i++) {
            pows[i] = (pows[i-1] * base) % mod;
            hash[i] = (hash[i-1] * base + (s.charAt(i)-'a'+1)) % mod;
            if (hash[i] < 0) {
                hash[i] += mod;
            }
        }

        long score = 0;
        for (int i = n - 1; i > 0; i--) {
            score += maxPrefixLen(s, i);
        }
        score += n;

        return score;
    }

    private long maxPrefixLen(String s, int start) {
        int left = 0, right = n - start;
        while (left < right) {
            int mid = left + (right - left+1) / 2;
            if (hash(0, mid-1) == hash(start, start+mid-1)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private long hash(int start, int end) {
        if (start == 0) {
            return hash[end];
        }
        long h = (hash[end] - hash[start-1] * pows[end-start+1]) % mod;
        if (h < 0) {
            h += mod;
        }
        return h;
    }
}