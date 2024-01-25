class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();

        if(s.length() <= 10){
            return res;
        }

        Set<String> set1 = new HashSet();
        Set<String> set2 = new HashSet();

        for(int i = 0; i<=s.length()-10; i++){
            String possibleDNASeq = s.substring(i,i+10);
            if(!set1.add(possibleDNASeq)){
                set2.add(possibleDNASeq);
            }
        }
        res.addAll(set2);
        return res;
        
    }
}