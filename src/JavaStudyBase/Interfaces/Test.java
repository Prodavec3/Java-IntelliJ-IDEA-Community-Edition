package JavaStudyBase.Interfaces;

import JavaStudyBase.Interfaces.Package.OneMorePackage.ClassPackage;

/**
 * импорт из пакета Alt+Enter автоматически на классе, который нужно импортировать
 * можно испортировать все классы из пакета
 * import JavaStudy.Interfaces.*
 */
// import JavaStudy.Interfaces.Package.Person;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal(1);
        Person person = new Person("Олег");
        animal.sleep();
        person.sayHello();

        ClassPackage classPackage = new ClassPackage(); // импортирую из пакета

        /**
         * допустим, оба эти класса имеют общее поведение, например, выдают инфу о себе
         * и этот функционал выведем в некий интерфейс
         */
        animal.showInfo();
        person.showInfo();
        /**
         * класс может реализовывать много интерфейсов, но наследовать только 1 класс
         * Если класс реализует какой-либо интерфейс - обязан наследовать методы из этого интерфейса
         * Таким образом мы точно знаем что класс имеет определенные методы согласно интерфейсам
         */

        /**
         * Мы можем так делать потому что данные классы реализуют интерфейс Info + в одном пакете
         * А если выйдем из пакета и попробуем в каком-либо другом классе так сделать, то не получится
         */
        Info infoAnimal = new Animal(2);
        Info infoPerson = new Person("Ольга");
    }
}
