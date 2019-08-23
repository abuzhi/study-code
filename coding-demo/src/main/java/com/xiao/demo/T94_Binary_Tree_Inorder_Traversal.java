package com.xiao.demo;

import com.xiao.demo.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class T94_Binary_Tree_Inorder_Traversal {

    public List<Integer> inorderTraversal(TreeNode root) {


        return null;
    }

    List<Integer> list =new ArrayList<>();
    public void test1(TreeNode root){
        if(root==null){
            return;
        }

        test1(root.left);
        list.add(root.val);
        test1(root.right);
    }

    public static void main(String[] args) {

        T94_Binary_Tree_Inorder_Traversal test = new T94_Binary_Tree_Inorder_Traversal();
        TreeNode t = new TreeNode();
        t = t.createTree(new Integer[]{1,null,2,null,null,3});

        test.test1(t);
        System.out.println( test.list);
    }

}
