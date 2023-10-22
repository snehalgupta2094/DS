package BST;

public class FlattenBST {

    public static void main(String[] args) {
     String msg="409 : \"{\"error\":{\"time\":\"2023-10-10T09:01:48.121401745Z\",\"code\":409,\"type\":\"ERROR_RESOURCE_OPERATION_IN_PROGRESS\",\"message\":\"The Cluster configuration ( 'Test-config-spec-1' ) setup is in progress. Please try later.\",\"developer_message\":\"MultiSDDCConfigException (cause: Cluster config spec of Test-config-spec-1 (domain-c11) of VC 107a1676-36c6-41d0-8dd1-c08cc8500011 in org 9f5c0d33-e4a9-4fd1-ad05-9e86ff025ef2 is not yet imported)\",\"args\":{\"RESOURCE_TYPE_KEY\":\"RESOURCE_CLUSTER_CONFIG\",\"RESOURCE_NAME\":\"Test-config-spec-1\",\"ACTION_TYPE_KEY\":\"RESOURCE_SETUP\"},\"trace_id\":\"8e6a07ea-9b42-432c-8250-7dd44d209f71\"}}\"";
       String msg1="409 : \"{\"error\":{\"time\":\"2023-10-10T08:56:33.217509Z\",\"code\":409,\"type\":\"ERROR_RESOURCE_OPERATION_IN_PROGRESS\",\"message\":\"The Cluster configuration ( 'Test-config-spec-1' ) setup is in progress. Please try later.\",\"args\":{\"RESOURCE_TYPE_KEY\":\"RESOURCE_CLUSTER_CONFIG\",\"RESOURCE_NAME\":\"Test-config-spec-1\",\"ACTION_TYPE_KEY\":\"RESOURCE_SETUP\"},\"trace_id\":\"75474fd1-991f-415e-8f8a-5d4160ab27a3\"}}\"";
        System.out.println(msg.contains("409"));
        System.out.println(msg1.contains("409"));
    }
}
