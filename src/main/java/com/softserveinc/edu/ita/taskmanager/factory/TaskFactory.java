package com.softserveinc.edu.ita.taskmanager.factory;

import java.util.*;

import com.softserveinc.edu.ita.taskmanager.model.AbstractTask;

/**
 * 
 * @author Nazar Dovhyy
 * 
 *         caching AbstarctTask implementations
 *
 */
public class TaskFactory {

	public static Map<String, Map<Class<?>, String>> tasks = new HashMap<>();
	private static Class<?> typeKey;

	/**
	 * returns Task.class object by the taskId e.g. (task199) or stores the task
	 * in the cache if returns null
	 * 
	 * @param taskId
	 *            parameter to retrieve/store object
	 * @param type
	 *            object of AbstractTask
	 * @see AbstractTask
	 * @return AbstractTask object class type
	 */
	public static Class<?> getTaskObject(String taskId, Class<?> type,
			String descr) {

		Map<Class<?>, String> typeMapping = tasks.get(taskId);

		if (typeMapping == null) {

			HashMap<Class<?>, String> localMap = new HashMap<Class<?>, String>();
			localMap.put(type, descr);

			tasks.put(taskId, localMap);

			typeMapping = tasks.get(taskId);
		}

		for (Class<?> key : typeMapping.keySet()) {
			typeKey = key;
			break;
		}

		return typeKey;
	}
	
	/**
	 * 
	 * @param taskId id parameter
	 * @return class type of Task object or null
	 *  if no task object could be found by the key
	 */
	public static Class<?> getTaskObject(String taskId){
		
		Class<?> taskObj =null;
		
		Map<Class<?>, String> typeMapping = tasks.get(taskId);
		
		if(typeMapping!=null){
			for(Class<?> cl: typeMapping.keySet()){
				taskObj = cl;
			}
		}
		
		return taskObj;
	}

	public static String getExistingTaskDescription(String taskId, Class<?> type) {
		return tasks.get(taskId).get(type);
	}
	
	
	public static List<String> getAllKeys(){
		
		List<String> keys = new ArrayList<>();
		
		for(String k: tasks.keySet()){
			
			keys.add(k);
		}
		
		return keys;
	}

}
