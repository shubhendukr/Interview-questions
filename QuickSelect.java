import java.util.Arrays;

public final class QuickSelect {
	
	private static int sort(int[] array, int left, int right, int n) {
		if (left == right) { // If the list contains only one element,
			return array[left]; // return that element
		}

		int pivotIndex = array[right];
		pivotIndex = partition(array, left, right, pivotIndex);
		// The pivot is in its final sorted position
		if (n == pivotIndex) {
			return array[n];
		} else if (n < pivotIndex) {
			return sort(array, left, pivotIndex - 1, n);
		} else {
			return sort(array, pivotIndex + 1, right, n);
		}
	}
	
	private static int partition(int[] array, int left, int right, int pivotIndex) {
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, right); // move pivot to end
		int storeIndex = left;
		for(int i = left; i < right; i++) {
			if(array[i] < pivotValue) {
				swap(array, storeIndex, i);
				storeIndex++;
			}
		}
		swap(array, right, storeIndex); // Move pivot to its final place
		return storeIndex;
	}
	
	private static void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}	
  	
  	public static void main(String[] args) {
  		int[] array = {9, 8, 7, 6, 5, 0, 1, 2, 3, 4};

  		for(int i = 0; i < array.length; i++) {
  			System.out.println(i+"th smallest element is : "+sort(array, 0, array.length-1, i));
  		}
  	}
}







































/*
class QuickSelect {
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low;
		for(int j = low; j< high; j++) {
			if(arr[j] <= pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, high);
		return i;
	}

	static int kthSmallest(int[] arr, int low, int high, int k) {
		if(k > 0 && k <= high) {
			int index = partition(arr, low, high);
			if(index-low == k-1)
				return arr[index];
			if(index-low > k-1)
				return kthSmallest(arr, low, index-1, k);
			return kthSmallest(arr, index+1, high, k-index+low-1);
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		int[] arr = {10, 4, 5, 8, 6, 11, 26};
		int n = arr.length;
		int k = 4;
		System.out.println(k+"th smallest element is : "+kthSmallest(arr, 0, n-1, k));
	}
}*/