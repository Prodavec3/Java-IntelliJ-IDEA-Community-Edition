package JavaStudyBase.Serialize.SaveFrSerialize;

import javax.swing.*;
import java.io.*;

/**
 * Если данные будут задействованы только в создавшей их Java-програме, то необходимо использовать Сериализацию
 * (создаем файл, который будет хранить преобразованные (сериализованные) объекты)
 *
 * Если данные будут использоваться другими программами - создать простой текстовый файл с разделителями,
 * которые смогут распознать другие программы. Например, это может быть файл с разделителями на основе табуляции,
 * который будет доступен для использотвания электронной таблице или приложению с БД
 *
 * При сериализации объекта также сериализуются все объекты, на которые он ссылается с помощью своих переменных экземпляра.
 * И все объекты на которые ссылаются те объекты - тоже сериализуются.
 * Сериализация сохраняет полный граф объекта.
 *
 * Сериализация либо проходит полностью, либо отменяется при ошибке или невозможности.
 *
 * Если какая-то переменная в записи не нужна - можно пометить ее transient
 */
public class SerializeClass implements Serializable {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "SerializeClass{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public static void main(String[] args) {
        SerializeClass serializeClass = new SerializeClass();
        serializeClass.setHeight(20);
        serializeClass.setWidth(50);

        /**
         * Сериализация
         */
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("fileOutput.ser"); // Соездиняемся с файлом с данным именем
            // Если он существует, в ином - будет создан новый с таким названием
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializeClass);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * Десериализация
         */
        try {
            FileInputStream fileInputStream = new FileInputStream("fileOutput.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println(objectInputStream.readObject());
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
