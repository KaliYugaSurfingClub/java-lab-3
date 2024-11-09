import java.time.LocalDate;
import java.time.Period;

public class RussianUserRepresentation {
    private String FIO;
    private String Gender;
    private String Age;

    public RussianUserRepresentation(User user) {
        this.FIO = String.format(
                "%s %c.%c.",
                user.getSurname(),
                user.getName().charAt(0),
                user.getFatherName().charAt(0)
        );

        this.Age = formatAge(Period
                .between(user.getBirthDay(), LocalDate.now())
                .getYears()
        );

        var ending = user.getFatherName().substring(user.getFatherName().length() - 4);
        this.Gender = switch (ending) {
            case "ович", "евич" -> "М.";
            case "овна", "евна" -> "Ж.";
            default -> "unknown";
        };
    }

    public String getAge() {
        return Age;
    }

    public String getFIO() {
        return FIO;
    }

    public String getGender() {
        return Gender;
    }

    @Override
    public String toString() {
        return String.format(
                "ФИО: %s\n Пол: %s\n Возраст: %s\n",
                FIO, Gender, Age
        );
    }

    private String formatAge(int age) {
        if (age % 10 == 1 && age % 100 != 11) {
            return age + " год";
        } else if ((age % 10 >= 2 && age % 10 <= 4) && (age % 100 < 10 || age % 100 >= 20)) {
            return age + " года";
        } else {
            return age + " лет";
        }
    }
}