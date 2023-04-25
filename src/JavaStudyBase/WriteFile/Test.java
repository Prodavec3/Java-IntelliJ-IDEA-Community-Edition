package JavaStudyBase.WriteFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * запись в файл текстовое значение
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("WriteFile123");
        PrintWriter pw = new PrintWriter(file);
        /**
         * Теперь можем записывать в файл данные. В данном случае только текстовые значения.
         * Если мы хотим записать что-то иное - необходимо провести сериализацию (запись объектов).
         */
        pw.println("Эту строку мы хотим записать в файл");
        pw.println("И эту тоже");

        pw.close(); // Необходимо закрыть файл
    }
}
