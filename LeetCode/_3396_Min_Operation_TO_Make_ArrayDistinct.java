public class _3396_Min_Operation_TO_Make_ArrayDistinct {
    public int minimumOperations(int[] nums) {
        /*This will use a hashSet for faster duplicate detection
          In this first of all I will start a loop
          Then create a set
          Then add the elements from start till end of array and also check if they
          have been added prior in the set 
          If so then containDuplicate 
          If not then notContainDuplicate

        */
 
        int start = 0;
        int len = nums.length;
        if(len==0)
        {
            return 0;
        }
        int totalOperations = 0;


        while(true)
        {
            Set<Integer> distinctElements = new HashSet<>();
            boolean containsDuplicate = false;

            for(int i=start ; i < len ;i++)
            {
                if( ! distinctElements.add(nums[i]))
                {
                   containsDuplicate=true;
                   break;
                }
            }

            if( ! containsDuplicate)
            {
                break;
            }  
               //ELSE - 
               start+=3;
               totalOperations +=1 ;

               if(start >=len)
               {
                break;
               }
        }

        return totalOperations;

     }
    public int minimumOperations_BRUTE_FORCE_RECURSIVE(int[] nums) {
        
        /**Key Observations: 
        1. If the length of array is 0 then return 0
        2. If there are only 2 elements left then remove them
           then update TotalOperations and then return it
        3. If we have found boolean value true for isDuplicatePresent then we
          will  pass the array with start= start+3 index 
        4.It will use recursion     */
        
        int len= nums.length;
        if(len==0)
        {
            return 0;
        }
        
       return RecursiveMaxOperCalculation(nums,0,0);
    }
    
private int RecursiveMaxOperCalculation(int[]nums , int startIndex, int totalOper )
    {
          //Base -Case
          if(startIndex >= nums.length - 1)
          {
            return totalOper ; 
          }

        boolean isDuplicatePresent = isDuplicatedArray(startIndex , nums);
        
        
        if(isDuplicatePresent) 
        { 
            if(startIndex + 2 == nums.length)
            {
             return  totalOper+1;
            }
            else
          return RecursiveMaxOperCalculation(nums , startIndex+3 , totalOper+1 );
        }
        else
        {
          return totalOper ;   
        }
    }
    private boolean isDuplicatedArray(int start , int[]nums)
    {
       int[] copy = Arrays.copyOfRange(nums, start, nums.length);
       Arrays.sort(copy);
       for(int i=0 ;i<copy.length-1;i++)
       {
        if(copy[i]==copy[i+1])
        {
            return true;
        }
       }

       return false;
    }
}
