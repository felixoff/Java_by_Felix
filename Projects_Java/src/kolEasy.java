import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kolEasy {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String reader = inp.readLine();
        Integer x8 = Integer.parseInt(reader);
        int N = x8.intValue();
        int kol = 0;
        String reader2 = inp.readLine();
        String[] mas = reader2.split(" ");
        long[] masi = new long[mas.length];
        for (int i = 0; i < mas.length; i++) {
            Long o = Long.parseLong(mas[i]);
            masi[i] = o.longValue();
               if (masi[i] > 10)
                    if ((masi[i] % 2 == 0) || (masi[i] % 10 == 5))
                        continue;
            int k = 2;
            for (long j = 2; j < masi[i]; j++)
            {
                   if (j*j - 1 > masi[i])
    {
       kol = kol + 1;
        break;
  }
                if (masi[i] % j == 0) {
                    break;
                }
                k++;
            }
            if (k == masi[i])
            {
                kol++;
            }
        }
        System.out.println(kol);
    }
}
