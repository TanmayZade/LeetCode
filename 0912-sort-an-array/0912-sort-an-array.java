class Solution {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;

        mergesort(nums,0,nums.length - 1);
        return nums;
    }

    public static void mergesort(int nums[],int si,int ei){
        int mid = si + (ei - si)/2;

        if(si >= ei)
            return;
        
        mergesort(nums,si,mid);
        mergesort(nums,mid+1,ei);
        merge(nums,si,ei,mid);
    }

    public static void merge(int nums[],int si,int ei,int mid){
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei){
            if(nums[i] < nums[j]){
                temp[k] = nums[i];
                k++;
                i++;
            }
            else{
                temp[k] = nums[j];
                j++;
                k++;
            }
        }
        //for leftover part of 1st part
        while(i <= mid){
            temp[k] = nums[i];
            k++;
            i++;
        }
        //for leftover part of 2nd part
        while(j <= ei){
            temp[k] = nums[j];
            k++;
            j++;
        }

        for(i = si,k = 0; k < temp.length;i++,k++)
            nums[i] = temp[k];


    }

}