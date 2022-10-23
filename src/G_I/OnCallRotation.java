/*Given on-call rotation schedule for multiple people by: their unique name, start time (timestamp 0-max int64) and end time (timestamp 0-max int64) of the rotation:
        Your goal is to return a rotation table without overlapping periods representing who is on call during that time.
        Return "Start time", "End time" and list of on-call people:
        Omit time periods that do not have on-call people, i.e., 120-150 in the given example.

        Example input:
        Name  | Start | End
        ----- | ----- | ---
        Abby  | 10    | 100
        Ben   | 50    | 70
        Carla | 60    | 120
        David | 150   | 300

        Example output:
        Start | End | Names
        ----- | --- | ----------------
        10    | 50  | Abby
        50    | 60  | Abby, Ben
        60    | 70  | Abby, Ben, Carla
        70    | 100 | Abby, Carla
        100   | 120 | Carla
        150   | 300 | David*/
package G_I;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class OnCallDetails{
    String name;
    int start;
    int end;
    OnCallDetails(String name, int start, int end){
        this.name=name;
        this.start=start;
        this.end=end;
    }
}
class Rotation{
    String name;
    int timestamp;
    int type;
    Rotation(String name,int timestamp, int type){
        this.name=name;
        this.timestamp=timestamp;
        this.type=type;
    }
}
public class OnCallRotation
{
    public static void main(String[] args)
    {
        OnCallDetails c=new OnCallDetails("Abby",10,100);
        OnCallDetails c1=new OnCallDetails("Ben",50,70);
        OnCallDetails c2=new OnCallDetails("Carla",60,120);
        OnCallDetails c3=new OnCallDetails("David",150,300);

        ArrayList<OnCallDetails> details=new ArrayList<>();
        details.add(c);
        details.add(c1);
        details.add(c2);
        details.add(c3);

        ArrayList<Rotation> schedule=new ArrayList<>();
       for(OnCallDetails detail: details){
           schedule.add(new Rotation(detail.name,detail.start,0));
           schedule.add(new Rotation(detail.name,detail.end,1));
       }
       HashSet<String> rotation=new HashSet<>();
       Collections.sort(schedule,(o1,o2)->Integer.compare(o1.timestamp,o2.timestamp));
       int prev=schedule.get(0).timestamp;
       rotation.add(schedule.get(0).name);
       for(int i=1;i<schedule.size();i++)
       {
           if(schedule.get(i).type==0)
           {
               if(!rotation.isEmpty())
               System.out.println(prev+"    "+schedule.get(i).timestamp+"   "+String.join(" ", rotation));
               rotation.add(schedule.get(i).name);
           }
           else
           {
               rotation.remove(schedule.get(i).name);

               System.out.println(prev+"    "+schedule.get(i).timestamp+"   "+schedule.get(i).name+" "+String.join(" ", rotation));
           }
           prev=schedule.get(i).timestamp;
       }
    }
}
//TC: O(n log n)+O(n), SC: O(n)

