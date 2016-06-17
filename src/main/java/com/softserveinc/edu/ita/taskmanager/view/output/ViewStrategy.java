package com.softserveinc.edu.ita.taskmanager.view.output;

public interface ViewStrategy {

    ViewStrategy TO_CONSOLE = new ConsoleView();

    void show(Object objectToShow);

    class ConsoleView implements ViewStrategy {

        @Override
        public void show(Object callTasks) {
            System.out.println(callTasks);

        }

    }

}
