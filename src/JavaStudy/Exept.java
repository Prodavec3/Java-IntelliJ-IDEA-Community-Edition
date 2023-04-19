/** package JavaStudy;
public class Exept {
    private void  ex(){
        int[] numbers = new int[3];
        try{
            numbers[6]=45;
            numbers[6]=Integer.parseInt("gfd");
        }
        catch(ArrayIndexOutOfBoundsException ex){

            System.out.println("Выход за пределы массива");
        }
        catch(NumberFormatException ex){

            System.out.println("Ошибка преобразования из строки в число");
        }
}

// frow - можно создавать свои эксепшены и потом их выводить
public class FirstApp {

    public static void main(String[] args) {

        try{
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            if(x>=30){
                throw new Exception("Число х должно быть меньше 30");
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        System.out.println("Программа завершена");
    }
}
}*/