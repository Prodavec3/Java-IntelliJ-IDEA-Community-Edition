package JavaStudy.Serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) {
        try { // Можем написать так
            /**
             * try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("People.bin")))
             * и тогда 16 и 17 строка не нужны и закрытие потока тоже (51)
             */
            FileInputStream fis = new FileInputStream("People.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Person person1 = (Person) ois.readObject(); // Получаем Object и переводим в -> Person
            Person person2 = (Person) ois.readObject();

            /**
             * Получаем количество элементов в массиве, и далее for достаем каждый элемент в массив people
             */
            int personCount = ois.readInt();
            Person[] people = new Person[personCount];
            for (int i = 0; i < personCount; i++){
                people[i] = (Person) ois.readObject();
            }

            /**
             * Получаем массив как объект, если нас не устраивает получать объекты массива через цикл и поочередно
             * и этот способ проще, более короткий и более предпочтительней
             * но по эффективности одинаковы
             */
            Person[] people1 = (Person[]) ois.readObject();

            System.out.println(person1);
            System.out.println(person2);

            System.out.println("Вывели массив через int и Object");
            System.out.println(Arrays.toString(people)); // Выводим элементы массива через метод toString в строку
            System.out.println("Вывели массив как целиковый Object");
            System.out.println(Arrays.toString(people1));

            /**
             * Закрывать поток мы можем автоматически, не вводя ois.close()
             * OIS реализует интерфейс Closable => мы может использовать try with resources
             */

            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) { // если нет объектов класса у получателя такого как Person
            throw new RuntimeException(e);
        }

    }
}
