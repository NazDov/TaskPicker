package com.softserveinc.edu.ita.taskmanager.factory;

import java.util.*;

import com.softserveinc.edu.ita.taskmanager.model.AbstractTask;

/**
 * 
 * @author Nazar Dovhyy
 * 
 * caching AbstarctTask implementations 
 *
 */
public class TaskFactory {
	
	private static Map<String, Class<? extends AbstractTask>> tasks = new HashMap<>();

	/**
	 * returns Task.class object by the taskId e.g. (task199)
	 * or stores the task in the cache if returns null
	 * 
	 * @param taskId parameter to retrieve/store object
	 * @param type object of AbstractTask
	 * @see AbstractTask
	 * @return AbstractTask object class type
	 */
	public static <T extends AbstractTask> Class<?> getTaskObject(String taskId, Class<T> type){
		
		@SuppressWarnings("unchecked")
		Class<? extends AbstractTask> taskObj = tasks.get(taskId);
		
		if(taskObj ==  null) {
			
			tasks.put(taskId, type);
			
			taskObj = tasks.get(taskId);
		}
		
		
		
		return taskObj;
	}
	
	
}
