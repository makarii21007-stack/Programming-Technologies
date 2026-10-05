import java.util.Scanner;

/*
 * Задание 6.
 * Найти все p-значные числа из заданной последовательности натуральных чисел,
 * в записи которых цифры упорядочены, и подсчитать их количество.
 *
 * Примечание: упорядоченными считаются цифры, образующие неубывающую
 * (например, 1357) или невозрастающую (например, 9642) последовательность.
 */
public class Task6 {

    // количество цифр в числе
    static int digitCount(long n) {
        int count = 0;
        do {
            count++;
            n /= 10;
        } while (n > 0);
        return count;
    }

    // проверка: цифры числа упорядочены (неубывающие или невозрастающие)
    static boolean digitsOrdered(long n) {
        boolean nonDecreasing = true; // слева направо цифры не убывают
        boolean nonIncreasing = true; // слева направо цифры не возрастают

        long cur = n;
        while (cur >= 10) {
            int low = (int) (cur % 10);        // младшая цифра
            int high = (int) ((cur / 10) % 10); // цифра слева от неё
            if (high > low) nonDecreasing = false;
            if (high < low) nonIncreasing = false;
            cur /= 10;
        }
        return nonDecreasing || nonIncreasing;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество чисел в последовательности: ");
        int count = in.nextInt();

        System.out.print("Введите p (количество цифр в числе): ");
        int p = in.nextInt();

        long[] numbers = new long[count];
        System.out.println("Введите " + count + " натуральных чисел:");
        for (int i = 0; i < count; i++) {
            numbers[i] = in.nextLong();
        }

        System.out.println("\nРезультат:");
        int found = 0;
        for (long number : numbers) {
            if (number <= 0) continue; // числа натуральные
            if (digitCount(number) == p && digitsOrdered(number)) {
                System.out.println("  " + number);
                found++;
            }
        }

        if (found == 0) {
            System.out.println("  подходящих чисел нет");
        }
        System.out.println("Количество найденных чисел: " + found);

        in.close();
    }
}