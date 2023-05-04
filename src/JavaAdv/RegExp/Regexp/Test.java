package JavaAdv.RegExp.Regexp;

/**
 * Регулярные выражения для работы с текстом.
 * Язык для описания паттернов в тексте.
 */
public class Test {
    public static void main(String[] args) {

        /**
         * Принимает на вход строку, сравнивает строку на которой вызывается и ту которую указываем в параметрах
         * true если строки одинаковые
         *
         * Такое сравнивание строк в лоб не очень полезно.
         * matches принимает еще и регулярные выражения помимо обычных строк
         *
         * Регулярные выражения:
         * 1) \\d - одна цифра
         * \\w - одна английская буква
         * + означает 1 или более цифр
         * * означает 0 или более цифр
         * ? символ, который идет до него может быть, а может не быть (0 или 1 символов до)
         * (x|y|z) одна строка из множества строк
         * [a-zA-Z] большие множества, в данном случае все английские буквы
         * [abc] = (a|b|c)
         * [0-9] = \\d
         * [^] - отрицание - все что идет после этого символа не должны быть в множестве
         * [^abc] - все символы кроме a,b,c
         * . точка это любой символ
         *
         * {2} точное количество предыдущих символов - 2 символа до
         * \\d{2} ровно 2 символа до
         * {2, } - 2 или более символа
         * \\d{2, }
         * {2, 4} от 2 до 4 сиволов до
         *
         *
         * a.matches("\\d+") - строка содержит любое количество символов от 1 до бесконечности
         *
         *
         */
        String a = "-4124";
        String b = "4124";
        String c = "+123";
        String d = "h12312543";
        String e = "dasAdSasdSAdasd23123124";
        String f = "3da113Ad2a2sdS3Adasd23123124";
        String g = "123fghjvvndthdtjty123";

        System.out.println("1");
        System.out.println(a.matches("-\\d+"));

        System.out.println("2");
        System.out.println(a.matches("-?\\d+"));
        System.out.println(b.matches("-?\\d+"));

        /**
         * + воспринимается как спецсимвол - поэтому перед + ставим \\
         */
        System.out.println("3");
        System.out.println(a.matches("(-|\\+)?\\d*"));
        System.out.println(b.matches("(-|\\+)?\\d*"));
        System.out.println(c.matches("(-|\\+)?\\d*"));

        System.out.println("4");
        System.out.println(d.matches("[a-zA-Z]\\d*"));
        System.out.println(e.matches("[a-zA-Z]+\\d*"));
        System.out.println(f.matches("[a-zA-Z123]+\\d*"));

        System.out.println("5");
        System.out.println(g.matches("[^abc]*"));

        String url = "http://www.google.com";
        String url2 = "http://www.yandex.ru";
        System.out.println("6");
        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));
        System.out.println(url2.matches("http://www\\..+\\.(com|ru)"));
        // \\. это символ точка, после любой символ как . и + как любое кол-во символо

        String str = "123";
        System.out.println(str.matches("\\d{3}")); // Ровно 3 цифры
        System.out.println(str.matches("\\d{2,}")); // 2 и более
    }
}
