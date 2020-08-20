package by.epam.shape.validation;

import by.epam.shape.entity.TetragonParameters;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ShapeValidator {
    public static final String REGEX = "^[\\d+].?[\\d+]? [\\d+].?[\\d+]$";
    public static final int MAX_COORDINATES = 8;

    public List<String> filterInputData(List<String> coordinatesFromData) {
        List<String> groupOfCoordinates = new ArrayList<>();
        for (String inputData : coordinatesFromData) {
            if (Pattern.matches(REGEX, inputData)) {
                groupOfCoordinates.add(inputData);
            }
        }
        return groupOfCoordinates;
    }

    public static boolean isTetragon(List<Double> coordinates, TetragonParameters tetragonParameters) {
        if (coordinates.size() != MAX_COORDINATES) {
            return false;
        }
        return isSumOfThreeSidesLessThanFourth(tetragonParameters);
    }

    private static boolean isSumOfThreeSidesLessThanFourth(TetragonParameters tetragonParameters) {
        return tetragonParameters.getSideAB() + tetragonParameters.getSideBC() +
                tetragonParameters.getSideCD() > tetragonParameters.getSideDA() &&
                tetragonParameters.getSideAB() + tetragonParameters.getSideBC() +
                        tetragonParameters.getSideDA() > tetragonParameters.getSideCD() &&
                tetragonParameters.getSideAB() + tetragonParameters.getSideDA() +
                        tetragonParameters.getSideCD() > tetragonParameters.getSideBC() &&
                tetragonParameters.getSideBC() + tetragonParameters.getSideCD() +
                        tetragonParameters.getSideDA() > tetragonParameters.getSideAB();
    }
}
