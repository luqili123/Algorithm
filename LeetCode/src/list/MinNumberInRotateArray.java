package list;

public class MinNumberInRotateArray {
	public int minNumberInRotateArray(int [] array) {
	    if(array.length==0)
	    	return 0;
	    for (int i = 0; i < array.length-1; i++) {
			if(array[i]>array[i+1])
				return array[i+1];
			else if (array[i]==array[i+1]) {
				if(i==array.length-1)
					return array[0];
				
			}
		}
	    return 0;
    }
	//二分法
	public int minNumberInRotateArray2(int [] array) {
	    if(array.length==0)
	    	return 0;
	    int l=0,h=array.length-1;
	   while(l<h){
			int mid=(l+h)/2;
			if(array[mid]<=array[h])
				h=mid;
			else {
				l=mid+1;
			}
		}
	   return array[l];
    }
}
