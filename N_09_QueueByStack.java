package codinginterviews;

import java.util.Stack;

/**
 * Description:用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能
 * User: pomelojiang
 * Date: 2019/1/29
 */
public class N_9_QueueByStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public N_9_QueueByStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int node) {
        stack1.push(node);
    }

    public int deleteHead() {

        if (stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
