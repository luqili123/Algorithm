package array;

public class Rotate {
	public void rotate(int[] nums, int k) {
		int temp;
		for(int i=1;i<=k;i++){
			temp=nums[nums.length-1];
			for(int j=nums.length-2;j>=0;j--){
				nums[j+1]=nums[j];
			}
			nums[0]=temp;
		}
		for(int n:nums)
			System.out.print(n+" ");
	}

	public static void main(String[] args) {
		Rotate rotate=new Rotate();
		int[] nums={1,2,3,4,5,6,7,23212,2313,2,32,32,2,23,23,22,3,45,536,3,324,234,3242,3245,667,6589809,790,123,123,2131,4543,34543,45,345,435,34534,534,34,534,543,534,543,53,534,54,543,534,3,535,34,545,345,345,43,34,534,54,5435,45,43,543,543,543,543,5435,435,435,435,43,435,435,435,435,435,435,345,43,435,6,765,77,657,58,57,8,7876,876,868,678,768,768,768,678,76,8678,678,678,678,76,7,57,657,57,567};
		rotate.rotate(nums, 100);
	}
}
