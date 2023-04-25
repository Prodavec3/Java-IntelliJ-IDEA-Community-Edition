package JavaStudyBase;

public class Dog extends Animal_nasledovanie{
    public void voice(){
        System.out.println("Лай собаки");
    }

    /**
     * Переопределяем метод из родительского в дочернем
     */
    public void eat(){
        System.out.println("Собака ест");
    }
    public void showname(){
        System.out.println(name);
    }
}
