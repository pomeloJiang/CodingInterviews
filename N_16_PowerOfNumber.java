package codinginterviews;

/**
 * Description:数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent
 * 次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * User: pomelojiang
 * Date: 2019/2/18
 */
public class N_16_PowerOfNumber {

    public double power(double base, int exponent) {
        if (equal(base, 0.0) && exponent <= 0) {
            throw new IllegalArgumentException("参数不合法");
        }

        double result = powerWithPositiveExponent(base, (exponent < 0 ? -exponent : exponent));
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    private double powerWithPositiveExponent(double base, int exponent) {
        double result = 1.0;
        while (exponent != 0) {
            if ((exponent & 1) != 0){
                result *= base;
            }
            base *= base;
            exponent = exponent >> 1;
        }
        return result;
    }

    private boolean equal(double num1, double num2) {
        if (Math.abs(num1 - num2) < 0.0000001) {
            return true;
        }
        return false;
    }
}
