package string;

public class CountAndSay {
	 public String countAndSay(int n) {
		 if(n==1)
			 return "1";
		 String string="11";
		 char[] sc=string.toCharArray();
		 int count=1;
		 char temp;
		 
		 while(n>2){
			 StringBuffer stringBuffer=new StringBuffer();
			 for(int i=1;i<sc.length;i++){
				 temp=sc[i];
				 if(sc[i-1]==temp)
					 count++;
				 else {
					stringBuffer.append(count).append(sc[i-1]);
					count=1;
				}
				 if (i == sc.length - 1) {
						stringBuffer.append(count).append(sc[i]);
					}
			 }
			 count=1;
			 sc=stringBuffer.toString().toCharArray();
			 n--;
		 }
//		 String result=sc.toString();
		 String result=String.valueOf(sc);
		return result;
	        
	    }
	 public static void main(String[] args) {
		CountAndSay countAndSay=new CountAndSay();
		int n=26;
		System.out.print(countAndSay.countAndSay(n));
		
	}
}
