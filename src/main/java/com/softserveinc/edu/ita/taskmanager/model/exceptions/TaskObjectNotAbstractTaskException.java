package com.softserveinc.edu.ita.taskmanager.model.exceptions;

/**
 * Created by nazar.dovhyy on 18.06.2016.
 */
public class TaskObjectNotAbstractTaskException extends Exception {
    private final String notAbstractTypeExceptionMsg =" not a type of AbstractTask.class";
    public TaskObjectNotAbstractTaskException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage()+notAbstractTypeExceptionMsg;
    }
}
