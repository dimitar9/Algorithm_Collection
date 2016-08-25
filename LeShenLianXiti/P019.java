package 狗.练习题;

/**
 * 给一个二维booleanarray,true代表greyed, 要找出所有可能的正方形。比如:
 *
 * 0 1 0
 * 
 * 0 0 0
 * 
 * 1 0 0
 * 
 * 一共有8个正方形(边长为1的7个,为2的1个,为3的0个)。
 * 
 * @author LiP
 *
 */
public class P019_CountSquares {
	public int countSquares(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] count = new int[m][n];
		int ans = 0;
		for (int i = 0; i < m; i++) {
			count[i][0] = matrix[i][0] == 0 ? 1 : 0;
			ans += count[i][0];
		}
		for (int j = 1; j < n; j++) {
			count[0][j] = matrix[0][j] == 0 ? 1 : 0;
			ans += count[0][j];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					count[i][j] = Math.min(count[i - 1][j - 1],
							Math.min(count[i][j - 1], count[i - 1][j])) + 1;
					ans += count[i][j];
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		P019_CountSquares cs = new P019_CountSquares();
		int[][] matrix1 = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 1 } };
		int[][] matrix2 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		System.out.println(cs.countSquares(matrix1)); // expected 23
		System.out.println(cs.countSquares(matrix2)); // expected 14
	}
}
