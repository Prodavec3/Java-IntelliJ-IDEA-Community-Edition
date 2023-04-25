package JavaAdv.JCFframework.Set_Mnozhestva;

import java.util.HashSet;
import java.util.Set;

public class Operations {
    public static void main(String[] args) {

        Set<Integer> hashSet1 = new HashSet<>();
        Set<Integer> hashSet2 = new HashSet<>();

        for (int i = 0; i < 10; i++){
            hashSet1.add(i);
            hashSet2.add(i+2);
            hashSet1.add((int)(Math.random() * 600));
            hashSet2.add((int)(Math.random() * 400));
        }

        // union - объединение множеств
        Set<Integer> union = new HashSet<>(hashSet1); // Создадим union с теми же эл. что и hashSet1
        union.addAll(hashSet2);

        System.out.println("Union: " + union);

        // intersection - пересечение множеств
        Set<Integer> intersection = new HashSet<>(hashSet1);
        intersection.retainAll(hashSet2);

        System.out.println("Intersection: " + intersection);

        // difference - разность множеств
        Set<Integer> difference = new HashSet<>(hashSet1);
        difference.removeAll(hashSet2); // удаляем из diff все hashSet2

        System.out.println("Difference: " + difference);
    }
}
