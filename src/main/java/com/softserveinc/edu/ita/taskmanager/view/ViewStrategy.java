package com.softserveinc.edu.ita.taskmanager.view;

public interface ViewStrategy {

	ViewStrategy TO_CONSOLE = new ConsoleView();
	
	
	static class ConsoleView implements ViewStrategy{

		@Override
		public void show(Object callTasks) {
			System.out.println(callTasks);
			
		}
		
	}

	void show(Object callTasks);

}
