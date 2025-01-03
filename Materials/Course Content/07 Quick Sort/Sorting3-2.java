/* Requirement:	
	(1) Complete the following codes, and auxiliary methods may be defined.
	(2) You are NOT allowed to modify the code originally given in Sorting3.java
	(3) You are NOT allowed to modify the filename of Sorting3.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
		
	*/
import java.util.*;

public class Sorting3 { /*Comparison of 3 sorting algorithms*/
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
		/*YOUR CODE HERE*/
	}
	
	private static int partition(int[] A, int left, int right) {
		/*YOUR CODE HERE*/
	}
	
	private static void median3(int[] A, int left, int right) {
		/*YOUR CODE HERE*/
	}
	public static void main(String[] args) {
		/*YOUR CODE HERE, 
		- Generate an array A1 consisting of 10^5 random integers which are in range [0, 999].
		- Generate arrays A2, A3 which are identical to A1.
		- Sort A1 using insertionSort, A2 using mergeSort, and A3 using quickSort.
		- Print the elapsed time in milliseconds during which all the search functions run, respectively.
		- Note that you are NOT required to print the array with the size 10^5.
		*/
		
	      
	}

}
