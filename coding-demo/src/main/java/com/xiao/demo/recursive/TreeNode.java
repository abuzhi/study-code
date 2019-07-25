package com.xiao.demo.recursive;

/**
 * * 输入:
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
 * 创建一个二叉树，用数组来表示的方法
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode() {
    }

    /**
     * 一个int数组转化为二叉树
     * @param data 一个int数组
     * @return
     */
    public TreeNode createTree(Integer[] data){
        return node(data,0);
    }

    private TreeNode node(Integer[] data,int i){
        if(i>=data.length || data[i]==null){
            return null;
        }

        TreeNode root = new TreeNode(data[i]);
        root.left = node(data,2*i + 1);
        root.right = node(data,2*i + 2);

        return root;
    }

    public static void main(String[] args) {
        Integer[] data = {5,1,4,null,null,3,6};
        TreeNode tree = new TreeNode();
        tree = tree.createTree(data);
        System.out.println(tree);
    }
}
