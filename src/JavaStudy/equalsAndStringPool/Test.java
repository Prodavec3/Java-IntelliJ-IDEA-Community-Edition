package JavaStudy.equalsAndStringPool;

public class Test {
    public static void main(String[] args) {
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
