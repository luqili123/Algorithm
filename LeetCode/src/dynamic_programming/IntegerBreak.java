package dynamic_programming;

public class IntegerBreak {
	public int integerBreak(int n) {
        if(n==0)
        	return 0;
        if(n==1||n==2)
        	return 1;
        if (n==3) {
			return 2;
		}
        //运行至此,说明绳子的长度是>3的,这之后0/1/2/3这种子问题最大就是其自身长度
        //而不再需要考虑剪一刀的问题,因为它们剪一刀没有不剪来的收益高
        //而在当下这么长的绳子上剪过才可能生成0/1/2/3这种长度的绳子,它们不需要再减
        //所以下面的表中可以看到它们作为子问题的值和上面实际返回的是不一样的 
        //存储4~n的最大乘积
        int[] products=new int[n+1];
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;//这里不能填3分解出的最大值，因为按照分析，分解到3之后就不分解了，否则分解出的乘积只会比3小
        int max=0,temp;
        //从4到n，求出之间所有的最大乘积
        for(int i=4;i<products.length;i++){
        	max=0;
        	//动态规划思路：切一刀之后：f(n)=max[f(n-i)*f(i)]
        	for(int j=1;j<=i/2;j++){
        		temp=products[j]*products[i-j];
        		//若乘积比前面的最大值还要大，就把现在的乘积给max
        		if(max<temp){
        			max=temp;
//        			System.out.println(max);
        		}
        	}
        	//每运行完一轮，都会计算出长度为i是，乘积的最大值
        	products[i]=max;
        	
        }
        //我们需要的是长度为n的乘积最大值
        max=products[n];
        return max;
    }
	//贪心算法：该算法不能保证得到的一定是最优解，此处需要数学证明出，贪心算法可以获得最优解
	//当n>=5时，3(n−3)>=2(n−2)且只在n取5时取等号，且它们都大于n，所以应把绳子剪成尽量多的3，让剩下的都是2这样的组合。
	//
	public int integerBreak2(int n) {
		//特殊值判断
		if(n<2)
			return 0;
		if(n==2)
			return 1;
		if(n==3)
			return 2;
		//n>4时只有再分才会得到更高的乘积，当分解到程度为3时，如果再分乘积会变小，所以这里应该尽量将绳子分割成长度为3
		//这里计算n最多可以有几个3
		int timeof3=n/3;
		
		//如果分割完3之后，绳子剩余长度为1，那么这个时候应该拿一个3和1组合成4，并将4分割成2,2，因为3*1<2*2
		if((n-timeof3*3)==1)
			timeof3--;//拿出一个3与1组合
		//保证剩下的只有4/2/0,
		int timeof2=(n-timeof3*3)/2;
		//最后的最优解就是，timeof3个3相乘加上timeof2个2相乘
		return  (int) (Math.pow(3, timeof3)*Math.pow(2, timeof2));
		
	}
	
	public static void main(String[] args) {
		IntegerBreak iBreak=new IntegerBreak();
//		iBreak.integerBreak(10);
		System.out.println(iBreak.integerBreak(10));
	}
}
