class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int[] dp = new int[specialRoads.length]; // the min cost from (x2i, y2i) to destination
        
        for (int i = 0; i < specialRoads.length; i++) {
            dp[i] = cost(target[0], specialRoads[i][2], target[1], specialRoads[i][3]);
        }
        
        for (int loop = 0; loop < specialRoads.length; loop++) {
            for (int i = 0; i < specialRoads.length; i++) {
                for (int j = 0; j < specialRoads.length; j++) {
                    dp[i] = Math.min(
                        dp[i], 
                        cost(specialRoads[i][2], specialRoads[j][0], specialRoads[i][3], specialRoads[j][1]) + specialRoads[j][4] + dp[j]
                    );
                }
            }
        }
        
        int minCost = cost(start[0], target[0], start[1], target[1]);
        
        for (int i = 0; i < specialRoads.length; i++) {
            minCost = Math.min(
                minCost,
                cost(start[0], specialRoads[i][0], start[1], specialRoads[i][1]) + specialRoads[i][4] + dp[i]
            );
        }
        
        return minCost;
    }
    
    private int cost(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}