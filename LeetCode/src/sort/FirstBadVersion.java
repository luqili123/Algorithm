package sort;
//二分查找法
public class FirstBadVersion {
	public int firstBadVersion(int n) {
		int i=1,j=n,mid;
		while(i<j){
			mid=i+(j-i)/2;
			if(isBadVersion(mid))
				j=mid-1;
			else {
				i=mid+1;
			}
		}
		return i;
		
	}
}
