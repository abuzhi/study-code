package com.xiao.demo;

import java.util.*;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T136_SingleNumber {


    /**
     * 题目要求给出了非空数组，两两出现，单个出现，以及线性复杂度，不用额外空间这些信息
     *
     * 既满足时间复杂度又满足空间复杂度，就要提到位运算中的异或运算XOR，主要因为异或运算有以下几个特点：
     * 一个数和0做XOR运算等于本身：a⊕0 = a
     * 一个数和其本身做XOR运算等于0：a⊕a = 0
     * XOR运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
     *
     * 这个操作真是太666了
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        int num = nums[0];
        for(int i=1;i<nums.length;i++){
            num = num ^ nums[i];
        }

        return num;
    }

    /**
     * 其他方法也可实现，但是不能满足题目中对时间和空间的要求
     * (1)for二次循环遍历查找 O(n^2)
     * （2）hash表，存入，取出。最后剩一个。时间和空间都是O(n)
     * （3）数学方法，2∗(a+b+c)−(a+a+b+b+c)=c 。。。这个。。。。
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }
    public static void main(String[] args) {
        int[] input = {4,1,2,1,2};

        T136_SingleNumber test = new T136_SingleNumber();

        int i = test.singleNumber2(input);
        System.out.println(i);

        i = test.singleNumber(input);
        System.out.println(i);
    }
}
