class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int skip = 0;
        for( int i = 0; i < s.length(); i++){
            maxCost -= Math.abs( s.charAt(i) - t.charAt(i));
            if( maxCost < 0){ 
                maxCost += Math.abs( s.charAt(skip) - t.charAt(skip));
                skip++;
            }
        }
        return s.length() - skip;
    }
}