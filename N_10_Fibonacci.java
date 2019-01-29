package codinginterviews;

/**
 * Description:裴波那契数列
 * 题目一：求裴波那契数列的第n项
 * 写一个函数，输入n，求裴波那契数列的第n项。裴波那契数列的定义如下：
 * 0                n=0
 * f(n) =  1                n=1
 * f(n-1) + f(n-2)  n>1
 * <p>
 * User: pomelojiang
 * Date: 2019/1/29
 */
public class N_10_Fibonacci {
    public int fibonacciByRecursion(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacciByRecursion(n - 1) + fibonacciByRecursion(n - 2);
    }

    public int fibonacciByLoop(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;

        int fibPreOne = 1;  // f(n-1)
        int fibPreTwo = 0;  // f(n-2)
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = fibPreOne + fibPreTwo;
            fibPreTwo = fibPreOne;
            fibPreOne = fib;
        }

        return fib;
    }
}
