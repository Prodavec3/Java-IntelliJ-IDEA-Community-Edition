package JavaStudy.equalsAndStringPool;

public class Test {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "Hello123".substring(0, 5); // 0 это H, 5 это 1, метод режет строку, правая граница не включитель
        System.out.println("Сравнение через ==: "+ str2 == str3); // false, т.к мы сравниваем не через equals, ссылки на объекты разные
        /**
         * нам выдаст сразу true, хотя при сравнении объектов было false
         * Оно рабоатет потому что есть StringPool - строка помещается в пул и указатель ссылается на эту строку
         * если второй раз мы создает такую же строку, то java ссылает указатель str2 на тот же объект, т.е ссылки str1=str2
         * т.о java экономит память и проверяет есть такая строка в пуле или нет
         *
         * Однако если String str1 = new String() создаем таким образом - StringPool срабатывать не будет => str1 != str2
         */
        System.out.println("Сравнение одинаковых строк: " + str1.equals(str2));

        int x = 1;
        int y = 2;
        System.out.println(x == y); //true, также double и тд
        Animal animal1 = new Animal(1);
        Animal animal2 = new Animal(1);
        System.out.println(animal2 == animal1); // выдаст false
        /**
         * == сравнивает объекты по ссылкам, т.к ссылки разные какие похожие бы ни были объекты будет false,
         * хранятся в разных участках памяти
         *
         * Если хотим сравнить структурно - equals
         * Object object = new Object();
         * object.equals(Object obj);
         */
        System.out.println("Сравнили 2 объекта: " + animal1.equals(animal2));
        // снова false, т.к сравниваем объекты как ссылки, если 29+ строки не прописали
    }
}

class Animal{
    private  int id;
    public Animal(int id){
        this.id = id;
    }

    /**
     * Переопределяем, и если id равны то пусть будет true
     */
    public boolean equals(Object obj){
        Animal otherAnimal = (Animal) obj;
        return this.id == otherAnimal.id;
    }
}
