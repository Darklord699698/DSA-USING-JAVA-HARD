class WILDCARDMATCHINGhard{
    public boolean isMatch(String s, String p) {
        int i=0;
        int j=0;
        int starIdx=-1;
        int match=0;
        while(i<s.length()){
            if(j<p.length() && (p.charAt(j)==s.charAt(i) || p.charAt(j)=='?')){
                i++;
                j++;
            }
            else if(j<p.length() && p.charAt(j)=='*'){
                starIdx=j++;
                match=i;
            }
            else if(starIdx!=-1){
                j=starIdx+1;
                i=++match;
            }
            else{
                return false;
            }
        }
        while(j<p.length() && p.charAt(j)=='*') j++;
        return j==p.length();
    }
}