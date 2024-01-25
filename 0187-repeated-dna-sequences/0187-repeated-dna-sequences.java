class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();

        if(s.length() <= 10){
            return result;
        }

        Set<String> set1 = new HashSet();
        Set<String> set2 = new HashSet();

        for(int i = 0; i<=s.length()-10; i++){
            String possibleSeq = s.substring(i, i+10);
            if(!set1.add(possibleSeq)){
                set2.add(possibleSeq);
            }
        }
        result.addAll(set2);
        return result;
    }
}