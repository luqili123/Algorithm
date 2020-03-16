package list;
/**
 * 在二维数组中查找
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * 
 * */

//要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
//该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
//因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
public class FindNumber {
	public boolean Find(int target, int [][] array) {
		if(array==null||array.length<=0||array[0].length<=0)
			return false;
		int r=0;
		int h=array[0].length-1;
		while(r<array.length&&h>=0){
			if(target==array[r][h])
				return true;
			else if (target>array[r][h]) {
				r++;
			}else if (target<array[r][h]) {
				h--;
			}
		}
		return false;
    }
}
