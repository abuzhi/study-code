package com.xiao.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoliang on 2017/3/22.
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T1_Two_Sum {

    //遍历
    public int[] twoSum(int[] nums, int target) {

        for(int i=0,len=nums.length; i<len; i++){
            int a = nums[i];
            for(int j=nums.length-1 ; j>i;j--){
                int b = nums[j];
                if(a + b == target){
                    int[] tmp = {i,j};
                    return tmp;
                }
            }
        }
        return null;
    }

    //用空间换时间
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0,len = nums.length; i<len; i ++){
            int a = nums[i];
            int b = target - a;

            if(map.containsKey(b)){
                int a1 = map.get(b);
                return new int[]{a1, i};
            }
            map.put(a,i);
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        T1_Two_Sum t = new T1_Two_Sum();
        int target = 9;
        int[] arr = {2, 7, 11, 15};
        int[] nums = t.twoSum(arr,target);
        int[] nums2 = t.twoSum2(arr,target);
    }
}
