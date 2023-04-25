package JavaStudyBase.VlozhennieClassi;

public class Test {
    public static void main(String[] args) {
        Electrocar electrocar = new Electrocar(1);
        electrocar.start();

        Electrocar.Battery battery = new Electrocar.Battery(); // motor это часть машины, при создании объекта машины
                                                                // создается и motor, а вот с battery другая тема
                                                                // при создании battery мы просто понимаем что он лежит в Electrocar
    }
}
