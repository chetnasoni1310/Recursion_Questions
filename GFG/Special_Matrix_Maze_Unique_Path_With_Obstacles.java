public class Special_Matrix_Maze_Unique_Path_With_Obstacles {
   
    public int FindWays(int n, int m, int[][] blocked_cells) {
        int MOD = 1000000007;
         int[][]dp=new int[n][m];
    
  
    for (int[] cell : blocked_cells)
    {
          int r = cell[0] -1;   //0 based indexing mai convert kr dia
          int c = cell[1] -1;
          dp[r][c] = -1;  // Block this cell
      }
      
if (dp[0][0] == -1 || dp[n-1][m-1]==-1)
{
    return 0;  // If start & end is blocked, no path
}

      dp[0][0] = 1;
 
      // Initialize first row
       for (int i = 1; i <m; i++) {
          if (dp[0][i] == -1) break;  // Stop after first obstacle
          dp[0][i] = dp[0][i-1];
      }
  

      // Initialize first column
      for (int i = 1; i <n; i++) {
          if (dp[i][0] == -1) break;  // Stop after first obstacle
          dp[i][0] =  dp[i-1][0];
      }
     
     for(int i=1;i<n;i++)
     {
      for (int j = 1; j <m; j++) {
          if(dp[i][j]==-1)
          {
        dp[i][j]=0;
          }
          else{
         int top = (i > 0 && dp[i - 1][j] != -1) ? dp[i - 1][j] : 0;
                  int left = (j > 0 && dp[i][j - 1] != -1) ? dp[i][j - 1] : 0;
                  dp[i][j] = (top + left) % MOD;
          }
      }
     }
     return dp[n-1][m-1];

  }

}
