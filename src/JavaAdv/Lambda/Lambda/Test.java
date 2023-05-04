package JavaAdv.Lambda.Lambda;

/**
 * Появились в 8 версии Java.
 * Способ передать кусок кода в метод.
 * Позволяют нам обойтись без использования анонимных классов (позволяют делать удобно то что мы и раньше делали)
 * Для передачи кода в метод или конструктор.
 *
 * То есть реализация анаонимного класса, где 1 метод -> используется лямбда выражение
 *
 * Аргументы () и тело лямбда выражения {}
 *
 *
 */
interface  Executable {
    void execute();
}

class Runner {
    public void run(Executable e){
        System.out.println("Hello");
    }
}

class ExecutableImplementation implements Executable {

    @Override
    public void execute() {
        System.out.println("Hello");
    }
}

public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hello"));

        Runner runner = new Runner();
        runner.run(new ExecutableImplementation()); // 1 вариант
        runner.run(new Executable() { // 2 вариант
            @Override
            public void execute() {
                System.out.println("Hello");
            }
        });

        runner.run(() -> System.out.println("Hello")); // 3 вариант
    }
}
