package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Comparator;

public class BuildingBridgesProblem {
	
	private static class Bridge{
		Integer south;
		Integer north;
		public Bridge(Integer north, Integer south) {
			super();
			this.south = south;
			this.north = north;
		}
		public Integer getSouth() {
			return south;
		}
		public void setSouth(Integer south) {
			this.south = south;
		}
		public Integer getNorth() {
			return north;
		}
		public void setNorth(Integer north) {
			this.north = north;
		}
		
		
		
		
	}
	
	public static void buildBridges(int[] north, int[] south){
		ArrayList<Bridge> bridges = new ArrayList<>();
		
		for(int i=0;i<north.length;i++){
			bridges.add(new Bridge(north[i], south[i]));
		}
		
		bridges.sort(new Comparator<Bridge>() {

			@Override
			public int compare(Bridge o1, Bridge o2) {
				if(o1.getSouth() != o2.getSouth()){
					return o1.getSouth().compareTo(o2.getSouth());
				}
				else{
					return o1.getNorth().compareTo(o2.getNorth());
				}
			}
			
		});
		
		int[] northArray = new int[north.length];
		int i=0;
		for(Bridge b: bridges){
			northArray[i]=b.getNorth();
			i++;
		}
		int bridgeCount = getLIS(northArray);
		
		System.out.println("No of Bridges that can be built: "+bridgeCount);
	}
	
	public static int getLIS(int[] arr){
		int[] LIS = new int[arr.length];
		
		for(int i=0;i<arr.length;i++){
			LIS[i]=1;
		}
		
		for(int i=1;i<arr.length;i++)
			for(int j=0;j<i;j++){
				if(arr[i] >= arr[j] && LIS[i] < LIS[j]+1){
					LIS[i]=LIS[j]+1;
				}
			}
		
		return LIS[arr.length-1];
	}

	public static void main(String[] args) {
		int[] north = {5,3,10};
		int[] south ={6,4,1};
		buildBridges(north,south);

	}

}
