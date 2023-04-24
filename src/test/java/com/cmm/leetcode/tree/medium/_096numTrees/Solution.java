package com.cmm.leetcode.tree.medium._096numTrees;

/**
 * @author caimingming02
 * @date 2020/10/10 5:41 PM
 * @desc
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 19
 */
public class Solution {
    /**
     * 结题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
     * 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
     * 同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
     * 所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     */
    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g[i] += g[j-1] * g[i - j];
            }
        }

        return g[n];
    }
}
