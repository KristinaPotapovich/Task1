package by.epam.shape.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DataValidationTest extends Assert {
    @Test
    public void isAllRowCoordinatesCorrectTrue() {
        String coordinatesOfPoints = "7.0 2.0";
        boolean actual = DataValidation.isRowOfCoordinatesCorrect(coordinatesOfPoints);
        assertTrue(actual);
    }

    @Test
    public void isAllRowCoordinatesCorrectFalse() {
        String coordinatesOfPoints = "-7.0 2.0";
        boolean actual = DataValidation.isRowOfCoordinatesCorrect(coordinatesOfPoints);
        assertFalse(actual);
    }

}
