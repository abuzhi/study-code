package com.xiao.demo;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T88_mergeSortedArray {
    /**
     * 最优为双指针，从后往前 ,再加num1的尾部指针。这样不需要额外再加空间
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1,j=n-1,k = nums1.length-1;
        while (i>=0 && j>=0){
            int n1 = nums1[i];
            int n2 = nums2[j];
            if(n1>n2){
                nums1[k] = n1;
                i--;
                k--;
            }else {
                nums1[k] = n2;
                j--;
                k--;
            }

        }

        while (i>=0){
            nums1[k] = nums1[i];
            i--;
            k--;
        }

        while (j>=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }



    }

    /**
     * 两个指针，从前往后 再加一个合并数组，时间复杂度 m +n
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void test1(int[] nums1, int m, int[] nums2, int n){
        int[] result = new int[nums1.length];
        int i=0,j=0,k=0;
        while (j < n && i < m){
            int n1 = nums1[i];
            int n2 = nums2[j];
            if(n1>n2){
                result[k] = n2;
                k ++;
                j ++;
            }else {
                result[k] = n1;
                k ++;
                i ++;
            }
        }

        while (i<m){
            int n1 = nums1[i];
            result[k] = n1;
            k ++;
            i ++;
        }

        while(j<n){
            int n2 = nums2[j];
            result[k] = n2;
            k ++;
            j ++;
        }

        for(int tmp =0;tmp<result.length;tmp++){
            nums1[tmp] = result[tmp];
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        T88_mergeSortedArray test = new T88_mergeSortedArray();
        test.test1(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = {1,2,3,0,0,0};
        int[] nums4 = {2,5,6};
        test.merge(nums3,3,nums4,3);
        System.out.println(Arrays.toString(nums3));


    }
}
