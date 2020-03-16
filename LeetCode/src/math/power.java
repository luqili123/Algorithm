package math;

public class power {
	//正常写法，时间复杂度为n
	public double Power(double base, int exponent) {
		if(exponent==0)
            return 1;
        if(exponent==1)
            return base;
        
        double result=1;
        if(exponent>0){
            while(exponent>0){
            result=base*result;
            exponent--;
            }
        }else{
            while(exponent<0){
                result=result*base;
                exponent++;
            }
            result=1/result;
        }
        
        
        return result;
  }
	//递归写法，时间复杂度为log2N
	//result=1   exponent=0
	//result=base   exponent=1	
	//result=(base*base)^exponent/2   exponent%2=0
	//result=base*(base*base)^exponent-1/2   exponent%2=0
	public double Power2(double base, int exponent) {
		if(exponent==0)
			return 1;
		if(exponent==1)
			return base;
		boolean isNegative=false;
		if(exponent<0){
			exponent=-exponent;
			isNegative=true;
		}
		double power=Power2(base*base, exponent/2);
		if(exponent%2==1)
			power=power*base;
		return isNegative ? 1/power :power;
	}
	
}
