package com.softserveinc.edu.ita.taskmanager.factory;

import java.util.*;

import com.softserveinc.edu.ita.taskmanager.model.AbstractTask;

public class TaskFactory {
	
	private static Map<String, Class<? extends AbstractTask>> tasks = new HashMap<>();

	
	public static <T extends AbstractTask> Class<?> getTaskObject(String taskId, Class<T> type){
		
		@SuppressWarnings("unchecked")
		Class<? extends AbstractTask> taskObj = tasks.get(taskId);
		
		if(taskObj ==  null) {
			
			tasks.put(taskId, type);
			
		}
		
		taskObj = tasks.get(taskId);
		
		
		return taskObj;
	}
	
	
}
