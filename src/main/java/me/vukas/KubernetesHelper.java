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

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Endpoints;
import io.kubernetes.client.util.Config;
import me.vukas.dto.EndpointAnnotation;

import java.io.IOException;
import java.util.Map;

public class KubernetesHelper {
    private static class Loader {
        static final KubernetesHelper INSTANCE = new KubernetesHelper();
    }
    private ApiClient client;
    private CoreV1Api api;

    private KubernetesHelper() {
        try {
            client = Config.defaultClient();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Configuration.setDefaultApiClient(client);
        api = new CoreV1Api();
    }

    public EndpointAnnotation readAnnotation(){
        try {
            V1Endpoints endpoints = api.readNamespacedEndpoints("example", "default", null, null, null);
            Map<String, String> annotations = endpoints.getMetadata().getAnnotations();
            System.out.println(annotations);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeAnnotation(EndpointAnnotation annotation){

    }

    public KubernetesHelper getInstance(){
        return Loader.INSTANCE;
    }
}
