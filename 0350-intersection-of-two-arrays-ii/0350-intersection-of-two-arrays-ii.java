class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int temp[] = new int[Math.min(nums1.length,nums2.length)];
        
        int i = 0,j = 0,k = 0;
        
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j] ){
                temp[k++] = nums1[i];
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        
        return Arrays.copyOf(temp,k);
        
    }
}