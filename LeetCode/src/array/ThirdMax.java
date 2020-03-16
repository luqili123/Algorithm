package array;

public class ThirdMax {
	 public int thirdMax(int[] nums) {
		 int first=Integer.MIN_VALUE;
		 int second=Integer.MIN_VALUE;
		 int third=Integer.MIN_VALUE;
		 if(nums.length==0)
			 return nums[0];
		 if(nums.length==2)
			 
			 return Math.max(nums[0],nums[1]);
		 int flag=0;
		 boolean b=true;
		 for(int i=0;i<nums.length;i++){
			 if(nums[i]==Integer.MIN_VALUE&&b){
				 flag++;
				 b=false;
			 }
			 if(nums[i]>first){
				 flag++;
				 third=second;
				 second=first;
				 first=nums[i];
			}else if (nums[i]>second&&nums[i]<first) {
				flag++;
				third=second;
				second=nums[i];
			}else if (nums[i]>third&&nums[i]<second) {
				flag++;
				third=nums[i];
			}
			 
		 }
		return flag>=3?third:first;
	        
	    }
	 public static void main(String[] args) {
		ThirdMax thirdMax=new ThirdMax();
		int[] nums={1,1,1,-2147483648,-2147483648,-2147483648,-2147483648};
		System.out.println(thirdMax.thirdMax(nums));
	}
}
