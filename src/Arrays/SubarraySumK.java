package Arrays;

public class SubarraySumK {
    public int subarraySum(int[] nums, int k) {

        int i=0, j=0, sum=0;
        int count=0;
        int n=nums.length;

        while(j<n){

            //Expansion
            sum=sum+nums[j];
            j++;
            //Contraction
            while(sum>k && i<j){
                sum=sum-nums[i];
                i++;
                // System.out.println(sum);
                //System.out.println("k"+k);
            }
            if(sum==k)
                count++;
        }
        return count;
    }
}
