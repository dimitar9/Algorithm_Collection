package 狗.练习题;
//lzb700m
/*
参考乐神的代码修改的。写了两个方法，一个是最小化moves，一个是最小化distance。
预处理都用一个函数。另外，结束条件是小球可以路过终点直接掉下去（高尔夫球进洞的感觉）
*/
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给了个迷宫用小球走，每次确定一个方向之后小球会一直走到碰到障碍物或者边界才会停下 如果停下的地方恰好是出口就算出去了.
 * 
 * 0: empty, 1: wall
 * 
 * @author LiP
 *
 */
public class P021_SlideMaze {
	/*
	 * calculate the minimum moves
	 */
	public int minMoves(int[][] grid, int si, int sj, int ei, int ej) {
		Cell[][] maze = preProcess(grid);
		Queue<Cell> frontier = new LinkedList<>();
		frontier.offer(maze[si][sj]);
		maze[si][sj].visited = true;

		while (!frontier.isEmpty()) {
			Cell cur = frontier.poll();

			// check 4 directions
			if (cur.left > 0 && !maze[cur.x][cur.y - cur.left].visited) {
				if (cur.x == ei && cur.y > ej && cur.y - cur.left <= ej)
					return cur.moves + 1;
				maze[cur.x][cur.y - cur.left].visited = true;
				maze[cur.x][cur.y - cur.left].moves = cur.moves + 1;
				frontier.offer(maze[cur.x][cur.y - cur.left]);
			}

			if (cur.right > 0 && !maze[cur.x][cur.y + cur.right].visited) {
				if (cur.x == ei && cur.y < ej && cur.y + cur.right >= ej)
					return cur.moves + 1;
				maze[cur.x][cur.y + cur.right].visited = true;
				maze[cur.x][cur.y + cur.right].moves = cur.moves + 1;
				frontier.offer(maze[cur.x][cur.y + cur.right]);
			}

			if (cur.top > 0 && !maze[cur.x - cur.top][cur.y].visited) {
				if (cur.y == ej && cur.x > ei && cur.x - cur.top <= ei)
					return cur.moves + 1;
				maze[cur.x - cur.top][cur.y].visited = true;
				maze[cur.x - cur.top][cur.y].moves = cur.moves + 1;
				frontier.offer(maze[cur.x - cur.top][cur.y]);
			}

			if (cur.bottom > 0 & !maze[cur.x + cur.bottom][cur.y].visited) {
				if (cur.y == ej && cur.x < ei && cur.x + cur.bottom >= ei)
					return cur.moves + 1;
				maze[cur.x + cur.bottom][cur.y].visited = true;
				maze[cur.x + cur.bottom][cur.y].moves = cur.moves + 1;
				frontier.offer(maze[cur.x + cur.bottom][cur.y]);
			}
		}

		return Integer.MAX_VALUE;
	}

	/*
	 * calculate minimum distance traveled
	 */
	public int minDist(int[][] grid, int si, int sj, int ei, int ej) {
		Cell[][] maze = preProcess(grid);
		PriorityQueue<Cell> frontier = new PriorityQueue<>();
		frontier.offer(maze[si][sj]);
		maze[si][sj].visited = true;

		while (!frontier.isEmpty()) {
			Cell cur = frontier.poll();

			// check 4 directions
			if (cur.left > 0 && !maze[cur.x][cur.y - cur.left].visited) {
				if (cur.x == ei && cur.y > ej && cur.y - cur.left <= ej)
					return cur.dist + (cur.y - ej);
				maze[cur.x][cur.y - cur.left].visited = true;
				maze[cur.x][cur.y - cur.left].dist = cur.dist + cur.left;
				frontier.offer(maze[cur.x][cur.y - cur.left]);
			}

			if (cur.right > 0 && !maze[cur.x][cur.y + cur.right].visited) {
				if (cur.x == ei && cur.y < ej && cur.y + cur.right >= ej)
					return cur.dist + (ej - cur.y);
				maze[cur.x][cur.y + cur.right].visited = true;
				maze[cur.x][cur.y + cur.right].dist = cur.dist + cur.right;
				frontier.offer(maze[cur.x][cur.y + cur.right]);
			}

			if (cur.top > 0 && !maze[cur.x - cur.top][cur.y].visited) {
				if (cur.y == ej && cur.x > ei && cur.x - cur.top <= ei)
					return cur.dist + (cur.x - ei);
				maze[cur.x - cur.top][cur.y].visited = true;
				maze[cur.x - cur.top][cur.y].dist = cur.dist + cur.top;
				frontier.offer(maze[cur.x - cur.top][cur.y]);
			}

			if (cur.bottom > 0 & !maze[cur.x + cur.bottom][cur.y].visited) {
				if (cur.y == ej && cur.x < ei && cur.x + cur.bottom >= ei)
					return cur.dist + (ei - cur.x);
				maze[cur.x + cur.bottom][cur.y].visited = true;
				maze[cur.x + cur.bottom][cur.y].dist = cur.dist + cur.bottom;
				frontier.offer(maze[cur.x + cur.bottom][cur.y]);
			}
		}

		return Integer.MAX_VALUE;
	}

	/*
	 * create Cell object, calculate left, right, top and bottom value for each
	 * cell
	 */
	private Cell[][] preProcess(int[][] grid) {
		int m = grid.length;
		int n = m == 0 ? 0 : grid[0].length;
		Cell[][] maze = new Cell[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				maze[i][j] = new Cell(i, j);
			}
		}

		// calculate left and right boundary
		for (int i = 0; i < m; i++) {
			for (int j = 0, l = 0, r = 0; j < n; j++) {
				if (grid[i][j] == 0)
					maze[i][j].left = l++;
				else
					l = 0;

				if (grid[i][n - j - 1] == 0)
					maze[i][n - j - 1].right = r++;
				else
					r = 0;
			}
		}

		// calculate top and bottom boundary
		for (int j = 0; j < n; j++) {
			for (int i = 0, t = 0, b = 0; i < m; i++) {
				if (grid[i][j] == 0)
					maze[i][j].top = t++;
				else
					t = 0;

				if (grid[m - i - 1][j] == 0)
					maze[m - i - 1][j].bottom = b++;
				else
					b = 0;
			}
		}

		return maze;
	}

	class Cell implements Comparable<Cell> {
		int x;
		int y;
		int left; // distance to the left border or wall
		int right;
		int top;
		int bottom;
		int moves; // number of move to reach here from source
		int dist; // distance (number of cells traveled) to source
		boolean visited;

		Cell(int xVal, int yVal) {
			this.x = xVal;
			this.y = yVal;
		}

		Cell(int xVal, int yVal, int distVal) {
			this.x = xVal;
			this.y = yVal;
			this.dist = distVal;
		}

		@Override
		public int compareTo(Cell that) {
			if (this.dist < that.dist)
				return -1;
			else if (this.dist > that.dist)
				return 1;
			else
				return 0;
		}

	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, };
		int si = 2, sj = 0, ei = 1, ej = 2;
		P021_SlideMaze sm = new P021_SlideMaze();
		System.out.println(sm.minMoves(grid, si, sj, ei, ej));
		System.out.println(sm.minDist(grid, si, sj, ei, ej));
	}
}
