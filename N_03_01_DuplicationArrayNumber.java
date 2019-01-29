package codingoffer;

/**
 * Description: 找出数组中重复的数字
 * User: pomelojiang
 * Date: 2019/1/25
 */
public class N_3_01_DuplicationArrayNumber {
    public static int findDuplicatedNumberInArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("参数为空或数组大小为0");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1){
                return -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]){
                if (arr[i] == arr[arr[i]]){
                    return arr[i];
                }
                Utils.swap(arr,i,arr[i]);
            }
        }

        return -1;
    }
}
