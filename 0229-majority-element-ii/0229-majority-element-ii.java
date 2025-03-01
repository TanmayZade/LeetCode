class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int cnt1= 0,cnt2 = 0, el1 = Integer.MIN_VALUE,el2 = Integer.MIN_VALUE;
         for(int i = 0;i < nums.length;i++){
            if(cnt1== 0 && el2 != nums[i]){
                cnt1++;
                el1 = nums[i];
            }else if(cnt2 == 0 && el1 != nums[i]){
                cnt2++;
                el2= nums[i];
            }else if(nums[i] == el1) cnt1++;
             else if(nums[i] == el2) cnt2++;
             else{
                cnt1--;
                cnt2--;
             }

         }

        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == el1) cnt1++;
            if (num == el2) cnt2++;
        }

        int threshold = nums.length / 3;
        if (cnt1 > threshold) result.add(el1);
        if (cnt2 > threshold) result.add(el2);
        return result;
    }
}