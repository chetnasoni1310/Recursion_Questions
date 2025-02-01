public class _63_Unique_Paths_2 {

     /*
    pehle recursion wala method hai
    fir dp top to down approach 
    fir bottom up approach 
    */
    public static int uniquePathsWithObstacles_Top_Down_DP(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
        {
            return 0;
        }
        
         int[][]dp=new int[m][n];
         for(int i=0;i<n;i++)
         {
            if(obstacleGrid[0][i]==1)
            {
                dp[0][i]=0;
            }
            else
            dp[0][i]=1;
         }
         for(int i=0;i<m;i++)
         {
            if(obstacleGrid[i][0]==1)
            {
                dp[i][0]=0;
            }
            else
            dp[i][0]=1;
         }

        return countingPath_Top_Down_DP(m,n,obstacleGrid,dp);
    }

    public static int countingPath_Top_Down_DP(int m,int n,int[][] obstacleGrid, int[][]dp)
    {  
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

    public static int uniquePathsWithObstacles_Recursion(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
        {
            return 0;
        }

        return countingPath_Recursion(0,0,m,n,obstacleGrid);
    }
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
     public static void main(String[] args) {
        int[][] obstacleGrid={
            {0,1,0,0}
        };
     
        // int[][] obstacleGrid={
        // {0,0,0},{0,1,0},{0,0,0}
        // };
       System.out.println(uniquePathsWithObstacles_Recursion(obstacleGrid)); 

       System.out.println(uniquePathsWithObstacles_Top_Down_DP(obstacleGrid));
     }
}
