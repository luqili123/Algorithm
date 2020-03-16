package oj;

import java.util.Scanner;

/**
 * 拉胡尔想购买蔬菜，主要是茄子，胡萝卜和西红柿。一条线上有N个不同的蔬菜销售商。
 * 每个蔬菜销售商出售所有三种蔬菜，但价格不同。拉胡尔，痴迷于他的天性，最优消费，决定不从相邻的商店购买同样的蔬菜。
 * 此外，Rahul将从一家商店购买恰好一种类型的蔬菜项目(只有1公斤)。Rahul希望用这个策略花最少的钱购买蔬菜。帮助拉胡尔确定他将花费的最低金额。
 * 
 * 
 * 
 * 第一行表示测试用例T的数量。第一行中的每个测试用例都包含N，表示蔬菜市场中蔬菜销售商的数量。则接下来的N行中的每一行都包含三个空格分隔的整数，
 * 表示该特定蔬菜销售商每公斤的茄子、胡萝卜和西红柿的成本。
 * 
 * 
 * 
2
3
1 50 50
50 50 50
1 50 50

2
5
1 10 10
20 5 4
3 6 18
2 4 39
2 4 5



题目有如下要求

不从邻近的商店购买同样的蔬菜。
一家商店购买一种蔬菜
必须挨着买,即先买第一家,再买第二家
不是所有的蔬菜都一定需要购买,可以不买某种蔬菜


思路解析
最优问题(最便宜)可以在选完前n-1个的基础上再选第n个,即min(n) = min(n-1) +min(cur)

可以从后往前倒着理解,即在最后一个商店,要么选择了第一种蔬菜,要么选择了第二种蔬菜,要么选择了第三种蔬菜.

假设我们在最后一个商店选了第1种蔬菜,那么在倒数第二个商店同样有三种选择…依次类推

如何构建dp数组

dp数组有几行代表就有几个商店,有几列代表有几个蔬菜,本题有3列.dp[i] [j] 代表当前选到当前商店的当前蔬菜的最少价格



 * @author lqllq
 *
 */
public class 花最少的钱购买蔬菜 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t-->0){
			int N=scanner.nextInt();
			int count=3;
			int[][] price=new int[N][count];
			for(int i=0;i<N;i++){
				for (int j = 0; j < price[i].length; j++) {
					price[i][j]=scanner.nextInt();					
				}
			}
			int[][] dp=new int[N+1][count];
			int min=Integer.MAX_VALUE;
			for(int i=1;i<dp.length;i++){
				for(int j=0;j<dp[i].length;j++){
					dp[i][j]=Math.min(dp[i-1][(j+1)%3]+price[i-1][j], dp[i-1][(j+2)%3]+price[i-1][j]);
					if(i==N&&dp[i][j]<min){
						min=dp[i][j];
					}
				}
			}

			System.out.println(min);
		}
	}
}
