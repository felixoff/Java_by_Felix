import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fakNul {
        public static void main(String[] args) throws IOException {
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            String mas0 = inp.readLine();
            Integer nnn = Integer.parseInt(mas0);
            int n = nnn.intValue();
            long k = 5;
            long kol = 0;
            while (n / k != 0 )
            {
                kol = kol + n/k;
                k = k*5;
            }
            System.out.println(kol);
        }
    }

