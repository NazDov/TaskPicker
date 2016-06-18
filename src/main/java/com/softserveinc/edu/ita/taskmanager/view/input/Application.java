package com.softserveinc.edu.ita.taskmanager.view.input;

/**
 * Created by nazar.dovhyy on 17.06.2016.
 * a simple marker interface
 */
public interface  Application {


     Application NULL_APPLICATION = new Application() {
        @Override
        public void start() {
            // return nothing
        }
    };

     void start();

}
