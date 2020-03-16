package list;

import java.util.HashMap;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

/**
 * 数组中的重复数字
 * 
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 
 * */
public class Duplicate {
	// Parameters:
	// numbers: an array of integers
	// length: the length of array numbers
	// duplication: (Output) the duplicated number in the array number,length of
	// duplication array is 1,so using duplication[0] = ? in implementation;
	// Here duplication like pointor in C/C++, duplication[0] equal *duplication
	// in C/C++
	// 这里要特别注意~返回任意重复的一个，赋值duplication[0]
	// Return value: true if the input is valid, and there are some duplications
	// in the array number
	// otherwise false

	// 方法1
	// public boolean duplicate(int numbers[],int length,int [] duplication) {
	// if(length==0||numbers==null)
	// return false;
	// HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>();
	// for(int i=0;i<length;i++){
	// if(hashMap.containsKey(numbers[i])){
	// duplication[0]=numbers[i];
	// return true;
	//
	// }else {
	// hashMap.put(numbers[i], 1);
	// }
	//
	// }
	// return false;
	//
	// }
	// 方法二，对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
	// 以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，因此可以知道
	// 2 重复
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		if (numbers == null || length <= 0)
	        return false;
	    for (int i = 0; i < length; i++) {
	        while (numbers[i] != i) {
	            if (numbers[i] == numbers[numbers[i]]) {
	                duplication[0] = numbers[i];
	                return true;
	            }
	            swap(numbers, i, numbers[i]);
	        }
	    }
	    return false;
	}
	private void swap(int numbers[],int i,int j){
		int temp=numbers[i];
		numbers[i]=numbers[j];
		numbers[j]=temp;
	}
	
	
    public static void main(String[] args) {
		Duplicate duplicate=new Duplicate();
		int numbers[]={2,1,3,1,4};
		int duplication[] = {3};
		boolean b=duplicate.duplicate(numbers, 5, duplication);
		System.out.println(duplication[0]+","+b);		
	}
}
