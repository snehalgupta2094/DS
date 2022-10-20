package G_I;


import java.util.ArrayList;
import java.util.HashSet;

public class SlidingWindow {

    public static void main(String[] args) {
        //   int a[]={0 ,5, 0, 7 ,2, 0 ,5};
        //  int b[]={5, 7, 0, 0, 0, 0, 2 };
        //    int a[]={0 ,5, 0, 0 ,2, 0 ,5};
        //  int b[]={5, 0, 0, 0, 0, 0, 2 };
        int a[]={1 ,5, 0, 0 ,2, 0 ,5};
        int b[]={0, 5, 0, 1, 0, 0, 2 };

        int k=3;
        //int k=1;
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
        // System.out.println(result);

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> op=new ArrayList<>();
        for (int i=0; i<a.length; i++)
        {
            set.add(b[i]);

            if (a[i]!=0 && set.contains(a[i]))
                op.add(a[i]);
            if (i-k >= 0)
                set.remove(b[i-k]);
        }

        set = new HashSet<>();
        for (int i=a.length-1; i>=0; i--)
        {
            set.add(b[i]);

            if (a[i]!=0 && set.contains(a[i])){
                op.add(a[i]);
            }

            if (i+k < a.length)
                set.remove(b[i+k]);
        }

        System.out.println(op);
    }
}
