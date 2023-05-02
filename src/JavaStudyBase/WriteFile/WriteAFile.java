package JavaStudyBase.WriteFile;

import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("FileWritter");
        writer.write("Привет, это запись в файл");
        writer.write("Вторая строка");
        writer.close();
    }
}
