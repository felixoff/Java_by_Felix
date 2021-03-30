import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class tutorial {
    public static void main(String[] args) throws IOException{
   //     System.out.println("Hello world");
      //  Scanner in =new Scanner(System.in);
     //   int b = in.nextInt();
    //   System.out.println(b);
    //    BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
    //    int c = Integer.parseInt(buffRead.readLine());
      //  System.out.println(c);
   //     int a = System.in.read();
   //     System.out.println(a);
    //    System.out.printf("\\\\\\\\\\\"\"\" kdkd");
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
       // System.out.printf("%.2f", (a % b));
     //   System.out.printf("%.0f", Math.ceil(a / 3.0));
       int [] mas = new int[n];
        int buf = 0;
        for (int i= 0 ; i < n; i++)
            mas[i] = in.nextInt();
        for (int i = 0; i< n; i++)
        {
            for (int j = 0; j < n-1; j++) {
                if (mas[j+1] < mas[j]) {
                    buf = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = buf;
                }
            }
        }
        Arrays.sort(mas);
        System.out.println(Arrays.toString(mas));
        for (int i : mas) System.out.print(i + " ");
     //   int i = 0;
     //   while(i++ < a)
      //      System.out.print("[");
     //   while(i-- > 1)
         //   System.out.print("]");
    }
}
