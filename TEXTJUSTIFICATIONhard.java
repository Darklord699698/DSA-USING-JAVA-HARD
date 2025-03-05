class TEXTJUSTIFICATIONhard {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result=new ArrayList<>();
        int index=0;

        while(index<words.length){
            int totalchars=words[index].length();
            int last=index+1;
            while(last<words.length){
                if(totalchars+1+words[last].length()>maxWidth) break;
                totalchars += 1+words[last].length();
                last++;
            }
            int gaps=last-index-1;
            StringBuilder line=new StringBuilder();
            if(last==words.length || gaps==0){
                for(int i=index;i<last;i++){
                    line.append(words[i]);
                    if(i<last-1) line.append(" ");
                }
                while(line.length()<maxWidth) line.append(" ");
            }
            else{
                int spaces=(maxWidth-totalchars+gaps)/gaps;
                int extraSpaces=(maxWidth-totalchars+gaps)%gaps;
                for(int i=index;i<last;i++){
                    line.append(words[i]);
                    if(i<last-1){
                        int spacecount=spaces+(i-index<extraSpaces ? 1:0);
                        for(int j=0;j<spacecount;j++){
                            line.append(" ");
                        }
                    }
                }
            }
            result.add(line.toString());
            index=last;
        }
        return result;
    }
}