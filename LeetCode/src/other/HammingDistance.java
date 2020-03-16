package other;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int n=x^y;
		System.out.println(n);
		int count=0;
		while (n!=0) {
			if((n&1)!=0) count++;
			n>>=1;
		}
		return count;

	}
	public static void main(String[] args) {
		HammingDistance hDistance=new HammingDistance();
		System.out.println(hDistance.hammingDistance(1, 4));
	}
}
