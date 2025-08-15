class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // Bruteforce approach
        // for(int i = 0;i < arr.length-1;i++)
        //     if(arr[i] > arr[i+1]) return i;
        // return -1;

        //using binary search
        int n = arr.length;
        int left = 0, right = n-1, mid;
        while(left < right){
            mid = left + (right - left)/2;
            if(arr[mid] < arr[mid+1]) left = mid+1;
            else right = mid;

        }
        return left;
    }
}