
class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        Set<String> res = new HashSet<>(Arrays.asList(words));
        for(String word : words){
            for(int i =1; i < word.length(); i++){
                res.remove(word.substring(i));
            }
            
        }
        int length=0;
        for(String j : res){
            length += j.length() +1;
        }
            
        return length;
    }
}
