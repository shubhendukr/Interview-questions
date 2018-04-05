/*
Possible moves of knight
----------------------------
Given a chess board of dimension m * n. 
Find number of possible moves where knight can be moved on a chessboard from given position.
Knight can move only to the place with value 0

Enter the dimension of chess board : 4 4
Enter the status of board : 
1 0 1 0
0 1 1 1
1 1 0 1
0 1 1 1
Enter the current position of Knight : 2 2
Number of possible moves : 4
*/

import java.util.Scanner;

class KnightMoves {
  public static int countPossiblMoves(int[][] board, int m, int n, int p, int q){
    int[] X = {2,1,-1,-2,-2,-1,1,2};
    int[] Y = {1,2,2,1,-1,-2,-2,-1};
    int possibleMoves = 0;
    
    for(int i=0; i<8; i++){
      int x = p + X[i];
      int y = q + Y[i];
      
      if(x >= 0 && y >= 0 && x < n && y < m && board[x][y] == 0)
        possibleMoves++;
    }
    return possibleMoves;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the dimension of chess board : ");
    int n = sc.nextInt();
    int m = sc.nextInt();
    System.out.println("Enter the status of board : ");
    int[][] board = new int[n][m];
    for(int i=0; i<n; i++)
      for(int j=0; j<m; j++)
        board[i][j] = sc.nextInt();
    System.out.print("Enter the current position of Knight : ");
    int p = sc.nextInt();
    int q = sc.nextInt();
    System.out.println("Number of possible moves : "+countPossiblMoves(board, m, n, p, q));

  }
}
