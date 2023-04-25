package JavaStudyBase.Exeptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Checked (Compile time exception) = исключетельные случаи в работе программы
 * и unchecked (Runtime exception) исключения
 * Во время компилирования или во время работы
 */
public class Exceptions3 {
    public static void main(String[] args) {
        File file = new File("test");
        try {
            Scanner scanner = new Scanner(file); // это чекд эксепшн, т.к без обработки данных исключений программа не скомпилируется
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        /**
         * Runtime exception не должен быть в программе, он даже не подразумевается - это ошибка в работе программы, ее не надо
         * обрабатывать. Это именно ошибка кода.
         */

        int a = 1 / 0; // unchecked exception, программа скомпилируется и запустится, но дальше будет ошибка как только программа
                        // досюда дойдет

        String name = null; // в переменной лежит null
        name.length(); // на ничто вызываем метод класса стринг - NullPointerException

        int[] arr = new int[2];
        System.out.println(arr[2]); // у вас всего 2 элемента, обращаемся к 3ему, Array Exception
    }
}

/**
 * все исключения в Java наследуются от Class Exception
 * можно обработать RuntimeException, но это не имеет смысл
 */
