package math;

import java.util.HashMap;

import com.sun.org.apache.xml.internal.security.Init;

public class RomanToInt {
	public int romanToInt(String s) {
		if (s == null)
			return -1;
		HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
		hMap.put('I', 1);
		hMap.put('V', 5);
		hMap.put('X', 10);
		hMap.put('L', 50);
		hMap.put('C', 100);
		hMap.put('D', 500);
		hMap.put('M', 1000);
		char[] num = s.toCharArray();
		// System.out.println(num.length);	
		if (num.length == 1)
			return hMap.get(num[0]);
		else {
			int value = 0;
			int i = 0, j = 1;
			while (i <= num.length - 1) {
				int first = hMap.get(num[i]);
				int second = hMap.get(num[j]);

				if (first >= second) {
					value += first;
					i++;
					j++;
					if (i >= num.length)
						break;
					if (i == num.length - 1) {
						value += hMap.get(num[i]);
						break;
					}
				} else {
					value += second - first;
					i = i + 2;
					j = j + 2;
					if (i >= num.length)
						break;
					if (i == num.length - 1) {
						value += hMap.get(num[i]);
						break;
					}
				}

			}
			return value;
		}
		

	}

	public static void main(String[] args) {
		RomanToInt romanToInt = new RomanToInt();
		System.out.println(romanToInt.romanToInt("IX"));
	}
}
