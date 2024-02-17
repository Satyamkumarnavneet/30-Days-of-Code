class Solution {
    public int countCollisions(String dir) {
        int i = 0;
        int j = dir.length() - 1;
        int count = 0;
        while(i<dir.length() && dir.charAt(i) == 'L'){
            i++;
        }
        while(j>=0 && dir.charAt(j) == 'R'){
            j--;
        }
        for(int it = i;it<=j;it++){
            if(dir.charAt(it) != 'S'){
                count++;
            }
        }
        return count;
    }
}