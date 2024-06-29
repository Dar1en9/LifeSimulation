//Класс объекта трава, наследует от класса клетки
public class Grass extends Square {

    public Grass(int x, int y) { //конструктор, создает объект трава по заданным в параметрах координатам x и y
        super(x, y);
    }
    @Override
    public int getValue() { //переопределен; возвращает значение константы травы
        return GRASS;
    }
    @Override
    public Square nextStep(Island isl) { //переопределен; проверяет соседей этой травы и, если травы вокруг
        // меньше, чем кроликов, возвращает пустую клетку, иначе возвращает саму себя;
        // в кач-ве параметра передаем объект остров
       check(isl);
       if (near[GRASS] < near[RABBIT])
            return new Square(x, y);
       else return this;
    }
    @Override
    public void print(){ //переопределенный форматированный вывод для травы
        System.out.printf("%4s", "vv");
    }
}
