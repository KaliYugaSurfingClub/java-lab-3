import java.time.LocalDate;

public class User {
    private String name;
    private String surname;
    private String fatherName;
    private LocalDate birthDay;

    private User(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.fatherName = builder.fatherName;
        this.birthDay = builder.birthDay;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public static class Builder {
        private String name;
        private String surname;
        private String fatherName;
        private LocalDate birthDay;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder fatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }

        public Builder birthDay(LocalDate birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public User build() {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            if (surname == null || surname.isEmpty()) {
                throw new IllegalArgumentException("Surname cannot be null or empty");
            }
            if (birthDay == null || birthDay.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Birth date cannot be null or in the future");
            }

            return new User(this);
        }
    }
}

