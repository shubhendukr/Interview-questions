import java.util.Scanner;
class ReverseFibonacci {
	public static int f(int n) {
		if(n <= 1)
			return n;
		else
			return f(n-1) + f(n-2);
	}

	public static void printReverseFinbonacci(int x) {
		if(x <= 1){
			System.out.println(f(x));
		} else {
			System.out.println(f(x));
			printReverseFinbonacci(x - 1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total number in series: ");
		int x = sc.nextInt();
		printReverseFinbonacci(x);
	}
}