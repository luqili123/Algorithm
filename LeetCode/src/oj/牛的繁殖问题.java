package oj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class 牛的繁殖问题 {
//	public static void main(String[] args) {
//		Scanner scanner=new Scanner(System.in);
//		int n=Integer.parseInt(scanner.nextLine());
//		for(int p=0;p<n;p++){
//			int year=Integer.parseInt(scanner.nextLine());
////			System.out.println(year);
//			System.out.println(cowNumer(year)%(10*10*10*10*10*10*10*10*10+7));
//		}
//	}
//	public static long cowNumer(int year){
//		long[] number=new long[year+1];
//		number[0]=0;
//		number[1]=1;
//		number[2]=2;
//		for(int i=3;i<=year;i++){
//			number[i]=number[i-1]+number[i-2];
//		}
//		return number[year];
//	}
	
	static Map<Long, Long> map = new HashMap<Long, Long>();

    public static long fib(long n) {
        if (n == 0)
            return 0;
        if (n == 2 || n == 1)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        if (n % 2 != 0) {
            long k = (n + 1) / 2;
            map.put(n, (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) % 1000000007);
        } else {
            long k = n / 2;
            map.put(n, (fib(k) * ((fib(k - 1) << 1) + fib(k))) % 1000000007);

        }
        return map.get(n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            System.out.println(fib(scanner.nextLong() + 1));
        }
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
