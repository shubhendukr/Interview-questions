package shopee.problems;
/**
 * Return -1 is string is already Palindrome
 * Return index of one character if it's possible to make Palindrome by removing that character
 * Return -2 is it's not possible to make Palindrome
 * @author shubhendukumar
 *
 */
public class PalindromeIndex {
	public static boolean isPalindrome(String str, int i, int j) {
		for(int k = i; k <= i + (j-i)/2; k++) {
			if(str.charAt(k) != str.charAt(j-k+i)) {
				return false;
			}
		}
		return true;
	}
	
	public static int getIndexToMakePalindrome(String str) {
		int n = str.length();
		for(int i = 0; i < n/2; i++) {
			if(str.charAt(i) != str.charAt(n-1-i)) {
				int j = n-1-i;
				if(!isPalindrome(str, i+1, j) && !isPalindrome(str, i, j-1)) {
					return -2;
				}
				if (!isPalindrome(str, i+1, j)) {
					return j;
				} else if(!isPalindrome(str, i, j-1)) {
					return i;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String str = "abedejcba";
		System.out.println(getIndexToMakePalindrome(str));
	}
}
