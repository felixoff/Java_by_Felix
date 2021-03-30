import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class rankOfMatrix {
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
        Determin2 dd = new Determin2(mas);
        dd.getValue();
    }
}
class Determin2 {
    private long summ;

    public Determin2(long[][] matrix) {
        this.summ = getReduction(matrix);
    }


    public void getValue() {
        System.out.println(this.summ);
    }


    private long getReduction(long [][] subMinor) {
        if (subMinor.length > 1){
            long [][] tmpMinor = new long[subMinor.length - 1][subMinor[0].length - 1];
            for (int c = 0; c < subMinor[0].length; c++) {
                for (int i = 1; i < subMinor.length; i++) {
                    for (int j = 0; j < subMinor[0].length; j++) {
                        if (j < c)
                            tmpMinor[i - 1][j] = subMinor[i][j];
                        else if (j > c)
                            tmpMinor[i - 1][j - 1] = subMinor[i][j];
                    }
                }
                this.summ += (long) (Math.pow(-1,c+2) *subMinor[0][c]*
                        getReduction(tmpMinor));
            }
        }
        else
            return (subMinor[0][0]);
        return this.summ;
    }
}

//5 5
 //       100 48 -29 2 4
  //      94 22 21 30 3
    //    3 1 5 6 -22
  //      2 5 99 0 12
   //     -4 4 8 1 9
   //     378848714286