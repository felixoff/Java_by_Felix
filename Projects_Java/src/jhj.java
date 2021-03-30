import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jhj {


        static final int R = 3;

        static final int C = 3;



        // функция для обмена двух строк

        // матрицы

        static void swap(int mat[][],

                         int row1, int row2, int col)

        {

            for (int i = 0; i < col; i++)

            {

                int temp = mat[row1][i];

                mat[row1][i] = mat[row2][i];

                mat[row2][i] = temp;

            }

        }



        // Функция для отображения матрицы

        static void display(int mat[][],

                            int row, int col)

        {

            for (int i = 0; i < row; i++)

            {



                for (int j = 0; j < col; j++)



                    System.out.print(" "

                            + mat[i][j]);



                System.out.print("\n");

            }

        }



        // функция для нахождения ранга матрицы

        static int rankOfMatrix(int mat[][])

        {



            int rank = C;



            for (int row = 0; row < rank; row++)

            {



                // Прежде чем мы посетим текущий ряд

                // 'row', мы уверены, что

                // mat [row] [0], .... mat [row] [row-1]

                // равны 0



                // Диагональный элемент не ноль

                if (mat[row][row] != 0)

                {

                    for (int col = 0; col < R; col++)

                    {

                        if (col != row)

                        {

                            // Это делает все записи

                            // текущего столбца

                            // как 0 кроме записи

                            // 'mat [row] [row]'

                            double mult =

                                    (double)mat[col][row] /

                                            mat[row][row];



                            for (int i = 0; i < rank; i++)



                                mat[col][i] -= mult

                                        * mat[row][i];

                        }

                    }

                }



                // Диагональный элемент уже равен нулю.

                // Возникают два случая:

                // 1) Если под ним есть строка

                // с ненулевой записью, затем поменять местами

                // эта строка с этой строкой и процессом

                // этот ряд

                // 2) Если все элементы в текущем

                // столбец под mat [r] [row] равен 0,

                // затем удаляем этот столбец

                // меняем его на последний столбец и

                // уменьшение количества столбцов на 1.

                else

                {

                    boolean reduce = true;



                    // Находим ненулевой элемент

                    // в текущем столбце

                    for (int i = row + 1; i < R; i++)

                    {

                        // Поменяем строку с ненулевым

                        // элемент с этой строкой.

                        if (mat[i][row] != 0)

                        {

                            swap(mat, row, i, rank);

                            reduce = false;

                            break ;

                        }

                    }



                    // Если мы не нашли ни одной строки с

                    // ненулевой элемент в текущем

                    // columnm, тогда все значения в

                    // этот столбец равен 0

                    if (reduce)

                    {

                        // Уменьшаем количество столбцов

                        rank--;



                        // Копируем последний столбец сюда

                        for (int i = 0; i < R; i ++)

                            mat[i][row] = mat[i][rank];

                    }



                    // Обработка этой строки снова

                    row--;

                }



                // Раскомментируем эти строки, чтобы увидеть

                // отображение промежуточных результатов (mat, R, C);

                // printf ("/ n");

            }



            return rank;

        }



        // Код драйвера

        public static void main (String[] args) throws IOException {
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            String[] reader2 = inp.readLine().split(" ");
            Integer k = Integer.parseInt(reader2[0]);
            Integer n = Integer.parseInt(reader2[1]);
            int[][] mas = new int[k][n];
            for (int i = 0; i < k; i++) {
                String[] readeri = inp.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    Integer elem = Integer.parseInt(readeri[j]);
                    mas[i][j] = elem;
                }
            }
            System.out.print("Rank of the matrix is : "

                    + rankOfMatrix(mas));

        }

    }