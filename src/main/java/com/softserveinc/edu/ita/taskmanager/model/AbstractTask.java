package com.softserveinc.edu.ita.taskmanager.model;

import com.softserveinc.edu.ita.taskmanager.view.output.ViewStrategy;

/**
 * @author Nazar Dovhyy
 *         <p>
 *         this object provides a base interface for the Tasks
 *         that can be created and run by the TaskRunner:)
 *         <p>
 *         when you create your own instance of the AbstractType task you
 *         are obliged to override and implement the callTasks() method
 *         <p>
 *         you are encouraged to create your own methods corresponded to your
 *         specific assignments (homework)
 *         <p>
 *         example:
 *         <p>
 *         <p>
 *         <pre>
 *                  class Task199 extends AbstractTask{
 *
 *                 // your homework task in a single method
 *                 public int calcLogN(){
 *
 *                 // your calculation
 *
 *                 return ...;// the output of your program
 *                 }
 *
 *                 public Object returnCalculatedOutput() {
 *                 return calcLogN();
 *                 }
 *
 *                 }
 *                 </pre>
 */
public abstract class AbstractTask {


    /**
     * some basic method 1
     * FIXME override this before using
     *
     * @return
     */
    public int findSum() {
        throw new UnsupportedOperationException();
    }

    /**
     * some basic method 2
     * FIXME override this before using.
     *
     * @return
     */
    public int findCount() {
        throw new UnsupportedOperationException();
    }

    /**
     * run this method if you want to get the output of your working module
     * sends object to console by default
     *
     * WARNING: Do NOT modify this code.
     */
    public final Object runTask() {

        return this.returnCalculatedOutput();
    }

    /**
     * run this method if you have a specific output ViewStrategy
     * defined and passed as an argument.
     *
     * @param viewStrategy view object e.g. console / GUI / web-page
     */
    public final void runTask(ViewStrategy viewStrategy) {

        viewStrategy.show(returnCalculatedOutput());

    }

    /**
     * you must always implement this method to return
     * your specific calculation.
     *
     * @return object result of the calculation
     */
    public abstract Object returnCalculatedOutput();


}
