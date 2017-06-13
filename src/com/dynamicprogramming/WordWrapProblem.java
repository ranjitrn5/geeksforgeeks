package com.dynamicprogramming;

import java.time.temporal.JulianFields;

public class WordWrapProblem {
	
	public static String justify(String[] words, int width){
		int[][] costMatrix = new int[words.length][words.length];
		
		for(int i=0;i<words.length;i++){
			costMatrix[i][i]=width-words[i].length();
			for(int j=i+1;j<words.length;j++){
				costMatrix[i][j] = costMatrix[i][j-1]+words[j].length()-1;
			}
		}
		
		for(int i=0;i<words.length;i++)
			for(int j=0;j<words.length;j++){
				if(costMatrix[i][j] < 0){
					costMatrix[i][j]=Integer.MAX_VALUE;
				}
				else{
					costMatrix[i][j] = (int)Math.pow(costMatrix[i][j], 2);
				}
			}
		
		int[] minCost = new int[words.length];
		int[] result = new int[words.length];
		
		for(int i=words.length-1;i>=0;i--){
			minCost[i] = costMatrix[i][words.length-1];
			result[i] = words.length;
			for(int j = words.length-1;j > i;j--){
				if(costMatrix[i][j-1] == Integer.MAX_VALUE){
					continue;
				}
				if(minCost[i] > minCost[j]+costMatrix[i][j-1]){
					minCost[i]=minCost[j]+costMatrix[i][j-1];
					result[i] = j;
				}
			}
		}
		
		System.out.println("Minimum Cost: "+minCost[0]);
		System.out.println("");
		
		StringBuilder resultString = new StringBuilder();
		int i =0;
		int j;
		do{
			j = result[i];
			for(int k=i;k<j;k++){
				resultString.append(words[k]);
			}
			resultString.append("\n");
			i =j;
		}while(j < words.length);
		
		return resultString.toString();
	}

	public static void main(String[] args) {
		String[] words = {"Geeks", "for","geeks","presents","word","wrap","problem"};
		int width = 15;
		System.out.println(justify(words, width));

	}

}
