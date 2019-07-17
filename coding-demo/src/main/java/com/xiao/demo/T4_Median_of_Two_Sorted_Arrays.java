package com.xiao.demo;

import java.text.DecimalFormat;

/**
 * Created by xiaoliang on 2017/3/26.
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 重点是归并排序，适合排序已经排好的两个数组之间
 */
public class T4_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length, len2 = nums2.length, i = 0, j = 0;
        int k = 0;
        int len = nums1.length + nums2.length;
        int[] sort = new int[len];


        if(len1 ==0){
            while (j < len2) {
                sort[k] = nums2[j];
                k++;
                j++;
            }
        }else if(len2==0){
            while (i < len1) {
                sort[k] = nums1[i];
                k++;
                i++;
            }
        }else {
            while (i < len1 || j < len2) {
                if (nums1[i] < nums2[j]) {
                    sort[k] = nums1[i];
                    i++;
                    k++;
                } else {
                    sort[k] = nums2[j];
                    j++;
                    k++;
                }

                if (i == len1) {
                    while (j < len2) {
                        sort[k] = nums2[j];
                        k++;
                        j++;
                    }
                }
                if (j == len2) {
                    while (i < len1) {
                        sort[k] = nums1[i];
                        k++;
                        i++;
                    }
                }

            }
        }


        double mid = 0;
        if (len % 2 == 0) {
            mid = (sort[len / 2] + sort[len / 2 - 1]) / 2.0;
        } else {
            mid = sort[len / 2 ];
        }

        return mid;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {};

        T4_Median_of_Two_Sorted_Arrays sorted_arrays = new T4_Median_of_Two_Sorted_Arrays();

        double mid = sorted_arrays.findMedianSortedArrays(nums1, nums2);
        System.out.print("ok");
    }
}
