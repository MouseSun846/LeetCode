import org.junit.Test;

public class RbArea {
    /**
     * 计算数字位数和
     * @param num 输入的数字
     * @return 返回位数和
     */
    public int getDigitNum(int num){
        int sum = 0;
        while (num>0){
            sum+=num%10;
            num = num/10;
        }
        return sum;
    }

    int movingCountCore(int k,int[][] map,int row,int col,boolean[][] vis){
        int count=0;
        if(row>=0 && row<map.length
               && col>=0 && col<map[0].length
            && getDigitNum(col)+getDigitNum(row)<k
            && !vis[row][col]){
            vis[row][col] = true;
            System.out.println(row+","+col);
            count = 1 + movingCountCore(k,map,row+1,col,vis)
                    + movingCountCore(k,map,row-1,col,vis)
                    + movingCountCore(k,map,row,col+1,vis)
                    + movingCountCore(k,map,row,col-1,vis);

        }
        return count;
    }



    @Test
    public void movingCount(){
        boolean[][] vis = new boolean[50][50];
        int[][] map = new int[50][50];
        int k = 35;
        int count = movingCountCore(k, map, 0, 0, vis);
        System.out.println("count = "+count);

    }




}
