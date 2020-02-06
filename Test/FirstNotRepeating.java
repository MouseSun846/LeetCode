import org.junit.Test;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/5 13:37
 */
public class FirstNotRepeating {
    @Test
    public void testFirst(){
        String str = "abaccdeff";
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i)-'a']++;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 1)
            {
                System.out.println(str.charAt(i));
                break;
            }
        }
    }
}
