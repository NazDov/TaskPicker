package com.softserveinc.edu.ita.taskmanager.model;

import java.util.Arrays;

public class PrimeNumbers extends AbstractTask {
	
	
	private int [] arr;
    private int num=0;
	private int n =10;

    public PrimeNumbers(){

        if(n<=1){
            throw new IllegalArgumentException();
        }

        arr = new int[n -1];

        fillInNumbsLessThan(n-1);
    }

    private void fillInNumbsLessThan(int n) {
        while(num<n){
            arr[num++]=num;
        }
    }


    public int[] findPrimeNumbersForN(){

        int [] numbers = new int[arr.length];
        int count=0;

        for(int i=n; i<n+1; i++){

            for(int j=0; j<arr.length; j++){


                if(retPrimeNumber(i, arr[j])==1){

                    numbers[count++]=arr[j];
                }

            }
        }

        return numbers;
    }


    public boolean hasAllPrimeNumberPairs(){


        if(arr.length<2){
            return true;
        }


        for(int i=0; i<arr.length; i++)
        {

            for(int j=0; j<arr.length; j++){


                if(i==j){
                    continue;
                }

                if(retPrimeNumber(arr[i], arr[j])!=-1){
                    System.out.printf("not a prime number pair %d and %d \n", arr[i], arr[j]);
                    return false;
                }


            }
        }



        return true;
    }

    private int retPrimeNumber(int firstNum, int secNum) {


        if(firstNum%secNum==0){

            return secNum;

        }

        return retPrimeNumber(secNum, firstNum%secNum);
    }
	
	
	
	
	

	@Override
	public Object returnCalculatedOutput() {
		
		return Arrays.toString(findPrimeNumbersForN());
	}

}
