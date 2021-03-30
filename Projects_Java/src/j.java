
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;


public class j {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String[] reader = inp.readLine().split(" ");
        Integer n = Integer.parseInt(reader[0]);
        Integer t = Integer.parseInt(reader[1]);
        Double D = Double.parseDouble(reader[2]);
        String[] mas = inp.readLine().split(" ");
        int[] masi = new int[mas.length];
        long sum = 0;
        double mean = 0;
        int kol = 0;
        for (int i = 0; i < mas.length; i++) {
            Integer o = Integer.parseInt(mas[i]);
            masi[i] = o.intValue();
            sum = sum + masi[i];
            kol++;
        }
        mean = sum / kol;
        double disp = 0;
        for (int i = 0; i < masi.length; i++) {
            disp = disp + Math.pow(masi[i] - mean, 2);
        }
        disp = disp / kol;
        if (disp > D) {
            int[] newMas = new int[mas.length-t];
            int[] newMas2 = new int[masi.length];
            System.arraycopy(masi, 0, newMas2, 0, mas.length);
            Arrays.sort(newMas2);
            System.out.println(Arrays.toString(newMas2));
            System.arraycopy(newMas2, t/2, newMas, 0, mas.length - t);
            System.out.println(Arrays.toString(newMas));
            for (int i = 0; i < masi.length; i++)
            {
                int finalI = i;
                boolean contains = IntStream.of(newMas).anyMatch(x -> x == masi[finalI]);
                if (contains == true)
                    System.out.print(masi[i] + " ");
            }
        } else {
            for (int i = 0; i< masi.length; i++)
            {
                System.out.print(masi[i]+ " ");
            }
        }
    }
}