package codinginterviews;

/**
 * Description: 表示数值的字符串
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 * “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 * <p>
 * User: pomelojiang
 * Date: 2019/3/11
 */
public class N_20_NumericStrings {
    private int index;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length < 1) {
            return false;
        }

        boolean isNumeric = scanInteger(str);

        if (index < str.length && str[index] == '.'){
            index++;
            isNumeric = scanUnsignedInteger(str) || isNumeric;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')){
            index++;
            isNumeric = isNumeric && scanInteger(str);
        }

        return (isNumeric && index==str.length);
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    //是否存在0-9的数
    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        if (index < str.length && str[index] >= '0' && str[index] <= '9'){
            index++;
        }
        return start < index;
    }
}
