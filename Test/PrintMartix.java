import org.junit.Test;

public class PrintMartix {
    public void myPrintMartix(int[][] map,int i,int j,boolean[][] vis ,int ore)
    {
        switch (ore){
            case 1:
                j+=1;
                if (j==map[0].length-1){
                    ore=2;
                    break;
                }
                if (j<map[0].length-1 && vis[i][j+1])
                {
                    ore=2;
                }
                break;
            case 2:
                i+=1;
                if (i==map.length-1) {
                    ore = 3;
                    break;
                }
                if (vis[i+1][j] && i<map.length-1) ore=3;
                break;
            case 3:
                j-=1;
                if (j==0){
                    ore = 4 ;
                    break;
                }
                if (vis[i][j-1] && j>0) ore=4;
                break;
            case 4:
                i-=1;
                if (i>0 && vis[i-1][j]) ore=1;
                break;
        }
        if (i>=0 && j>=0 && i<map.length && j <map[0].length && !vis[i][j]){
            vis[i][j] = true;
            System.out.printf("%d,",map[i][j]);
            myPrintMartix(map,i,j,vis,ore);
        }
    }

    @Test
    public void testPrint(){
        int[][] map = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        boolean[][] vis = new boolean[map.length][map[0].length];
        vis[0][0] = true;
        System.out.printf("%d,",map[0][0]);
        myPrintMartix(map,0,0,vis,1);
    }

}
