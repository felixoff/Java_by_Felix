import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class irrFrac
{
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String[] mas = inp.readLine().split(" ");
        Integer a = Integer.parseInt(mas[0]);
        Integer b = Integer.parseInt(mas[1]);
        Integer c = Integer.parseInt(mas[2]);
        Integer d = Integer.parseInt(mas[3]);
        int e = a * d + b * c;
        int f = b * d;
        int limit = Math.min(e, f);
        for (int i = limit; i >1 ; i--)
        {
            if (e % i == 0 && f % i == 0) {
                f /= i;
                e /= i;
            }
        }
        System.out.print(e + " ");
        System.out.print(f);
    }
}
