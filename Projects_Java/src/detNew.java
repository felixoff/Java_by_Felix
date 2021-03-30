import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class detNew {
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
            Determin dd = new Determin(mas);
            dd.getValue();
        }
    }
    //=================
    class Determin {
        private long summ;

        public Determin(long[][] matrix) {
            getReduction(matrix, 1);
        }


        public void getValue() {
            System.out.println(this.summ);
        }


        private void getReduction(long [][] subMinor, double elemParentMinor) {
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
                    long paramForSub = (long) (Math.pow(-1,c+2) *subMinor[0][c]*elemParentMinor);
                    getReduction(tmpMinor, paramForSub);
                }
            }
            else
                this.summ += elemParentMinor * subMinor[0][0];
        }

    }
