package Math;

public class DecimalToBinary {

    public static void main(String[] args) {
        int x=123;
        //Math
        String answer="";
        while(x>0){
            int remainder=x%2;
            x=x/2;
            answer=answer+remainder;
        }
        System.out.println("Math: "+answer);

        //Bitwise
        x=123;
        answer="";
        while(x>0){
            int bit=x&1; //extract last bit
            answer=answer+bit;
            x=x>>1; //right shift divides by 2
        }
        System.out.println("Bitwise: "+answer);
    }
}
