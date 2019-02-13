package codinginterviews;

/**
 * Description:剪绳子
 * 给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 * 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * 时得到最大的乘积18。
 * <p>
 * User: pomelojiang
 * Date: 2019/2/13
 */
public class N_14_CuttingRope {

    /**
     * 动态规划求解
     */
    public int maxProductAfterCutting_solution1(int length) {
        if (length < 2) {
            return 0;
        }

        if (length == 2) {
            return 1;
        }

        if (length == 3) {
            return 2;
        }

        int[] f = new int[length + 1];
        //当长度 >=4时，剪成几段后长度为1,2,3的最大值分别为1,2,3
        //例如长度=5,剪成2段,分别为2,3,长度为3的那一段最大值为3
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;

        int max;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int result = f[j] * f[i-j];
                if (max < result){
                    max = result;
                }
                f[i] = max;
            }
        }

        max = f[length];
        return max;
    }

    /**
     * 贪心算法求解
     * 当length>=5时，尽可能多剪长度为3的绳子
     * 剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子 2*2 > 3*1
     */
    public int maxProductAfterCutting_solution2(int length) {
        if (length < 2){
            return 0;
        }

        if (length == 2){
            return 1;
        }

        if (length == 3){
            return 2;
        }

        int timesOf3 = length / 3;

        if (length - timesOf3*3 == 1){
            timesOf3--;
        }

        int timesOf2 = (length - timesOf3*3)/2;

        return (int) (Math.pow(3,timesOf3) * Math.pow(2,timesOf2));
    }
}
