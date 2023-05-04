package JavaAdv.Lambda.MethodsSpecLambda;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        /**
         * в массиве/листе каждое число х2 хотим сделать
         */
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();

        fillArr(arr);
        fillList(list);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

//        for(int i = 0; i < 10; i++){
//            arr[i] = arr[i] * 2;
//            list.set(i, list.get(i) * 2);
//        }
        //map берет каждый элемент из набора данных и сопоставляет
        arr = Arrays.stream(arr).map(a -> a * 2).toArray(); // На выходе поток в случае с целочисленным массивом
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());
        /**
         * То есть мы берем массив, поток из элементов, с помощью мап сопоставляем элементы
         */

        // map method
        int[] arr1 = new int[10];
        fillArr(arr1);
        arr1 = Arrays.stream(arr).map(a -> 3).toArray();
        arr1 = Arrays.stream(arr).map(a -> a + 1).toArray();

        System.out.println();
        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        // filter method
        // Фильтрует данные (если нужно подмножество из множества)
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArr(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray(); // Проверка на четность
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println("\nТолько четные");
        System.out.println(Arrays.toString(arr2));
        System.out.println(list2);

        // forEach - перебор каждого элемента массива
        System.out.println("\nforEach: ");
        Arrays.stream(arr2).forEach(System.out::println);
        list2.stream().forEach(System.out::println);

        // reduce - уменьшение (сжимает набор данных в 1 элемент)
        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillArr(arr3);
        fillList(list3);

        /**
         * [1,2,3]
         * acc=1, b=2 (т.к не указали значение аккумулятора он берет 1 элемент)
         * acc = 1 + 2 = 3
         * b=3
         * acc = 3 + 3 = 6
         * b = 4
         * acc = 6 + 4 и тд
         *
         * Если не укажем значение аккумулятора
         * Аккумулятор берет 1й элемент
         * Итерация начинается со второго элемента
         *
         * Иногда лучше использовать цикл, нежели reduce
         * Его используем если нужна сумма всех элементов, например
         * (простые операции)
         */
        int summ1 = Arrays.stream(arr3).reduce(Integer::sum).getAsInt();
        int summ2 = list3.stream().reduce((acc, b) -> acc * b).get();

        System.out.println("Сумма: "+summ1);
        System.out.println("Произведение: " + summ2);

        /**
         * Можно вызывать несколько методов друг за другом
         */
        int[] arr4 = new int[10];
        fillArr(arr4);
        int[] newArray = Arrays.stream(arr4).filter(a -> a % 2 != 0).map(a -> a * 2).toArray();
        System.out.println("Взяли только нечетные числа [0;10] и умножили на 2: ");
        System.out.println(Arrays.toString(newArray));

        /**
         * На Set тоже можем вызывать эти методы
         */
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        System.out.println("Set до: "+set);

        set = set.stream().map(a -> a * 5).collect(Collectors.toSet());

        System.out.println("Set после: "+set);
    }

    private static void fillList(List<Integer> list){
        for (int i = 0; i < 10; i++){
            list.add(i+1);
        }
    }

    private static void fillArr(int[] arr){
        for (int i = 0; i < 10; i++){
            arr[i] = i+1;
        }
    }
}
