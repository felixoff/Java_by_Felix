import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class squareN {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String inp0 = inp.readLine();
        Integer n = Integer.parseInt(inp0);
        double[] mas = new double[n * 2];
        int j = 0;
        double square = 0;
        while (n > 0) {
            String[] inp1 = inp.readLine().split(" ");
            mas[j] = Double.parseDouble(inp1[0]);
            j++;
            mas[j] = Double.parseDouble(inp1[1]);
            j++;
            n--;
        }
        for (int i = 0; i < mas.length - 3; i = i + 2)
        {
            square = square + ((mas[i + 2] -mas[i])*(mas[i+ 3] + mas[i + 1]))/2;
        }
        square = square + ((mas[0] -mas[mas.length - 2])*(mas[1] + mas[mas.length - 1]))/2;
        System.out.println(square);
    }
}

