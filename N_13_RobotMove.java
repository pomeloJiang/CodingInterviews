package codinginterviews;

/**
 * Description:机器人的运动范围
 * 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 * 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * User: pomelojiang
 * Date: 2019/2/12
 */
public class N_13_RobotMove {

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0) {
            return 0;
        }

        boolean[] visited = new boolean[rows * cols];
        int count = movingCountCore(threshold, 0, 0, rows, cols, visited);

        return count;
    }

    private int movingCountCore(int threshold, int row, int column, int rows, int cols, boolean[] visited) {
        int count = 0;
        if (check(threshold, row, column, rows, cols, visited)) {
            visited[row * cols + column] = true;
            count = 1 + movingCountCore(threshold, row - 1, column, rows, cols, visited)
                    + movingCountCore(threshold, row + 1, column, rows, cols, visited)
                    + movingCountCore(threshold, row, column - 1, rows, cols, visited)
                    + movingCountCore(threshold, row, column + 1, rows, cols, visited);
        }
        return count;
    }

    /**
     * 判断可达的标准：
     * 1、当前节点在矩阵内
     * 2、当前节点未被访问过
     * 3、当前节点满足limit条件
     */
    private boolean check(int threshold, int row, int column, int rows, int cols, boolean[] visited) {
        boolean result = false;
        if (row >= 0 && row < rows && column >= 0 && column < cols
                && !visited[row * cols + column]
                && getDigitSum(row, column) <= threshold) {
            result = true;
        }
        return result;
    }

    private int getDigitSum(int row, int column) {
        int rowDigitSum = 0;
        int colDigitSum = 0;

        while (row > 0) {
            rowDigitSum += row % 10;
            row /= 10;
        }

        while (column > 0) {
            colDigitSum += column % 10;
            column /= 10;
        }
        return rowDigitSum + colDigitSum;
    }
}
