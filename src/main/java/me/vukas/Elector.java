package me.vukas;

import org.rapidoid.setup.App;

public class Elector {
    public static void main(String[] args) {
        App.bootstrap(args);
        Election.start();
    }
}
