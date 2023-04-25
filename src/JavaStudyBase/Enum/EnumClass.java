package JavaStudyBase.Enum;

/**
 * Перечисления для своих типов
 * До enum было
 * public static final int DOG = 0;
 * И в методе int animal = DOG;
 *
 * Перечисления удобно использовать в switch(){case}
 */
public class EnumClass {
    enum Type{TYPE1, TYPE2} // большими буквами согласно конвенции



    public static void main(String[] args) {
        Animal animal = Animal.CAT;
        System.out.println(animal.getTranslation()); // через геттер можем вывести перевод
        Animal animal1 = Animal.DOG;
        Type type = Type.TYPE1;
        switch (animal){
            case CAT -> System.out.println("cat");
            case DOG -> System.out.println("d");
            case FROG -> System.out.println("f");
        }



        Season season = Season.WINTER;
        System.out.println(season.getTemperature());

        /**
         * .name() возвращает имя enum'a
         */
        System.out.println(season.name());

        /**
         * Так же можно найти с помощью valueOf элемент перечисления.
         * Используется когда из строки мы хотим получить Enum.
         * Например, пользователь вводит сообщение и мы всю инфу подтягиваем
         */
        Animal userAnimal = Animal.valueOf("Dog");
        System.out.println(userAnimal.getTranslation()); // или получить всю инфу о перечислении например

        /**
         * Порядок возвращает, т.е номер индекса в перечислении методом ordinal()
         */
        Season winter = Season.WINTER;
        System.out.println(winter.ordinal());
    }

}
