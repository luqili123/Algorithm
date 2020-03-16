package math;

//统计所有小于非负整数 n 的质数的数量。
/*用了筛选法，挨个筛选。
 * 大概步骤为，第一次筛选2的倍数的数字，将其都筛选出去，第二轮筛选3的倍数的数字，筛选后，剩下的第一个数字就是5（因为4在第一次筛选的时候作为2的倍数已经筛出去）
 * 第三轮则筛选5倍数的数字，第四轮7倍数，第五轮11倍数……依次筛选下去，筛n轮。
 */
public class CountPrimes {
	public int countPrimes(int n) {
		int count = 0;
		Boolean[] boolean1 = new Boolean[n];
		for(int i=0;i<n;i++) boolean1[i]=false;// 初始化都是false
		if(n<=2) return 0;
		for(int i=2;i<n;i++){
			if(boolean1[i]==false){
				count++;
				for(int j=1;j*i<n;j++)
					boolean1[j*i]=true;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CountPrimes countPrimes = new CountPrimes();
		System.out.println(countPrimes.countPrimes(3));
	}
}
