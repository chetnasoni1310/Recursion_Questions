import java.util.ArrayList;
import java.util.List;

public class _1155_Dice_Roll {
    public static List<String> dice_comb(String p,int target)
    {
         if(target==0)
        {
            List<String> list=new ArrayList<String>();
            list.add(p);
            return list;
        }
        List<String> list=new ArrayList<String>();
       
        for(int i=1;i<=6;i++)
        {
            if (i <= target) 
            {  // Ensure the dice roll does not exceed the remaining sum
                list.addAll(dice_comb(p + i, target - i));
            }
        }

    
   return list;
    }
    public static void main(String[] args) {
        List<String> list=dice_comb("", 4);
        System.out.println(list);

    }
}
