class PERMUTATIONSEQUENCEhard {
    public String getPermutation(int n, int k) {
        List<Integer> numbers=new ArrayList<>();
        int fact=1;

        for(int i=1;i<=n;i++){
            numbers.add(i);
            if(i<n) fact *=i;
        }

        k--;
        StringBuilder result=new StringBuilder();

        for(int i=n-1;i>=0;i--){
            int index= k/fact;
            result.append(numbers.get(index));
            numbers.remove(index);

            if(i>0){
                k %=fact;
                fact /=i;
            }
        }
        return result.toString();
    }
}