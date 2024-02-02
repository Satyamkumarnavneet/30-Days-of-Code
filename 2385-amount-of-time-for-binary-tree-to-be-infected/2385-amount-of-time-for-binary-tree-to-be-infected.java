class Solution {
    void postOrder(TreeNode root, HashMap<Integer, List<Integer>> adj){
        if(root == null) return;

        postOrder(root.left, adj);
        postOrder(root.right, adj);

        int cur = root.val;
        adj.put(cur, new ArrayList<>());

        if( root.left != null ){
            adj.get(cur).add(root.left.val);
            adj.get(root.left.val).add(cur);
        }
        
        if( root.right != null ){
            adj.get(cur).add(root.right.val);
            adj.get(root.right.val).add(cur);
        }
    }

    int dfs(int src, int par, HashMap<Integer, List<Integer>> adj ){
        int ans = 0;

        for(int nbr : adj.get(src)){
            if(nbr == par) continue;
            ans = Math.max(ans, dfs(nbr, src, adj));
        }
        return 1+ans;
    }


    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        postOrder(root, adj);

        return dfs(start, -1, adj)-1;
    }
}