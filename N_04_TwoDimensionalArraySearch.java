package codinginterviews;

/**
 * Description: 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数
 * 判断数组中是否含有该函数
 * User: pomelojiang
 * Date: 2019/1/25
 */
public class N_4_TwoDimensionalArraySearch {
    public static boolean findNumberInArray(int[][] arr, int number) {
        if (arr == null) {
            throw new IllegalArgumentException("数组不能为Null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("数组大小为0");
        }

        boolean result = false;
        int rows = arr.length - 1;
        int columns = arr[0].length - 1;
        int row = 0;
        while (row <= rows && columns >= 0) {
            int base = arr[row][columns];
            if (number == base) {
                return result = true;
            } else if (number < base) {
                columns--;
            } else if (number > base) {
                row++;
            }
        }
        return result;
    }
}
