package com.softserveinc.edu.ita.taskmanager.app;

import com.softserveinc.edu.ita.taskmanager.model.exceptions.TaskObjectNotAbstractTaskException;
import com.softserveinc.edu.ita.taskmanager.controller.XMLInitializeContext;
import com.softserveinc.edu.ita.taskmanager.view.input.Application;
import com.softserveinc.edu.ita.taskmanager.view.input.ConsoleApplication;
import com.softserveinc.edu.ita.taskmanager.view.input.WindowApplication;

/**
 * Created by nazar.dovhyy on 17.06.2016.
 */
public class ApplicationRunner implements Runnable {

    private Application application = Application.NULL_APPLICATION;

    public ApplicationRunner(Application application) {

        if (application != null)
            this.application = application;

        Thread applicationRunnerThread = new Thread(this, "ApplicationRunner");

        applicationRunnerThread.start();
    }

    public static ApplicationRunner runApplication(Application application) {


        return new ApplicationRunner(application);
    }


    @Override
    public void run() {

        runApplication();

    }


    private static class ApplicationRunnerTool {

        public static void main(String[] args) {

            ApplicationRunner.runApplication(new WindowApplication());
        }

    }

    private void runApplication() {

        // initializing controller

        try {
            XMLInitializeContext
                    .init(XMLInitializeContext.XML_TASKS_FILE)
                    .parseTag(XMLInitializeContext.TAG_ATTR)
                    .loadIntoCache();
        } catch (TaskObjectNotAbstractTaskException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (application.getClass() == ConsoleApplication.class) {

            System.out.println("start console application...\n");

            application.start();

        } else if (application.getClass() == WindowApplication.class) {

            System.out.println("start windows application...\n");

            application.start();
        }


    }
}
