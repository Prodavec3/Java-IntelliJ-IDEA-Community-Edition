package JavaStudy.ReadFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        /* Scanner scanner = new Scanner(System.in); // Потом данных из консоли
        String input = scanner.nextLine();*/
        /**
         * Считаем с файла
         */
        String separator = File.separator; // Системный сепаратор / или // для винды
        String path = separator + "Users" + separator + "iu.biriukov" + separator + "IdeaProjects"
                    + separator + "untitled" + separator + "ReadFile";
        File file = new File(path);
        Scanner scannerFile = new Scanner(file);
        while (scannerFile.hasNextLine()){ // пока есть строки в файле, false - если все строки считали
            System.out.println(scannerFile.nextLine());
        }
        scannerFile.close(); // для освобождения ресурсов и чтобы поток не оставался открытым

        /**
         * Считаем с ReadFile2 там 1  2  3 в строке с пробелами цифры
         */

        String path2 = separator + "Users" + separator + "iu.biriukov" + separator + "IdeaProjects"
                + separator + "untitled" + separator + "ReadFile2"; // т.к файл я положил в корень - можно было просто new File("ReadFile2")
        File file2 = new File(path2);
        Scanner scanner2 = new Scanner(file2);

        String line = scanner2.nextLine();
        String[] numbers = line.split("  "); // Указываем на чем будем сплитить (т.е он делит по пробелам)
        System.out.println(Arrays.toString(numbers));
        int[] numbersInt = new int[3];
        int counter = 0;

        for(String number : numbers){
            numbersInt[counter++] = Integer.parseInt(number);
        }
        System.out.println(Arrays.toString(numbersInt));

        scanner2.close();
    }
}
