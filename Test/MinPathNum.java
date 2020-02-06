import org.junit.Test;

public class MinPathNum {
    public int calcMinPathNum(int[][] grid, int row, int col, int sum){
        if(row == grid.length-1 && col == grid[0].length-1)
            return sum+grid[row][col];

            if (row == grid.length-1)
            {
                System.out.println(row + "," + col + " " + grid[row][col]);
                sum += grid[row][col];
                return calcMinPathNum(grid, row, col+1, sum);
            }
            if (col == grid[0].length-1){
                System.out.println(row + "," + col + " " + grid[row][col]);
                sum += grid[row][col];
                return calcMinPathNum(grid, row+1, col, sum);
            }
            if (grid[row][col + 1] <= grid[row + 1][col] ) {
                System.out.println(row + "," + col + " " + grid[row][col]);
                sum += grid[row][col];
                return calcMinPathNum(grid, row, col + 1, sum);
            } else {
                System.out.println(row + "," + col + " " + grid[row][col]);
                sum += grid[row][col];
                return calcMinPathNum(grid, row + 1, col, sum);
            }

    }

    public int bapli(int[][] grid,int row,int col){
        if (row == grid.length || col == grid[0].length) return Integer.MAX_VALUE;
        if(row == grid.length-1 && col == grid[0].length-1)
            return grid[row][col];
        return grid[row][col]+Math.min(bapli(grid,row+1,col),bapli(grid,row,col+1));
    }

    @Test
    public void test(){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
//        int sum = 0;
//        int res = calcMinPathNum(grid,0,0,sum);
        int res = bapli(grid,0,0);
        System.out.println("res = " + res);
        int su = Integer.MAX_VALUE + 10;
        System.out.println(su);
    }

    @Test
    public void dpMinPathSum(){
        int[][] grid = {{1,2,3},{4,5,6}};
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length-1; i >=0 ; i--) {
            for (int j = grid[0].length-1; j >=0 ; j--) {
                //最后一行
                if (i == grid.length-1 && j != grid[0].length-1)
                {
                    dp[i][j] = grid[i][j]+dp[i][j+1];
                }
                //最后一列
                else if (j == grid[0].length-1 && i != grid.length-1)
                {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                }
                else if (i != grid.length-1 && j != grid[0].length-1){
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
                }else{
                    //初始化第一个值
                    dp[i][j] = grid[i][j];
                }
            }
        }
        System.out.println("minsun = "+dp[0][0]);
    }

}
