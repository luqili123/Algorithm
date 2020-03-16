package array;

public class PlusOne {
	public int[] plusOne(int[] digits) {

		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] += 1;

			if (digits[i] >= 10) {
				if (i == 0) {
					int digits2[] = new int[digits.length + 1];
					digits2[0] = 1;
					digits2[1] = 0;
					if (digits.length > 1) {
						for (int j = 1; j < digits.length; j++) {
							digits2[j+1] = digits[j];
						}
					}
					return digits2;
				}
				digits[i] = digits[i] % 10;
				continue;
			} else {

				break;
			}
		}

		return digits;

	}

	public static void main(String[] args) {
		PlusOne plusOne = new PlusOne();
//		int[] digits = { 0};
		int[] digits = { 9};
//		int[] digits = { 9,9};
//		int[] digits = { 1,2,3,4,6};
		int[] result=plusOne.plusOne(digits);
		
		for (int i : result) {
			System.out.print(i + ",");
		}
	}
}
