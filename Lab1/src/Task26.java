import java.util.Scanner;

/*
 * Задание 26.
 * Для каждого числа из заданной последовательности натуральных чисел
 * с чётной суммой цифр получить число, записанное цифрами исходного
 * числа в обратном порядке.
 *
 * Например: 1234 -> сумма цифр 10 (чётная) -> 4321.
 */
public class Task26 {

    // сумма цифр числа
    static int digitSum(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // число, записанное цифрами исходного в обратном порядке
    static long reverse(long n) {
        long result = 0;
        while (n > 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество чисел в последовательности: ");
        int count = in.nextInt();

        long[] numbers = new long[count];
        System.out.println("Введите " + count + " натуральных чисел:");
        for (int i = 0; i < count; i++) {
            numbers[i] = in.nextLong();
        }

        System.out.println("\nРезультат:");
        int processed = 0;
        for (long number : numbers) {
            if (number <= 0) {
                System.out.println("  " + number + " — не натуральное число, пропущено");
                continue;
            }

            int sum = digitSum(number);
            if (sum % 2 == 0) {
                System.out.println("  " + number + " (сумма цифр " + sum + ", чётная) -> " + reverse(number));
                processed++;
            } else {
                System.out.println("  " + number + " (сумма цифр " + sum + ", нечётная) — не преобразуется");
            }
        }

        System.out.println("Преобразовано чисел: " + processed);

        in.close();
    }
}