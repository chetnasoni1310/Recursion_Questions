import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_PhonePad_LetterCombination {
   
    static void LetterComb(String p ,String up)
{
    if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }

    int digit= up.charAt(0)-'0';
    for(int i=(digit-1)*3;i<(digit*3);i++)
    {  
        char char_converted= (char) (i+'a'); 
        LetterComb(p+char_converted, up.substring(1));
    } 
}
    static ArrayList<String> LetterComb_II(String p ,String up)
{
    if(up.isEmpty())
        {
            ArrayList<String> list=new ArrayList<String>();
            list.add(p);
            return list;
        }

    int digit= up.charAt(0)-'0';
    ArrayList<String> list=new ArrayList<String>();
    for(int i=(digit-1)*3;i<(digit*3);i++)
    {  
        char char_converted= (char) (i+'a'); 
        list.addAll(LetterComb_II(p+char_converted, up.substring(1)));
    } 
    return list;
}



       public static List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        {
            return new ArrayList<String>();
        }
        HashMap<Character , String> map=new HashMap<>();
            map.put('2',"abc");
            map.put('3',"def");
            map.put('4',"ghi");
            map.put('5',"jkl");
            map.put('6',"mno");
            map.put('7',"pqrs");
            map.put('8',"tuv");
            map.put('9',"wxyz");
         
           List<String> list=Permutation("",digits,map)   ;
           return list;
          
    }
    public static List<String> Permutation(String p,String up,HashMap<Character,String> map)
    {
          if(up.isEmpty())
        {
           List<String> list=new ArrayList<String>();
            list.add(p);
            return list;
        }
     
   char ch= up.charAt(0);
    List<String> list=new ArrayList<String>();
     String letters=map.get(ch);
     for(int i=0;i<letters.length();i++)
     { 
        char l=letters.charAt(i);
        list.addAll(Permutation(p+l, up.substring(1), map));
     }
    return list;
    }
        public static void main(String[] args) {

            
            // LetterComb("", "12");

            // System.out.println();

            // ArrayList<String> list=LetterComb_II("", "12");
            // System.out.println(list);

            // System.out.println();

            List<String> list_II=letterCombinations("23");
            System.out.println(list_II);

            List<String> list_I=letterCombinations("2");
            System.out.println(list_I);

            List<String> list_III=letterCombinations("");
            System.out.println(list_III);
            
        }
}
