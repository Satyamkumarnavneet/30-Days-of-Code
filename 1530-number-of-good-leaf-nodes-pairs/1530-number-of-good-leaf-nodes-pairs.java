class Solution {
    int pairs = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return pairs;
    }

    private List<Integer> dfs(TreeNode root, int distance){
        if(root==null)
            return new ArrayList<>();

        if(root.left==null && root.right==null){
            var lst = new ArrayList<Integer>();
            lst.add(1);
            return lst;
        }

        var leftDistances = dfs(root.left, distance);
        var rightDistances = dfs(root.right, distance);
        
        for(int leftDistance : leftDistances){
            for(int rightDistance : rightDistances){
                if(leftDistance+rightDistance<=distance)
                    pairs++;
            }
        }

        leftDistances.addAll(rightDistances);
        leftDistances.replaceAll(x->x+1);
        return leftDistances;
    }
}
