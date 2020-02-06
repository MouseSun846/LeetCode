import org.junit.Test;



/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/5 14:42
 */
public class ReverseNunbers {
    public int InversePairsCore(int[] data,int[] copy,int start,int end){
        if (start == end)
        {
            copy[start] = data[start];
            return 0;
        }
        int len = (end - start)/2;
        int left = InversePairsCore(copy,data,start,start+len);
        int right = InversePairsCore(copy,data,start+len+1,end);
        //i为前半段最后一个数字的下标
        int i = start+len;
        //j初始化为后半段最后一个数字的下标
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i>=start && j>=start+len+1){
            if (data[i]>data[j]){
//                copy[indexCopy--] = data[i--];
//                count+=(j-start-len);
                copy[indexCopy--] = data[i--];
                count += j - start - len;
            }else {
                copy[indexCopy--] = data[j--];
            }
        }
        for (;i>=start ; --i) {
            copy[indexCopy--] = data[i];
        }
        for(;j>=(start+len+1);--j){
            copy[indexCopy--] = data[j];
        }
        return left + right + count;

    }

    @Test
    public void test(){
        int[] data = {7,5,6,4};
        int[] copy = {7,5,6,4};
        int count = InversePairsCore(data, copy, 0, data.length - 1);
        System.out.println(count);
//        int res = InversePairs(data);
//        System.out.println(res);
    }

    public int InversePairsCoren(int[] data,int[] copy,int start,int end){
        if(start == end){
            copy[start] = data[start];
            return 0;
        }
        int length = (end-start)/2;//一半长度
        int left = InversePairsCoren(copy,data,start,start+length);
        int right = InversePairsCoren(copy,data,start+length+1,end);

        int i = start + length;//前半段最后一个坐标
        int j = end;//后半段最后一个坐标
        int indexCopy = end;
        int count = 0;
        while(i>=start && j>=start+length+1){
            if(data[i] > data[j]){//如果左边最大数大于右边最大数时可以构成逆序对
                copy[indexCopy--] = data[i--];
                count += j - start - length;
            }else{
                copy[indexCopy--] = data[j--];
            }
        }
        for(;i>=start;--i){
            copy[indexCopy--] = data[i];
        }
        for(;j>=start+length+1;--j){
            copy[indexCopy--] = data[j];
        }
        return left + right + count;
    }
}
