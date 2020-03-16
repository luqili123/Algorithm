package 剑指offer;
/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 
 * @author lqllq
 * 思路：找出数组中的最大值和最小值，遇到大小王（0）跳过，找出最大和最小值之后就可以知道想要组成顺子至少需要多少张牌。max-min+1
 * 		而如果max-min+1>5则即使有大小王，也不够.另外还要考虑重复的问题，还需额外定义一个数组来判断重复
 */
public class 扑克牌中的顺子 {
	 public boolean isStraight(int[] nums) {
		 int max=Integer.MIN_VALUE;
		 int min=Integer.MAX_VALUE;
		 boolean[] repeat=new boolean[14];
		 for(int i=0;i<nums.length;i++){
			 //若存在非0重复元素，则直接返回
			 if( repeat[nums[i]]){
				 return false;
			 }
			 if(nums[i]!=0){
				 repeat[nums[i]]=true;
				 max=Math.max(max, nums[i]);
				 min=Math.min(min,nums[i]);
			 }
		 }
		 if(max-min+1>5){
			 return false;
		 }else{
			 return true;
		 }
	 }
}
