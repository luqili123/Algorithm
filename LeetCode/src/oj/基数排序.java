package oj;


/**
 * 求一个数组排序之后相邻两个数的最大差值
 * @author lqllq
 *
 */
public class 基数排序 {
	
	public static int maxGap(int[] nums){
		if(nums==null||nums.length<2)
			return 0;
		int len=nums.length;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		//找出数组的最大和最小值：确定桶的取值范围
		for(int i=0;i<len;i++){
			min=Math.min(min, nums[i]);
			max=Math.max(max, nums[i]);
		}
		//最大值==最小值，说明数组中数的最大差值就是0，都是同一个数
		if(max==min){
			return 0;
		}
	
		//len个数，需要len+1个桶
		boolean[] hasNum=new boolean[len+1];//hasNum[i]代表第i个桶里是否有数
		int[] maxs=new int[len+1];//maxs[i]代表第i个桶里数的最大值
		int[] mins=new int[len+1];//mins[i]代表第i个桶里数的最小值
		int bid=0;//桶号
		for(int i=0;i<len;i++){
			//将该数放入对应的桶中，并判断是否需要更新最值
			bid=bucket(nums[i], len, min, max);
			mins[bid]=hasNum[bid] ? Math.min(mins[bid], nums[i]):nums[i];
			maxs[bid]=hasNum[bid] ? Math.max(max, nums[i]):nums[i];
			hasNum[bid]=true;
		}
		
		int res=0;//存储最大差值
		int lastMax=maxs[0];//代表当前遍历的桶的上一个桶的最大值
		for(int i=1;i<=len;i++){
			if(hasNum[i]){//桶不空是
				res=Math.max(res, mins[i]-lastMax);//当前桶的最小值减去上一个桶的最大值
				lastMax=maxs[i];//将上一个桶的最大值设置为当前桶的最大值，继续向后遍历
			}
		}
		return res;
	}
	/**
	 * 返回num这个数应该放到那个桶里
	 * @param num
	 * @param len
	 * @param min
	 * @param max
	 * @return
	 */
	public static int bucket(long num,long len,long min,long max){
		
		return (int) ((num-min)*len/(max-min));
		
	}
	
	public static void main(String[] args) {
		int[] nums=new int[]{12,17,35,41,52,97,98,99};
		System.out.println(maxGap(nums));
	}

}
