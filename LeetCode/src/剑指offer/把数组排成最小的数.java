package 剑指offer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @author lqllq
 *	思路：通过在排序时传入一个自定义的 Comparator 实现，重新定义 String 列表内的排序方法，若拼接 s1 + s2 > s2 + s1，那么显然应该把 s2 在拼接时放在前面，
 *	以此类推，将整个 String 列表排序后再拼接起来。
 */
public class 把数组排成最小的数 {
	public String minNumber(int[] nums) {
		
		ArrayList<String> arr=new ArrayList<String>();
		//将数字转换成字符串存储
		for(int i=0;i<nums.length;i++){
			arr.add(String.valueOf(nums[i]));
		}
		//自定义比较器实现字符串排序
		arr.sort(new Comparator<String>(){
			public int compare(String s1,String s2){
				return (s1+s2).compareTo(s2+s1);//十分关键，升序
			}		
		});
		//连接字符串
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<arr.size();i++){
			sb.append(arr.get(i));
		}
		return sb.toString();
		
    }
}
