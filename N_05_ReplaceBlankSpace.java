package codinginterviews;

/**
 * Description: 替换空格
 * 请事先一个函数，把字符串中的每个空格天幻成%20.
 * 例如，输入“We are happy.”，则输出“We%20are%20happy.”
 * <p>
 * User: pomelojiang
 * Date: 2019/1/26
 */
public class N_5_ReplaceBlankSpace {
    /**
     * String.replace()可以直接替换某个字符
     * 为了和书中的案例保持一致，这里将String改为char[]
     * test:{'W','e',' ','a','r','e',' ','h','a','p','p','y','.',' ',' ','t',' '}
     * @param str
     * @return
     */
    public static char[] replaceBlankSpace(char[] str) {
        if (str == null || str.length == 0) {
            throw new IllegalArgumentException("参数为Null或长度为0");
        }

        int len = str.length;
        int newLen = len;
        for (int i = 0; i < len; i++) {
            if (str[i] == ' ') {
                newLen += 2;
            }
        }

        char[] tmp = new char[newLen];
        int extra = 0;
        for (int i = 0; i < len; i++) {
            if (str[i] == ' ') {
                tmp[i + extra] = '%';
                tmp[i + extra + 1] = '2';
                tmp[i + extra + 2] = '0';
                extra += 2;
                continue;
            }
            tmp[i + extra] = str[i];
        }

        return tmp;
    }
}
