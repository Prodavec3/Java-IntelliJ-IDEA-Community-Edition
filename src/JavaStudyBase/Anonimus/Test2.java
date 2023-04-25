package JavaStudyBase.Anonimus;

interface AbleToEat{
    public void eat();
}

/* class Animal2 implements AbleToEat{
    @Override
    public void eat() {
        System.out.println("eat");
    }
} */

public class Test2 {
    public static void main(String[] args) {
        /*AbleToEat ableToEat = new Animal2();
        ableToEat.eat();*/
        AbleToEat ableToEat = new AbleToEat() {
            @Override
            public void eat() {
                // тут мы сами реализуем метод eat при создании объекта интерфейса
                System.out.println("Someone is eating...");
            }
        };
        ableToEat.eat();
    }
}
