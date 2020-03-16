package array;


public class MoveZeroes {
	
	public void moveZeroes(int[] nums) {
		int count=0;
		int temp;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0)
				count++;
		}
		int n=0;
		while(n<nums.length-1)
		{
			if(count==0)
				break;
			else if(nums[n]==0){
					temp=nums[n];
					for(int j=n;j<nums.length-1;j++){
						nums[j]=nums[j+1];						
					}
					nums[nums.length-1]=temp;
					count--;
				}
			else {
				n++;
			}
				
			
		}
			
	}

	public static void main(String[] args) {
		MoveZeroes moveZeroes=new MoveZeroes();
		int[] nums={0,2,0,3,12};
//		int[] nums={1,2,0,3,0,0,0,0,0,0,0,0,0,0,56,546,56,2312,3,1,0,0,0,0,0,0,0,46,6,456,456,54,0};
		moveZeroes.moveZeroes(nums);
		for (int i : nums) {
			System.out.print(i+",");
		}

	}
}
