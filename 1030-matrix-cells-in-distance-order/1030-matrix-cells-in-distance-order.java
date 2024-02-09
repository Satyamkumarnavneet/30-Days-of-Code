class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCentre, int cCentre) {

        PriorityQueue<Pair<Integer, int[]>> pq = new PriorityQueue<>(rows*cols,(a,b) -> a.getKey() - b.getKey());
        int[][] ans = new int[rows*cols][];

        Integer dist;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dist = Math.abs(rCentre-i) + Math.abs(cCentre-j);
                pq.add(new Pair<Integer, int[]>(dist, new int[]{i,j}));
            }
        }

        int i=0;
        while(!pq.isEmpty()){
            ans[i] = pq.poll().getValue();
            i++;
        }

        return ans;
    }
}