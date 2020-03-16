package 基础算法;

import java.util.Random;

/**
 * 假设数据序列的规模为 n，需要采样的数量的为 k。
       首先构建一个可容纳 k 个元素的数组，将序列的前 k 个元素放入数组中。
      然后从第 k+1 个元素开始，以 kn 的概率来决定该元素是否被替换到数组中（数组中的元素被替换的概率是相同的）。
       当遍历完所有元素之后，数组中剩下的元素即为所需采取的样本。
 * https://www.cnblogs.com/snowInPluto/p/5996269.html
 * @author lqllq
 *
 */
public class 蓄水池采样算法 {
	////k[]表示源数组  m表示水池大小
	public static int[] xushuichi(int k[], int m) {
		//水池,容量为m
		int[] pool=new int[m];
		Random random=new Random();
		for(int i=0;i<k.length;i++){
			if(i<m){
				//前m个元素直接放入池中
				pool[i]=k[i];
			}else{
				 // K + 1 个元素开始进行概率采样
				int r=random.nextInt(i+1);
				//若获取的r在水池坐标范围内，则把对应位置的数据替换
				if(r<m){
					pool[r]=k[i];
				}
			}
		}
		return pool;
	}
}	
