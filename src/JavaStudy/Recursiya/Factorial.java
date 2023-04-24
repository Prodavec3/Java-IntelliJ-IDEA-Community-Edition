package JavaStudy.Recursiya;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Factorial {
    public static void main(String[] args) {
        /**
         * 4! = 4*3*2*1
         * 0! = 1
         */
        int n = 4;
        System.out.println(n+"! : "+factorial(n));
    }

    private static int factorial(int n){
        if (n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    /**
     * fac(4)
     * 4 * fac(3)
     * 3 * fac(2)
     * 2 * fac(1)
     * fac(1) = return 1 дошли до самого низа и потом обратно вверх 1, 2*1, 2*3, 4*6
     */

}
