class LRUCache {
    int capacity;
    Map<Integer,Integer> map=new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Integer val = map.get(key);
            map.remove(key);

            map.put(key,val);
            return map.get(key);
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
        }
        else{
            if(map.size()<capacity){
                map.put(key,value);
            }else{
                // removing first element in the map.
                Iterator<Integer> iterator = map.keySet().iterator();
                map.remove(iterator.next());
                map.put(key,value);
            }
        }
    }
}