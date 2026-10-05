import java.util.Scanner;

/*
 * Задание 16.
 * Для каждого числа из заданной последовательности натуральных чисел найти
 * произведение цифр, находящихся на чётных позициях
 * (нумерация позиций идёт справа налево).
 *
 * Позиции нумеруются с 1: самая правая цифра — позиция 1,
 * следующая слева от неё — позиция 2 и т.д.
 * Например, для 1234: чётные позиции занимают цифры 3 и 1, произведение = 3.
 */
public class Task16 {

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
        for (long number : numbers) {
            if (number <= 0) {
                System.out.println("  " + number + " — не натуральное число, пропущено");
                continue;
            }

            long product = 1;
            boolean hasEvenPosition = false;
            int position = 1;

            for (long cur = number; cur > 0; cur /= 10) {
                int digit = (int) (cur % 10);
                if (position % 2 == 0) {
                    product *= digit;
                    hasEvenPosition = true;
                }
                position++;
            }

            if (hasEvenPosition) {
                System.out.println("  " + number + " -> произведение цифр на чётных позициях = " + product);
            } else {
                System.out.println("  " + number + " -> чётных позиций нет (число однозначное)");
            }
        }

        in.close();
    }
}
