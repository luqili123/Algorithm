package 基础算法;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    	int[] arr={1,3,3,13,12,3213,13,13,3,434,65,54};
    	QuickSort(arr,0,arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
    }
    
    static void QuickSort(int[] arr,int l,int r){   
    	int key;
    	int i=l;
    	int j=r;
    	if(i<j){
    	    key=arr[l];
    		while(i<j){
		    	while(i<j&&key<=arr[j]){
		    		j--;
		    	}
		    	if(i<j){
		    		arr[i]=arr[j];
		    		i++;	
		    	}
		    	while(i<j&&key>=arr[i]){
		    		i++;
		    	}
		    	if(i<j){
		    		arr[j]=arr[i];
		    		j--;
		    	}
    		}
	    	arr[i]=key;
	    	QuickSort(arr,l,i-1);
	    	QuickSort(arr,i+1,r);
    	}
    }
       
}