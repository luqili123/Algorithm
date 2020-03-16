

public class CountAndSay {
	public String countAndSay(int n) {
		if(n==1)
			return "1";
		
		String origin=countAndSay(n-1);
		int count=1;
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=0;i<origin.length();i++){
			if((i+1)==origin.length()){
				stringBuilder.append(count).append(origin.charAt(i));
				break;
			}
			
			if(origin.charAt(i+1)==origin.charAt(i)){
				count++;
				continue;
			}
			else {
				stringBuilder.append(count).append(origin.charAt(i));
				count=1;
			}
			
			
		}
		return stringBuilder.toString();
		
	}
	 public static void main(String[] args) {
			CountAndSay countAndSay=new CountAndSay();
			int n=6;
			System.out.print(countAndSay.countAndSay(n));
			
		}
}
