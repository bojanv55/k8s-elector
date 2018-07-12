package me.vukas;

//apiVersion: v1
//        kind: Endpoints
//        metadata:
//        annotations:
//        control-plane.alpha.kubernetes.io/leader: '{"holderIdentity":"aspectcaffleader-59cfc8b997-9kk46","leaseDurationSeconds":10,"acquireTime":"2018-07-12T16:25:07Z","renewTime":"2018-07-12T18:40:46Z","leaderTransitions":0}'
//        creationTimestamp: 2018-07-12T14:45:24Z
//        name: example
//        namespace: default
//  resourceVersion: "22852"
//          selfLink: /api/v1/namespaces/default/endpoints/example
//        uid: 35ae2314-85e2-11e8-8629-08002702cbca

//https://github.com/kubernetes/client-go/blob/master/tools/leaderelection/leaderelection.go
//https://github.com/fabric8io/fabric8-ipaas/blob/master/camel-master/src/main/java/io/fabric8/camel/master/KubernetesLock.java


import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.auth.ApiKeyAuth;
import io.kubernetes.client.models.V1ConfigMap;
import me.vukas.dto.EndpointAnnotation;

public class KubernetesHelper {

    private KubernetesHelper() {
        ApiClient client = Configuration.getDefaultApiClient();
        ApiKeyAuth BearerToken = (ApiKeyAuth) client.getAuthentication("BearerToken");
        BearerToken.setApiKey("YOUR API KEY");
        //BearerToken.setApiKeyPrefix("Token");
    }

    public void test(){
        System.out.println("test");
    }

    public EndpointAnnotation readAnnotation(){
        CoreV1Api apiInstance = new CoreV1Api();
        String namespace = "namespace_example"; // String | object name and auth scope, such as for teams and projects
        V1ConfigMap body = new V1ConfigMap(); // V1ConfigMap |
        String pretty = "pretty_example"; // String | If 'true', then the output is pretty printed.
        try {
            V1ConfigMap result = apiInstance.createNamespacedConfigMap(namespace, body, pretty);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CoreV1Api#createNamespacedConfigMap");
            e.printStackTrace();
        }
        return null;
    }

    public void writeAnnotation(EndpointAnnotation annotation){

    }

}
