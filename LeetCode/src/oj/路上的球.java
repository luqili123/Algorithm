package oj;

import java.util.Scanner;

/**
 * 给两个数组,两个数组都是排好序的,数组的长度叫做桶的个数,其中每个数代表球的个数
	我们要从一个数组去收集球,每当遇到两个数组中重复的部分,则可以选择更换数组去收集球
	输出收集到的球的最大值
	
	思路解析
由于数组是有序的,我们只需遍历数组1,和数组2,如果数组1的当前值比数组2的小,就将数组1向后移动一位,同时记录和,直到数组1和数组2的值相同,则选择和大的即可

注意: 数组遍历结束后仍需要额外统计一次
 * @author lqllq
 *
 */
public class 路上的球 {
	public static void main(String[] args) {
		Scanner  scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t-->0){
			int len1=scanner.nextInt();
			int len2=scanner.nextInt();
			int[] arr1=new int[len1];
			int[] arr2=new int[len2];
			for (int i = 0; i < arr1.length; i++) {
				arr1[i]=scanner.nextInt();
			}
			for (int i = 0; i < arr2.length; i++) {
				arr2[i]=scanner.nextInt();
			}
			//-----------------------------------------------
			int x=0;
			int y=0;
			int sum1=0;
			int sum2=0;
			int total=0;
			while(x<len1&&y<len2){
				if(arr1[x]<arr2[y]){
					sum1+=arr1[x];
					x++;
				}else if (arr1[x]>arr2[y]) {
					sum2+=arr2[y];
					y++;
				}else {
					total+=Math.max(sum1, sum2)+arr1[x];
					x++;
					y++;
					sum1=0;
					sum2=0;
				}
			}
			while(x<len1){
				total+=arr1[x];
				x++;
			}
			while(y<len2){
				total+=arr2[y];
				y++;
			}
			System.out.println(total);
		}
	}
}
