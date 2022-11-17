import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 *
 * Рекурсивно найдем решения. Т.к. ферзи не должны бить друг друга - для хранения информации о
 * позиции расстановки достаточно линейной структуры. Используем HashMap, в котором ключ - номер вертикали,
 * значение - номер ряда доски. Нумерацию начнем с 0. При выводе позиции переведем в шахматный порядок
 */

public class Main {
    // кол-во ферзей для расстановки
    private static final int QUEEN_COUNT = 8;
    // массив для хранения расстановки фигур
    private static Map<Integer, Integer> board = new HashMap<>(QUEEN_COUNT);
    //отображение
    private static Map<Integer, String> columnAlpha = new HashMap<>() {{
        put(0, "a");
        put(1, "b");
        put(2, "c");
        put(3, "d");
        put(4, "e");
        put(5, "f");
        put(6, "g");
        put(7, "h");
    }};

    public static void main(String[] args) {
        // инициализация хранения позиций
        for (int i = 0; i < QUEEN_COUNT; i++) {
            board.put(i, -1);
        }

        putQueen(0);
    }

    public static void putQueen(int queenCount) {
        if (queenCount >= QUEEN_COUNT) {
            printBoard(board);
            return;
        }

        for (int row = 0; row < QUEEN_COUNT; row++) {
            int col;
            for (col = 0; col < queenCount; col++) {
                if (board.get(col) == row || Math.abs(board.get(col) - row) == queenCount - col)
                    break;
            }

            if (col == queenCount) {
                board.put(col, row);
                putQueen(queenCount + 1);
            }
        }
    }

    public static void printBoard(Map<Integer, Integer> map) {
        Logger logger = Logger.getAnonymousLogger();

        StringBuilder result = new StringBuilder("Позиции ферзей: ");
        for (int i = 0; i < QUEEN_COUNT; i++) {
            result.append(columnAlpha.get(i));
            result.append(board.get(i) + 1);
            if (i < QUEEN_COUNT - 1) {
                result.append(", ");
            }
        }
        logger.info(result.toString());
    }
}