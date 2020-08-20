package by.epam.shape.parsing;
import java.util.*;

public class DataParser {
    public static final String DELIMITER = "\\s+";
    public List<Double> parseToDouble(List<String> groupOfCoordinates) {
        List<Double> coordinates = new ArrayList<>();
        String [] strings;
        for (String coordinatesOfPoints : groupOfCoordinates) {
            strings = coordinatesOfPoints.split(DELIMITER);
            for (String string : strings) {
                coordinates.add(Double.parseDouble(string));
            }
        }
        return coordinates;
    }
}




