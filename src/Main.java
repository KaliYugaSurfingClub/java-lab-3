import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            var scanner = new Scanner(System.in);
            var builder = new User.Builder();

            System.out.println("Введите имя");
            builder.name(scanner.next());

            System.out.println("Введите фамилию");
            builder.surname(scanner.next());

            System.out.println("Введите отчество");
            builder.fatherName(scanner.next());

            var datePattern = "yyyy-MM-dd";

            System.out.printf("Введите дату рождения %s\n", datePattern);
            builder.birthDay(LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern(datePattern)));

            var representation = new UserRussianRepresentation(builder.build());

            System.out.println(representation);
        } catch (IllegalAccessError e) {
            System.out.println("некоректные данные");
        } catch (Exception e) {
            System.out.println("что-то пошло не так");
        }
    }
}