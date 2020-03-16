

public class RemoveDuplicates {
		
	   public int removeDuplicates(int[] nums){
		   int i=0,count=nums.length;
		   while(i<(count-1)){
			   if(nums[i]==nums[i+1]){
				   for(int j=i+1;j<nums.length;j++){
					   nums[j-1]=nums[j];
				   }
				   count--;
			   }
			   else {
				i++;
			}
			   
		   }
		return count;
		   
	   }
	   public static void main(String[] args) {
		   RemoveDuplicates removeDuplicates=new RemoveDuplicates();
			int[] nums={1,2,3,4,4,4,5,6,7,7,8,9,9};
			System.out.print("数组长度为："+removeDuplicates.removeDuplicates(nums));
	}
	   
}
