import java.util.*;
import java.util.logging.Logger;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 *
 * телефонный справочник организуем по принципу записной Книжки, где основой поиска служит ФИО
 * дубли телефонов не вносим
 */


public class Task01 {
    private static Map<String, List<String>> phoneNote = new HashMap<>();

    public static void main(String[] args) {
        int menuOption = 1;

        String fio = "";
        String phone = "";
        while (menuOption > 0){
            menuOption = menu();

            switch (menuOption){
                case 1:
                    fio = readStrConsole("ФИО: ");
                    phone = readStrConsole("Номер: ");
                    setPhone(fio, phone);
                    break;
                case 2:
                    fio = readStrConsole("ФИО: ");
                    List<String> phones = getPhones(fio);
                    if(phones.size() == 0) {
                        printLog("Абонент не найден!");
                    }else {
                        printLog(phones.toString());
                    }
                    break;
            }
        }

    }

    // получить телефонные номера для абонента fio, если абонент отсутствует - вернет пустой список
    public static List<String> getPhones(String fio) {
        return phoneNote.getOrDefault(fio, new ArrayList<>());
    }

    // добавить телефон в справочник, если абонент fio уже существует - добавит еще один номер
    // (дубликаты номеров не добавляются)
    // если абонента в справочнике нет - создаст
    public static void setPhone(String fio, String phoneNumber) {
        if (phoneNote.containsKey(fio)) {
            if (!phoneNote.get(fio).contains(phoneNumber)) {
                phoneNote.get(fio).add(phoneNumber);
            }
        } else {
            List<String> phoneList = new ArrayList<>();
            phoneList.add(phoneNumber);
            phoneNote.put(fio, phoneList);
        }
    }

    // логированный вывод
    public static void printLog(String message){
        Logger logger = Logger.getAnonymousLogger();
        logger.info(message);
    }

    // очистка терминала
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // получение целочисленного значения с консоли
    public static int readIntConsole(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

    // получение строкового значения с консоли
    public static String readStrConsole(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.next();
    }

    // меню программы
    public static int menu(){
        System.out.println("1 - добавить запись");
        System.out.println("2 - найти телефон");
        System.out.println("0 - выход");
        return readIntConsole(">");
    }

}
