/*Add some comments by yourself*/
import java.util.*;

public class MaxHeap {
	int A[];
	int size;
	public MaxHeap(int A[]) {
		this.A = A;
		size = 0;
	}
	
	public boolean insert(int x) {
		if(size == A.length)
			return false;
		int hole = size ++;
		while(hole > 0 && x > A[(hole-1)/2]){
			A[hole] = A[(hole-1)/2];
			hole = (hole-1)/2;
		}
		A[hole] = x;
		return true;
	}
	
	public int deleteMax() {
		if(size == 0)
			return -1;
		int max = A[0];
		int x = A[--size];
		int hole = 0;
		while(2*hole+1 < size) {
			int sid = 2*hole + 1;
			if(sid +1 < size && A[sid+1] > A[sid])
				sid ++;
			if(x >= A[sid])
				break;
			A[hole] = A[sid];
			hole = sid;
		}
		A[hole] = x;
		return max;
	}
	
	public static void heapSort(int A[]) {
		MaxHeap heap = new MaxHeap(A);
		for(int x: A)
			heap.insert(x);
		for(int i=A.length-1; i>=0; i--)
			A[i] = heap.deleteMax();
	}
	public static void main(String[] args) {
		int arraySize = 100000;
		// Create a random array A1 of arraySize
		int A[] = new int[arraySize];
		int upperbound = 100000;
		Random rand = new Random();
		for(int i=0; i<A.length; i++)
			A[i] = rand.nextInt(upperbound);
		long time1 = System.currentTimeMillis();
		heapSort(A);		
		long time2 = System.currentTimeMillis();
		//System.out.println(Arrays.toString(A));
		long heapSortTime = time2 - time1;
		System.out.println("Running time for heapSort: " + heapSortTime + "ms");
	}

}
