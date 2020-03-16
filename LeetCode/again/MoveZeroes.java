

public class MoveZeroes {
	 public void moveZeroes(int[] nums) {
		 int count=0,n=0;
		 for (int i = 0; i < nums.length; i++) {
			 if (nums[i]==0) {
				 count++;
			}
			
		}
		 for(int i=0;i<nums.length;i++){
			 if(nums[i]==0)
			 {
				 n++;			 
				 continue;
			 }
			 else if(nums[i]!=0&&n>0){
				for(int j=i;j<nums.length;j++)
				{
					nums[j-n]=nums[j];
					
				}
				
				i=i-n;
				n=0;
			}
			}
		 for(int i=1;i<=count;i++){
			 nums[nums.length-i]=0;
		 }
		 
		 }
	 public static void main(String[] args) {
		 MoveZeroes moveZeroes=new MoveZeroes();
			int[] nums={0,0,3,0,5,1,0};
//			int[] nums={0,1,0};
//			int[] nums={1,2,0,3,0,0,0,0,0,0,0,0,0,0,56,546,56,2312,3,1,0,0,0,0,0,0,0,46,6,456,456,54,0};
			moveZeroes.moveZeroes(nums);
			for (int i : nums) {
				System.out.print(i+",");
			}
	}
	 }

