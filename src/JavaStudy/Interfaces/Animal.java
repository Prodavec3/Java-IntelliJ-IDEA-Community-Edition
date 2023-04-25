package JavaStudy.Interfaces;

public class Animal implements Info{
    /**
     * Разграничивается класс и если у нас был бы такой же класс вне папки, ничего страшного не было бы
     *
     * implements означает что мы должны реализовать методы из интерфейса Info, в данном случае showInfo
     */
    public int id;

    public void sleep(){
        System.out.println("Спит");
    }

    public Animal(int id){
        this.id = id;
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " +id);
    }
}
