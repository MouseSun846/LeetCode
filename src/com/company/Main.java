package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int[] result = new int[nums.length];
        int index = nums.length-k;
        if(k>0)
        {
            for(int i=index;i<nums.length*2;i++){
                if(i-index==nums.length)
                    break;
                result[i-index] = nums[i%nums.length];
            }
            nums=Arrays.copyOf(result,nums.length);

        }
        System.out.println("over");

    }
}
