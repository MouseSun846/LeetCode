import org.junit.Test;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/5 12:38
 */
public class UglyNum {
    public int nthUglyNumber(int n) {
        if(n <= 0 ) return 0;
        int[] pUglyNums = new int[n];
        pUglyNums[0] = 1;
        int nextUglyIndex = 1;
        int pMultiply2 = 0;
        int pMultiply3 = 0;
        int pMultiply5 = 0;
        while(nextUglyIndex < n){
            int min = Math.min(pUglyNums[pMultiply2]*2,pUglyNums[pMultiply3]*3);
            min = Math.min(min,pUglyNums[pMultiply5]*5);
            pUglyNums[nextUglyIndex] = min;
            while(pUglyNums[pMultiply2]*2<=pUglyNums[nextUglyIndex]) pMultiply2++;
            while(pUglyNums[pMultiply3]*3<=pUglyNums[nextUglyIndex]) pMultiply3++;
            while(pUglyNums[pMultiply5]*5<=pUglyNums[nextUglyIndex]) pMultiply5++;
            nextUglyIndex++;
        }
        int num = pUglyNums[nextUglyIndex-1];
        return num;
    }

    @Test
    public void test(){
        int number = nthUglyNumber(11);
        System.out.println(number);
    }

        public int GetUglyNumber_Solution(int index) {
            if(index <= 0) return 0;
            int[] res = new int[index];
            res[0] = 1;
            int t2=0, t3=0, t5=0;
            int temp = 0;
            for(int i=1; i<index; i++){
                temp= Math.min(res[t2]*2,res[t3]*3);
                res[i]=Math.min(temp,res[t5]*5);
                if(res[i] == res[t2]*2) t2++;
                if(res[i] == res[t3]*3) t3++;
                if(res[i] == res[t5]*5) t5++;
            }
            return res[index-1];
        }
}
