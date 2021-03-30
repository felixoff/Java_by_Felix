import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class rankOfMatrix3 {
    static final int R = 3;
    static final int C = 3;
    static void swap(long mat[][],
                     int row1, int row2, int col)
    {
        for (int i = 0; i < col; i++)
        {
            long temp = mat[row1][i];
            mat[row1][i] = mat[row2][i];
            mat[row2][i] = temp;
        }
    }
    static void display(long mat[][],
                        int row, int col)
    {
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
                System.out.print(" "
                        + mat[i][j]);
            System.out.print("\n");
        }
    }
    static int rankOfMatrix(long mat[][])
    {
        int rank = C;
        for (int row = 0; row < rank; row++)
        {
            if (mat[row][row] != 0)
            {
                for (int col = 0; col < R; col++)
                {
                    if (col != row)
                    {
                        double mult =
                                (double)mat[col][row] /
                                        mat[row][row];
                        for (int i = 0; i < rank; i++)
                            mat[col][i] -= mult
                                    * mat[row][i];
                    }
                }
            }
            else
            {
                boolean reduce = true;
                for (int i = row + 1; i < R; i++)
                {
                    if (mat[i][row] != 0)
                    {
                        swap(mat, row, i, rank);
                        reduce = false;
                        break ;
                    }
                }
                if (reduce)
                {
                    rank--;
                    for (int i = 0; i < R; i ++)
                        mat[i][row] = mat[i][rank];
                }
                row--;
            }
        }
        return rank;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String[] reader2 = inp.readLine().split(" ");
        Integer k = Integer.parseInt(reader2[0]);
        Integer n = Integer.parseInt(reader2[1]);
        long[][] mas = new long[k][n];
        for (int i = 0; i < k; i++) {
            String[] readeri = inp.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                Integer elem = Integer.parseInt(readeri[j]);
                mas[i][j] = elem;
            }
        }
        System.out.println(rankOfMatrix(mas));
    }
}
