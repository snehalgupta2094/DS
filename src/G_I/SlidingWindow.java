/*Non Zero Signals with distance D
        A = [0 ,5, 0, 0 , 2, 0 ,5 ]
        B = [5, 0, 0, 0, 0, 0, 2 ]
        return validSignal at distance D given the signals are equal:
        for D= 2 ,output is 5,2
        for D= 1, OUTPUT  is 5*/
package G_I;
import java.util.ArrayList;
import java.util.HashSet;

public class SlidingWindow {

    public static void main(String[] args) {
        //  int a[]={0 ,5, 0, 7 ,2, 0 ,5};
          //int b[]={5, 7, 0, 0, 0, 0, 2 };
         int a[]={0 ,5, 0, 0 ,2, 0 ,5};
          int b[]={5, 0, 0, 0, 0, 0, 2 };
      //int a[]={1 ,5, 0, 0 ,2, 0 ,5};
      //int b[]={0, 5, 0, 1, 0, 0, 2 };
        int k=2;
//Approach1:
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                System.out.println(a[i]);
                int start=i-k;
                int end=i+k;
                if(start<0)
                    start=0;
                if(end>=a.length)
                    end=a.length-1;
                while(start<=end){
                    if(i!=start && b[start]==a[i])
                        result.add(b[start]);
                    start++;
                }
            }
        }

//Approach2:
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> output=new ArrayList<>();
        //Traversing left to right and saving all previous element in set so that we dont have to revisit them again
        for (int i=0; i<a.length; i++)
        {
            if (a[i]!=0 && set.contains(a[i]))
                output.add(a[i]);
            if (i-k>=0) {
                set.remove(b[i - k]);
            }
            set.add(b[i]);
        }
        //Traversing right to left and saving all previous element in set so that we dont have to revisit them again
        set = new HashSet<>();
        for (int i=a.length-1; i>=0; i--)
        {
            if (a[i]!=0 && set.contains(a[i]))
                output.add(a[i]);
            if (i+k<a.length)
                set.remove(b[i+k]);
            set.add(b[i]);
        }
        System.out.println(output);
    }
}
//TC: O(n), SC: O(n)