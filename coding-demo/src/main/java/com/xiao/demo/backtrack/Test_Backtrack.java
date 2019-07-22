package com.xiao.demo.backtrack;

/**
 * 回溯法
 * 一般回溯的问题有三种：
 *
 * Find a path to success 有没有解
 *
 * Find all paths to success
 *          求所有解
 *          求所有解的个数
 *          求所有解的具体信息
 *
 * Find the best path to success 求最优解
 *
 * 关于回溯的三种问题，模板略有不同，
 * 第一种，返回值是true/false。
 * 第二种，求个数，设全局counter，返回值是void；求所有解信息，设result，返回值void。
 * 第三种，设个全局变量best，返回值是void。
 *
 * 第一种：
 *
 * boolean solve(Node n) {
 *     if n is a leaf node {
 *         if the leaf is a goal node, return true
 *         else return false
 *     } else {
 *         for each child c of n {
 *             if solve(c) succeeds, return true
 *         }
 *         return false
 *     }
 * }
 *
 * 第二种：
 *
 * void solve(Node n) {
 *     if n is a leaf node {
 *         if the leaf is a goal node, count++, return;
 *         else return
 *     } else {
 *         for each child c of n {
 *             solve(c)
 *         }
 *     }
 * }
 *
 * 第三种：
 *
 * void solve(Node n) {
 *     if n is a leaf node {
 *         if the leaf is a goal node, update best result, return;
 *         else return
 *     } else {
 *         for each child c of n {
 *             solve(c)
 *         }
 *     }
 * }
 *
 */
public class Test_Backtrack {

}
