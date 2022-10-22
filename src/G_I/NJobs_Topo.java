package G_I;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class JobScheduler{
    public void scheduleJobs(Job[] jobs){
     Set<Job> visited=new HashSet<>();
     Queue<Job> parents=new LinkedList<>();
     boolean isCycle=false;
     for(Job job: jobs){
         if(!visited.contains(job)){
            if(dfs(job,visited))
             parents.offer(job);
            else{
                isCycle=true;
                break;
            }
         }
     }
        if (isCycle) {
            System.out.println("cycle");
        }
        else {
            while (!parents.isEmpty()){
                parents.poll().run();
        }

     }
    }
    public boolean dfs(Job job, Set<Job> visited){
        visited.add(job);
        Job dependentJob=job.getDependency();
       if (dependentJob != null && !visited.contains(dependentJob)) {
            if(dfs(dependentJob, visited)){
                visited.add(dependentJob);
                dependentJob.run();
            }
           else
               return false;
        }else if(visited.contains(dependentJob)){
           return false;
       }
       return true;
    }
}
public class NJobs_Topo {

    public static void main(String[] args) {
        JobDetails A=new JobDetails("A");
        JobDetails B=new JobDetails("B");
        JobDetails C=new JobDetails("C");
        JobDetails D=new JobDetails("D");
       A.dependent=B;
       B.dependent=C;
       C.dependent=D;
       //D.dependent=A;
       Job[] jobs={A,B,C,D};
       JobScheduler s=new JobScheduler();
       s.scheduleJobs(jobs);

    }
}
