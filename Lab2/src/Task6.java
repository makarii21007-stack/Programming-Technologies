import java.util.Scanner;

/*
 * Задание 6.
 * Для каждой строки матрицы найти сумму элементов матрицы, расположенных
 * между первым и вторым положительными элементами каждой строки.
 * Отсортировать строки матрицы по этой сумме. Строки, в которых все
 * элементы отрицательные — удалить. Строки у которых только один
 * положительный элемент — удалить.
 */
public class Task6 {

    // индекс первого положительного элемента, начиная с позиции from (или -1)
    static int findPositive(int[] row, int from) {
        for (int j = from; j < row.length; j++) {
            if (row[j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // сумма элементов между первым и вторым положительными (-1 если второго нет)
    static int[] positions(int[] row) {
        int first = findPositive(row, 0);
        int second = (first == -1) ? -1 : findPositive(row, first + 1);
        return new int[]{first, second};
    }

    static int sumBetween(int[] row, int first, int second) {
        int sum = 0;
        for (int j = first + 1; j < second; j++) {
            sum += row[j];
        }
        return sum;
    }

    static void printMatrix(int[][] a) {
        for (int[] row : a) {
            for (int x : row) {
                System.out.print(x + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите n: ");
        int n = in.nextInt();

        int[][] a = new int[n][n];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }

        // считаем, сколько строк останется (минимум два положительных элемента)
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (positions(a[i])[1] != -1) {
                count++;
            }
        }

        // копируем подходящие строки и считаем для них суммы
        int[][] rows = new int[count][];
        int[] sums = new int[count];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int[] p = positions(a[i]);
            if (p[1] != -1) {
                rows[k] = a[i];
                sums[k] = sumBetween(a[i], p[0], p[1]);
                k++;
            }
        }

        // сортировка строк по сумме (по возрастанию)
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (sums[j] > sums[j + 1]) {
                    int tmpSum = sums[j];
                    sums[j] = sums[j + 1];
                    sums[j + 1] = tmpSum;

                    int[] tmpRow = rows[j];
                    rows[j] = rows[j + 1];
                    rows[j + 1] = tmpRow;
                }
            }
        }

        System.out.println("\nРезультат:");
        if (count == 0) {
            System.out.println("Все строки удалены.");
        } else {
            for (int i = 0; i < count; i++) {
                for (int x : rows[i]) {
                    System.out.print(x + "\t");
                }
                System.out.println("| сумма = " + sums[i]);
            }
        }

        in.close();
    }
}
