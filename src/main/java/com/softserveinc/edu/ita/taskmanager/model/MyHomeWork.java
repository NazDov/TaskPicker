package com.softserveinc.edu.ita.taskmanager.model;

import java.util.Random;
/**
 * 
 * @author User
 *
 *default task for testing
 *
 */
public class MyHomeWork extends AbstractTask {
	

	
	Random rand = new Random();
	
	public int calcSum(){
		
		int sum=0;
		
		final int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++){
			arr[i] = rand.nextInt(100);
		}
		
		for(int elem: arr){
			
			if(elem%5 == 0 && elem %7 !=0){
				sum+=elem;
			}
		}
		
		
		return sum;
		
	}
	
	
	@Override
	public Object returnCalculatedOutput() {
		
		
		return calcSum();
		
	}
	
	

}
