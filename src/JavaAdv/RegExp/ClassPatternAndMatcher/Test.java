package JavaAdv.RegExp.ClassPatternAndMatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Регулярные выражения до этого вызывали на String
 * Но в Java существуют еще 2 класса для работы с регулярными выражениями
 *
 * Pattern представляет из себя само регулярное выражение
 * Matcher использует паттерн чтобы проводить операции над текстом
 * Поиск паттерна в тексте.
 *
 * Например найти все эл. адреса в большом тексте.
 * Найти любые паттерны в тексте.
 */
public class Test {
    public static void main(String[] args) {
        String text = "Hello, Guys! I send you my email joe@gmail.com so we can\n" +
                "keep in touch. Thanks, Joe! That's cool. I am sending you\n" +
                "my address: tim@yandex.ru. Let's stay in touch...";

        // Заводим новый паттерн. new не пишем т.к конструктор данного класса приватный
        Pattern email = Pattern.compile("(\\w+)@(gmail|yandex)\\.(ru|com)");

        // На основании паттерна создаем матчер сущность и передаем текст
        Matcher matcher = email.matcher(text);

        while(matcher.find()){
            /**
             * Мы можем при вызве group() передать число, это id группы
             * Группа в регулярном выражении это строка, которая находится в круглых скобках (gmail|yandex) и тд
             *
             * Предположим, мы хотим получить только имя (до @) (\\w+)@()\\.() сделали \\w+ группой
             * group(1),
             * Если id не указываем - получаем всю строку.
             *
             * Нумерация id начинается с 1 слева направо и идет в глубину
             */
            System.out.println(matcher.group(1));
            System.out.println(matcher.group());
        }
    }
}
