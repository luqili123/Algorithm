package oj;

import java.util.HashMap;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 设计一种结构，在该结构下有三个功能：
 * insert(key):将某个key加入到该结构，不重复
 * delete(key):将结构中的key移除
 * getRandom():等概率随即返回结构中任何一个key
 * 三个方法时间复杂度为O(1)
 * 
 *两个HashMap结构
 * @author lqllq
 *
 */
public class RandomPool结构 {
	
	HashMap<String, Integer> hashMap1=new HashMap<String, Integer>();
	HashMap<Integer,String> hashMap2=new HashMap<Integer,String>();
	int index=0;
	public RandomPool结构() {
		char temp='a';
		while(temp++<='z'){
			hashMap1.put(temp+"", index);
			hashMap2.put(index, temp+"");
			index++;
		}
		
	}
	
	public void insert(String key) {
		index++;
		hashMap1.put(key, index);
		hashMap2.put(index, key);
	}
	public void delete(String key) {
		
		
	}
	public String getRandom(){
		return null;
	}
	
	

}
