package string;

public class ToLowerCase {
	 public String toLowerCase(String str) {
		 String string="";
		 char temp;
		 for(int i=0;i<str.length();i++){
			 temp=str.charAt(i);
			 if(temp>='A'&&temp<='Z')
				 string=string+(char)(temp+32);
			 else
				 string=string+temp;
		 }
		return string;
	        
	    }
	 public static void main(String[] args) {
		ToLowerCase tCase=new ToLowerCase();
		String str="Hello";
		System.out.println(tCase.toLowerCase(str));
	}
}
