import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Пусть дан список сотрудников:
 *
 * - Иван Иванов
 * - Светлана Петрова
 * - Кристина Белова
 * - Анна Мусина
 * - Анна Крутова
 * - Иван Юрин
 * - Петр Лыков
 * - Павел Чернов
 * - Петр Чернышов
 * - Мария Федорова
 * - Марина Светлова
 * - Мария Савина
 * - Мария Рыкова
 * - Марина Лугова
 * - Анна Владимирова
 * - Иван Мечников
 * - Петр Петин
 * - Иван Ежов
 * <p>
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */
public class Main {
    private static List<String> employeer = new ArrayList<>();
    private static Map<String, Integer> names = new TreeMap<>();

    public static void main(String[] args) {
        // инициализация списка
        employeer.add("Иван Иванов");
        employeer.add("Светлана Петрова");
        employeer.add("Кристина Белова");
        employeer.add("Анна Мусина");
        employeer.add("Анна Крутова");
        employeer.add("Иван Юрин");
        employeer.add("Петр Лыков");
        employeer.add("Павел Чернов");
        employeer.add("Петр Чернышов");
        employeer.add("Мария Федорова");
        employeer.add("Марина Светлова");
        employeer.add("Мария Савина");
        employeer.add("Мария Рыкова");
        employeer.add("Марина Лугова");
        employeer.add("Анна Владимирова");
        employeer.add("Иван Мечников");
        employeer.add("Петр Петин");
        employeer.add("Иван Ежов");

        // подсчет повторений
        for (String s : employeer) {
            String[] fio = s.split(" ");
            if (names.containsKey(fio[0])) {
                names.put(fio[0], names.get(fio[0]) + 1);
            } else {
                names.put(fio[0], 1);
            }
        }

        // сортировка, получениеи списка
        List<String> listNames = names.entrySet().stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .map(e -> e.getKey() + "=" +e.getValue().toString())
                .collect(Collectors.toList());

        // вывод
        Logger logger = Logger.getAnonymousLogger();
        for (String s : listNames) {
            logger.info(s);
        }

    }
}