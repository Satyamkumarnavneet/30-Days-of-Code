class DataStream {
    private int val, k, count;
    public DataStream(int value, int k) {
        this.val = value;
        this.k = k;
        this.count = 0;
    }
    
    public boolean consec(int num) {
        count = (num == val) ? count + 1 : 0;
        return count >=k;
    }
}

