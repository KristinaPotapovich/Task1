package by.epam.shape.reader;

import by.epam.shape.exception.ShapeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {
    public static final Logger LOGGER = LogManager.getLogger();

    public List<String> readData(String filePath) throws ShapeException {
        List<String> coordinatesFromData;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            coordinatesFromData = bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "file is missing", e);
            throw new ShapeException("file is missing", e);
        }
        return coordinatesFromData;
    }
}
