package codinginterviews;

/**
 * Description:面试题17:打印从1到最大的n位数
 * 输入数字n,按顺序打印出从1到最大的n位十进制数。
 * 比如输入3，则打印出1、2、3一直到最大的3位数999
 * <p>
 * User: pomelojiang
 * Date: 2019/2/25
 */
public class N_17_Print1ToMaxOfNDigits {

    //考虑溢出
    public void printToMaxOfDigits(int n) {
        if (n <= 0) {
            System.out.println("输入的n没有意义");
            return;
        }
        char number[] = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }

        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            printToMaxOfNDigitsCore(number, n, 0);
        }
    }

    //利用递归实现1到最大的n位数的全排列
    private void printToMaxOfNDigitsCore(char[] number, int length, int index) {
        if (index == length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            printToMaxOfNDigitsCore(number, length, index + 1);
        }
    }

    private void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if (isBeginning0 && number[i] != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
}
