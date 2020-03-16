package math;

public class AddBinary {
	 public String addBinary(String a, String b) {
		 int i=a.length(),j=b.length(),carry=0;	//记录进位	 
		 String result="";
		 while(i>0||j>0){
			if(i>0){
				carry+=Integer.parseInt(a.substring(i-1, i));
				i--;
			}
			if(j>0){
				carry+=Integer.parseInt(b.substring(j-1,j));
				j--;
			}
			if(carry==2){//1+1=10
				result="0"+result;
				carry=1;
			}else if (carry==3) {//10+1=11
				result="1"+result;
				carry=1;
			}else {
				result=carry+""+result;
				carry=0;
			}
			
		 }
		 //处理最高位的进位
		 if(carry==1)
				result="1"+result;
		return result;
	        
	    }
	 public static void main(String[] args) {
		AddBinary addBinary=new AddBinary();
		System.out.println(addBinary.addBinary("1111", "1111"));
	}
}
