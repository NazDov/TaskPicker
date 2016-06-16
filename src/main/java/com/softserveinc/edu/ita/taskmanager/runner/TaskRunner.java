package com.softserveinc.edu.ita.taskmanager.runner;

import com.softserveinc.edu.ita.taskmanager.model.AbstractTask;
import com.softserveinc.edu.ita.taskmanager.view.ViewStrategy;

public class TaskRunner {
	
	private TaskRunner(){
		throw new UnsupportedOperationException();
	}
	
	public static void run(AbstractTask abstractTask){
		abstractTask.runTask(ViewStrategy.TO_CONSOLE);
	
	}
	

}
