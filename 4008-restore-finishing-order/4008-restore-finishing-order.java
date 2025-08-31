class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        List<Integer> li = new ArrayList<>();

        Set<Integer> st = new HashSet<>();

        for(int i = 0;i < friends.length;i++) st.add(friends[i]);

        for(int i = 0;i < order.length;i++){
            if(st.contains(order[i])){
                li.add(order[i]);
            }
        }

        int ans[] = new int[li.size()];
        for(int i = 0;i < li.size();i++) ans[i] = li.get(i);
        return ans;
    }
}