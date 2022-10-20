package G_I;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

interface Job{
    void run();
    Job getDependency();

}

class JobDetails implements Job{
     String name;
     Job dependent;
    JobDetails(String name){
        this.name=name;
    }

    public void setDependent(Job dependent){
        this.dependent=dependent;
    }
    @Override
    public void run() {
        System.out.println(this.name);
    }

    @Override
    public Job getDependency() {
        return this.dependent;
    }
}
class JobSchedule{
    public void scheduleJobs(Job[] jobs)
    {
        Stack<Job> parentJobs = new Stack<>();
        Set<Job> visitedJobs = new HashSet<>();
        for(Job job : jobs)
        {
          if(!visitedJobs.contains(job)){
              dfs(job,visitedJobs,parentJobs);
          }
        }
        while (!parentJobs.isEmpty())
        {
            Job parentJob=parentJobs.pop();
            if(!visitedJobs.contains(parentJob))
            {
                parentJob.run();
                visitedJobs.add(parentJob);
            }
        }
    }
    public void dfs(Job job,Set<Job> visitedJobs,List<Job> parentJobs){
        Job dependentJob=job.getDependency();
        if(dependentJob!=null){
            dfs(dependentJob,visitedJobs,parentJobs);
            parentJobs.add(job);
        }
        else if(!visitedJobs.contains(job)){
            job.run();
            visitedJobs.add(job);
        }
    }

}

public class NJobs {

    public static void main(String[] args) {
        JobDetails A=new JobDetails("A");
        JobDetails B=new JobDetails("B");
        JobDetails C=new JobDetails("C");
        JobDetails D=new JobDetails("D");
       A.dependent=B;
      // B.dependent=C;
       C.dependent=D;
      // D.dependent=A;
       Job[] jobs={A,B,C,D};
       JobSchedule s=new JobSchedule();
       s.scheduleJobs(jobs);

    }
}
