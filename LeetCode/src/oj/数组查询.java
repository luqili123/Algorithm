package oj;

import java.util.Scanner;

//给定一个数组，任务是完成查找最大和子数组的函数，在该函数中，您最多可以删除一个元素以获得最大和。

/**
 * 我们定义f ( i ) 和 g ( i )，其中 f( i ) 表示不删除元素的情况下最大子数组和（区间为[0，i]），g( i ) 代表删除元素的情况下的最大子数组和（区间为[0，i]）。

	f(i) = Math.max(f(i-1)+arr[i],arr[i]) //要么是当前元素累加之前的和，要么是重新从当前元素开始
	g(i) = Math.max(g(i-1)+arr[i],f(i-1)) 
	//要么是加上当前元素，也就是维持之前删除某个元素的情形，即g[i-1]+arr[i]
	//要么是删除当前这个元素，那么区间[0, i-1]就是不删除元素的情况，即f(i-1)+0（注意是f不是g！！）
	 * 
	 * 问题在于初始化：

	f(0)= arr[0] //因为必须要有元素，不能为 0 个元素

	g(0) = 什么呢？

	举个例子，假设我们要计算g(1)：

	g(1) = Math.max(g(0)+arr[1],f(0))//题目提到至少保留一个元素，所以必须要选f(0)，即g(0)要足够小
	// g(0) + arr[1] < arr[0]
	// g(0) < arr[0] - arr[1]
	// 因为 - 10^4 <= arr[i] <= 10^4，所以arr[0]-arr[1] >= -2 * 10^4，即g(0)取-20001即可


 * @author lqllq
 *
 */
public class 数组查询 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=Integer.parseInt(scanner.nextLine());
		while(t-->0){
			int len=Integer.parseInt(scanner.nextLine());
			String[] temp=scanner.nextLine().split(" ");
			int[] arr=new int[len];
			for(int i=0;i<len;i++){
				arr[i]=Integer.parseInt(temp[i]);
			}
			//-----------------------------------------------------
			System.out.println(maximumSum(arr));
			

		}
	}
	public static int maximumSum(int[] array) {
		int[] f=new int[array.length];
		int[] g=new int[array.length];
		f[0]=array[0];
		g[0]=-200001;
		for(int i=1;i<array.length;i++){
			f[i]=Math.max(f[i-1]+array[i], array[i]);
			g[i]=Math.max(g[i-1]+array[i], f[i-1]);
		}
		int res=Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++){
			res=Math.max(res,Math.max(f[i], g[i]));
		}
		return res;
	}
	
	
	
	
	
//    public static void main(String args[]){
//        Scanner reader=new Scanner(System.in);
//        int num=Integer.parseInt(reader.nextLine());
//        while(num-->0){
//            int length=Integer.parseInt(reader.nextLine());
//            int []nums=new int[length];
//            String n[]=reader.nextLine().split(" ");
//            for(int i=0;i<length;i++){
//                nums[i]=Integer.parseInt(n[i]);
//            }
//            int [] left=new int[length];
//            int [] right=new int[length];
//            left[0]=nums[0];
//            right[length-1]=nums[length-1];
//            int res=Math.max(left[0],right[length-1]);
//            for(int i=1;i<length;i++){
//                left[i]=nums[i]+Math.max(left[i-1],0);
//                res=Math.max(res,left[i]);
//            }
//            for(int i=length-2;i>=0;i--){
//                right[i]=nums[i]+Math.max(right[i+1],0);
//                res=Math.max(res,right[i]);
//            }
//            for(int i=1;i<length-1;i++){
//                res=Math.max(left[i-1]+right[i+1],res);
//            }
//            System.out.println(res);
//        }
//    }
}