class Solution {
    public class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first= first;
            this.second = second;
        }
    }

    public int numEnclaves(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<Pair>();

        
        //traversing through boundaries
        //first row and last row
        for(int i = 0;i < n;i++){
            if(vis[0][i] == false && mat[0][i] == 1)
                q.add(new Pair(0,i));
            
            if(vis[m-1][i] == false && mat[m-1][i] == 1)
                q.add(new Pair(m-1,i));
            }
        //first column and last column
        for(int i = 0;i < m;i++){
            if(vis[i][0] == false && mat[i][0] == 1)
                q.add(new Pair(i,0));

            if(vis[i][n-1] == false && mat[i][n-1] == 1)
                q.add(new Pair(i,n-1));

        }
        int delRow[] = {-1,1,0,0};
        int delCol[] = {0,0,-1,1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            vis[row][col] = true;
            for(int i = 0;i < 4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && vis[nRow][nCol] == false && mat[nRow][nCol] == 1){
                    vis[nRow][nCol] = true;
                    q.add(new Pair(nRow,nCol));
                }
            }

        }
        int count1 = 0;
        int count2 = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0 ; j < n; j++){
                if(vis[i][j] == true && mat[i][j] == 1)
                    count1++;
                if(mat[i][j] == 1)
                    count2++;
            }
        }

        return count2 - count1;
    }
}