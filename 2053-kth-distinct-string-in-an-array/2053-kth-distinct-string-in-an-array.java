class Solution {
    public String kthDistinct(String[] arr, int k) {
        ArrayList<String> DistStrings = new ArrayList<>();
        int n = arr.length;

        for(int i = 0; i < n; i++){
            String currentString = arr[i];
            boolean isDistinct = true;
            for(int j = 0; j < n ;j++){
                if(j == i)
                    continue;
                if(arr[j].equals(currentString)){
                    isDistinct = false;
                    break;
                }
            }

            if(isDistinct)
                DistStrings.add(currentString);
        }
        if(DistStrings.size() < k)
            return "";

        return DistStrings.get(k - 1);
    }
}