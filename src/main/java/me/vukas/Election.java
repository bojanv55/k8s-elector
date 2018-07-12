package me.vukas;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class Election {
    private static AtomicBoolean running = new AtomicBoolean(false);
    private Election(){}

    static void start(){
        if(running.compareAndSet(false, true)) {
            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
            service.scheduleWithFixedDelay(new Election()::elect, 0, 5, TimeUnit.SECONDS);
        }
    }

    private void elect(){
        System.out.println("ELECTING");
    }

    private String currentLeader(){
        return null;
    }
}
