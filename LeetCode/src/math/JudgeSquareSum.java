package math;

//判断一个数是否可以表示为两个数的平方和
//双指针思想，这两个数一定比给出的数c的开根号要小，一定比0大，所以一个数赋值0，另一个赋值根号c
public class JudgeSquareSum {
	public boolean judgeSquareSum(int c) {
		int i=0,j=(int) Math.sqrt(c);
		while(i<=j){
			int d=i*i+j*j;
			if(d<c)
				i++;
			else if (d>c) {
				j--;
			}
			else {
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {

	}
}
