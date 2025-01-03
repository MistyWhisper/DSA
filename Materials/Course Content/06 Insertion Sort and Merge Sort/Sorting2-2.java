/*Add some comments by yourself*/
import java.util.*;

public class Sorting2 {
	public static void insertionSort(int[] A) {
		for(int p=0; p<A.length; p++) {
			int key = A[p];
			int i = p-1;
			while(i>=0 && A[i]>key) {
				A[i+1] = A[i];
				i--;
			}
			A[i+1] = key;
		}
	}
	public static void mergeSort(int[] A) {
		mergeSort(A, 0, A.length-1);
	}
	
	private static void mergeSort(int[] A, int left, int right) {
		if(left >= right)
			return;
		int center = (left + right) / 2;
		mergeSort(A, left, center);
		mergeSort(A, center + 1, right);
		merge(A, left, center, right);
	}
	
	private static void merge(int[] A, int left, int center, int right) {
		int i1 = left, i2 = center + 1, i = 0;
		int B[] = new int[right - left + 1];
		while(i1<=center && i2 <= right)
			if(A[i1] < A[i2])
				B[i++] = A[i1++];
			else
				B[i++] = A[i2++];
		while(i1<=center)
			B[i++] = A[i1++];
		while(i2<=right)
			B[i++] = A[i2++];
		for(i=0; i<B.length; i++)
			A[left + i] = B[i];
	}	
	
	public static void main(String[] args) {
		
		int arraySize = 100000;
		// Create a random array A1 of arraySize
		int A1[] = new int[arraySize];
		int upperbound = 1000;
		Random rand = new Random();
		for(int i=0; i<A1.length; i++)
			A1[i] = rand.nextInt(upperbound);
		// Create an array A2 identical to A1
		int A2[] = A1.clone();
		
		// Sort A1 using insertionSort and record the time
		long time1 = System.currentTimeMillis();
		//System.out.println(Arrays.toString(A1));
		insertionSort(A1);
		//System.out.println(Arrays.toString(A1));
		long time2 = System.currentTimeMillis();
		// Sort A2 using mergeSort and record the time
		mergeSort(A2);
		//System.out.println(Arrays.toString(A2));
		long time3 = System.currentTimeMillis();
		long insertionSortTime = time2 - time1;
		long mergeSortTime = time3 - time2;
		System.out.println("Running time for insertionSort: " + insertionSortTime + "ms");
		System.out.println("Running time for mergeSort: " + mergeSortTime + "ms");
	      
	}

}