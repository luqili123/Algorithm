

public class PlusOne {
	 public int[] plusOne(int[] digits) {
		 int num=0;
		 for (int i = 0; i < digits.length; i++) {
			num=num*10+digits[i];
			
		}
		 num=num+1;
		 String temp=num+"";
		 System.out.println(temp.length());
		 int[] dig=new int[temp.length()];
		 for (int i = dig.length-1; i >=0; i--) {
			dig[i]=num%10;		
			num/=10;
//			System.out.println(num);
		}
		return dig;
		 
	 }
	 public static void main(String[] args) {
		 PlusOne plusOne = new PlusOne();
//			int[] digits = { 0};
//			int[] digits = { 9};
//			int[] digits = { 9,9};
			int[] digits = { 1,2,3,4,6};
			int[] result=plusOne.plusOne(digits);
			
			for (int i : result) {
				System.out.print(i + ",");
			}
		}
	}

