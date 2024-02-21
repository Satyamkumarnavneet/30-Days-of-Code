class Solution {
    Integer[] arr; MountainArray mt;
    private int get(int i) { 
        if(arr[i]==null) return arr[i]=mt.get(i);
        else return arr[i];
    }
    public int findInMountainArray(int t, MountainArray mt) {
        int n=mt.length(),m; this.mt=mt;
        arr=new Integer[n];
        int peak=binarySearch(mt, 0, n-1, 0, -1);
        int fl=binarySearch(mt, 0, peak, 1, t), fr=binarySearch(mt, peak, n-1, 2, t);
        int s=Math.min(fl, fr);
        return s==Integer.MAX_VALUE? -1: s;
    }
    private int binarySearch(MountainArray mt, int l, int r, int choice, int s) {
        int m;
        while(l<=r) {
            m=(l+r)/2;
            int cmp=compare(mt, m, choice, s);
            if(cmp==0) {
                return m;
            }else if(cmp>0) {
                l=m+1;
            }else r=m-1;
        }
        return Integer.MAX_VALUE;
    }
    private int compare(MountainArray mt, int ind, int choice, int search) {
        switch(choice) {
            case 0:
                if(ind==0) return 1; 
                if(ind==arr.length-1) return -1;
                if(get(ind-1)<get(ind) && get(ind)>get(ind+1)) return 0;
                else if(get(ind-1)<get(ind) && get(ind)<get(ind+1)) return 1;
                else return -1;
            case 1:
                if(get(ind)<search) return 1;
                else if(get(ind)==search) return 0;
                else return -1;
            case 2:
                if(get(ind)<search) return -1;
                else if(get(ind)==search) return 0;
                else return 1;
            default: return 0;
        }
    }
}