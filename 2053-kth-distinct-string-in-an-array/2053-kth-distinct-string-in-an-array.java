class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> count=new HashMap<>();
        for(final String s:arr){
            count.merge(s,1,Integer::sum);
        }
        for(final String s:arr){
            if(count.get(s)==1 &&--k==0)
                return s;
        }
    return "";}
}