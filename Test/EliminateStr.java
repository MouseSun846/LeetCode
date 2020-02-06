import org.junit.Test;

import java.util.Arrays;

/**
 * 最长不含重复字符的字字符串
 */
public class EliminateStr {

    @Test
    public void eliminateStrDup(){
        int curlen = 0;
        int maxlen = 0;
        String str = "arabcacfr";
        int[] pos = new int[26];
        Arrays.fill(pos,-1);
//        System.out.println(Arrays.toString(pos));
        for (int i = 0; i <str.length() ; i++) {
            int preIndex = pos[str.charAt(i)-'a'];
            if (preIndex < 0 || i - preIndex >curlen){
                curlen++;
            }else {
                if (curlen > maxlen){
                    maxlen = curlen;
                }
                curlen = i - preIndex;
            }
            pos[str.charAt(i) - 'a'] = i;
        }
        if (curlen > maxlen) maxlen = curlen;
        System.out.println("maxlen = "+maxlen);
    }


}
