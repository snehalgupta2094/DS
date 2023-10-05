package Recursion;

public class Factorial {
    public static int findFactorial(int n){
        if(n==0 || n==1)
            return 1;
        return findFactorial(n-1)*n;
    }
    public static void main(String[] args) {
        System.out.println(findFactorial(3));
    }
}
