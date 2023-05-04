package JavaAdv.Lambda.Lambda;

/**
 * 2 метода реализовать в лямбда выражениях нельзя, только 1.
 */
interface Executable2 {
    //int execute2(int x);
    int execute2(int x, int y);
}

class Runner2 {
    public void run (Executable2 e){
        //int a = e.execute2(10);
        int a = e.execute2(10, 20);
        System.out.println(a);
    }
}

public class Test2 {
    public static void main(String[] args) {

        Runner2 runner2 = new Runner2();
        /**
         * Скобки можем не писать, т.к 1 аргумент, int можем не писать т.к java знает
         * из интерфейса что передается int
         */
        //runner2.run(x -> x + 5);
        /**
         * Передать переменную в лямбду можно, если только оно final, либо не менялось
         * после объявления
         *
         * У лямбда выражений нет соей области видимости (у методов есть)
         * ее область видимости там где она создана (такая же как и у внешнего метода)
         */
        int a = 1;
        // a = 2 нельзя изменять
        runner2.run((x, y) -> x + y + a);
    }
}
