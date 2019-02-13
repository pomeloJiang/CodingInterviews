package codinginterviews;

/**
 * Description:二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 * 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 * <p>
 * User: pomelojiang
 * Date: 2019/2/13
 */
public class N_15_NumberOf1InBinary {
    public int numberOf1_solution1(int num) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((num & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 把一个整数减去1之后再和原来的整数做与运算，
     * 得到的结果相当于把整数的二进制最右边的1变成0
     * 例如 1100减去1，结果1011
     */
    public int numberOf1_solution2(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            //将num与num-1做与运算，可将num最右边的1变成0
            num = num & (num - 1);
        }
        return count;
    }
}
