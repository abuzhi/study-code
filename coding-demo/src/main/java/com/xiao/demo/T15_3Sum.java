package com.xiao.demo;

import java.util.*;

/**
 * Created by xiaoliang on 2017/3/22.
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class T15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {

        return null;
    }

    /**
     * 用set去重做
     * 但是由于给定 数组中会有重复数据，所以这个不好做
     * @param nums
     * @return
     */
    public List<List<Integer>> test1(int[] nums){

        return null;
    }

    /**
     * 先排序，再遍历
     * @param nums
     * @return
     */
    public List<List<Integer>> test2(int[] nums){

        List<List<Integer>> list = new ArrayList<>();

        if(nums==null || nums.length<3){
            return list;
        }

        //先排序
        Arrays.sort(nums);

        for(int i =0;i<nums.length-2;i++){
            if(nums[i]>0) break;    //不满足
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重

            int left = i+1;
            int right = nums.length-1;

            while (left<right){
                int tmp = nums[i] + nums[left] + nums[right];
                if(tmp>0 ){
                    right --;
                }else if(tmp<0){
                    left ++;
                }else {
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    //去重
                    while (left< right && nums[left] == nums[left+1]){
                        left ++;
                    }
                    while (left< right &&  nums[right] == nums[right-1]){
                        right --;
                    }
                    right --;
                    left ++;

                }
            }

        }

        return list;
    }

    public static void main(String[] args) {
        T15_3Sum test = new T15_3Sum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List result = test.test2(nums);
        System.out.println(Arrays.toString(result.toArray()));

        int[] nums2 = {0,0,0,0};
        result = test.test2(nums2);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
