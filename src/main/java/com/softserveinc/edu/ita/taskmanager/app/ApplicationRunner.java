package com.softserveinc.edu.ita.taskmanager.app;

import com.softserveinc.edu.ita.taskmanager.controller.XMLInitializeContext;
import com.softserveinc.edu.ita.taskmanager.view.input.Application;
import com.softserveinc.edu.ita.taskmanager.view.input.ConsoleApplication;
import com.softserveinc.edu.ita.taskmanager.view.input.WindowApplication;

/**
 * Created by nazar.dovhyy on 17.06.2016.
 */
public class ApplicationRunner implements Runnable {

    private final Application application;

    public ApplicationRunner(Application application) {

        this.application = application;

        Thread applicationRunnerThread = new Thread(this);

        applicationRunnerThread.start();
    }

    public static ApplicationRunner runApplication(Application application) {


        return new ApplicationRunner(application);
    }


    @Override
    public void run() {

        runApplication();

    }


    private static class ApplicationRunnerTool{

        public static void main(String [] args){

            ApplicationRunner.runApplication(new ConsoleApplication());
        }

    }

    private void runApplication() {

        // initializing controller

        try {
            XMLInitializeContext.init(XMLInitializeContext.XML_TASKS_FILE)
                    .parseTag(XMLInitializeContext.TAG_ATTR).loadIntoCache();
        } catch (Exception e1) {
            e1.printStackTrace();
        }


        if(application.getClass() == ConsoleApplication.class){

            application.start();

        }else if(application.getClass() == WindowApplication.class){

            application.start();
        }

    }
}
