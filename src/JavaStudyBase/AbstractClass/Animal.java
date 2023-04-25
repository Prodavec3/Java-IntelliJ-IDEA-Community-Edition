package JavaStudyBase.AbstractClass;

public abstract class Animal { //abstr - от класса нужно наследоваться, дополнять, но не создавать объекты
    public  void eat(){
        System.out.println("Iam eating");
    }
    public abstract  void makeSound(); // только в абстрактных классах можно создавать абстрактные методы
    /**
     * Все будут издавать звуки, но все по-разному
     */
}
