package com.xiao.demo;

import java.util.*;

/**
 * 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        return null;
    }

    /**
     * 参考3sum的实现
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> test1(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<>();
        if(nums.length<4){
            return list;
        }
        Set<List<Integer>> set = new HashSet<>();

        //排序
        Arrays.sort(nums);

        for(int i =0;i < nums.length -3;i++){
            for(int j = i+1;j < nums.length -2;j++){
                int left = j + 1;
                int right = nums.length-1;

                while (left<right){
                    int tmp = nums[i] + nums[j] + nums[left] + nums[right];
                    if(tmp>target){
                        right --;
                    }else if(tmp<target){
                        left ++;
                    }else {
                        //用set去重
                        set.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));

                        //去重
                        while (left< right && nums[left] == nums[left+1]){
                            left ++;
                        }
                        while (left< right &&  nums[right] == nums[right-1]){
                            right --;
                        }
                        left ++ ;
                        right --;
                    }
                }

            }
        }

        for(List<Integer> t : set){
            list.add(t);
        }


        return list;
    }

    public static void main(String[] args) {
        T18_4Sum test = new T18_4Sum();
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        System.out.println(Arrays.toString(test.test1(nums,0).toArray()));

        int[] nums2 = {1,-2,-5,-4,-3,3,3,5};
        System.out.println(Arrays.toString(test.test1(nums2,-11).toArray()));
    }
}
