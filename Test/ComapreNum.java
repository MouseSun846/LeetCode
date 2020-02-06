import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的熟
 * 自定义排序，隐含的大数的问题
 */
public class ComapreNum {
    @Test
    public void testPrintCompareNum(){
        int[] numbers = {3,32,321};
        String[] cpNum = new String[numbers.length];
        //将数组转字符串
        for (int i = 0; i < numbers.length; i++) {
            cpNum[i] = ""+numbers[i];
        }
        Arrays.sort(cpNum, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                String str1 = s + t1;
                String str2 = t1 + s;
                return str1.compareTo(str2);
            }
        });
        String tp = "";
        for (String s : cpNum) {
            tp += s;
        }

        System.out.println(tp);
//        System.out.println(Arrays.toString(cpNum));
    }
}
