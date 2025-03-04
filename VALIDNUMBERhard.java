class VALIDNUMBERhard {
    public boolean isNumber(String s) {
        s=s.trim();
        boolean seenDigit=false ,seenExponent=false ,seenDot=false;

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                seenDigit=true;
            }
            else if(c=='.'){
                if(seenDot || seenExponent){
                    return false;
                }
                seenDot=true;
            }
            else if(c=='e' || c=='E'){
                if(seenExponent || !seenDigit){
                    return false;
                }
                seenExponent=true;
                seenDigit=false;
            }
            else if(c=='+' || c=='-'){
                if(i>0 && s.charAt(i-1)!='e' && s.charAt(i-1)!='E'){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return seenDigit;
    }
}