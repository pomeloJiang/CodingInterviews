package codinginterviews;

/**
 * Description:重建二叉树
 * 输入某二叉树的谦虚遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如：输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
 * 则重建如图所示的二叉树便输出它的头结点
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * \     /
 * 7   8
 * User: pomelojiang
 * Date: 2019/1/28
 */
public class N_7_RebuildBinaryTree {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * preOrder:{1,2,4,7,3,5,6,8}
     * inOrder:{4,7,2,1,5,3,8,6}
     */
    public TreeNode reConstructBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            throw new IllegalArgumentException("参数为空");
        }

        if (preOrder.length <= 0 || inOrder.length <= 0) {
            throw new IllegalArgumentException("数组为空");
        }

        if (preOrder.length != inOrder.length) {
            throw new IllegalArgumentException("数组大小不一致");
        }

        return performReConstructBinaryTree(preOrder, inOrder);
    }

    private TreeNode performReConstructBinaryTree(int[] preOrder, int[] inOrder) {
        return performReConstructBinaryTree(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    private TreeNode performReConstructBinaryTree(int[] preOrder, int[] inOrder,
                                                  int startPre, int endPre, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        int rootValue = preOrder[startPre];
        TreeNode root = new TreeNode(rootValue);
        for (int i = startIn; i <= endIn; i++) {
            if (inOrder[i] == rootValue) {
                int leftChildLength = i - startIn;
                root.left = performReConstructBinaryTree(preOrder, inOrder,
                        startPre + 1, startPre + leftChildLength,
                        startIn, i - 1);
                root.right = performReConstructBinaryTree(preOrder, inOrder,
                        startPre + leftChildLength + 1, endPre,
                        i + 1, endIn);
                break;
            }
        }
        return root;
    }
}
