package by.epam.shape.reader;
import by.epam.shape.exception.ShapeException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {
    private DataReader() {
    }

    public static List<String> readData(String filePath) throws ShapeException {
        List<String> coordinatesFromData;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            coordinatesFromData = bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new ShapeException(e);
        }
        return coordinatesFromData;
    }

}
