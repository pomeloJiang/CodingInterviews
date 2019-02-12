package codinginterviews;

/**
 * Description:矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
 * 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
 * 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
 * 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
 * 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
 * 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * A B T G
 * C F C S
 * J D E H
 * User: pomelojiang
 * Date: 2019/2/12
 */
public class N_12_StringPathInMatrix {

//    char[][] matrix = new char[][]{{'A','B','C','E','H','J','I','G'},{'S','F','C','S','L','O','P','Q'},
//            {'A','D','E','E','M','N','O','E'},{'A','D','I','D','E','J','F','M'},{'V','C','E','I','F','G','G','S'}};
//    String str = "SGGFIECVAASABCEHJIGQEM";
    public boolean hasPath(char[][] matrix, String str) {
        if (matrix == null || matrix.length == 0 || str == null) {
            throw new IllegalArgumentException("参数非法");
        }

        char[] strCharArray = str.toCharArray();
        int pathLength = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (hasPathCore(matrix, row, column, strCharArray, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[][] matrix, int row, int column, char[] strCharArray, int pathLength, boolean[][] visited) {
        if (pathLength == strCharArray.length) {
            return true;
        }

        boolean hasPath = false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (row >= 0 && row < rows && column >= 0 && column < columns
                && matrix[row][column] == strCharArray[pathLength]
                && !visited[row][column]) {
            pathLength++;
            visited[row][column] = true;
            hasPath = hasPathCore(matrix, row - 1, column, strCharArray, pathLength, visited)
                    || hasPathCore(matrix, row, column - 1, strCharArray, pathLength, visited)
                    || hasPathCore(matrix, row + 1, column, strCharArray, pathLength, visited)
                    || hasPathCore(matrix, row, column + 1, strCharArray, pathLength, visited);

            if (!hasPath) {
                pathLength--;
                visited[row][column] = false;
            }
        }

        return hasPath;
    }
}
