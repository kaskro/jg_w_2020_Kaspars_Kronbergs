package lv.javaguru.homework.lesson10.level1;

//ok
public class UserValidationService {

    public static void validate(User user) {
        final int MIN_AGE = 0;
        final int MAX_AGE = 120;
        final int MIN_LENGTH = 3;
        final int MAX_LENGTH = 15;
        if (isNotValidString(user.getName(), MIN_LENGTH, MAX_LENGTH)) {
            throw new ValidationException("Name must be in range from 3 to 15 characters");
        } else if (isNotValidString(user.getLastName(), MIN_LENGTH, MAX_LENGTH)) {
            throw new ValidationException("Surname must be in range from 3 to 15 characters");
        } else if (!isValueInRange(user.getAge(), MIN_AGE, MAX_AGE)) {
            throw new ValidationException("Age must be in range from 0 to 120 characters");
        }
    }

    private static boolean isNotValidString(String value, int min, int max) {
        return !isValueInRange(value.length(), min, max);
    }

    private static boolean isValueInRange(int value, int min, int max) {
        return value > min && value < max;
    }
}
