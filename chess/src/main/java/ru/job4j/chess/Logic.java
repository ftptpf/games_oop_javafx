package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

/**
 * Logic - этот класс управляет логикой игры.
 */
public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source); //По объекту типа Cell source в массиве figures найти объект типа Figure.
        Cell[] steps = figures[index].way(dest); //Если объект найден, то нужно получить его ходы до клетки Cell dest.
        // Это нужно сделать через метод way объекта Figure.
        free(steps); //Дальше нужно проверить, что массив клеток от метода way не заполнен другими объектами класса Figure.
        // Если он не заполнен, но нужно в массив figures в позицию, полученную в пункте 1, записать новый объект,
        // полученный из метода figure.copy.
        figures[index] = figures[index].copy(dest);
    }
    //Метод free должен пройтись по массиву figures и проверить,
    //что фигуры не занимают элементы из массива cells.
    //Если они занимают ячейки cells, то метод должен кинуть исключение.
    private boolean free(Cell[] steps) throws OccupiedCellException {
        int st = 0;
        for (int index = 0; index < steps.length; index++) {
            Figure figure = figures[index];
            if (figure == null) {
                st = st + 1;
            }
        }
        if (st == steps.length) {
            return true;
        }
        throw new OccupiedCellException();
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}
