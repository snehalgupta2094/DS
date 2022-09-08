package Stacks;


import java.util.Arrays;
import java.util.Stack;

public class NextSmallestElement {
   public static int[] nextSmallestElement(int a[]){
       int n=a.length;
       int ans[]=new int[n];
       Stack<Integer> stack=new Stack<>();
       stack.push(-1);
       for(int i=n-1;i>=0;i--){
           while (stack.peek()!=-1 && stack.peek()>a[i]){
               stack.pop();
           }
           ans[i]= stack.peek();
           stack.push(a[i]);
       }
       return ans;
   }
    public static void main(String[] args) {
        int a[]={2,1,4,3};
        int ans[]=nextSmallestElement(a);
        System.out.println(Arrays.toString(ans));
    }
}
