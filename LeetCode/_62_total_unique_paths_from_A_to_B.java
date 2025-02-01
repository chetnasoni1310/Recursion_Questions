import java.util.ArrayList;
import java.util.List;

public class _62_total_unique_paths_from_A_to_B {
    /*
     * using recursion
     * using dp top down
     * dp bottom up 
     * Printing paths
     * path when diagonal movements are allowed 
    */
   

   public static int uniquePaths(int m, int n) {
       
      // return uniquePath_Recursion(0,0,m,n);

      int[][]dp=new int[m][n];

      // return uniquePath_DP_top_down_approach(0,0,m,n,dp);

      return uniquePath_DP_bottom_up_(0,0,m,n,dp);
     

  }
  /***************************************************************************************** */
   public static  int  uniquePath_Recursion(int row,int col,int m,int n)
   {
         if(row==m-1 || col==n-1)
         {
          return 1;
         }
          if (row >= m || col >= n) {
          return 0;
      }
      return  uniquePath_Recursion(row,col+1,m,n) + uniquePath_Recursion(row+1,col,m,n);

   }


  /***************************************************************************************** */
   public static  int  uniquePath_DP_top_down_approach
                  (int row,int col,int m,int n,int[][]dp)
   {
         if(row==m-1 || col==n-1)
         {
          return 1;
         }
          if (row >= m || col >= n) {
          return 0;
      }
      if(dp[row][col]!=0)
      {
          return dp[row][col];
      }
      return dp[row][col]= uniquePath_DP_top_down_approach(row,col+1,m,n,dp) + 
                              uniquePath_DP_top_down_approach(row+1,col,m,n,dp);
         
   }     



  /***************************************************************************************** */
   public static int uniquePath_DP_bottom_up_(int row,int col,int m,int n,int[][]dp)  
   {  
      //filling the 1st row with 1 kyunki ek hi path hai jaane ka 
      for(int i=0;i<m;i++)
      {
         dp[i][0]=1;
      }


      //filling the 1st column with 1 kyunki ek hi path hai jaane ka 
      for(int i=0;i<n;i++)
      {
         dp[0][i]=1;
      }

      for (int i = 1; i < m; i++) {
         for (int j = 1; j <n; j++) {
            dp[i][j]= dp[i-1][j] +  dp[i][j-1];
         }
      }
      return dp[m-1][n-1] ;
   }



  /***************************************************************************************** */
   public static  List<String>  Printing_uniquePath_Recursion(String p,int row,int col,int m,int n)
   {
         if(row==m-1 && col==n-1)
         {  
           
            List<String> list=new ArrayList<String>();
            list.add(p);
            return list;
         }
          
         List<String> path=new ArrayList<String>();
   
         
      if(row<m-1)
      {
     path.addAll(Printing_uniquePath_Recursion(p+"D" ,row+1,col,m,n));  
    }


       if(col<n-1)
      {
          path.addAll(Printing_uniquePath_Recursion(p+"R" ,row,col+1,m,n)); 
          
      }
     return path ;
   }



  /***************************************************************************************** */
  public static  int  Diagonal_allow_uniquePath_Recursion(int row,int col,int m,int n)
   {
         if(row==m-1 || col==n-1)
         {
          return 1;
         }
          if (row >= m || col >= n) {
          return 0;
      }
      return     Diagonal_allow_uniquePath_Recursion(row,col+1,m,n) 
             +   Diagonal_allow_uniquePath_Recursion(row+1,col,m,n)
             +   Diagonal_allow_uniquePath_Recursion(row+1,col+1,m,n);

   }


     public static void main(String[] args) {

      //   System.out.println(uniquePaths(3, 4));

      //   List<String> list=Printing_uniquePath_Recursion("", 0, 0,3, 4);
      //   System.out.println(list);


      System.out.println(Diagonal_allow_uniquePath_Recursion(0, 0, 3, 3));
     }
}
