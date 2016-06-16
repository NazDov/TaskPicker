package com.softserveinc.edu.ita.taskmanager.model;

import java.util.Random;

import com.softserveinc.edu.ita.taskmanager.view.ViewStrategy;

/**
 * 
 * @author Nazar Dovhyy
 * 
 * this object provides a base interface for the Tasks
 * that can be created and run by the TaskRunner:)
 * 
 * when you create your own instance of the AbstractType task you
 * are obliged to override and implement the callTasks() method
 * 
 * you are encouraged to create your own methods corresponded to your
 * specific assignments (homework)
 * 
 * example:
 * 
 * 
 * <pre>
 * static class Task199 extends AbstractTask{

		// your homework task in a single method
		public int calcLogN(){
			
			// your calculation
		
			return ...;// the output of your program
		}
		
		public Object callTasks() {	
			return calcLogN();
		}
		
	}
	</pre>
 *
 */
public abstract class AbstractTask {

	/**
	 * some basic method 1
	 * FIXME override this before using
	 * @return
	 */
	public int findSum(){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * some basic method 2
	 * FIXME override this before using.
	 * @return
	 */
	public int findCount(){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * run this method if you want your output to be sent to console.
	 */
	public final void runTask(){
		
		ViewStrategy.TO_CONSOLE.show(returnCalculatedOutput());
		
	}
	
	/**
	 * run this method if you have a specific output ViewStrategy
	 * defined and passed as an argument.
	 * 
	 * @param viewStrategy view object e.g. console / GUI / webpage
	 */
	public final void runTask(ViewStrategy viewStrategy){
		
		viewStrategy.show(returnCalculatedOutput());
		
	}
	
	/**
	 * you must always implement this method to return
	 * your specific calculation.
	 * @return object result of the calculation
	 */
	public abstract Object returnCalculatedOutput();
	
}
