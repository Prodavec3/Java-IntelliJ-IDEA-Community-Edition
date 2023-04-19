package JavaStudy;

public class VoshodNishodPreobrazovanie {
    /**
     * Восходящее и нисходящее преобразование
     * Dog наследуется от Animal, но тут объект воспринимаем как его родителя
     * Поэтому восходящее от наследника до родителя
     * восходящее преобразование происходит неявно (java делает это сама)
     *
     * Нисходящее преобразование делаем вручную. Не всегда преобразование это безопасно.
     * Т.к собака это точно животное, но не каждое животное это собака
     */
    Animal_nasledovanie animalNasledovanie= new Dog(); // Upcasting - восходящее преобразование
    Dog dog = new Dog();
    // Animal animal = dog

    // Downcasting
    Dog dog2 = (Dog)animalNasledovanie; // неявно это сделать не получится, поэтому приписываем (Dog)
}
