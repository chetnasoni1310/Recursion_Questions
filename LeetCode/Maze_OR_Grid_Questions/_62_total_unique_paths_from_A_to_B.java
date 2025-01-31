package Maze_OR_Grid_Questions;


public class _62_total_unique_paths_from_A_to_B {
    
    public static int uniquePaths(int m, int n) {
        
        return uniquePathRec(0,0,m,n,0);
    }
     public static  int  uniquePathRec
     (int row,int col,int m,int n,int count)
     {
           if(row==m-1 || col==n-1)
           {
            count+=1;
            return count;
           }
        return  uniquePathRec(row,col+1,m,n,count) + uniquePathRec(row+1,col,m,n,count);  
     }
     public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
     }
}
