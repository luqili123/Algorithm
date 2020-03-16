package string;

public class IsNumeric {
	//使用正则表达式匹配
	public boolean isNumeric(char[] str) {
		if (str == null || str.length == 0)
	        return false;
	    return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
