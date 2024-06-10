import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счет");
        int persons;
        while (true) {
            if (scanner.hasNextInt()) {
                persons = scanner.nextInt();
                if (persons == 1) {
                    System.out.println("Вам придется полностью оплатить счет");
                } else if (persons <= 0) {
                    System.out.println("Ошибка, введите корректное значение");
                } else if (persons > 1) {
                    break;
                }
            }else {
                System.out.println("Введены не корректные данные");
                scanner.next();
            }
        }
        Calculate calculate = new Calculate();
        calculate.calculate(persons);
        calculate.printBil(persons);
    }
}
