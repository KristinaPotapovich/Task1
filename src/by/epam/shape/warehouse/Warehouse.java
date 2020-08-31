package by.epam.shape.warehouse;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance = new Warehouse();
    private Map<Long, TetragonParameters> parameters = new HashMap<>();

    private Warehouse() {

    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }


    public void put(long tetragonId, TetragonParameters tetragonParameters) {
        parameters.put(tetragonId, tetragonParameters);
    }

    public void remove(long tetragonId) {
        parameters.remove(tetragonId);
    }

    public TetragonParameters get(long tetragonId) {
        return parameters.get(tetragonId);
    }

    public Map<Long, TetragonParameters> getParameters() {
        return Collections.unmodifiableMap(parameters);
    }
}



