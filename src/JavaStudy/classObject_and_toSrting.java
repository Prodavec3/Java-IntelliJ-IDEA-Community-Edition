package JavaStudy;

public class classObject_and_toSrting {
    public static void main(String[] args) {
        Human h1 = new Human("Олег", 25);
        System.out.println(h1); // выведет JavaStudy.Human@5f184fc6, все объекты наследуются от класса Object
        h1.toString(); //метод из класса Object, возвращает хэш - код объекта созданного
        /**
         * хэш код - уникальный код объекта , pringln, print - вызывают toString, т.е print == toString
         */
    }
}
class Human{
    private String name;
    private  int age;
    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }
    /**
     * можно переопределить метод в своем классе, например toString
     */
    public String toString(){
        return name + ", "+age;
    }
}
