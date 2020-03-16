package math;

import java.util.HashMap;
import java.util.HashSet;

public class IsHappy {
	// 快乐数
	// 关键问题在于如何判断是否出现了循环，因为一个数若不是快乐数就会出现无限循环，wom可以用hashSet来判断是否出现循环
	public boolean isHappy(int n) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		while (n != 1) {
			int temp = 0;
			while (n != 0) {
				
				temp +=(n%10)*(n%10);
				n = n / 10;
//				System.out.println(n);
			}
			n = temp;
			if (!hashSet.contains(n))
				hashSet.add(n);
			else {
				return false;
			}
		}
		return n==1;

	}

	public static void main(String[] args) {
		int num=19;
		IsHappy isHappy=new IsHappy();
//		System.out.println(11%10);
		System.out.println(isHappy.isHappy(num));
	}
}
