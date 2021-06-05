class Solution {
    public int minPathSum(int[][] grid) {
        return findPath(grid,0,0, new int[grid.length][grid[0].length]);
    }
    
    int findPath(int[][] grid, int row, int col, int[][] cache){
        if(row==grid.length || col==grid[0].length) return Integer.MAX_VALUE;
        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }
        if(cache[row][col]>0) return cache[row][col];
        cache[row][col]= grid[row][col]+ Math.min(findPath(grid, row+1, col, cache),
        findPath(grid, row, col+1, cache));
        return cache[row][col];
    }  
}
