package com.dynamicprogramming;

public class CuttingRod {
	
	public static int maxValue(int price[]){
        int max[] = new int[price.length+1];
        for(int i=1; i <= price.length; i++){
            for(int j=i; j <= price.length; j++){
                max[j] = Math.max(max[j], max[j-i] + price[i-1]);
            }
        }
        return max[price.length];
    }
	
	public static int recursiveMaxValue(int price[],int len){
        if(len <= 0){
            return 0;
        }
        int maxValue = 0;
        for(int i=0; i < len;i++){
            int val = price[i] + recursiveMaxValue(price, len-i-1);
            if(maxValue < val){
                maxValue = val;
            }
        }
        return maxValue;
	}
        
	
	public static int profitDP(int[] value, int length) {
		int[][] solution = new int[value.length+1][length+1];

		for(int i=1;i<=value.length;i++){
			for(int j=1;j<=length;j++){
				if(j >= i){
					solution[i][j]=Math.max(solution[i-1][j], value[i-1]+solution[i][j-i]);
				}
				else{
					solution[i][j]=solution[i-1][j];
				}
			}
		}
		return solution[value.length][length];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = {2,5,7,8};
		System.out.println(maxValue(price));
		//System.out.println(recursiveMaxValue(price,5));
		System.out.println(profitDP(price, 5));

	}

}
