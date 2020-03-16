package string;

//字符串转换整数 
public class MyAtoi {
	public int myAtoi(String str) {
		
		if(str == null||str.length()==0)
			return 0;
		int sign=1;
		char[] ch = str.toCharArray();//这个方法只能去除两端的空格字符，无法去掉空白字符""
		
		if (str == null||str==""||(ch[0]>'a'&&ch[0]<'z'||(ch[0]>'A'&&ch[0]<'Z'))){
			return 0;
		}
		
			
		else {
			if(ch[0]=='-') sign=-1;
			for (int i = 1; i < ch.length; i++) {
				if ((ch[i] > '0' && ch[i] < '9') || ch[i] == '+' || ch[i] == '-') {
					System.out.println(i);
					temp.append(ch[i]);
				} else {
					break;
				}
			}
			
			long temp2 = Long.parseLong(temp.toString());
			if (temp2 > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if (temp2 < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			} else {
				int result = (int) temp2;
				return result;
			}
		}

	}

	public static void main(String[] args) {
		MyAtoi myAtoi = new MyAtoi();
		// String tString="";
		// System.out.println(tString=="");
		System.out.println(myAtoi.myAtoi("-94"));

	}

}
