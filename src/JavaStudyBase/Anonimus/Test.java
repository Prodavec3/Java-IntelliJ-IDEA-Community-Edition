package JavaStudyBase.Anonimus;

/**
 * Создавать класс для переопределения одного метода и чтобы использовать его 1 раз не целесообразно
 * В данном случае можно убрать OtherAnimal и оставить только Animal
 */


public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();

        OtherAnimal otherAnimal = new OtherAnimal();
        otherAnimal.eat();

        Animal animal12 = new Animal() { // Переопределяем тут новый объект класса, но переопределять 1 метод не полезно
            @Override
            public void eat() {
                System.out.println("Other Anonim animal eat...");
            }
        };
        animal12.eat();
    }
}

class Animal{
    public void eat(){
        System.out.println("Animal is eating...");
    }
}

class OtherAnimal extends Animal{
    public void eat(){
        System.out.println("other animal is eating...");
    }
}