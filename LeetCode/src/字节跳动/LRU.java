package 字节跳动;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LRU<K,V> extends LinkedHashMap<K,V>{
	
	protected boolean removeEldestEntry(Map.Entry<K, V> map){
		return size()>3;
	}
	public LRU(){
		super(3,(float) 0.75,true);
	}
	
	public static void main(String[] args){
//		LRU<Integer,String> lru=new LRU<Integer,String>();		
//			lru.put(1, "a");//1,2
//			lru.put(2, "a");
//			System.out.println(lru.keySet());
//			lru.put(1, "a");
//			System.out.println(lru.keySet());
//			lru.put(3, "a");
//			lru.put(2, "a");
//			lru.put(4, "a");			
//			System.out.println(lru.keySet());
		
			
		LinkedList<Integer> list=new LinkedList<Integer>();
		int i=0;
		while(i++<100){
			int value=(int) (Math.random()*20);
			System.out.println(value);
			if(list.size()<3){
				if(list.contains(value)){
					list.remove(list.get(value));						
				}
				list.add(value);
			}else if(list.size()==3){
				if(list.contains(value)){
					list.remove((Integer)value);								
				}else{
					list.remove();
				}
				list.add(value);
			}else{
				throw new RuntimeException();
			}
			System.out.println(list);
		}
		
	}
	

}
