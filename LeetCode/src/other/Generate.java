package other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Generate {
	public List<List<Integer>> generate(int numRows) {
		List<Integer> first=new ArrayList<Integer>();;
		List<List<Integer>> list=new ArrayList<List<Integer>>(numRows);
		if (numRows<=0) {
			return list;
		}
		else {
			int n,i;
			
			first.add(1);
			list.add(0,first);
			for(n=1;n<numRows;n++){
				List<Integer> list2=new ArrayList<Integer>();
				list2.add(1);				
				i=1;
				while (i<n) {
					int left=list.get(n-1).get(i-1);
					int right=list.get(n-1).get(i);
					list2.add(i, left+right);
					i++;
				}
				list2.add(1);
				list.add(n,list2);
			}
			return list;
		}
	}
	public static void main(String[] args) {
		Generate generate=new Generate();
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		list=generate.generate(20);
		Iterator<List<Integer>> iterator=list.iterator();
		while (iterator.hasNext()) {			
			Iterator<Integer> iterator2=iterator.next().iterator();
			while (iterator2.hasNext()) {
				System.out.print(iterator2.next());
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
}
