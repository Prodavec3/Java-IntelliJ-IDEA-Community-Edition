package JavaStudyBase.Recursiya;

/**
 * Вызов метода в теле этого же метода
 */
public class Test {
    public static void main(String[] args) {
        //someMethod();
        counter(10);
    }

    private static void someMethod(){
        System.out.println("Hello");
        someMethod();
    } // StackOverFlow выдаст ошибку, т.к метод будет работать бесконечно

    /**
     * Информация о вызовах методов хранится в стеке.
     * размер памяти под стек выделяется ограниченное количество
     *
     * чтобы рекурсия была полезна - необходимо условие выхода
     */

    private static void counter(int n){
        if (n == 0){
            return;
        }
        System.out.println("Число: "+n);
        counter(n-1); // рекурсия ждет последующих выполнений итераций
    }
}
