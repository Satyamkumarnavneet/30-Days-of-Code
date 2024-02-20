class Solution {
    public boolean isSafe(int x,int y,int n,int m,int[][] grid,boolean[][] vis){
        return x>=0 && x<n && y>=0 && y<m && vis[x][y]==false && grid[x][y]==1;
    }
    public void countLandHelper(int x,int y,int[][] grid,boolean[][] vis){
        vis[x][y] = true;
        int[] dir = {1,0,-1,0,1};
        for(int i = 0;i<4;i++){
            int curr = x + dir[i];
            int curc = y + dir[i+1];
            if(isSafe(curr,curc,grid.length,grid[0].length,grid,vis)){
                countLandHelper(curr,curc,grid,vis);
            }
        }

    }
    public int countLand(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j]==1&&vis[i][j]==false){
                   countLandHelper(i,j,grid,vis);
                   count++;
                }
            }
        }
        return count;
    }
    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = countLand(grid);
        if(cnt>1||cnt==0) return 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1){
                    grid[i][j] = 0;
                    int totalLands = countLand(grid);
                    if(totalLands!=1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
}