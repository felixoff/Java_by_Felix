import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class detOld {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String reader2 = inp.readLine();
        Integer k = Integer.parseInt(reader2);
        long[][] mas = new long[k][k];
        for (int i = 0; i < k; i++) {
            String[] readeri = inp.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                Integer elem = Integer.parseInt(readeri[j]);
                mas[i][j] = elem;
            }
        }
        long det = 0;
        det = deter(mas, k, det);
        System.out.println(det);
    }

    public static long deter(long[][] mas, int k, long det)
    {
        det = 0;
        if (k > 2)
        {
            for (int i = 0; i < k; i++)
            {
                long [][] mas2 = new long[k-1][k-1];
                for (int ind = 0; ind < k-1; ind++)
                {
                    int q = 0;
                    for (int j = 0; j < k; j++)
                    {
                        if (j != i) {
                            mas2[ind][q] = mas[ind+1][j];
                            q++;
                        }
                    }
                }
                if ( i % 2 == 0)
                {
                    det = det + mas[0][i]*deter(mas2,k-1,det);
                }
                else
                {
                    det = det - mas[0][i]*deter(mas2,k-1,det);
                }
            }
        }
        else
        {
            det = mas[0][0]*mas[1][1]-mas[1][0]*mas[0][1];
        }
        return(det);
    }
}

