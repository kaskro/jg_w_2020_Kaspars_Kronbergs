package lv.javaguru.homework.lesson10.level1;

public class UserValidationService {

    public static void validate(User user) {
        if (isNotValidString(user.getName())) {
            throw new ValidationException("Name must be in range from 3 to 15 characters");
        } else if (isNotValidString(user.getLastName())) {
            throw new ValidationException("Surname must be in range from 3 to 15 characters");
        } else if (!isValueInRange(user.getAge(), 0, 120)) {
            throw new ValidationException("Age must be in range from 0 to 120 characters");
        }
    }

    private static boolean isNotValidString(String value) {
        return !isValueInRange(value.length(), 3, 15);
    }

    private static boolean isValueInRange(int value, int min, int max) {
        return value > min && value < max;
    }
}