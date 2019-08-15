package com.xiao.demo;

import com.xiao.demo.pojo.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T226_Invert_Binar_Tree {

    /**
     * 递归方法比较简单
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;

        return root;
    }

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public TreeNode test1(TreeNode root){
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if(node.left !=null){
                queue.add(node.left);
            }
            if(node.right !=null){
                queue.add(node.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {

        T226_Invert_Binar_Tree test = new T226_Invert_Binar_Tree();
        TreeNode treeNode = new TreeNode();
        Integer[] data = {4,2,7};

        treeNode = treeNode.createTree(data);

//        TreeNode result = test.invertTree(treeNode);
        TreeNode result = test.test1(treeNode);
        System.out.println(result);

    }
}
