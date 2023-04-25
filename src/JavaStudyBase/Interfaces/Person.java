package JavaStudyBase.Interfaces;

public class Person implements Info{
    public String name;
    public Person(String name){
        this.name = name;
    }
    public void sayHello(){
        System.out.println("hello");
    }

    @Override
    public void showInfo() {
        System.out.println("Имя: " + name);
    }
}
