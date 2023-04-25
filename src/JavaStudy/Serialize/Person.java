package JavaStudy.Serialize;

import java.io.Serializable;

public class Person implements Serializable {
    /**
     * Допустим, не хотим сериализовывать поле name (не хотим тратить память, оно нам не надо и тд)
     * для этого мы указываем transient - т.к это поле String - то при записи просто оно будет хранить в себе
     * ссылку на null - вместо имени выдаст null на выводе, а если transient int (т.е для примитивного типа)
     * - будет не null, а 0 (т.е значение по-умолчанию для int, для long, byte и тд)
     *
     * Если мы реализуем интерфейс Serializable в нашем классе и не создаем SerialVersionUID то будет предупреждение
     * если у нас включено -> Preferences -> Editor -> Inspections -> Serialization issues
     * -> Serializable class without 'serialVersionUID' но в этой ВЕРСИИ ТАКОГО НЕТ
     *
     * Если давно создали и записали файл, потом поменяли класс (добавили поля и тд и тп) и далее мы хотим считать объект класса
     * т.е класс был другим, а теперь он поменялся и если мы запишем в этот файл - классы не одинаковые, а значит и объекты не одинаковые
     * для этого и используем SVUID. После изменения можно снова сгенерировать SVUID и он будет другим, т.к структура класса другая
     * Тот объект класса который мы записали в файл - объект другого класса - класс поменялся т.к разный SVUID стал.
     * Поэтому когда есть это поле и мы вносим изменения - данное поле меняем и тем самым исключаем ситуацию
     * когда туда записываем старый объект в новый. Сейчас это автоматически происходит.
     */

    private int id;
    private transient String name;
    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return id + " : " + name;
    }
}
