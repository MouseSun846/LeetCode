import org.junit.Test;

public class NumDecodeing {
    public int numDecodings(String s) {
        if(s == null || s.length()==0) return 0;
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for(int i=s.length()-1;i>=0;i--){
                if(i<s.length()-1){
                    if (s.charAt(i) == '0')
                    {
                        dp[i] = 0;
                        continue;
                    }
                }
                else{
                    if (s.charAt(s.length()-1) == '0')
                        dp[s.length()-1] = 0;
                    else
                        dp[s.length()-1] = 1;
                }

            if(i<s.length()-1){
                String dw = s.substring(i,i+2);
                int num = Integer.parseInt(dw);
                if(num <= 26){
                    dp[i] = dp[i+1] + dp[i+2];
                }else {
                    dp[i] = dp[i+1];
                }
            }
        }
        return dp[0];
    }

    public int numDecode(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    @Test
    public void testNumDecode(){
        int cnt = numDecodings("121");
        System.out.println(cnt);

    }
}
