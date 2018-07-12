package me.vukas.dto;

import java.time.Instant;

public class EndpointAnnotation {
    private String holderIdentity;
    private Integer leaseDurationSeconds;
    private Instant acquireTime;
    private Instant renewTime;
    private Integer leaderTransitions;

    //'{"holderIdentity":"aspectcaffleader-59cfc8b997-9kk46",
    // "leaseDurationSeconds":10,
    // "acquireTime":"2018-07-12T16:25:07Z",
    // "renewTime":"2018-07-12T18:40:46Z",
    // "leaderTransitions":0}'
}
