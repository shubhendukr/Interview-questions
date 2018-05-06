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
