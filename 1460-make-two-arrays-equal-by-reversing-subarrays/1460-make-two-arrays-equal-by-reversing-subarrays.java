import java.util.*;
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int arr1[] = new int[1001];
        int arr2[] = new int[1001];
        for(int i : target)
            ++arr1[i];

        for(int j : arr)
            ++arr2[j];

        return Arrays.equals(arr1,arr2);
    }
}