public class Solution {
    public int numIslands(char[][] grid) {
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                if(grid[i][j] == '1')
                    grid[i][j] = 'X';
        int num = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 'X'){
                    flip(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void flip(char[][] grid, int i, int j) {
        if(grid[i][j] != 'X')   return;
        grid[i][j] = '1';
        if(i>0)
            flip(grid, i-1, j);
        if(j>0)
            flip(grid, i, j-1);
        if(i<grid.length-1)
            flip(grid, i+1, j);
        if(j<grid[0].length-1)
            flip(grid, i, j+1);
    }
}

