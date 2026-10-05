import java.util.Scanner;

/*
 * Задание 16.
 * В матрице найти минимальный элемент и переместить его на место
 * заданного элемента путем перестановки строк и столбцов.
 */
public class Task16 {

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

        System.out.print("Введите строку заданного элемента (с 1): ");
        int targetRow = in.nextInt() - 1;
        System.out.print("Введите столбец заданного элемента (с 1): ");
        int targetCol = in.nextInt() - 1;

        // поиск минимального элемента
        int minRow = 0;
        int minCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] < a[minRow][minCol]) {
                    minRow = i;
                    minCol = j;
                }
            }
        }
        System.out.println("Минимальный элемент: " + a[minRow][minCol]);

        // перестановка строк
        int[] tmpRow = a[minRow];
        a[minRow] = a[targetRow];
        a[targetRow] = tmpRow;

        // перестановка столбцов
        for (int i = 0; i < n; i++) {
            int tmp = a[i][minCol];
            a[i][minCol] = a[i][targetCol];
            a[i][targetCol] = tmp;
        }

        System.out.println("\nРезультат:");
        printMatrix(a);

        in.close();
    }
}