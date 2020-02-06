import org.junit.Test;
public class FullyArray {
    /**
     * 生成大数的位数
     * @param n
     */
    public void PrintToMaxOfNDigits(int n){
        if (n < 0)
            return;
        char[] number = new char[n+1];
        number[n]='\0';
        for (int i = 0; i < 10; i++) {
            number[0]= (char) (i+'0');
            PrintToMaxOfNDigitsRecursively(number,n,0);
        }
    }
    /**
     * 递归并打印
     * @param number
     * @param n
     * @param index
     */
    private void PrintToMaxOfNDigitsRecursively(char[] number, int n, int index) {
        if (index == n-1){
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for (char ch : number) {
                if (flag)
                    sb.append(ch);
                if (ch != '0' && flag == false){
                    sb.append(ch);
                    flag = true;
                }

            }
            System.out.println(sb);
            return;
        }
        System.out.println("head");
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            System.out.println("middle");
            PrintToMaxOfNDigitsRecursively(number,n,index+1);
        }
        System.out.println("tail");
    }
    @Test
    public void testPrintDigit(){
        PrintToMaxOfNDigits(2);
    }

}
