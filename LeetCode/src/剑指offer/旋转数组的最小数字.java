package 剑指offer;
/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * @author lqllq
 *
 * 二分法，书83页
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
 */
public class 旋转数组的最小数字 {
	public int minArray(int[] numbers) {
        if(numbers==null||numbers.length==0){
        	return -1;
        }
       
        int left=0;
        int right=numbers.length-1;
        //旋转0个数字
        if(numbers[left]<numbers[right]){
            return numbers[0];
        }
        while(right>left){
        	int mid=(left+right)/2;
        	if(numbers[mid]>numbers[right]){
        		left=mid+1;
        	}else if(numbers[mid]<numbers[right]){
        		right=mid;
        	}else{
        		right-=1;
        	}
        }
        return numbers[left];
    }
}

