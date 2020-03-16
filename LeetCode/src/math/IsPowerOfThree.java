package math;

public class IsPowerOfThree {
	public boolean isPowerOfThree(int n) {
		 	if (n == 1) return true;
		    else if (n == 0) return false;
		    else if (n % 3 == 0)
		        return isPowerOfThree(n / 3);
		    else return false;
        
    }
	public static void main(String[] args) {
		IsPrime isPrime=new IsPrime();
		System.out.println(isPrime.isPrime(27));
	}
}
