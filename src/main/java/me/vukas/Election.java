package me.vukas;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class Election {
    private static AtomicBoolean running = new AtomicBoolean(false);

    private Election(){}

    static void start(){
        if(running.compareAndSet(false, true)) {
            ThreadFactory threadFactory = new ThreadFactoryBuilder().setDaemon(true).build();
            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(threadFactory);
            service.scheduleWithFixedDelay(new Election()::elect, 0, 5, TimeUnit.SECONDS);
        }
    }

    private void elect(){
        System.out.println("ELECTING");
        //try reading from configmap
        //if not there, try creating new config map
        //if there - read it
        //check who is current leader; if this component, update state
        //if other component, check if lease time expired and if not, do nothing
        //if expired - try to update configmap
    }

    private String currentLeader(){
        return null;
    }
}
