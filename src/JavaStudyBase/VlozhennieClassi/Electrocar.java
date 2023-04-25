package JavaStudyBase.VlozhennieClassi;

/**
 * Вложенные классы
 *
 * Классы мы можем создавать внутри других классов, рядом с классом, внутри методов
 * 1) нестатический вложенный класс
 * 2) статический вложенный класс
 * 3) вложенный класс, который находится в методе
 */
public class Electrocar {
    private  int id;
    //

    // Нестатический вложенных класс - относятся к объекту (они имеют доступ к полям объекта)
    // нужны для того, чтобы упростить объект электрокар (если вся логика была бы прописана в одном классе - был бы перегружен)
    // используются чаще всего с мод д private
    private class Motor{ // внутри элеткромашины есть мотор
        public void startMotor(){
            System.out.println("Motor" + id + "is starting.");
        }
    }

    // статический вложенный класс, чаще всего публичный, доступ к полям объекта не имеет (т.е id не видит),
    // но любой другой static параметр увидит
    // Нужен для группировки классов. Связывает их только логика. Нужны для доступа извне.
    public static class Battery{
        public void charge(){
            System.out.println("Battery is charging...");
        }
    }

    // вложенный класс в методе

    public Electrocar(int id) {
        this.id = id;
    }

    public void start(){
        Motor motor = new Motor();
        motor.startMotor();
        /**
         * Таким образом обращаемся к нестатическому вложенному классу
         * Он нужен для сложного объекта класса и когда его можно разделить на несколько подобъектов
         * внутри реализации методов этого объекта будем создаваать подобъекты объекта
         */
        System.out.println("Electrocar " + id + " is starting.");
        final int x = 1;
        class SomeClass{
            public void someMethod(){
                // имеет доступ к переменным метода и нестатическим полям, но требования - переменные метода должны быть
                // константами
                System.out.println(x);
                System.out.println(id);
                // похоже на анонимные классы, но мы не хотим создавать анонимный класс, а хотим полноценный
            }
        }

        SomeClass someObject = new SomeClass();
        test(someObject);
    }
    private void test(Object object){

    }
}
