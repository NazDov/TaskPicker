package com.softserveinc.edu.ita.taskmanager.model;

import com.softserveinc.edu.ita.taskmanager.view.ViewStrategy;

/**
 * 
 * @author Nazar Dovhyy
 *
 */
public abstract class AbstractTask {

	public int findSum(){
		throw new UnsupportedOperationException();
	}
	
	public int findCount(){
		throw new UnsupportedOperationException();
	}
	
	public final void runTask(ViewStrategy viewStrategy){
		
		viewStrategy.show(callTasks());
		
	}
	
	public abstract Object callTasks();
	
}
