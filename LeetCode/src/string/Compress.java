package string;

import com.sun.corba.se.impl.oa.toa.TOA;

public class Compress {
	 public int compress(char[] chars) {
		 if(chars==null)
			 return 0;
		 if(chars.length==1)
			 return 1;
		 int count=0,n=0,i=0;
		 char temp;
		 int length=chars.length;
		 while(i<length){
//			 System.out.println(i);
			 temp=chars[i];
			 count=1;
//			 System.out.print(temp);
			 int j=i+1;
			 while(j<length&&temp==chars[j]){
				 count++;
				 j++;
			 }
//			 System.out.println(j);
			 char[] res=intToChar(count);
			 if(count==1){
				 i++;
				 continue;
			 }
			 else if (count==2) {
				for(int k=0;k<res.length;k++)
					chars[i+k+1]=res[k];
								
			}else if (count>=3) {
				n=count-1-res.length;
//				System.out.println(n);
				for(int k=0;k<res.length;k++)
					chars[i+k+1]=res[k];
				for(int k=j;k<length;k++){
					chars[k-n]=chars[k];
				}
				
			}
			 length=length-(count-1-res.length);
				i=i+res.length+1;
//				System.err.println(i);
			 for (char c : chars) {
					System.out.print(c+" ");
				}
			 System.out.println();
		 }
		return length;
	        
	    }
	 private char[] intToChar(int n) {
		 String string=String.valueOf(n);
		 char[] result=string.toCharArray();
		return result;
		
	}
	 public static void main(String[] args) {
//		 System.out.println((char)10-'0'+48);
		char[] chars={'1','1','3','3','2','2'};
		Compress compress=new Compress();
		System.out.println(compress.compress(chars));
	}
}
