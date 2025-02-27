class TRAPPINGRAINWATERhard {
    public int trap(int[] height) {
        if(height==null || height.length==0) return 0;
        int left=0;
        int right=height.length-1;
        int leftmax=0;
        int rightmax=0;
        int waterTrapped=0;
        while(left<=right){
            if(height[left]<height[right]){
                if(height[left]>=leftmax){
                    leftmax=height[left];
                }
                else{
                    waterTrapped +=leftmax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>=rightmax){
                    rightmax=height[right];
                }
                else{
                    waterTrapped +=rightmax-height[right];
                }
                right--;
            }
        }
        return waterTrapped;
    }
}