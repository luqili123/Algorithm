package string;

public class IsPalindrome {
	public boolean isPalindrome(String s) {
		String string=s.toLowerCase();
//		System.out.println(string.length());
		//两个指针指向字符首尾，进行比较，遇到非字母和数字就跳过
		int front=0,rear=string.length()-1;
		while(front<rear&&front<string.length()-1){
			char f=string.charAt(front);
			char r=string.charAt(rear);
			if(!((f>='a'&&f<='z')||(f>='0'&&f<='9'))){
				front++;
				continue;
			}
			if(!((r>='a'&&r<='z')||(r>='0'&&r<='9'))){
				rear--;
				continue;
			}
			if(f!=r)
				return false;
			front++;
			rear--;
		}
				
		return true;
		

	}

	public static void main(String[] args) {
		IsPalindrome isPalindrome = new IsPalindrome();
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome.isPalindrome(s));
		
	}
}
