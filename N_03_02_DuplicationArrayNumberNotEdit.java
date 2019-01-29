package codingoffer;

/**
 * Description: 不修改数组找出重复的数字(数组值的范围:1~n)
 * 思路1:利用辅助数组保存原数据，空间复杂度O(n)
 * 思路2:二分法查找，时间复杂度O(nlogn)
 * User: pomelojiang
 * Date: 2019/1/25
 */
public class N_3_02_DuplicationArrayNumberNotEdit {
    public static int findDuplicatedNumberInArray(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("参数为空或数组大小为0");
        if (arr.length == 1)
            return -1;
        int start = 1;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int count = countRange(arr, start, mid);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int countRange(int[] arr, int start, int end) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end) {
                count++;
            }
        }
        return count;
    }
}
