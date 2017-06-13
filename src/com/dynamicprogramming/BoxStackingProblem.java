package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BoxStackingProblem {
	
	private static void stackBoxes(BoxDimension[] boxes){
		ArrayList<BoxDimension> boxList = new ArrayList<BoxDimension>();
		boxList = createBoxRotations(boxes);
		
		boxList.sort(new Comparator<BoxDimension>(){

			@Override
			public int compare(BoxDimension arg0, BoxDimension arg1) {
				int box1Area = arg0.getLength()*arg0.getWidth();
				int box2Area = arg1.getLength()*arg1.getWidth();
				if(box1Area >= box2Area){
					return 1;
				}
				else{
					return -1;
				}
			}
			
		});
		
		getMaxLIS(boxList.toArray(new BoxDimension[boxList.size()]));
		
		
	}
	
	private static void getMaxLIS(BoxDimension [] boxRotationalDimensions){
		int[] maxLis = new int[boxRotationalDimensions.length];
		int[] result = new int[boxRotationalDimensions.length];
		
		for(int i=0;i<boxRotationalDimensions.length;i++){
			maxLis[i]=boxRotationalDimensions[i].getHeight();
			result[i] = -1;
		}
		
		for(int i=1;i<boxRotationalDimensions.length;i++)
			for(int j=0;j<i;j++){
				if (boxRotationalDimensions[i].length < boxRotationalDimensions[j].length
						&& boxRotationalDimensions[i].width < boxRotationalDimensions[j].width) {
					if(maxLis[i] < maxLis[j] + boxRotationalDimensions[i].height){
						maxLis[i] = maxLis[j] + boxRotationalDimensions[j].height;
						result[i] = j;
					}
				}
			}
		
		System.out.println("Maximum Height of box stack:"+maxLis[boxRotationalDimensions.length-1]);
		int index = result.length-1;
		while(index >= 0){
			System.out.println(boxRotationalDimensions[index]);
			index = result[index];
		}
		/*for(int i = result.length-1;i >=0;){
				System.out.print(boxRotationalDimensions[i]);
				i = result[i];
		}*/
		
		
	}
	
	private static ArrayList<BoxDimension> createBoxRotations(BoxDimension[] boxes){
		ArrayList<BoxDimension> temp = new ArrayList<BoxDimension>();
		int index = 0;
		
		for(int i = 0;i<boxes.length;i++){
			temp.add(createBoxDimensions(boxes[i].height, boxes[i].length, boxes[i].width));
			temp.add(createBoxDimensions(boxes[i].length, boxes[i].height, boxes[i].width));
			temp.add(createBoxDimensions(boxes[i].width, boxes[i].length, boxes[i].height));
		}
		
		return temp;
		
	}
	
	public static BoxDimension createBoxDimensions(int height, int side1, int side2){
		BoxDimension d = new BoxDimension();
		
		d.height = height;
		if(side1 >= side2){
			d.length = side1;
			d.width = side2;
		}
		else{
			d.length = side2;
			d.width = side1;
		}
		return d;
	}
	

	public static void main(String[] args) {
		int[] box1 = {1,2,4};
		int[] box2 = {3,2,5};
		BoxDimension[] boxes = {new BoxDimension(3, 2, 5), new BoxDimension(1, 2, 4)};
		stackBoxes(boxes);

	}
	
	private static class BoxDimension{
		int length;
		int width;
		int height;
		
		public BoxDimension() {
			// TODO Auto-generated constructor stub
		}
		
		public BoxDimension(int length, int width, int height) {
			this.length = length;
			this.width = width;
			this.height = height;
		}
		
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}

		@Override
		public String toString() {
			return "BoxDimension [length=" + length + ", width=" + width + ", height=" + height + "]";
		}
		
		
		
	}

}



