public class _1342_Count_No_Of_Steps{
    public int numberOfSteps(int num) {
        return helper(num,0);
      }
     public int helper(int n,int stepCount)
     {
         if(n==0)
         {
           return stepCount;
         }
         if(n%2==0)
         {
            return helper(n/2,stepCount+1);
         }
         else
         {
           return helper(n-1,stepCount+1);
         }
     }
}