import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.function.Predicate;
class Deployment{

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

}
class History{
    Number ended;
}
public class Practice {


    public static void main(String[] args) {

/*        String uri="/api/vcenter/lcm/555e2e4a-fa18-4c17-9414-49d4e3daa50d/deployments/f874dc29-4dd5-49cc-8b92-52a13b0f1f2a/status";
        String blockedURI="/api/vcenter/lcm/[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}/deployments/[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}/status";
        if (uri.matches(blockedURI)) {
            System.out.println("matched");
        } else {
            System.out.println("nope");
        }*/
     /*   PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->Integer.compare(a[0], b[0]));
        pq.add(new int[]{13,1});
        pq.add(new int[]{11,4});
        pq.add(new int[]{4,9});
        pq.add(new int[]{7,3});
        pq.add(new int[]{1,6});

        while (!pq.isEmpty()){
            System.out.println(Arrays.toString(pq.poll()));
        }*/

//        System.out.println(Objects.nonNull(deployment.getId()));

/*String input="driftDetectionCheck,pollDriftDetectionCheck,init_upgrade,poll_upgrade,post_upgrade_check";
 //String input="cdnConnectivity,diskSpace,shouldTriggerDownloadWF,parallelDownloadManifest,validateVCBuilds,canStartDownload,parallelDownloadPackage,setDownloadStatus,updateResult,pollOtherInstanceDownloadStatus,downloadManifest,downloadPackage,extractPackage,updateTrustedCert,checkIfvLCMPatchingRequired,patchvLCMService,pollPatchvLCMService,setRepo,checkIfSecondNetworkExists,identifyAdapterType,addNetworkDevice,pollReconfigTask,assignIPAddress,checkIfNic0NetworkExist,fetchNic0Network,prepareInitSpec,preCheck,pollRduPreCheck,deleteCertChainStep,executeDeleteCertChain";
    *//*String input="downloadManifest,validatePreCondition,updateTrustedCert,getVCSAToDelete,pollPowerOffVMTasks,deleteOldVCSAs,pollDeleteVMTasks,fetchNic0Network,prepareInitSpec,initRDU,initPolling,stageUpgrade,stagePolling,postStageMoidTrackingStep,upgrade,upgradePolling,cleanUp,postUpgradeStepMoidTracking,handleFailure,deleteCertChainStep,executeDeleteCertChain";
*//*
    String tokenize[]=input.split(",");

    for(String token: tokenize){
        token=token.replaceAll("([a-z])([A-Z])", "$1_$2").toUpperCase();
        System.out.println(token+"_STEP.message=");
    }*/








   // String path="/api/vcenter/lcm/8a77c1e9-4159-44fb-9179-5023edc702a1/deployments/bdc60a8d-473f-4a2d-affb-43b2d7de8863/lifecycle-settings";
      /*  String path="/api/vcenter/lcm/8a77c1e9-4159-44fb-9179-5023edc702a1/deployments/lifecycle-settings";

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(Arrays.toString(list.toArray()));*/

  /*      final Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        map.put("1", list);


        map.forEach((abc,
                    deployments)->{

            Iterator<String> iterator = deployments.iterator();
            while (iterator.hasNext()) {
                String deployment = iterator.next();
                if(deployment.equalsIgnoreCase("b"))
                    iterator.remove();
            }
        });
        map.forEach((abc,
                     deployments)-> {
            System.out.println(deployments);
        });*/

    }
}
