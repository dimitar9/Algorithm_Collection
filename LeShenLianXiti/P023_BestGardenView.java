package 狗.练习题;

/**
 * 给一个 two D garden , 每一个 slot 可以是 flower 或者 Wall. 找一个合适的位置,让游客可以看 到最多的
 * flower.可以站在 flower 上,不能站在墙上 如果被墙挡了,就看不到墙后面的花。然后游客只能竖直或者水瓶看,不能看对角线。。比如 [
 * 
 * [f, x, x, w, f],
 * 
 * [f, f, x ,x ,x],
 * 
 * [x, x, f, w, f],
 * 
 * [f, f, x, w, x]
 * 
 * ]
 * 
 * 这样,{3, 0} 和 {1,4}都能看到四朵花。
 * 
 * @author LiP
 *
 */
public class P023_BestGardenView {
	public int maxFlowerCanSee(char[][] garden) {
		int m = garden.length;
		int n = m == 0 ? 0 : garden[0].length;
		int rowCount = 0;
		int[] colCounts = new int[n];
		int best = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || garden[i - 1][j] == 'w') {
					rowCount = 0;
					for (int k = i; k < m && garden[k][j] != 'w'; k++)
						if (garden[k][j] == 'f')
							rowCount += 1;
				}

				if (j == 0 || garden[i][j - 1] == 'w') {
					colCounts[j] = 0;
					for (int k = j; k < n && garden[i][k] != 'w'; k++)
						if (garden[i][k] == 'f')
							colCounts[j] += 1;
				}

				best = Math.max(best, rowCount + colCounts[j]);
			}
		}

		return best;
	}

	public static void main(String[] args) {
		P023_BestGardenView bgv = new P023_BestGardenView();
		char[][] garden = { { 'f', 'x', 'x', 'w', 'f' },
				{ 'f', 'f', 'x', 'x', 'x' }, { 'x', 'x', 'f', 'w', 'f' },
				{ 'f', 'f', 'x', 'w', 'x' } };
		System.out.println(bgv.maxFlowerCanSee(garden));
	}
}
