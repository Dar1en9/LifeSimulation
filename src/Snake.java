//Класс объекта удав, наследует от класса клетки
public class Snake extends Square {
    protected int age; //возраст удава
    public Snake(int x, int y) { //конструктор, создает объект удав по заданным в параметрах координатам x и y,
        //при создании задает объекту возвраст 0
        super(x, y);
        age = 0;
    }

    @Override
    public int getValue() { //переопределен; возвращает значение константы удава
        return SNAKE;
    }

    @Override
    public Square nextStep(Island isl) { //переопределен; проверяет соседей этого удава и, если вокруг
        // больше 5 удавов либо удав старый (достиг 6 лет), возвращает пустую клетку, иначе возвращает
        // самого себя; в кач-ве параметра передаем объект остров
        check(isl);
        if (near[SNAKE] > 5 || age == 6)
            return new Square(x, y);
        else {
            age++; //если не умер, возраст увеличивается на 1
            return this;
        }
    }
    @Override
    public void print(){ //переопределенный форматированный вывод для удава
        System.out.printf("%4s", "S");
    }
}
