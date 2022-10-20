/*There are N processes with some processes having dependencies on other processes
* Find order for n jobs such that job is executed after all other dependent jobs are executed
abstract class Job{
List<Job> dependencies;
}
Example:
Job a
Job b
Job c
Job a=new ArrayList<>();
a.dependencies.add(b);
a.dependencies.add(c);
* */
package G_I;

public class NProcesses {

    public static void main(String[] args) {

    }
}
