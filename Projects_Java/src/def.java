import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class def {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String mas0 = inp.readLine();
        char[] mas = mas0.toCharArray();
        long arab = 0;
        int kol = 0;
        while (kol < mas.length - 1) {
            if(mas[kol] == 'I' && mas[kol + 1] != 'V' && mas[kol+1] != 'X')
            {
                arab += 1;
                kol++;
                continue;
            }
            else if (mas[kol] == 'X' && mas[kol + 1] != 'L' && mas[kol+1] != 'C')
            {
                arab += 10;
                kol++;
                continue;
            }
            else if (mas[kol] == 'C' && mas[kol + 1] != 'D' && mas[kol+1] != 'M')
            {
                arab += 100;
                kol++;
                continue;
            }
            else if (mas[kol] == 'D')
            {
                arab += 500;
                kol++;
                continue;
            }
            else if (mas[kol] == 'M')
            {
                arab += 1000;
                kol++;
                continue;
            }
            else if (mas[kol] == 'V')
            {
                arab += 5;
                kol++;
                continue;
            }
            else if (mas[kol] == 'L')
            {
                arab += 50;
                kol++;
                continue;
            }
            else if (mas[kol] == 'I' && mas[kol + 1] == 'V')
            {
                arab += 4;
                kol= kol + 2;
                continue;
            }
            else if (mas[kol] == 'I' && mas[kol + 1] == 'X')
            {
                arab += 9;
                kol= kol + 2;
                continue;
            }
            else if (mas[kol] == 'X' && mas[kol + 1] == 'L')
            {
                arab += 40;
                kol= kol + 2;
                continue;
            }
            else if (mas[kol] == 'X' && mas[kol + 1] == 'C')
            {
                arab += 90;
                kol= kol + 2;
                continue;
            }
            else if (mas[kol] == 'C' && mas[kol + 1] == 'D')
            {
                arab += 400;
                kol= kol + 2;
                continue;
            }
            else if (mas[kol] == 'C' && mas[kol + 1] == 'M')
            {
                arab += 900;
                kol= kol + 2;
                continue;
            }
        }
        System.out.println(kol);
        if (kol != mas.length) {
            if(mas[kol] == 'I')
                arab += 1;
            else if (mas[kol] == 'X')
                arab += 10;
            else if (mas[kol] == 'C')
                arab += 100;
            else if (mas[kol] == 'D')
                arab += 500;
            else if (mas[kol] == 'M')
                arab += 1000;
            else if (mas[kol] == 'V')
                arab += 5;
            else if (mas[kol] == 'L')
                arab += 50;
        }
        System.out.println(arab);
    }
}
