import java.util.ArrayList;
import java.util.Scanner;

public class Calculate<persons> {
    static Scanner scanner = new Scanner(System.in);
    ArrayList<String> allProducts = new ArrayList<>();
    double totalCoast = 0.0;
    String productName = " ";
    double productCost = 0.0;
    double finalResult = 0.2f;

    void calculate(int persons) {
        while (true) {

            System.out.println("Введите название товара");
            productName = scanner.next();
            allProducts.add(productName);

            while (true) {
                System.out.println("Введите стоимость товара");
                if (scanner.hasNextDouble()) {
                    productCost = scanner.nextDouble();
                    if (productCost < 0) {
                        System.out.println("Цена не может быть отрицательная");
                        continue;
                    }

                    totalCoast += productCost;
                    break;


                } else {
                    System.out.println("Введены не корректные данные");
                    scanner.next();
                }
            } System.out.println("Товар успешно добавлен, нужно ли добавить еще товар? - Если нужно пишите \"Да\". Если нет - напишите \"Завершить\"");
            while (true) {

                String stopWord = scanner.next();
                if (stopWord.equalsIgnoreCase("Завершить")) {
                    System.out.println("Готово, больше товары добавить нельзя");
                    System.out.println("Вы добавили:" + "\n" + allProducts + " на сумму " + totalCoast + getRUB(totalCoast));
                    return;


                } else if (stopWord.equalsIgnoreCase("Да")) {
                    break;

                } else {
                    System.out.println("Введите коректную команду");

                }
            }
        }
    }

    void printBil(int persons) {
        finalResult = totalCoast / persons;
        finalResult = Math.floor(finalResult);
        if (finalResult % 100 == 0) {
            System.out.println("Каждый должен заплатить по: " + String.format("%.2f", finalResult) + getRUB(finalResult));
        } else if (finalResult >= 5) {
            System.out.println("Каждый должен заплатить по: " + String.format("%.2f", finalResult) + getRUB(finalResult));
        } else {
            System.out.println("Каждый должен заплатить по: " + String.format("%.2f", finalResult) + getRUB(finalResult));
        }
    }

    public String getRUB(double rub) {
        String[] plural = {" рубль", " рубля", " рублей"};

        int rubInt = (int) rub;
        int num100 = rubInt % 100;
        int num10 = rubInt % 10;

        if (num100 > 10 && num100 < 20) return plural[2];
        if (num10 > 1 && num10 < 5) return plural[1];
        if (num10 == 1) return plural[0];

        return plural[2];
    }
}
