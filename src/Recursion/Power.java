package Recursion;

public class Power {
    //even=a^(b/2)*a^(b/2)
    //odd=a*a^(b/2)*a^(b/2)

    public static int power(int a, int b){
        if(b==1)
            return a;
        if(b==0)
            return 1;

        int ans=power(a,b/2);

        if(b%2==0){
            return ans*ans;
        }else
        {
            return a*ans*ans;
        }
    }

    public static void main(String[] args) {
      int a=2,b=10;
        System.out.println(power(a,b));
    }
}
