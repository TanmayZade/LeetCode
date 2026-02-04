class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nIdx = n-1, mIdx = m-1, right = m + n - 1;

        while(nIdx >= 0){
            if(mIdx >= 0 && nums1[mIdx] > nums2[nIdx]){
                nums1[right] = nums1[mIdx];
                mIdx--;
            }else{
                nums1[right] = nums2[nIdx];
                nIdx--;
            }
            right--;
        }
    }
}