package JavaStudyBase;

public class Nasledovanie {
    public static void main(String[] args) {
        Animal_nasledovanie animal = new Animal_nasledovanie();
        animal.eat();
        animal.sleep();
        /**
         * Дочерний класс вызывает методы из родительского, однако он может иметь и свои
         */
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
        dog.voice();
        dog.eat(); // Собака ест
        animal.eat(); // Животное ест

        dog.showname();
    }
}
