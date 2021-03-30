import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class stringsAndMas {
    public static void main(String[] args) throws IOException {
        //     Scanner in = new Scanner(System.in);
        //    int n = in.nextInt();
        //  int [] a = new int[n];
        //   for (int i = 0; i<n; i++) a[i] = in.nextInt();
        //  int kol = 0;
        //    for (int i= 0; i < n-1; i++) {
        //       if (a[i] > a[i+1])  {
        //          kol++;
        //     }
        //  }
        //   System.out.print(kol);
        //  if (kol == 0) System.out.print("-1");
        //   String s = in.nextLine()
        //  String s = in.next();
        //   char [] c = s.toCharArray();
        //   for (int i = 0; i<s.length();i++) {
        //    if(c[i] >= 'A' && c[i] <= 'Z')
        //           c[i] += (int)('a'-'A');
        //   }

        //    s = Arrays.toString(c); // 1 способ
        //    System.out.println(s);
        //   String s1 = "";             // 3 способ
        //   for (char i : c) s1 += i;
        // System.out.println(s1);
        //     for ( char i : c) System.out.print(i); // 2й способ
        //     StringBuilder s2 = new StringBuilder();             // 4й способ
        //     for (char i : c) s2.append(i);
        //   System.out.println(s2);
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] m = s.split(" ");
        for (int i = 0; i < m.length; i++) {
            if (m[i].charAt(0) >= 'a' && m[i].charAt(0) <= 'h') System.out.println(m[i]);
        }
    }
}