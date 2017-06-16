package com.trees;

public class Solution {
    
    public static boolean isVowel(char c){
        return (c == 'a'||c== 'e' || c == 'i' || c== 'o' || c == 'u');
    }
    public static String reverseVowels(String s) {
        int i = 0, j=s.length()-1;
        char[] charArray = s.toCharArray();
        while(i<j){
            while(i<j && !isVowel(charArray[i])){
                i++;
            }
            while(i<j && !isVowel(charArray[j])){
                j--;
            }
            char temp = charArray[i];
            charArray[i]=charArray[j];
            charArray[j]=temp;
                i++;
                j--;
        }
        
        
        return String.valueOf(charArray);
    }
    
    public static void main(String[] args){
    	String s ="hello";
    	System.out.println(reverseVowels(s));
    }
}