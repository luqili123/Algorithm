package dynamic_programming;
//有f(n)=f(n-1)+f(n-2)。 
public class ClimbStairs {
	public int climbStairs(int n) {
		if(n<=2)
			return n;
		else {
			return climbStairs(n-1)+climbStairs(n-2);
		}
		
	}
	public static void main(String[] args) {
		ClimbStairs climbStairs=new ClimbStairs();
		System.out.print(climbStairs.climbStairs(4));
		
	}
}
