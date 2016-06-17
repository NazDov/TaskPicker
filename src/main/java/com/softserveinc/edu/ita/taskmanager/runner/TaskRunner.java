package com.softserveinc.edu.ita.taskmanager.runner;

import java.io.IOException;

import com.softserveinc.edu.ita.taskmanager.model.AbstractTask;
import com.softserveinc.edu.ita.taskmanager.view.impl.FileOutputStrategy;
import com.softserveinc.edu.ita.taskmanager.view.inter.ViewStrategy;

/**
 * 
 * @author Nazar Dovhyy
 * 
 * utility class designed to run tasks
 * 
 * use example:
 * 
 * <pre>
 * 
 * //saving output to file
 * TaskRunner.run(new MyHomeWork(), new FileOutputStrategy());
 * 
 * or
 * 
 * TaskRunner.run(new MyHomeWork());
 * 
 * try {
			TaskRunner.run(new MyHomeWork(), new FileOutputStrategy("newFile.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 * 
 * </pre>
 *
 */
public class TaskRunner {
	
	private TaskRunner(){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * runs the task object with default output strategy
	 * @param abstractTask task implementation
	 */
	public static Object run(AbstractTask abstractTask){
		return abstractTask.runTask();
	
	}
	
	/**
	 * runs the task object with the given ViewStrategy
	 * @param abstarctTask given task implementation
	 * @param viewStrategy given output strategy
	 */
	public static void run(AbstractTask abstarctTask, ViewStrategy viewStrategy){
		abstarctTask.runTask(viewStrategy);
	}
	

}
