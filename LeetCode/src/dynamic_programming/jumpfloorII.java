package dynamic_programming;

public class jumpfloorII {
	public int JumpFloorII(int target) {
        if(target<=2)
        	return target;
        return  2*JumpFloorII(target-1);
    }
	
public static void main(String[] args) {
	jumpfloorII jIi=new jumpfloorII();
	
	System.out.println(jIi.JumpFloorII(4));
}
}
