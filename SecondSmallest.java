/*
Find the second smallest element in an array
------------------------------------------------
Efficient solution is to find the minimum two elements in one traversal.

Enter total numbe rof array elements : 6
Enter Array elements : 
12 13 1 10 34 1
Second smallest element : 10

*/


import java.util.Scanner;

class SecondSmallest{
	public static int findSecondSmallest(int[] arr){
		int firstSmallest, secondSmallest;
		firstSmallest = secondSmallest = Integer.MAX_VALUE;

		for(int i = 0; i < arr.length; i++){
			if(arr[i] < firstSmallest){
				secondSmallest = firstSmallest;
				firstSmallest = arr[i];
			}
			else if(arr[i] < secondSmallest && arr[i] != firstSmallest)
				secondSmallest = arr[i];
		}
		return secondSmallest;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter total numbe rof array elements : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter Array elements : ");
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		System.out.println("Second smallest element : "+findSecondSmallest(arr));
	}
}