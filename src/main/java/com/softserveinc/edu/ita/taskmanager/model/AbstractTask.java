package com.softserveinc.edu.ita.taskmanager.model;

import java.util.Random;

import com.softserveinc.edu.ita.taskmanager.view.inter.ViewStrategy;

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
		
		public Object returnCalculatedOutput() {	
			return calcLogN();
		}
		
	}
	</pre>
 *
 */
public abstract class AbstractTask {

	protected String id;
	protected String name;
	protected String description;
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

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
	public final Object runTask(){
		
		ViewStrategy.TO_CONSOLE.show(returnCalculatedOutput());
		
		return this.returnCalculatedOutput();
	}
	
	/**
	 * run this method if you have a specific output ViewStrategy
	 * defined and passed as an argument.
	 * 
	 * @param viewStrategy view object e.g. console / GUI / web-page
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

	@Override
	public String toString() {
		return "AbstractTask [id=" + id + ", name=" + name + ", description="
				+ description + ", returnCalculatedOutput()="
				+ returnCalculatedOutput() + "]";
	}
	
	
	
}
