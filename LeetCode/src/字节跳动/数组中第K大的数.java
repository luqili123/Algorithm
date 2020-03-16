package 字节跳动;

public class 数组中第K大的数 {
	/**
	 * 这其实也是一个二分法啦，只不过之前的二分法都是从数组索引的角度去二分，而这次等于是二分一个数是否是满足第K大数的条件。 【即相当二分法求一个单调函数值f(x)−k=0f(x)−k=0，依次去二分x看这个函数什么时候相等。】 
 		这种方法的复杂度是需要讨论的，如果数组中全都是int类型的整数，那么时间复杂度是O(n)O(n) 
 		因为本质上查找一遍数组需要O(n)O(n)，而至多需要查找log(Max−Min)≤32log(Max−Min)≤32所以至多查找32遍，所以复杂度还是O(n)O(n)的 
 		PS，这种方法其实还是只是适用于整数，因为如果是浮点数的话，其复杂度是不可估计的。
	 * @param arr
	 * @return
	 */
	public static int getKth(int[] arr,int k){
		if(k<=0||k>arr.length){
			return -1;
		}
		int left=Integer.MAX_VALUE;
		int right=Integer.MIN_VALUE;
		//找到arr数组中的最大值和最小值
		for(int x:arr){
			left=Math.min(x, left);
			right=Math.max(x, right);
		}
		while(left<=right){
			int c1=0;
			int c2=0;
			//中位数
			int mid=left+(right-left)/2;
//			System.out.println(mid);
			for(int x:arr){
				if(x>=mid){
					c1++;
				}
				if(x>mid){
					c2++;
				}
			}
//			System.out.println(c1+" "+c2);
			if(c1>=k&&c2<k){
				return mid;
			}
			
			if(c1<k){
				right=mid-1;
			}else{
				left=mid+1;
			}
			
		}
		return -1;
	}
	
	public static void main (String[] args) 
	{
		int[] arr={1,5,3,7,2,4};
		System.out.print(getKth(arr,2));
	}
}
