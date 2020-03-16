package 剑指offer;

import java.util.HashMap;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @author lqllq
 *
 *思路：
 *	1.排序
 *	2.哈希表
 *	3.重排数组，在过程中检测 书59
 *	4.二分法：将长度为n的分成一半，哪一半多，哪一半就有重复 书59
 */
public class 数组中重复的数字 {
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if(numbers==null||numbers.length<=0){
            return false;
        }
		HashMap<Integer,Integer> hashmap=new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            if(hashmap.containsKey(numbers[i])){
                duplication[0]=numbers[i];
                return true;
            }else{
                hashmap.put(numbers[i],0);
            }
        }
        return false;
    }
	/**
	 * 重拍数组，若没有重复，则数组i位置会对应一个数组i。书59	 
	 * @param numbers
	 * @param length
	 * @param duplication
	 * @return
	 */
	public static boolean duplicate2(int numbers[],int length,int [] duplication) {
		if(numbers==null||numbers.length<=0){
            return false;
        }
        for(int i=0;i<numbers.length;i++){
            while(numbers[i]!=i){
                if(numbers[numbers[i]]==numbers[i]){
                    duplication[0]=numbers[i];
                    return true;
                }
               int t=numbers[i];
               numbers[i]=numbers[t];
               numbers[t]=t;
               System.out.println(numbers[i]);
              
            }
            
        }
        return false;
		
		
	}
	
	public static void main(String[] args) {
		int[] arr={3,1,2,0,2,5,3};
		int[] result=new int[1];
		duplicate2(arr,arr.length,result);
	}

}
