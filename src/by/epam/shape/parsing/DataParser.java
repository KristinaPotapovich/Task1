package by.epam.shape.parsing;

import by.epam.shape.validation.DataValidation;

import java.util.*;

public class DataParser {
    public static final String DATA_DELIMITER = "\\s+";

    public List<Double> parseToDouble(List<String> coordinatesFromData) {
        List<Double> coordinates = new ArrayList<>();
        String[] strings;
        for (String coordinatesOfPoints : coordinatesFromData) {
            if (DataValidation.isRowOfCoordinatesCorrect(coordinatesOfPoints)) {
                strings = coordinatesOfPoints.split(DATA_DELIMITER);
                for (String string : strings) {
                    coordinates.add(Double.parseDouble(string));
                }
            }
        }
        return coordinates;
    }
}





