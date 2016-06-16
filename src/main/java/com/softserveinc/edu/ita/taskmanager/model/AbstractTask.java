package com.softserveinc.edu.ita.taskmanager.model;
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
	
	public final void runTask(){
		
		callTasks();
		
	}
	
	public abstract void callTasks();
	
}
