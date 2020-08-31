package by.epam.shape.validation;

import java.util.regex.Pattern;

public class DataValidation {

    public static final String ALLOWED_VALUES = "^[\\d+].?[\\d+]? [\\d+].?[\\d+]$";

    private DataValidation() {
    }

    public static boolean isRowOfCoordinatesCorrect(String coordinatesOfPoints) {
        boolean result = false;
        if (Pattern.matches(ALLOWED_VALUES, coordinatesOfPoints)) {
            result = true;
        }
        return result;
    }
}

