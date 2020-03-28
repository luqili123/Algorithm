package leetcodeTop精选面试题;
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 所有输入只包含小写字母 a-z 。
 * @author lqllq
 * 思路：首先比较两个字符串，找出他们的公共前缀，所有字符的公共前缀一定是包含在其中，再拿这个前缀和其他字符比较，
 * 如果比较过程中前缀变成“”，则说明没有公共前缀
 */
public class 最长公共前缀 {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0){
			return "";
		}
		//先以第一个字符串作为标杆，最长子串不会比他更长的
		String res=strs[0];
		//遍历数组，逐个比较
		for(int i=1;i<strs.length;i++){
			int j=0;
			while(j<res.length()&&j<strs[i].length()){
				if(res.charAt(j)!=strs[i].charAt(j)){
					break;
				}
				j++;
			}
			res=res.substring(0,j);
			if(res.equals("")){
				return "";
			}
		}
		return res;
    }
}
