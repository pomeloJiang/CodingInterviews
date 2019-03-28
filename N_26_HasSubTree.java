package codinginterviews;

/**
 * Description:输入两棵二叉树A和B，判断B是不是A的子结构。
 * User: pomelojiang
 * Date: 2019/3/28
 */
public class N_26_HasSubTree {

    static class BinaryTreeNode {
        double mValue;
        BinaryTreeNode mLeft;
        BinaryTreeNode mRight;

        public BinaryTreeNode(double value, BinaryTreeNode left, BinaryTreeNode right) {
            this.mValue = value;
            this.mLeft = left;
            this.mRight = right;
        }
    }

    public boolean hasSubTree(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {

        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }

        boolean result = false;

        if (isDoubleEqual(pRoot1.mValue,pRoot2.mValue)){
            result = doesTree1HaveTree2(pRoot1,pRoot2);
        }

        if (!result){
            result = hasSubTree(pRoot1.mLeft,pRoot2);
        }

        if (!result){
            result = hasSubTree(pRoot1.mRight,pRoot2);
        }

        return result;
    }

    private boolean doesTree1HaveTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        if (pRoot2 == null){
            return true;
        }

        if (pRoot1 == null){
            return false;
        }

        if (!isDoubleEqual(pRoot1.mValue,pRoot2.mValue)){
            return false;
        }

        return doesTree1HaveTree2(pRoot1.mLeft,pRoot2.mLeft)
                && doesTree1HaveTree2(pRoot1.mRight,pRoot2.mRight);
    }

    private boolean isDoubleEqual(double value1, double value2) {
        if (value1 - value2 > -0.0000001 && value1 - value2 < 0.0000001) {
            return true;
        }
        return false;
    }
}
