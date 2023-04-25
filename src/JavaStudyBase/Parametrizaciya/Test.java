package JavaStudyBase.Parametrizaciya;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /**
         * Дженерики
         *
         * ArrayList - динамический массив
         */
        List animals = new ArrayList();
        Animal animalC = new Animal();
        animals.add("Первый"); // Добавлять можем сколько угодно, пока память на пк не кончится, т.е расширяется динамически
        animals.add("Второй");
        animals.add("Третий");
        animals.add(animalC); // Т.е объект любого класса может лежать в динамическом массиве
        // объект класса List хранит в себе Object, т.е рассматривается как объект класса Object, а не строка, цифра и тд
        String animal = (String) animals.get(1);
        // это все было до 5 версии, поэтому надо (String) писать, т.е даункастить
        /**
         * Но каждый раз доставать из динамического массива и его даункастить неудобно, поэтому в 5+ java
         * была придумана - параметризация класса
         *
         * Как в Java 5 и далее
         */
        List<String> animals2 = new ArrayList<String>();
        animals2.add("Первый");
        animals2.add("Второй");
        animals2.add("Третий");
        // теперь не нужен даункастинг и вместо Object можем сразу получить String, но объекты другого класса уже не положить
        String animal2 = animals2.get(1);

        ///////////////// Java 7 /////////////////////
        List<String> animals3 = new ArrayList<>(); // можно не указывать справа тип параметризации, т.к указан слева
    }
}

class Animal{

}
