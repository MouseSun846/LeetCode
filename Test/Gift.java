import org.junit.Test;

/**
 * 礼物的最价值
 */
public class Gift {
    @Test
    public void getMaxValueGift(){
        int[][] map = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        int[][] dp = new int[map.length][map[0].length];
        for (int i = map.length-1; i>=0 ; i--) {
            for (int j = map[0].length-1; j >=0 ; j--) {
                //最后一行
                if (i == map.length-1 && j !=map[0].length-1){
                    dp[i][j] = map[i][j] + dp[i][j+1];
                }
                //最后一列
                else if (i != map.length-1 && j == map[0].length-1){
                    dp[i][j] = map[i][j] + dp[i+1][j];
                }
                else if (i != map.length-1 || j != map[0].length-1){
                    if (map[i+1][j]>map[i][j+1]){
                        dp[i][j] = dp[i+1][j] + map[i][j];
                    }else{
                        dp[i][j] = dp[i][j+1]+ map[i][j];
                    }
                }else {
                    //赋初值
                    dp[i][j] = map[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
