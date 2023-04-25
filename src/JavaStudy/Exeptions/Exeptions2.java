package JavaStudy.Exeptions;

import java.io.IOException;
import java.util.Scanner;

public class Exeptions2 {
    public static void main(String[] args) throws ScennerException {
        Scanner scanner = new Scanner(System.in);
        /**
         * Если юзер ввел не 0 пусть это будет ошибкой
         */
        while (true) {
            int x = Integer.parseInt(scanner.nextLine());

            if (x==1){
                try {
                    throw new IOException(); // выбросили исключение и поэтому добавляем в сигнатуру метода
                } catch (IOException e) {
                    System.out.println("Пользователь ввел 1");
                    throw new RuntimeException(e); // это сама ошибка, можно ее убрать чтоб пользователь не видел и вывести текст
                }
                // java Exception и смотрим какой тип исключения нужен
            }

            if (x == 0){
                throw new ScennerException("Ты ввел 0");
            }
        }
    }
}
/**
 * Если вдруг нет исключений, которые нам подходят из всего списка, то можно создать свое исключение
 * Например, ScannerException
 */
