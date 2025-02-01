import java.util.Arrays;

public class _63_Unique_Paths_2 {

     /*
    pehle recursion wala method hai
    fir dp top to down approach 
    fir bottom up approach 
    */


  /***************************************************************************************** */
    public static int uniquePathsWithObstacles_Bottom_Up_DP(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
        {
            return 0;
        }
        
         int[][]dp=new int[m][n];

 // Initialize first row
         for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;  // Stop after first obstacle
            dp[0][i] = 1;
        }
    

        // Initialize first column
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;  // Stop after first obstacle
            dp[i][0] = 1;
        }
       
    
       for(int i=1;i<m;i++)
       {
        for (int j = 1; j < n; j++) {
            if(obstacleGrid[i][j]==0)
            {
            dp[i][j]=dp[i-1][j] +dp[i][j-1] ;
            }
            else
            dp[i][j]=0;
        }
       }
       return dp[m-1][n-1];
    }


  /***************************************************************************************** */
  public static  int  uniquePathsWithObstacles_DP_top_down_approach
        (int m,int n,int row,int col,int[][]obstacleGrid, int[][] dp)
      { 
        if(row<m && col<n && obstacleGrid[row][col]==1)
        {
            return 0;
        }
        if(row==m-1 && col==n-1)
        {
        return 1;
        }

        if (row >= m || col >= n) {
        return 0;
        }

        if(dp[row][col]!=-1)
        {
        return dp[row][col];
        }
        dp[row][col] = uniquePathsWithObstacles_DP_top_down_approach(m,n,row + 1, col, obstacleGrid, dp) 
        + uniquePathsWithObstacles_DP_top_down_approach(m,n,row, col + 1, obstacleGrid, dp);

        return dp[row][col];

        }     


  /***************************************************************************************** */
    public static int uniquePathsWithObstacles_Recursion(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
        {
            return 0;
        }

        return countingPath_Recursion(0,0,m,n,obstacleGrid);
    }



  /***************************************************************************************** */
     public static int countingPath_Recursion(int r,int c,int m,int n,int[][] obstacleGrid)
     {  
        if(r<m && c<n && obstacleGrid[r][c]==1)
        {
            return 0;
        }
        if(r==m-1 && c==n-1)     //answer row ya answer col mai aagye 1 hi tarika hai jaane ka 
        {
            return 1;
        }
        int down=0;
        int right=0;
        if(r<m)
        {   
            down=countingPath_Recursion(r+1,c,m,n,obstacleGrid);
        }
        if(c<n-1)
        {
            right=countingPath_Recursion(r,c+1,m,n,obstacleGrid);
        }
        return down+right;
     }


  /***************************************************************************************** */
     public static void main(String[] args) {
        // int[][] obstacleGrid={
        //     {0,1,0,0}
        // };
        
 int[][] obstacleGrid={
        {0,0,0},{0,1,0},{0,0,0}
        };
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
        {
            System.out.println(0);
        }
        else{
       
       System.out.println(uniquePathsWithObstacles_Recursion(obstacleGrid)); 

       System.out.println(uniquePathsWithObstacles_Bottom_Up_DP(obstacleGrid));
    
       int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
       for (int[] row : dp)
       {
       Arrays.fill(row,-1);
       }
       System.out.println(uniquePathsWithObstacles_DP_top_down_approach(m,n,0,0,obstacleGrid,dp));
     }
    }
}
