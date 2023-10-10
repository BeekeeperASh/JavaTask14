import java.util.Arrays;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String pattern = "abcdefghijklmnopqrstuv18340";
        String correctExample = "abcdefghijklmnopqrstuv18340";
        String incorrectExample = "abcdefghijklmnoasdfasdpqrstuv18340";

        System.out.println(isMatch(pattern, correctExample));
        System.out.println(isMatch(pattern, incorrectExample));

        String text = "Пример текста со списками цен: 25.98 USD, 100 RUB, 10.55 EU. Неверные форматы: 44 ERR, 0.004 EU.";
        extractPrices(text);

        String s1 = "(1 + 8) – 9 / 4";
        String s2 = "+ 6 + 5 + 2 + 9 + a";

        checkForMissingPlus(s1);
        checkForMissingPlus(s2);

        String correctExamples = "30/02/2000";
        String incorrectExamples = "1/1/1899";

        checkDates(correctExamples);
        checkDates(incorrectExamples);

        String[] validEmails = {"user@example.com", "root@localhost.com"};
        String[] invalidEmails = {"myhost@@@com.ru", "@my.ru", "Julia String"};

        checkEmails(validEmails);
        checkEmails(invalidEmails);

        String[] validPasswords = {"F032_Password", "TrySpy13"};
        String[] invalidPasswords = {"smart_pass", "A007"};

        checkPasswords(validPasswords);
        checkPasswords(invalidPasswords);

        String[] stringArray = {"apple", "orange", "banana", "grape"};
        StringFilter stringFilter = new StringFilter();
        filter(stringArray, stringFilter);
        System.out.println("Фильтрованный массив строк: " + Arrays.toString(stringArray));

        Integer[] integerArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        NumberFilter numberFilter = new NumberFilter();
        filter(integerArray, numberFilter);
        System.out.println("Фильтрованный массив чисел: " + Arrays.toString(integerArray));

    }

    public static boolean isMatch(String pattern, String input) {
        String regex = "^" + Pattern.quote(pattern) + "$";
        return input.matches(regex);
    }

    public static void extractPrices(String text) {
        String regex = "\\b(\\d+\\.\\d{2}) (USD|RUB|EU)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String price = matcher.group(1);
            String currency = matcher.group(2);

            System.out.println("Цена: " + price + " " + currency);
        }
    }

    public static void checkForMissingPlus(String text) {
        String regex = "\\d (?![+])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("В тексте есть цифры без знака '+'");
        } else {
            System.out.println("В тексте нет цифр без знака '+'");
        }
    }

    public static void checkDates(String date) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}$";
        Pattern pattern = Pattern.compile(regex);


            Matcher matcher = pattern.matcher(date);
            if (matcher.matches()) {
                System.out.println(date + " - Это правильная дата");
            } else {
                System.out.println(date + " - Это неправильная дата");
            }
    }

    public static void checkEmails(String[] emails) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);

        for (String email : emails) {
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                System.out.println(email + " - Это корректный email");
            } else {
                System.out.println(email + " - Это некорректный email");
            }
        }
    }

    public static void checkPasswords(String[] passwords) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d_]{8,}$";
        Pattern pattern = Pattern.compile(regex);

        for (String password : passwords) {
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) {
                System.out.println(password + " - Это надежный пароль");
            } else {
                System.out.println(password + " - Это ненадежный пароль");
            }
        }
    }

    public static <T> void filter(T[] array, Filter<T> filter) {
        for (int i = 0; i < array.length; i++) {
            if (!filter.apply(array[i])) {
                array[i] = null;
            }
        }
    }
}
