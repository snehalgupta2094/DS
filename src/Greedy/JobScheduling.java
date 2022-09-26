package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class JobScheduling {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");

            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }

            Solution ob = new Solution();

            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        //sort max profit
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return Integer.compare(o2.profit,o1.profit);
            }
        });

        //set schedule
        int maxDeadline=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxDeadline=Math.max(maxDeadline,arr[i].deadline);
        }
        int schedule[]=new int[maxDeadline+1];
        for(int i=0;i<maxDeadline;i++)
            schedule[i]=-1;

        int count=0;
        int maxProfit=0;
        for(int i=0;i<n;i++){
            int currProfit=arr[i].profit;
            int currId=arr[i].id;
            int currDead=arr[i].deadline;

            for(int k=currDead;k>0;k--){
                if(schedule[k]==-1){
                    count++;
                    schedule[k]=currId;
                    maxProfit=maxProfit+currProfit;
                    break;
                }
            }
        }
        int[]ans=new int[2];
        ans[0]=count;
        ans[1]=maxProfit;
        return ans;

    }
}



