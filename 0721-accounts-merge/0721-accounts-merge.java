import java.util.*;

class Solution {
    static class DisjointSet{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n){
            for(int i = 0;i <= n;i++){
                size.add(1);
                parent.add(i);
            }
        }

        public int findParent(int node){
            if(node == parent.get(node)) return node;

            int ult_parent = findParent(parent.get(node));
            parent.set(node, ult_parent);
            return ult_parent;
        }

        public void unionBySize(int u,int v){
            int ultP_u = findParent(u);
            int ultP_v = findParent(v);
            if(ultP_v == ultP_u) return;

            if(size.get(ultP_u) < size.get(ultP_v)){
                parent.set(ultP_u, ultP_v);
                size.set(ultP_v, size.get(ultP_u) + size.get(ultP_v));
            }else{
                parent.set(ultP_v, ultP_u);               
            size.set(ultP_u, size.get(ultP_u) + size.get(ultP_v));
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        HashMap<String, Integer> hm = new HashMap<>(); // (email , index for accounts[i])

        DisjointSet dj = new DisjointSet(n);

        for(int i = 0;i < n;i++){
            for(int j = 1;j < accounts.get(i).size();j++){
                if(!hm.containsKey(accounts.get(i).get(j)))
                    hm.put(accounts.get(i).get(j),i);
                else{
                    dj.unionBySize( i, hm.get(accounts.get(i).get(j)));
                }
            }
        }

// we need to have two 2d arraylists
        List<List<String>> mergedMails = new ArrayList<>();


        for(int i = 0;i < n;i++) mergedMails.add(new ArrayList<>());

        for(Map.Entry<String, Integer>  entry : hm.entrySet()){
            mergedMails.get(dj.findParent(entry.getValue())).add(entry.getKey());
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0;i < n;i++){
            if(mergedMails.get(i).size() == 0) continue;
            Collections.sort(mergedMails.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String mail : mergedMails.get(i)) temp.add(mail);
            ans.add(temp);
        }

        return ans;
    }
}