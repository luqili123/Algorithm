package array;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
        int i=0,j=nums.length-1,temp;
        int count=0;
        if(j==0&&nums[0]==val) return 0;
        for (int k = 0; k < nums.length; k++) {
			if (nums[k]==val) {
				count++;
			}
		}
        while(i<j){
        	while(nums[j]==val&&i<j) {
        		
        		j--;
        	}
        	while(nums[i]!=val&&i<j) i++;
        	
        	if(i<j){
        		temp=nums[i];
        		nums[i]=nums[j];
        		nums[j]=temp;
        		i++;
        		j--;
        	}
        }
        for (int k = 0; k < nums.length; k++) {
			System.out.print(nums[k]);
			
		}
        System.out.println();
		return nums.length-count;
    }
	public static void main(String[] args) {
		int[] nums={1,2};
		RemoveElement removeElement=new RemoveElement();
		System.out.println(removeElement.removeElement(nums,2));
	}
}
