package com.softserveinc.edu.ita.taskmanager.view.input;

import com.softserveinc.edu.ita.taskmanager.view.input.validator.InputValidator;
import com.softserveinc.edu.ita.taskmanager.factory.TaskFactory;
import com.softserveinc.edu.ita.taskmanager.model.AbstractTask;
import com.softserveinc.edu.ita.taskmanager.view.output.ViewStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nazar.dovhyy on 17.06.2016.
 * <p>
 * <p>
 * This Application implementation is designed to provide input controls via System.in console
 */
public class ConsoleApplication implements Application, Runnable {

    private static final String TERMINATE_RESULT_MESSAGE = "thank you for using our application. come back next time";
    private static final String VALIDATION_ERROR_MESSAGE = "sorry. no match for the given task id. try again or enter 'stop' ";
    private static final String ENTER_TASK_BY_ID_MESSAGE = "please enter your task by id (e.g. task100..)";

    volatile boolean terminatedThread = false;
    private BufferedReader reader;
    private String operationResult;

    @Override
    public void start() {

        new Thread(this, "ConsoleApplication").start();

    }

    private void returnOutput(Object processedInput, ViewStrategy toConsole) {
        toConsole.show(processedInput);
    }

    private Object processInput(String fetchedInput) {

        AbstractTask outputTask = null;

        if (isTerminateCondition(fetchedInput)) {
            operationResult = TERMINATE_RESULT_MESSAGE;
            terminatedThread = true;
            return outputTask;
        }

        if (!isValidated(fetchedInput)) {
            operationResult = VALIDATION_ERROR_MESSAGE;
            System.out.println(operationResult+"\n");
            return outputTask;
        }


        Class<? extends AbstractTask> taskById = TaskFactory.getTaskById(fetchedInput);
        String taskDescription = TaskFactory.getExistingTaskDescription(fetchedInput, taskById);
        System.out.println("description:" + taskDescription);

        try {
            outputTask = taskById.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return outputTask;
    }

    private boolean isValidated(String fetchedInput) {

        return InputValidator.validate(fetchedInput);
    }

    private boolean isTerminateCondition(String fetchedInput) {
        return "stop".equalsIgnoreCase(fetchedInput);
    }

    public String readInputTaskId() {
        String inputLine = null;

        try {

            reader = new BufferedReader(new InputStreamReader(System.in));


            inputLine = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputLine;
    }

    @Override
    public void run() {

        while (!terminatedThread) {

            System.out.println(ENTER_TASK_BY_ID_MESSAGE);

            String fetchedInput = readInputTaskId();

            Object processedInput = processInput(fetchedInput);

            if (processedInput == null) {
                continue;
            }

            returnOutput(processedInput, ViewStrategy.TO_CONSOLE_TASK);

        }

        closeReader();

        System.out.println(operationResult+"\n");

    }

    private void closeReader() {
        if (reader != null)
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
