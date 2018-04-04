/*
Count ways to reach the N'th stair
----------------------------------------------------
How to count number of ways to climb n stairs 
if the person can climb up to m stairs

Enter total number of stairs : 4
Enter maximum number of stairs one can climb at a time : 3
Number of ways = 7
*/
import java.util.Scanner;

class Stairs
{
    // A recursive function used by countWays
    static int countWaysUtil(int n, int m)
    {
        int res[] = new int[n];
        res[0] = 1; res[1] = 1;
        for (int i=2; i<n; i++)
        {
           res[i] = 0;
           for (int j=1; j<=m && j<=i; j++)
             res[i] += res[i-j];
        }
        return res[n-1];
    }
      
    // Returns number of ways to reach s'th stair
    static int countWays(int s, int m)
    {
        return countWaysUtil(s+1, m);
    }
 
    // Driver method 
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of stairs : ");
        int s = sc.nextInt();
        System.out.print("Enter maximum number of stairs one can climb at a time : ");
        int m = sc.nextInt();
        System.out.println("Number of ways = " + countWays(s, m));
    }
}