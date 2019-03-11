package codinginterviews;

/**
 * Description:调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 * 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * User: pomelojiang
 * Date: 2019/3/11
 */
public class N_21_ReorderOddEven {
    public void reorderOddEven(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int p1 = 0;
        int p2 = array.length - 1;
        while (p1 < p2) {
            //奇数
            while (p1 < p2 && (array[p1] & 0x1) != 0) {
                p1++;
            }

            //偶数
            while (p1 < p2 && (array[p2] & 0x1) == 0) {
                p2--;
            }

            if (p1 < p2) {
                swap(array, p1, p2);
            }
        }
    }

    //保持相对顺序不变
    public void reorderOddEven_order(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        //类似于冒泡
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if ((array[j-1] & 0x1) == 0 && (array[j] & 0x1) != 0){
                    swap(array,j-1,j);
                }
            }
        }
    }

    private void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
