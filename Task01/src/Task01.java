import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 *
 * телефонный справочник организуем по принципу записной Книжки, где основой поиска служит ФИО
 */


public class Task01 {
    private static Map<String, List<String>> phoneNote = new HashMap<>();

    public static void main(String[] args) {

    }

    // получить телефонные номера для абонента fio, если абонент отсутствует - вернет пустой список
    private static List<String> getPhones(Map<String, List<String>> phones, String fio) {

    }

    // добавить телефон в справочник, если абонент fio уже существует - добавит еще один номер
    // если абонента в справочнике нет - создаст
    // дубликаты номеров не добавляются
    public static void setPhone(Map<String, List<String>> phones, String fio, String phoneNumber) {
        if (phones.containsKey(fio)) {
            if (!phones.get(fio).contains(phoneNumber)) {
                phones.get(fio).add(phoneNumber);
            }
        } else {
            List<String> phoneList = new ArrayList<>();
            phoneList.add(phoneNumber);
            phones.put(fio, phoneList);
        }
    }
}
