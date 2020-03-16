package design;

import java.util.Random;

public class Shuffle_an_Array {
	private int[] cur;
	private int[] org;
public Shuffle_an_Array(int[] nums) {
		
        org=nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return org;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        cur=new int[org.length];
        for(int i=0;i<org.length;i++)
        	cur[i]=org[i];
        Random random=new Random();
        int temp,n;
        for(int i=cur.length-1;i>=0;i--){
        	n=random.nextInt(i+1);
        	temp=cur[i];
        	cur[i]=cur[n];
        	cur[n]=temp;
        }
        return cur;
    }
}
