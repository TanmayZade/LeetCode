class Solution {
    public class Node{
        int first;
        int second;
        int third;
        public Node(int first,int second,int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int  m = mat.length;
        int n = mat[0].length;
        Queue<Node> q = new LinkedList<Node>();
        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(mat[i][j] == 0){
                    q.add(new Node(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        int[] delRow = {-1,1,0,0};
        int[] delCol = {0,0,-1,1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.poll();
            dist[row][col] = steps;
            for(int i = 0;i < 4;i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && vis[nrow][ncol] == false ){
                    q.add(new Node(nrow,ncol,steps+1));
                    vis[nrow][ncol] = true;
                }
            }
        }

        return dist;
    }
}