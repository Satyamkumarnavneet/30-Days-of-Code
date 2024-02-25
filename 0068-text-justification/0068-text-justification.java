class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans=new ArrayList<>();
        int r=0,l=0;
        int n=words.length;
        while(r<n){
            int totlen=0,numword=0;
            while(r<n){
                totlen+=words[r].length();
                numword++;
                if(totlen+numword-1>maxWidth){
                    totlen-=words[r].length();
                    numword--;
                    break;
                }
                r++;
            }
            StringBuilder str=new StringBuilder();
            if(r<n && numword>1){
                int numspace=(maxWidth-totlen)/(numword-1);
                int rem=(maxWidth-totlen)%(numword-1);
                String space="";
                for(int i=0;i<numspace;i++)space+=" ";
                while(l<r-1){
                    str.append(words[l]+space);
                    if(rem!=0){
                        str.append(" ");
                        rem--;
                    }
                    l++;
                }
                str.append(words[l++]);
            }else{
                while(l<r-1){
                    str.append(words[l]+" ");
                    l++;
                }
                str.append(words[l++]);
                if(str.length()<maxWidth){
                    int numspace=maxWidth-str.length();
                    String space="";
                    for(int i=0;i<numspace;i++)space+=" ";
                    str.append(space);
                }
            }
            ans.add(str.toString());
        }
        return ans;
    }
}