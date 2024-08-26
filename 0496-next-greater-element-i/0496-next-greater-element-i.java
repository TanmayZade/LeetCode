class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        int ansIdx[] = new int[nums1.length];
        int nextGreat[] = new int[nums2.length];
        for(int i = 0;i < nums1.length;i++){
            for(int j = 0; j < nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    ansIdx[i] = j;
                    break;
                }
            }
        }
        Stack<Integer> s = new Stack<>();
        for(int i = nums2.length - 1;i >= 0;i--){
            int curr = nums2[i];
            while(!s.isEmpty() &&   curr >= s.peek() )
                s.pop();

            if(s.isEmpty())
                nextGreat[i] = -1;
            else
                nextGreat[i] = s.peek();

            s.push(curr);
        }

        for(int i = 0; i < nums1.length;i++){
            ans[i] = nextGreat[ansIdx[i]];
        }

        return ans;
    }
}