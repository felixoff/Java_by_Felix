import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;

public class rankOfMatrix2 {
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
        Determin3 dd = new Determin3(mas,k,n);
        dd.getValue();
    }
}
class Determin3 {
    private long rank;

    public Determin3(long[][] matrix, int k, int n)
    {
        this.rank = getReduction(matrix,k,n);
    }


    public void getValue() {
        System.out.println(this.rank);
    }


    private long getReduction(long [][] a,int n, int m) {
        this.rank = Math.min(n,m);
        boolean[] line_used = new boolean[n];
        for (int i = 0; i < n; ++i)
            line_used[i] = false;
        System.out.println(Arrays.toString(line_used));
        for (int i = 0; i< m; ++i )
        {
            int j;
            for (j = 0; j < n; ++j)
                if ( line_used[j] == false && Math.abs(a[j][i]) > 0)
                    break;
            if (j == n)
                --this.rank;
            else {
                line_used[j] = true;
                for (int p = i + 1; p < m; ++p)
                    a[j][p] /= a[j][i];
                for (int k = 0; k < n; ++k)
                    if (k != j && Math.abs(a[k][i]) > 0)
                        for (int p = i + 1; p <m; ++p)
                            a[k][p] -= a[j][p]*a[k][i];
            }
        }
        return this.rank;
    }
}

//5 5
//       100 48 -29 2 4
//      94 22 21 30 3
//    3 1 5 6 -22
//      2 5 99 0 12
//     -4 4 8 1 9
//     378848714286