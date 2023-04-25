package JavaStudy.Enum;

/**
 * new Class и там выбрать Enum
 */
public enum Animal {
    DOG("Собака"), CAT("Кошка"), FROG("Лягушка"); // Если не стд конструктор - можем указать параметры
    //это то же самое что и new Dog("Собака")
    /**
     * можно создать конструктор
     * и если в энаме появляется что-то помимо самих членом перечислений - ставим ;
     *
     * В конструкторе, допустим, укажем перевод
     */
    private String translation;
    Animal(){

    }
    private Animal(String translation){ // конструктор в Enum по-умолчанию private
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }

    /**
     * Можем переопределить стд метод toString()
     */
    @Override
    public String toString() {
        return "Перевод на русский язык" + translation;
    }
}
