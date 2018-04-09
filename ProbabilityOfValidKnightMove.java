/*
Probability of a valid Knight move in chessboard
--------------------------------------------------
A chess knight has 8 possible moves it can make.
Return the porbability that the knight remains on the board 
after it has stopped moving after K steps.

Enter the initial position of Knight : 0 0
Enter the number of steps : 3
Probabilty of Knight to remain in the chessboard : 0.125

*/
import java.util.Scanner;

class ProbabilityOfValidKnightMove{
	static final int N = 8;

	static boolean inside(int x, int y){
		return (x >= 0 && x < N && y >= 0 && y < N);
	}

	static double findProb(int sr, int sc, int K) {
		if(!inside(sr, sc))
			return 0;

        double[][] dp = new double[N][N];
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

        dp[sr][sc] = 1;
        for (; K > 0; K--) {
            double[][] dp2 = new double[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    for (int k = 0; k < 8; k++) {
                        int cr = r + dr[k];
                        int cc = c + dc[k];
                        if (inside(cr, cc)) {
                            dp2[cr][cc] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0.0;
        for (double[] row: dp) {
            for (double x: row) ans += x;
        }
        return ans;
    }
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the initial position of Knight : ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.print("Enter the number of steps : ");
		int K = sc.nextInt();

		System.out.println("Probabilty of Knight to remain in the chessboard : "+findProb(x, y, K));
	}
}