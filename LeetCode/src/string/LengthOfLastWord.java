package string;

public class LengthOfLastWord {
	 public int lengthOfLastWord(String s) {
		 int i=s.length()-1,count=0;
	       if(s==null||s.length()==0) return 0;
	       while(i>=0){
	    	   if(s.charAt(i)==' '){
	    		   i--;
	    		   continue;
	    	   }else {
				break;
			}	    	   
	       }
	       if(i==-1) return 0;
	       else {
			while(i>=0){
				if(s.charAt(i)==' ') return count;
				else {
					count++;
				}
				i--;
			}
		}
		return count;
		
	        
	    	   
	    }
	 public static void main(String[] args) {
		String string=" ";
		LengthOfLastWord lOfLastWord=new LengthOfLastWord();
		System.out.println(lOfLastWord.lengthOfLastWord(string));
	}
}
