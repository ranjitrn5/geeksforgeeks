package com.dynamicprogramming;

public class KnapsackProblem {
	
	public static int getMaximumValueWithRepititions(int[] wt, int items[], int capacity){
		int[] value = new int[capacity+1];
		int val;
		for(int w=1;w<=capacity;w++){
			value[w]=0;
			for(int i=0;i<items.length;i++){
				if(wt[i] <= w){
					val = value[w-wt[i]]+items[i];
					if(val > value[w]){
						value[w]=val;
						//System.out.println("w="+w+" value="+value[w]);
					}
					
				}
			}
		}
		
		return value[capacity];
	}
	
	public static int getMaxValueWithoutRepetition(int[] wt, int[] item_val, int capacity){
		int[][] value = new int[item_val.length+1][capacity+1];
		int val;
		for(int i = 0;i<value.length;i++)
			for(int w=0;w<value[i].length;w++){
				if(i == 0 || w == 0){
					value[i][w]=0;
				}
				else{
				value[i][w] = value[i-1][w];
				if(wt[i-1]<=w){
					val = value[i-1][w-wt[i-1]]+item_val[i-1];
					if(val > value[i][w]){
						value[i][w]=val;
					}
				}
				}
			}
		return value[item_val.length][capacity];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] items = {60,100,120};
		int[] weight = {20,10,30};
		int capacity = 50;
		
		System.out.println("With Repitions: "+getMaximumValueWithRepititions(weight, items, capacity));
		System.out.println("Without Reppititions: "+getMaxValueWithoutRepetition(weight, items, capacity));

	}

}
