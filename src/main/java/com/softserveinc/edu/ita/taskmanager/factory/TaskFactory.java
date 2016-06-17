package com.softserveinc.edu.ita.taskmanager.factory;

import com.softserveinc.edu.ita.taskmanager.model.AbstractTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nazar Dovhyy
 *         <p>
 *         represanting a cache-like data structure to store and retrieve
 *         AbstractTask binaries during the application execution.
 */
public class TaskFactory {

    /**
     *
     */
    public static Map<String, Map<Class<? extends AbstractTask>, String>> tasks = new HashMap<>();
    private static Class<? extends AbstractTask> typeKey;

    /**
     * method returns Task.class object mapped by the taskId
     * or stores the task in cache
     * <p>
     * the method returns null if both no mapping by typeId exists and type object
     * is null.
     * <p>
     * WARNING
     * this implementation of Map interface allows null parameters as both keys and values
     *
     * @param taskId parameter to retrieve/store object
     * @param type   object representing AbstractTask.class
     * @return AbstractTask object class type
     * @see AbstractTask
     */
    public static Class<? extends AbstractTask> getTaskById(String taskId, Class<? extends AbstractTask> type,
                                                            String descr) {

        Map<Class<? extends AbstractTask>, String> taskValueById = tasks.get(taskId);

        taskValueById = addTaskByIdIfNull(taskId, type, descr, taskValueById);

        for (Class<? extends AbstractTask> key : taskValueById.keySet()) {
            typeKey = key;
            break;
        }

        return typeKey;
    }

    /**
     * this method is called when no mapping per given key exists
     * the output of this method is that every time new Map<Type, String>
     * is stored as the value under the mapping.
     *
     * @param taskId           a key to find/store data with
     * @param valueType        - our valueType to be mapped/retrieved/ with the key
     * @param valueDescription - String description for the valueType object
     * @param taskValueById
     * @return
     */
    private static Map<Class<? extends AbstractTask>, String> addTaskByIdIfNull(String taskId,
                                                                                Class<? extends AbstractTask> valueType,
                                                                                String valueDescription,
                                                                                Map<Class<? extends AbstractTask>, String> taskValueById) {
        if (taskValueById == null) {

            HashMap localMap = new HashMap<>();

            localMap.put(valueType, valueDescription);

            tasks.put(taskId, localMap);

            taskValueById = tasks.get(taskId);
        }
        return taskValueById;
    }

    /**
     * method returns task type by the represented taskId.
     *
     * @param taskId id parameter
     * @return class type of Task object or null
     * if no task object could be found by the key
     */
    public static Class<? extends AbstractTask> getTaskById(String taskId) {

		/*
        Class<?> taskObj =null;
		
		Map<Class<? extends AbstractTask>, String> typeMapping = tasks.get(taskId);
		
		if(typeMapping!=null){
			for(Class<?> cl: typeMapping.keySet()){
				taskObj = cl;
			}
		}
		*/

        return getTaskById(taskId, null, null);
    }

    /**
     * method returns description for the existing task or null if no task can be found by taskId.
     *
     * @param taskId a key to find value with
     * @param type   a class object used as a key for description retrieval
     * @return
     */
    public static String getExistingTaskDescription(String taskId, Class<? extends AbstractTask> type) {
        Map<Class<? extends AbstractTask>, String> typeStringMap = tasks.get(taskId);
        return typeStringMap != null ? typeStringMap.get(type) : null;
    }


    public static List<String> getAllKeys() {

        List<String> keys = new ArrayList<>();

        for (String k : tasks.keySet()) {

            keys.add(k);
        }

        return keys;
    }

}
