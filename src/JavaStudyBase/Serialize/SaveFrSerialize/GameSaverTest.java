package JavaStudyBase.Serialize.SaveFrSerialize;

import java.io.*;
import java.util.Arrays;

public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Эльф", new String[]{"лук", "меч", "кастет"});
        GameCharacter two = new GameCharacter(200, "Тролль", new String[]{"голые руки", "большой топор"});
        GameCharacter three = new GameCharacter(120, "Маг", new String[]{"заклинания", "невидимость"});

        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("GameSaver.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Обнуляем ссылки, чтоб мы не могли обратиться к объектам в "куче"
        one = null;
        two = null;
        three = null;

        System.out.println("Загрузка");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("GameSaver.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter theeRestore = (GameCharacter) is.readObject();

            System.out.println(oneRestore);
            System.out.println(twoRestore);
            System.out.println(theeRestore);

            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class GameCharacter implements Serializable{
    private int power;
    private String type;
    private String[] weapons;

    @Override
    public String toString() {
        return "GameCharacter{" +
                "power=" + power +
                ", type='" + type + '\'' +
                ", weapons=" + Arrays.toString(weapons) +
                '}';
    }

    public GameCharacter(int power, String type, String[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getWeapons() {
        return weapons;
    }

    public void setWeapons(String[] weapons) {
        this.weapons = weapons;
    }
}