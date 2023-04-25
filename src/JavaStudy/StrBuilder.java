package JavaStudy;

public class StrBuilder {
    public static void main(String[] args) {
        StringBuilder strBuilder = new StringBuilder("New string");
        strBuilder.append(" добавление к уже существующей строке");
        strBuilder.append(" вместо создания конкатинации строк.").append(" + можно еще и так");
        System.out.println(strBuilder);
        System.out.printf("String, %s строка, %d цифра, %f float", "str", 2, 2.5);
        System.out.println();
        System.out.printf("Число %10d \n", 532);
        // % ширина числа
        // если ставим минус, то просто число оказывается табулировано слева, а так справа
        // %0.2d - 2 знака после запятой, при чем он округляет, а не отрезает хвост
        // \n перенос на новую строку
    }
}
