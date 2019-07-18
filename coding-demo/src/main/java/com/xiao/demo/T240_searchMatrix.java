package com.xiao.demo;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T240_searchMatrix {

    /**
     * 由于数组是排序好的，可以定义两个指针，从左下角开始遍历，比target值大，指针就向小的方向移动即可
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean is = false;
        if(matrix==null || matrix.length == 0){
            return is;
        }
        //取左下元素为起点
        int x =0, y = matrix.length-1;

        int wid = matrix[y].length;

        while (y>-1 && x<wid){
            int k = matrix[y][x];
            if(k==target){
                return true;
            }else {
                if(target < k){
                    y --;
                }else {
                    x ++;
                }
            }
        }

        return is;
    }

    /**
     * 暴力法
     * 时间复杂度为 m * n ,空间为1
     * @param matrix
     * @param target
     * @return
     */
    public boolean test1(int[][] matrix, int target) {
        boolean exist = false;
        for(int i = 0;i<matrix.length;i++){
            int[] tmp = matrix[i];
            for(int j = 0;j<tmp.length;j++){

                int k = tmp[j];
                if(k==target){
                    exist = true;
                    break;
                }
            }
        }
        return exist;
    }

    /**
     * 二分查找
     * 由于是已经排序好的数据，可以用来进行二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean test2(int[][] matrix, int target) {

        int x,y=0;



        return false;
    }
        public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int[][] matrix2 = {
                {1, 4, 7},
                {10,13,24}
        };

        T240_searchMatrix test = new T240_searchMatrix();
        boolean is = test.test1(matrix,5);
        System.out.println(is);

        is = test.searchMatrix(matrix,5);
        System.out.println(is);
    }
}
