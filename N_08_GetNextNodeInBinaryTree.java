package codinginterviews;

/**
 * Description:给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针
 *               a
 *            /     \
 *           b       c
 *          / \     / \
 *         d   e   f   g
 *            / \
 *           h   i
 * User: pomelojiang
 * Date: 2019/1/29
 */
public class N_8_GetNextNodeInBinaryTree {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }

    public static TreeNode getNextNodeByInOrder(TreeNode pNode) {
        if (pNode == null) {
            return null;
        }

        //有右子树，找到右子树最左孩子
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }

        /*
        * 没有右子树，找到父节点
        * 1、当前节点是父节点的左孩子，则next为父节点
        * 2、当前节点是父节点的右孩子，则沿着父节点向上遍历，直到找到一个节点：它是该节点的左子节点
        */
        while (pNode.parent != null){
            if (pNode.parent.left == pNode){
                return pNode.parent;
            }
            pNode = pNode.parent;
        }

        return null;
    }
}
