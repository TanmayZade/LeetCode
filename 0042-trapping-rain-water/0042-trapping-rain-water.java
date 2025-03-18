class Solution {
    public int trap(int[] height) {
        int leftmax[] = new int[height.length];
        int rightmax[] = new int[height.length];

        leftmax[0] = height[0];
        rightmax[height.length-1] = height[height.length-1];
        int n = height.length;
        for(int i = 1;i <n;i++ ){
            leftmax[i] = Math.max(leftmax[i-1],height[i]);
        }

        for(int i = n-2;i >= 0;i--){
            rightmax[i] = Math.max(height[i],rightmax[i+1]);
        }
        int trappedwater = 0;
        for(int i = 0;i < n;i++){
            int wl = Math.min(leftmax[i],rightmax[i]);
            trappedwater += (wl - height[i]) * 1;
        }

        return trappedwater;
    }
}