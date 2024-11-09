import java.time.LocalDate;
import java.time.Period;

public class UserRussianRepresentation {
    private String FIO;
    private String gender;
    private String age;

    public UserRussianRepresentation(User user) {
        this.FIO = String.format(
                "%s %c.%c.",
                user.getSurname(),
                user.getName().charAt(0),
                user.getFatherName().charAt(0)
        );

        this.age = formatAge(Period
                .between(user.getBirthDay(), LocalDate.now())
                .getYears()
        );

        var ending = user.getFatherName().substring(user.getFatherName().length() - 4);

        this.gender = switch (ending) {
            case "ович", "евич" -> "М.";
            case "овна", "евна" -> "Ж.";
            default -> "не опредленн";
        };
    }

    public String getAge() {
        return age;
    }

    public String getFIO() {
        return FIO;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format(
                "ФИО: %s\n Пол: %s\n Возраст: %s\n",
                FIO, gender, age
        );
    }

    private String formatAge(int age) {
        if (age % 10 == 1 && age % 100 != 11) {
            return age + " год";
        }

        if ((age % 10 >= 2 && age % 10 <= 4) && (age % 100 < 10 || age % 100 >= 20)) {
            return age + " года";
        }

        return age + " лет";
    }
}