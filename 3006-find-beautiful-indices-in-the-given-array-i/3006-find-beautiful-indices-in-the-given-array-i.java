class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
         List<Integer> aList=new ArrayList<>();
        List<Integer> bList=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(i<=s.length()-a.length() && a.equals(s.substring(i,i+a.length()))){
                aList.add(i);
            }
            if(i<=s.length()-b.length() && b.equals(s.substring(i,i+b.length()))){
                bList.add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<aList.size();i++){
            for(int j=0;j<bList.size();j++){
                if(Math.abs(aList.get(i)-bList.get(j))<=k){
                    // bList.remove(new Integer(bList.get(j)));
                    ans.add(aList.get(i));
                    break;
                }
            }
        }
        // Collections.sort(ans);
        return ans;
    }
}