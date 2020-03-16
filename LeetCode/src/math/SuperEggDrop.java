package math;

public class SuperEggDrop {
	//鸡蛋个数有限，当N很大是，无法一个一个尝试，最快的方法应该是二分法查找
	public int superEggDrop(int K, int N) {
		int n=N,count=0;
		while (n!=0) {
			n=n/2;
			count++;
		}
		return count;

	}
}
