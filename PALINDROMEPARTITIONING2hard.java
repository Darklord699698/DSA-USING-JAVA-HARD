class PALINDROMEPARTITIONING2hard {
    public int minCut(String s) {
        int n=s.length();
        boolean[][] isPalindrome=new boolean[n][n];
        int[] dp=new int[n];
        for(int mid=0;mid<n;mid++){
            expandAroundCenter(s,mid,mid,isPalindrome);
            expandAroundCenter(s,mid,mid+1,isPalindrome);
        }
        for(int i=0;i<n;i++){
            if(isPalindrome[0][i]){
                dp[i]=0;
            }
            else{
                dp[i]=i;
                for(int j=0;j<i;j++){
                    if(isPalindrome[j+1][i]){
                        dp[i]=Math.min(dp[i],dp[j]+1);
                    }
                }
            }
        }
        return dp[n-1];
    }
    private void expandAroundCenter(String s,int left,int right,boolean[][] isPalindrome){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            isPalindrome[left][right]=true;
            left--;
            right++;
        }
    }
}