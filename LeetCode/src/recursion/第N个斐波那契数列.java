package recursion;

public class 第N个斐波那契数列 {
	public static  int tribonacci(int n) {
		if(n<0)
			return 0;
		if(n<0)
			return -1;
        if(n==0)
        	return 0;
        if(n==1||n==2)
        	return 1;
		int[] array=new int[n+1];
		array[0]=0;
		array[1]=1;
		array[2]=1;
		for(int i=3;i<=n;i++){
			array[i]=array[i-1]+array[i-2]+array[i-3];
		}
		return array[n];
    }
	public static void main(String[] args) {
		System.out.println(tribonacci(4));
	}
}
