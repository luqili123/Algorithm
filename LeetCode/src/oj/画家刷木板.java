package oj;
import java.util.Scanner;

public class 画家刷木板 {
	
	// return the maximum element from the array 
    static int getMax(int arr[], int n) 
    { 
        int max = Integer.MIN_VALUE; 
        for (int i = 0; i < n; i++) 
            if (arr[i] > max) 
                max = arr[i]; 
        return max; 
    } 
  
    // return the sum of the elements in the array 
    static int getSum(int arr[], int n) 
    { 
        int total = 0; 
        for (int i = 0; i < n; i++) 
            total += arr[i]; 
        return total; 
    } 
  
    // find minimum required painters for given maxlen 
    // which is the maximum length a painter can paint 
    static int numberOfPainters(int arr[], int n, int maxLen) 
    { 
        int total = 0, numPainters = 1; 
  
        for (int i = 0; i < n; i++) { 
            total += arr[i]; 
  
            if (total > maxLen) { 
  
                // for next count 
                total = arr[i]; 
                numPainters++; 
            } 
        } 
  
        return numPainters; 
    } 
  
    static int partition(int arr[], int n, int k) 
    { 
        int lo = getMax(arr, n); 
        int hi = getSum(arr, n); 
  
        while (lo < hi) { 
            int mid = lo + (hi - lo) / 2; 
            int requiredPainters = numberOfPainters(arr, n, mid); 
  
            // find better optimum in lower half 
            // here mid is included because we 
            // may not get anything better 
            if (requiredPainters <= k) 
                hi = mid; 
  
            // find better optimum in upper half 
            // here mid is excluded because it gives 
            // required Painters > k, which is invalid 
            else
                lo = mid + 1; 
        } 
  
        // required 
        return lo; 
    } 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testNumber = scan.nextInt();
		for(int i = 0; i < testNumber; i++)
		{
			int numberOfPeople = scan.nextInt();
			int numberOfBoard = scan.nextInt();
			int[] numberArr = new int[numberOfBoard];
			for(int j = 0; j < numberOfBoard; j++)
			{
				numberArr[j] = scan.nextInt();
			}
			System.out.println(partition(numberArr, numberOfBoard, numberOfPeople));
		}
	}
}