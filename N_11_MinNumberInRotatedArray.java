package codinginterviews;

/**
 * Description: 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如：数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 * <p>
 * User: pomelojiang
 * Date: 2019/1/30
 */
public class N_11_MinNumberInRotatedArray {

    int min(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("参数为Null");
        }

        if (arr.length == 0){
            return 0;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid = left;
        //条件也可以为： right - left >= 1
        while (arr[left] >= arr[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }

            mid = left + ((right - left) >> 1);

            //{1,0,1,1,1} 和 {1,1,1,0,1}
            //左右指针和中间数字都相等的情况
            if (arr[left] == arr[right]
                    && arr[mid] == arr[left]){
                return minNumberInOrder(arr,left,right);
            }

            if (arr[left] <= arr[mid]) {
                left = mid;
            } else if (arr[right] >= arr[mid]){
                right = mid;
            }
        }
        return arr[mid];
    }

    private int minNumberInOrder(int[] arr, int left, int right) {
        int min = arr[left];
        for (int i = left; i < right; i++) {
            min = arr[i] > min ? min : arr[i];
        }
        return min;
    }
}
