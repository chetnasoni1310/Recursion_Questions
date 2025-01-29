public class Power_of_b_raise_to_e {
    double power(double b, int e) {
        // code here
        
        if(e==0)
        {
            return (double)1;
        }
        //base case 
        
        //If negative power of b i.e. e is negative
        if(e<0)
        {   
            //Ques ne kaha h ki b is not zero 
            //But in general ese hota hai 
            if(b==0)
            {
                throw new ArithmeticException("Cannot divide by zero.");
            }
            
            /*
            vrna jo bhi result aayega e ko positive krke
            uska reciprocal krdo
            aur e ko positive banane ke liye - se jod dia
            kyunki neg into neg is positive
            */
            return 1/power(b,-e);     
        }
        
        if(e%2 == 0) //if even
        {
            double halfpower = power(b,e/2);
            return halfpower*halfpower ;
        }
        else{
            double halfpower = power(b,(e-1)/2);
            return b*halfpower*halfpower ;
        }
    }
}
