package JavaStudyBase;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        String str = "строка в переменной";
        int intCount = 5;
        float flCount = 0.212f;
        System.out.printf("Переменные: \n Строка: %s \n Целое число: %d \n Дробное число с 2 знаками после запятой: %.2f \n", str, intCount, flCount);

        String userStr;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите любую  строку");
        userStr = scanner.nextLine(); // считывает строку, просто next() считывает строку до пробела
        System.out.println("Ваша строка: " + userStr);

        ArrayList<Float> num = new ArrayList<>();
        num.add(2.0f);
        num.add(55.55f);
        num.add(1, 22.4f);




        System.out.println(num.get(1)); // получить элемент по индексу

        for (Float e : num){
            System.out.println(e);
        }

        num.remove(2.0f);
        num.remove(0);
        int size = num.size();
        System.out.println("Элементов: " + size);


        LinkedList<Float> linkedList = new LinkedList<>(); // в () размер
        // привязывает элементы внутри массива друг к другу

        linkedList.add(22.2f);
        // все работает по аналогии с ArrayList

        Test2 test2 = new Test2("Имя", 12, 22.43f);
        /* test2.age = 5;
        test2.name = "Имя";
        test2.week = 22.2f; */


/*        // отлов ошибок в try и вывод ошибки юзеру, т.е остановка try и переход сразу в catch
        try {
            //do smth
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        есть еще один блок finally - он в конце и выполняется в любом случае, может и не быть */
    }
}