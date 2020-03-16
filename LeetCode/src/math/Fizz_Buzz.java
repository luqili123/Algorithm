package math;

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz {
	private List<String> list;
	public List<String> fizzBuzz(int n) {
		list=new ArrayList<String>(n);
		for(int i=1;i<=n;i++){
			if(i%3==0&&i%5==0) list.add("FizzBuzz");
			else if (i%3==0) list.add("Fizz");
			else if (i%5==0) list.add("Buzz");
			else list.add(i+"");
		}
		return list;
        
    }
}
