package com.softserveinc.edu.ita.taskmanager.view.output;

import com.softserveinc.edu.ita.taskmanager.model.AbstractTask;
import com.softserveinc.edu.ita.taskmanager.runner.TaskRunner;

public interface ViewStrategy {

    ViewStrategy TO_CONSOLE = new ConsoleView();
    ViewStrategy TO_CONSOLE_TASK = new ConsoleViewTask() ;

    void show(Object objectToShow);

    class ConsoleView implements ViewStrategy {

        @Override
        public void show(Object callTasks) {

            System.out.println(callTasks);

        }


        public void show(AbstractTask task) {

            System.out.println(TaskRunner.run(task));

        }

    }

     class ConsoleViewTask implements ViewStrategy{
         @Override
         public void show(Object objectToShow) {
             if(objectToShow instanceof AbstractTask) {
                 System.out.println("result: "+TaskRunner.run((AbstractTask) objectToShow));
             }
         }
     }
}
