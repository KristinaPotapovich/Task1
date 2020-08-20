package by.epam.shape;
import by.epam.shape.creator.ShapeCreator;
import by.epam.shape.entity.Tetragon;
import by.epam.shape.exception.ShapeException;
import by.epam.shape.parsing.DataParser;
import by.epam.shape.reader.DataReader;
import by.epam.shape.validation.ShapeValidator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ShapeException {
        List <String> coordinatesFromData = DataReader.readData("init/data.txt");
        ShapeValidator validator = new ShapeValidator();
        List<String> filterInputData = validator.filterInputData(coordinatesFromData);
        DataParser dataParser = new DataParser();
        List <Double> coordinates=dataParser.parseToDouble(filterInputData);
        ShapeCreator shapeCreator = new ShapeCreator();
        shapeCreator.createPoint(coordinates);
        Tetragon tetragon = shapeCreator.createTetragon(shapeCreator.createPoint(coordinates));

        System.out.println(tetragon);
    }
}

