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

public class OnCallRotation {

    public static void main(String[] args) {

    }
}
