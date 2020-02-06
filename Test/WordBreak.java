import org.junit.Test;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        return false;
    }

    @Test
    public void test() {
//        String s = "applepenapple";
//        List<String> wordDict = Arrays.asList("apple", "pen");

//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        String s = "cars";
        List<String> wordDict = Arrays.asList("car", "ca", "rs");

        //首先拿到List第一个字母的index
        int[][] ap = new int[26][wordDict.size() + 1];
        for (int i = 0; i < wordDict.size(); i++) {
            int index = wordDict.get(i).charAt(0) - 'a';
            ap[index][0]++;
            ap[index][ap[index][0]] = i;
        }
        //判断是否匹配
        int index = 0;
        int cnt = 0;
        while (true) {
            if (index == s.length()) {
                System.out.println("true");
                break;
                //                return true;
            }
            char ch = s.charAt(index);
            if (ap[ch - 'a'][0] > 0) {
                for (int i = 1; i < 1 + ap[ch - 'a'][0]; i++) {
                    String temp = wordDict.get(ap[ch - 'a'][i]);
                    boolean res = match(s.substring(index), temp);
                    if (res) {
                        index += temp.length();
                        cnt = temp.length();
                        break;
                    }
                }
            } else {
                break;
            }

        }
        System.out.println("flase");

    }

    public boolean match(String s, String dict) {
        int[][] dp = new int[dict.length()][dict.length()];
        dp[0][0] = 1;
        for (int i = 1; i < dict.length(); i++) {
            for (int j = 1; j < dict.length(); j++) {
                if (s.charAt(i) == dict.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                ;
            }
        }
        if (dp[dict.length() - 1][dict.length() - 1] == dict.length())
            return true;
        return false;
    }

    /**
     * 以与第一行（字符串）为基础
     * 第二行所有的字串去匹配
     *
     */

    @Test
    public void testdp() {
        String s = "cars";
        List<String> wordDict = Arrays.asList("ca","rs");
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        System.out.println(dp[s.length()] );
    }

}