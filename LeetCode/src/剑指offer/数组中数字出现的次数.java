package 剑指offer;
/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @author lqllq
 *	思路：位运算，异或操作（相同为0不同为1），两个相同的数异或一定等于0，所以，我们可以将整个数组全部异或一遍，这样相同的数就会相互抵消，最后剩下
 *		     的值一定是两个不重复的值异或的结果。
 *		  为了将两个数分开，还需要对数组进行分组。如何分组呢？
 *		 因为两个数一定不一样，所以异或的二进制结果里一定有1，有1说明这两个数一个数这个位置为0，一个数这个位置为1，我们就按这位上的数是0，是1来分成
 *		 2组。这样既可以确保两个不重复的数字会被分到不同组，也能确保存在重复的元素在同一组。
 */
public class 数组中数字出现的次数 {
	public int[] singleNumbers(int[] nums) {
		//存储所有元素异或之后的结果
		int num=nums[0];
		for(int i=1;i<nums.length;i++){
			num^=nums[i];
		}
		//全员异或之后得到了两个不重复元素的异或结果
		//计算最低位1的位置，用于分组
		//num&(-num)可以使得最低位1的位置为1，其他位全部变成0
		int onePosition=num&(-num);
		int num1=0,num2=0;
		for(int i=0;i<nums.length;i++){
			//与操作之后变成onePosition，nums[i]的二进制数对应的位置也是1
			if((nums[i]&onePosition)==onePosition){
				num1^=nums[i];
			}else{//对应位置是0，分成另一组
				num2^=nums[i];
			}
		}
		//由于一开始num1和nums2的值是0，所以，最终和结果需要再异或一次0，中和0对结果的影响
		return new int[]{num1,num2};
    }
}
