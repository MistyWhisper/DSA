/*Add some comments by yourself*/
import java.util.*;

public class Sorting3 {
	public static void insertionSort(int[] A) {
		insertionSort(A, 0, A.length - 1);
	}
	
	private static void insertionSort(int[] A, int left, int right) {
		// This insertionSort is called by quickSort when the sub-array size is small
		for(int p=left + 1; p<=right; p++) {
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
	
	public static void quickSort(int[] A) {
		quickSort(A, 0, A.length-1);
	}	

	private static void quickSort(int[] A, int left, int right) {
		// The base case is decided during testing
		if(left > right - 11){
			insertionSort(A, left, right);
			return;
		}
		int q = partition(A, left, right);
		quickSort(A, left, q);
		quickSort(A, q+1, right);
	}
	
	private static int partition(int[] A, int left, int right) {
		median3(A, left, right);
		int i=left+1, j=right-2, pivot=A[right-1];
		while(true) {
			while(A[i]<pivot)
				i++;
			while(A[j]>pivot)
				j--;
			if(i < j){
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i++;
				j--;
			}
			else {
				A[right - 1] = A[i];
				A[i] = pivot;
				return i;
			}	
		}
	}
	
	private static void median3(int[] A, int left, int right) {
		int center = (left + right) / 2;
		int s, m, l;
		if(A[left]<A[center])
			if(A[right]>A[center]) {
				s = A[left];
				m = A[center];
				l = A[right];
			}
			else{
				l = A[center];
				if(A[left]<A[right]) {
					s = A[left];
					m = A[right];
				}
				else {
					m = A[left];
					s = A[right];
				}
			}
		else
			if(A[right]<A[center]) {
				l = A[left];
				m = A[center];
				s = A[right];
			}
			else{
				s = A[center];
				if(A[left]<A[right]) {
					m = A[left];
					l = A[right];
				}
				else {
					l = A[left];
					m = A[right];
				}
			}
		A[left] = s;
		A[right] = l;
		A[center] = A[right -1];
		A[right - 1] = m;
	}
	public static void main(String[] args) {
		
		int arraySize = 100000;
		// Create a random array A1 of arraySize
		int A1[] = new int[arraySize];
		int upperbound = 1000;
		Random rand = new Random();
		for(int i=0; i<A1.length; i++)
			A1[i] = rand.nextInt(upperbound);
		// Create two arrays, A2 and A3, identical to A1
		int A2[] = A1.clone();
		int A3[] = A1.clone();
		
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
		// Sort A3 using quickSort and record the time
		quickSort(A3);
		//System.out.println(Arrays.toString(A3));
		long time4 = System.currentTimeMillis();
		long insertionSortTime = time2 - time1;
		long mergeSortTime = time3 - time2;
		long quickSortTime = time4 - time3;
		System.out.println("Running time for insertionSort: " + insertionSortTime + "ms");
		System.out.println("Running time for mergeSort: " + mergeSortTime + "ms");
		System.out.println("Running time for quickSort: " + quickSortTime + "ms");
	      
	}
}