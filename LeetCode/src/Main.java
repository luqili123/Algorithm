import java.util.Scanner;
/** 
1
5
4 9 5 2 2
1 3 5 1 4
 * @author lqllq
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        	int n=sc.nextInt();
        	int[] len=new int[n];
        	int[] we=new int[n];
        	for(int i=0;i<n;i++){
        		len[i]=sc.nextInt();
        	}
        	for(int i=0;i<n;i++){
        		we[i]=sc.nextInt();
        	}
        	
        	//先对长度排序
        	for(int i=0;i<n;i++){
        		for(int j=0;j<n-i-1;j++){
        			if(len[j]>len[j+1]){
        				swap(len,j+1,j);
        				swap(we,j+1,j);
        			}
        		}
        	}
        	//长度相同，再按重量排序
        	for(int i=0;i<n;i++){
        		for(int j=0;j<n-i-1;j++){
        			if(len[j]==len[j+1]&&we[j]>we[j+1]){
        				swap(len,j+1,j);
        				swap(we,j+1,j);
        			}
        		}
        	}
        	int cost=1;
        	for(int i=1;i<n;i++){
        		if(len[i]<len[i-1]||we[i]<we[i-1]){
        			cost++;
        		}
        	}
//        	System.out.print(cost);

        	
        	//再先按重量排序
        	for(int i=0;i<n;i++){
        		for(int j=0;j<n-i-1;j++){
        			if(we[j]>we[j+1]){
        				swap(len,j+1,j);
        				swap(we,j+1,j);
        			}
        		}
        	}
        	
        	//重量相同，再按长度排序
        	for(int i=0;i<n;i++){
        		for(int j=0;j<n-i-1;j++){
        			if(we[j]==we[j+1]&&len[j]>len[j+1]){
        				swap(len,j+1,j);
        				swap(we,j+1,j);
        			}
        		}
        	}
        	int cost2=1;
        	for(int i=1;i<n;i++){
        		if(len[i]<len[i-1]||we[i]<we[i-1]){
        			cost2++;
        		}
        	}
        	System.out.println(Math.min(cost, cost2));
        	
        }   
    }
    public static void swap(int[] arr,int i,int j){
    	int temp=arr[i];
    	arr[i]=arr[j];
    	arr[j]=temp;
    }

}