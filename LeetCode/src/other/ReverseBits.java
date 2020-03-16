package other;
//通过右移n依次获取n的末位 设置为m的末位，左移m实现颠倒
public class ReverseBits {
	public int reverseBits(int n) {
		int m=0;
	for(int i=0;i<32;i++){
			m<<=1;
			m=m|(n&1);
			n>>=1;
		}
		return m;

	}
	public static void main(String[] args) {
		ReverseBits rBits=new ReverseBits();
		System.out.println(rBits.reverseBits(43261596));
	}
}
