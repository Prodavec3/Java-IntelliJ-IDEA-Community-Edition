package JavaAdv.RegExp.Regexp;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        String a = "Hello there hey"; // 3 слова разделены пробелом
        String[] words = a.split(" "); // Массив строк

        String b = "Hello.there.hey";
        String[] words2 = b.split("\\.");

        System.out.println(Arrays.toString(words));
        System.out.println(Arrays.toString(words2));

        /**
         * допустим, более сложный разделитель если
         */

        String str = "Hello3123123there23221hey44411122";
        String[] words3 = str.split("[0-9]+"); // либо \\d+
        System.out.println(Arrays.toString(words3));

        /**
         * В оригинальной строке мы можем заменить что-то на что-то
         * replace - часть строки меняем на часть строки, не принимает регулярные выражения
         * replaceAll принимает не строки конкретные, а регулярные выражения
         * replaceFirst - принимается на вход регулярные выражения, заменяет не все, а первые
         */
        String strReplace = "Hello there hey";
        String modifyStr = strReplace.replace(" ", ".");
        System.out.println(modifyStr);

        String strReplaceAll = "Hello312312445there1231543hey1";
        String modifyStr2 = strReplaceAll.replaceAll("\\d+", " ");
        System.out.println(modifyStr2);
    }
}
