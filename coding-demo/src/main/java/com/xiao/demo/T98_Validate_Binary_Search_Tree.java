package com.xiao.demo;

import com.xiao.demo.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  验证二叉搜索树
 *  给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class T98_Validate_Binary_Search_Tree {

    List<Integer> list = new ArrayList<>();


    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return false;
        }
        if(root.right==null && root.left ==null){
            return true;
        }
        inOrder(root);
        for(int i =1;i<list.size();i++){
            if(list.get(i) <= list.get(i-1)){
                return false;
            }
        }

        return true;
    }

    /**
     * 中序遍历
     * 完全搜索二叉树的中序遍历结果是一个从小到大的排列
     * @param root
     * @return
     */
    public void inOrder(TreeNode root){
        if(root ==null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }


    public static void main(String[] args) {

    }
}

