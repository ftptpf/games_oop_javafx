package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    //Создайть объект и вызовать у него метод position.
    //Проверить, что он занимает ту же ячейку, что и при создании объекта.
    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        String expected = bishopBlack.position().toString();
        assertThat(expected, is("C1"));
    }

    //Создать объект с начальным положением C1.
    //Вызвать метод way с указанием C1 и G5.
    //Метод должен вернуть массив из 4 клеток. D2, E3, F4, G5.
    @Test
    public void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        String expected = Arrays.toString(bishopBlack.way(Cell.G5));
        assertThat(expected, is("[D2, E3, F4, G5]"));
    }

    @Test (expected = IllegalStateException.class)
    public void isDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        String expected = Arrays.toString(bishopBlack.way(Cell.G1));
    }

    //Создайть объект и вызвать у него метод copy.
    //Проверить, что, возвращенный объект имеет правильную позицию.
    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D1);
        String expected = bishopBlack.copy(Cell.E3).position().toString();
        assertThat(expected, is("E3"));
    }
}