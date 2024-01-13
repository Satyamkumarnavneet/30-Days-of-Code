class DataStream {
    int val = 0;
    int k = 0; 
    int count = 0;

    public DataStream(int value, int k) {
        val = value;
        this.k = k;
    }
    
    public boolean consec(int num) {
        if(num == val){
            count++;
        } else{
            count = 0;
        }
        if(count >= k){
            return true;
        }
        return false;
    }
}
