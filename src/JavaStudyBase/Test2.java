package JavaStudyBase;

public class Test2 {
    //функции вне классов, методы в классе

    //и теперь когда есть конструкторы ставим private (мод доступа)
    private String name;
    private int age;
    private float week;

    /*public void setParams(String _name, int _age, float _week){
        name = _name;
        age = _age;
        week =  _week;
    }*/



    //this. - мы обращаемся к переменной класса
    // то есть this.name = name;
    // вместо name = _name;

    // конструкторы - методы для назначения параметра
    // конструктор по-умолчанию, он по-умолчанию был невидимый
    /* public JavaStudy.Test2(String _name, int _age, float _week){
        //например, join to db при создании, либо вывести на экран что-нибудь
        name = _name;
        age = _age;
        week =  _week;
    } */

    public Test2(){}

    public Test2(String name, int age, float week){
        //например, join to db при создании, либо вывести на экран что-нибудь
        this.name = name;
        this.age = age;
        this.week =  week;
    }

    // в 1 классе можно много конструкторов установить
    // если ничего нет в строке то это null, в др типах данных 0

}
