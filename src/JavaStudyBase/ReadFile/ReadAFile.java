package JavaStudyBase.ReadFile;

import java.io.*;

/**
 * Буфер дает временное хранилище для объектов, пока держатель не заполнится.
 * Благодаря буферу придется делать намного меньше "рейсов"
 * Аналогия: покупать товары с тележкой или без
 */
public class ReadAFile {
    public static void main(String[] args) {

        try {
            File myFile = new File("FileWritter");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;

            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
