package JavaStudyBase.Exeptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exeptions {
    public static void main(String[] args){ // можно к методу добавить - throws FileNotFoundException {
        File file = new File("TestFile"); // путь до файла указывается
        /**
         * Допустим, такого файла нет по установленному пути и необходимо обрабатывать эту ошибку
         */

        try {
            Scanner scanner = new Scanner(file);
            System.out.println("А если тут ошибка появляется далее код в блоке try уже не работает");
        } catch (FileNotFoundException e) { // Переменная объект FNFE - выбрасывается при ошибке
            System.out.println("И можно вывести что-то свое");
            throw new RuntimeException(e);
        }
        System.out.println("После блока try/catch код выполняется далее");

        /**
         * Вызовем readFile который с добавленным throws, и без throws FNFE в main работать не будет
         * Т.е обработка исключений делигируется вверх и теперь можем обработать исключение
         * либо через try/catch, либо добавить сигнатуру FNFE
         */
        //readFile();
        try {
            readFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile() throws FileNotFoundException {
        File file = new File("TestFile");
        Scanner scanner = new Scanner(file);
    }
}
/**
 * Обрабатывать исключения следует так, чтоб не выдавало красных ошибок и пользователю было понятно как исправить
 */
