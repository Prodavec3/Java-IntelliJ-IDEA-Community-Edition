package JavaStudy.Exeptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Exceptions4 {
    /**
     * Может быть несколько блоков catch
     */
    public static void main(String[] args) {
        try {
            run();
        } catch (IOException e) { // multi catch можно ловить через "|"
            e.printStackTrace();
        } catch (Exception e) { // Общий класс исключений, т.е любую ошибку можно отловить тут (полиморфизм)

        }/** catch (ParseException e){ // Эта часть кода никогда не запустится - т.к Exception все поймает

        }*/

    }
    public static void run() throws IOException, ParseException, IllegalArgumentException{
        /**
         * Может быть много Exceptions у метода и их надо будет либо обработать, либо также добавить в тот метод,
         * где вызывается этот
         *
         * Illegal не выкидываем в main потому что он наследуется от IOException
         */
    }
}
