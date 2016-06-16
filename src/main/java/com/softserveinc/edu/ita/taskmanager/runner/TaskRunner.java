package com.softserveinc.edu.ita.taskmanager.runner;

import com.softserveinc.edu.ita.taskmanager.model.AbstractTask;

public class TaskRunner {
	
	private TaskRunner(){
		throw new UnsupportedOperationException();
	}
	
	public static void run(AbstractTask abstractTask){
		abstractTask.runTask();
	
	}
	

}
