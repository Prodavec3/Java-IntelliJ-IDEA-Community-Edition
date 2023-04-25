package JavaStudyBase.Wildcard;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Animal> listOfAnimal = new ArrayList<>();
        listOfAnimal.add(new Animal(1));
        listOfAnimal.add(new Animal(2));

        List<Dog> listOfDogs = new ArrayList<>();
        listOfDogs.add(new Dog());
        listOfDogs.add(new Dog());

        test(listOfAnimal);
        // вызовет ошибку - test(listOfDogs);
        // Но если мы будем использовать wildcard -> List<?> , то мы сможем передать любой параметр
        test(listOfDogs);
    }

    private  static void test(List<? extends  Animal> list){ /** теперь мы рассматриваем как лист каких-либо объектов,
     и далее мы пишем extends Animal, что говорит о том, что мы можем использовать либо Animal, либо дочерние классы
     а если вместо extends напишем super, то Animal и его родители
     Object
      Animal
       Dog
     */
        for (Animal animal : list){
            System.out.println(animal + "говорит: ");
            animal.eat();
        }
    }
}
