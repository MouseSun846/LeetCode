import org.junit.Test;

public class GetNindex {

    public void getIndex(int index){
        if (index < 0) return ;
        int digit = 1;
        while (true){
            int numbers = getDigitCount(digit);
            if (index < numbers*digit){
                System.out.println(digitAtIndex(index,digit));
                break;
            }
            index-=digit*numbers;
            digit++;
        }
    }

    /**
     * 获取指定位数上的数字
     * @param index
     * @param digit
     * @return
     */
    public int digitAtIndex(int index,int digit){
        if (digit == 1) return index;
        int snum = (int) Math.pow(10,digit-1);
        int head = index / digit;
        int tail = index % digit;
        snum += head;
        int res = (""+snum).charAt(tail) -'0';
        return res;
    }

    /**
     * 获得指定位数的数字个数
     * @param digit
     * @return
     */
    public int getDigitCount(int digit){
        if (digit == 1) return 10;
        int count = (int) Math.pow(10,digit-1);
        return count*9;
    }

    /**
     * 测试获取位数
     */
    @Test
    public void testGetDigit(){
        getIndex(1001);
    }
}
