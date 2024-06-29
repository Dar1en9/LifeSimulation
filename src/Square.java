//Класс объекта клетка
public class Square {
    protected static int[] near = new int[4]; //переменная под массив для хранения количества каждого вида соседей
    // у клетки

    protected static final int SQUARE = 0, GRASS = 1, SNAKE = 2, RABBIT = 3; //константы, для работы с объектами
    //присваиваем каждому виду клеток число
    protected int x, y; //координаты объекта клетки на поле острова

    protected Square(int coordX, int coordY) { //конструктор, создает клетку по заданным в параметрах
        // координатам x и y
        x = coordX;
        y = coordY;
    }

    public int getValue() { //возвращает значение константы пустой клетки
        return SQUARE;
    }
    public static void clean() { //очищает переменную near, чтобы использовать её повторно
        int i; //счетчик строк
        for (i = 0; i < near.length; i++) //циклом проходимся по всему массиву соседей и обнуляем значение
            near[i] = 0;
    }


    protected void check(Island island) { //заполняет переменную near соседями текущей клетки,
        //в кач-ве параметра передаем объект остров
        Square[][] isl = island.islandCur(); //массив текущего состояния переданного в параметре острова
        clean();
        int beforeX = x + 1, beforeY = y + 1, i, j; //beforeX - нижняя граница поля соседей клетки,
        //beforeY - последний столбец поля соседей, i и j - счетчики строк и столбцов острова соответственно
        for (i = x - 1; i <= beforeX; i++) //в цикле проходимся по всем соседям клетки и подсчитываем их в
            //переменной near
            for (j = y - 1; j <= beforeY; j++)
                if (i != x || j != y) //исключаем случай, когда дойдем до самой клетки
                    near[isl[i][j].getValue()] += 1;

    }

    protected Square nextStep(Island isl) { //проверяет соседей клетки и, в зависимости от состояния на острове,
        //возвращает удава/кролика/траву либо возвращает саму себя (т.е. не меняет клетку);
        // в кач-ве параметра передаем объект остров
        check(isl);
        if (near[SNAKE] >= 2)
            return new Snake(x, y);
        if (near[RABBIT] >= 2)
            return new Rabbit(x, y);
        if (near[GRASS] > 0)
            return new Grass(x, y);
        else return this;
    }
    public void print(){ //форматированный вывод для пустой клетки
        System.out.printf("%4s", "[]");
    }
}

