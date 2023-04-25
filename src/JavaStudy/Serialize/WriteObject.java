package JavaStudy.Serialize;

import java.io.*;

public class WriteObject {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Bob");
        Person person2 = new Person(2,"Mike");

        Person[] people = {new Person(10, "Tom"),
        new Person(11,"Marge"), new Person(12, "Mikel")};
        /**
         * Программа отработает, оперативка очистится, данные пропадут
         * Чтобы потом получить к ним доступ, можно их записать в файл в файловую систему (сериализовать)
         * и потом их прочитать
         *
         * Сначала объект файл аутпут стрим создаем - этот класс и объекты предназначены для записи последовательности байтов в файл
         * т.е этот класс что угодно может записать
         *
         * ObjectOS предназначен для записи именно объектов в файл и ему нужен класс повыше с записью байтов.
         */

        try { // try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("People.bin")))
              // это try with resources , закрывать поток в данном случае не надо будет и 25 26 строки не нужны
            FileOutputStream fos = new FileOutputStream("People.bin"); // Расширение может быть любым, чаще всего bin
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(person1);
            oos.writeObject(person2);

            /**
             * Запись масссива. Получение длины, далее циклом пишем каждый элемент массива
             */
            oos.writeInt(people.length); //длина массива и после пишем объекты
            for(Person person : people){
                oos.writeObject(person);
            }

            /**
             * Либо массив можно записать также как и объект (массив передать как объект)
             */
            oos.writeObject(people);

            oos.close(); // закрываем поток после того как использовали
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
