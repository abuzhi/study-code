package com.xiao.demo;

import com.xiao.demo.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    /**
     * 由于为二叉搜索树，递归比较各子节点大小即可
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        int pVal = p.val;
        int qVal = q.val;
        if(pVal<root.val && qVal<root.val){
            return this.lowestCommonAncestor(root.left,p,q);
        }else if(pVal > root.val && qVal>root.val){
            return this.lowestCommonAncestor(root.right,p,q);
        }else {
            return root;
        }
    }

    public static void main(String[] args) {

        Integer[] data = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = new TreeNode();
        root = root.createTree(data);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);

        T235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree test = new T235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree();
        System.out.println(test.lowestCommonAncestor(root,p,q).val);

        p.val = 2;
        q.val = 4;
        System.out.println(test.lowestCommonAncestor(root,p,q).val);

    }
}
